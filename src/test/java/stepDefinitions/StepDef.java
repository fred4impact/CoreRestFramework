//package stepDefinitions;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import static io.restassured.RestAssured.*;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.http.ContentType;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//import org.junit.Assert;
//import utils.BaseSetUp;
//
//import java.io.IOException;
//
//import static org.hamcrest.Matchers.*;
//import static org.junit.Assert.assertEquals;
//
//public class StepDef extends BaseSetUp {
//
//    RequestSpecification reQ;
//    Response response ;
//
//    @Given("The API endpoint url is set")
//    public void theAPIEndpointUrlIsSet() throws IOException {
//        // these set the request specification
//        reQ = given().spec(requestspecification());
//    }
//
//    @When("I send a Get request to retrieve user data")
//    public void iSendAGetRequestToRetrieveUserData() {
//        response = reQ.when().get("/posts").then().extract().response();
//    }
//
//    @Then("I receive success response with status {int}")
//    public void i_receive_success_response_with_status(Integer code) {
//        response.then().assertThat().statusCode(code);
//    }
//
////    @And("^(.*) in response body as (.*)")
////    public void nameInResponseBodyAsValue(String key, String value) {
////        JsonPath jspath = new JsonPath(response.asString());
////        String msg = jspath.get(key);
////       Assert.assertEquals(msg,(value));
////    }
//
//
//
//
//}
