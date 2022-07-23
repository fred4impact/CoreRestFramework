package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;



public class BaseSetUp {

    RequestSpecification requestSpec;

    public RequestSpecification  requestspecification() throws IOException {

    if (requestSpec == null) {

            // create logger to log all request & response
            PrintStream log = new PrintStream(Files.newOutputStream(Paths.get("logger.txt")));
            requestSpec = new RequestSpecBuilder()
                    .setBaseUri(getConfigValue("restUrl"))
                    .setContentType(ContentType.JSON)

                    // these are for the logging request & response
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))

                    .build();

            return requestSpec;
         }
    return requestSpec;
    }

public static String getConfigValue(String key) throws IOException {

     Properties prop = new Properties();
     FileInputStream file = new FileInputStream("/Users/sam/Documents/AUTOMATION /CoreRestFramework/src/test/resources/config.properties");
     prop.load(file);
     return prop.getProperty(key);

  }

    public String getJsonObjectValue(String string, String key) {
        String resp = string.toString();
        JsonPath js = new JsonPath(resp);
        return js.get(key).toString();
    }



}
