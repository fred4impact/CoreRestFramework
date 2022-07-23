package endpoints;

public enum ResourceEndpoints {
    
//    AddPost("/posts"),
//    GetPosts("/posts"),
//    DeletePost("/post/1"),
    GetProducts("/products"),
    PostProducts("/products"),
    DeleteProduct("/products/");



    private String resource;
    ResourceEndpoints(String resource) {
        this.resource=resource ;
    }

    public String getResource(){
        return resource ;
    }
}
