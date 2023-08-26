package tech.codingclub.utility;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

class TopKeywordAnalyser  implements Runnable {
    public final String filePath;

    public TopKeywordAnalyser(String filePath) {

        this.filePath = filePath;
    }


    public void run() {

        ArrayList<String> keywordsFileData = null;
        try {
            keywordsFileData = FileUtility.readFileAsList(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }


        HashMap<String,Integer>keywordCounter=new HashMap<String,Integer>();
        //read every row
            for(String row:keywordsFileData) {
                String[] keywords = row.split(" ");
                // within each row proces each keyword
                for (String keyword : keywords) {
                    String str = keyword.toLowerCase();
                    //if not there in hashmap
                    if (!keywordCounter.containsKey(str)) {
                        //first time any keyword found
                        keywordCounter.put(str, 1);
                    } else {
                        Integer value = keywordCounter.get(str);
                        keywordCounter.put(str, value + 1);
                    }
                }
            }
         ArrayList<KeywordCount>keywordCountArrayList=new ArrayList<KeywordCount>();
            for(String keyword:keywordCounter.keySet()){
             KeywordCount keywordCount =   new KeywordCount( keyword,keywordCounter.get(keyword));
                keywordCountArrayList.add(keywordCount);
            }
        Collections.sort(keywordCountArrayList, new Comparator<KeywordCount>(){
                    public int compare(KeywordCount o1, KeywordCount o2){
                        if(o2.count==o1.count)return  o1.keyword.compareTo(o2.keyword);
                        return o2.count-o1.count;
                    }
                });
            for(KeywordCount keywordCount:keywordCountArrayList){
                System.out.println(keywordCount.keyword+":"+keywordCount.count);}
        String json=new Gson().toJson(keywordCountArrayList );
        System.out.println(json);
        // aaoo try karte haa ex lekar convert karna'
        String covertJson="{\"keyword\":\"HEllo Gson\",\"count\":100}";
        KeywordCount keywordCount=new Gson().fromJson(covertJson,KeywordCount.class);
        System.out.println("convert into object  "+keywordCount.keyword +" :"+keywordCount.count);
        // aaoo array se try karte haa
        String covertJsonArray="[{\"keyword\":\"Hello Gson\",\"count\":1},{\"keyword\":\"Last one\",\"count\":2} ]";
        ArrayList<KeywordCount>covertedArrayList=new Gson().fromJson(covertJsonArray,new TypeToken<ArrayList<KeywordCount>>(){}.getType());
        System.out.println("ArrayList from Json");
        for(KeywordCount keywordCountTemp:covertedArrayList){
            System.out.println(keywordCountTemp.keyword+": "+keywordCountTemp.count);
        }
    }

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager(5);
        taskManager.waitTillQueueIsFreeAndAddTask(new TopKeywordAnalyser("C:\\Users\\Suraj Patwa\\Downloads\\Suraj.text"));
    }
}
