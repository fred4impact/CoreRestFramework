package stepDefinitions;

import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {


    @Before("@DeleteProduct")
    public void Delete_method_preRequite() throws IOException
    {
        if(E2EStepDefinition.productId==null)
        {
            E2EStepDefinition step = new E2EStepDefinition();
            step.theAPIUrlIsSetWithPayload("Voxwagen Golf", "5", "VW", "Car");
            step.iSendRequestToEndpoint("POST", "PostProducts");
            step.verifyIdOfDataCreatedEqualsToUsing("lADIES Bag ", "GetProducts");
        }
    }




}
