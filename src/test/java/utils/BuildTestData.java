package utils;

import pojo.JsonPost;
import pojo.ProductsPayload;

public class BuildTestData {

    ProductsPayload product;

    public ProductsPayload getProduct(String name, String quantity, String brand, String category){

        product = new ProductsPayload(name, quantity, brand, category);
        return product;

    }

    public String deleteProduct(String productId)
    {
        return "{\r\n\r\n    \"id\" : \""+productId+"\"\r\n}";
    }




}
