package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonPost {

   public JsonPost(String title, String body, int userId){
       this.title = title;
       this.body = body ;
       this.userId = userId ;
   }

    @JsonProperty("title")
    String title;

    @JsonProperty("body")
    String body;

    @JsonProperty("userId")
       int  userId;

}
