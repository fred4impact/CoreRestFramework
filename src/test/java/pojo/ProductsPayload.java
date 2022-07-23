package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductsPayload {

    public ProductsPayload(String name, String quantity, String brand, String category ){
        this.name = name ;
        this.quantity = quantity;
        this.brand = brand;
        this.category = category;
    }

    @JsonProperty("name")
    String name;

    @JsonProperty("quantity")
    String quantity;

    @JsonProperty("brand")
    String brand ;

    @JsonProperty("category")
    String category ;

}
