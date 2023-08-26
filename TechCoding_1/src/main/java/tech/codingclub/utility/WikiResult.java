package tech.codingclub.utility;

public class WikiResult {
    private String query;
    private String image_url;
    private String text_result;
    public WikiResult(){

    }


    public WikiResult(String query,String text_result, String image_url) {
        this.query = query;
         this.text_result=text_result;
        this.image_url = image_url;
    }




}
