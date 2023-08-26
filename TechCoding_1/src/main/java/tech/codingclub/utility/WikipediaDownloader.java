package tech.codingclub.utility;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

import org.jsoup.Jsoup;
import tech.codingclub.entity.Coders;

import java.util.Date;

public class WikipediaDownloader  implements Runnable {
    //private static TaskManager taskmanager=new TaskManager(20);
    private String keyword;


    public WikipediaDownloader(String keyword) {

        this.keyword = keyword;
    }

    public void run() {
        if (this.keyword == null || this.keyword.length() == 0) {
            return;
        }
// step 1
        this.keyword = this.keyword.trim().replaceAll("[ ]+", "_");  // trim remove stasrting and ending space remove
        // step 2
        String wikiUrl = getWikipediaUrlForQuery(this.keyword);
        String response="";
        String imageUrl = null;
        try {
//            //step 3
            String wikipediaResponseHTML = HttpUrlConnectionExample.sendGet(wikiUrl);                   //HttpURLConnectionExample.sendGet(wikiUrl);
            //System.out.print(wikipediaResponseHTML);

            //step 4
            Document document = (Document) Jsoup.parse(wikipediaResponseHTML, "https://en.wikipedia.org");
            ///fElements mainElement= document.;
            Elements childElements = document.body().select(".mw-parser-output > *");  // it is select  the  child  element
            int state = 0;

            for (Element childElemet : childElements) {
                if (state == 0) {
                    if (childElemet.tagName().equals("table")) {
                        state = 1;
                    }
                } else if (state == 1)
                    if (childElemet.tagName().equals("p")) {
                        state = 2;

                        response = childElemet.text();
                        break;
                    }
            }
            try{
              imageUrl=  document.body().select(".infobox img").get(0).attr("src");
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
            WikiResult wikiResult=new WikiResult(this.keyword,response,imageUrl);
            //push result into database
            Gson gson=new GsonBuilder().setPrettyPrinting().create();
            String json=gson.toJson(wikiResult);
            System.out.println(json);
        }



        catch (Exception exception) {
            exception.printStackTrace();
        }



    }



    private String getWikipediaUrlForQuery(String cleanKeyword) {
        return "https://en.wikipedia.org/wiki/"+cleanKeyword;
    }

    public static void main(String[] args) {
        TaskManager taskManager=new TaskManager(20 );
        String arr[]={"India","United States"};
        System.out.println("this side is Suraj Patwa");
        System.out.println("Running Wikipedia Downloader at "+new Date().getTime());
        for(String keyword:arr){
            WikipediaDownloader wikipediaDownloader=new WikipediaDownloader(keyword);
            taskManager.waitTillQueueIsFreeAndAddTask(wikipediaDownloader);
        }



    }


}
