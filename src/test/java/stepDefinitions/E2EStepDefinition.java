package stepDefinitions;



import endpoints.ResourceEndpoints;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.BaseSetUp;
import utils.BuildTestData;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class E2EStepDefinition extends BaseSetUp {

    private static final Logger log = LoggerFactory.getLogger("PostStepDefinition");

    RequestSpecification reQ;
    static Response response;
    BuildTestData data = new BuildTestData();
    // create a new variable for payload setup
    static String productId ;
    @Given("The API url is set with payload {string} {string} {string} {string}")
    public void theAPIUrlIsSetWithPayload(String name, String quantity, String brand, String category) throws IOException {

        reQ = given().spec(requestspecification()).body(data.getProduct(name, quantity, brand, category));
        log.info(" Step 1: The API url is set with payload with ");
    }

    @When("I send {string} request to {string} endpoint")
    public void iSendRequestToEndpoint(String method, String resource) {

        ResourceEndpoints endpoint = ResourceEndpoints.valueOf(resource);
        System.out.println(endpoint.getResource());

        if (method.equalsIgnoreCase("POST"))
            response = reQ.when().post(endpoint.getResource());
        if (method.equalsIgnoreCase("GET"))
            response = reQ.when().get(endpoint.getResource());
        else if (method.equalsIgnoreCase("DELETE"))
            response = reQ.when().get(endpoint.getResource());
        }

    @Then("I receive success response with status code {int}")
    public void iReceiveSuccessResponseWithStatusCode(int code) {
        response.then().assertThat().statusCode(code);
        log.info(" Step 3: I receive success response with status == " + response.getStatusCode());
    }

    @And("Verify id of data created equals to {string} using {string}")
    public void verifyIdOfDataCreatedEqualsToUsing(String expectedName, String resource) throws IOException {

        // here we get title
         productId = getJsonObjectValue(response.asString(), "id");
        log.info("=== Display Product ID  === > " + "" + productId );
        reQ = given().spec(requestspecification()).queryParam("id", productId);

        // here we try to get the resource just been created
        iSendRequestToEndpoint("GET", resource);
        String actualName = getJsonObjectValue(response.asString(), "name");
        log.info("==== Actual Product Name === > " + " " + actualName);

        String productsActualName = actualName.replaceAll("(^\\[|\\]$)", "");
        assertEquals(productsActualName, expectedName);

        log.info("=== Response String == > " + response.asString());
        log.info("=== Expected Name ===> " + expectedName);
        log.info("=== Actual Name ===> " + productsActualName);

//         System.out.println(response.asString());
//         System.out.println(expectedPostTitle);
//         System.out.println(actualPostTitleString);
    }


    @Given("The API url is set")
    public void theAPIUrlIsSet() throws IOException {
       reQ = given().spec(requestspecification()).body(data.deleteProduct(productId));
    }


}