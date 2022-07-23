package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

        public User(String name, String gender, String email, String status){
            this.name = name;
            this.gender = gender;
            this.email = email;
            this.status = status;

        }

        @JsonProperty("name")
        String name;

        @JsonProperty("gender")
        String gender;

        @JsonProperty("email")
        String email;

        @JsonProperty("status")
         String status;








}
