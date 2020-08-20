package RestAssuredExtension;


import Common.ENDPOINT;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.trustStore;

public class RestAssuredResposeBuilder {
    public static RequestSpecification Request;
    public Response Response;

    public RestAssuredResposeBuilder() {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setContentType(ContentType.JSON);
        builder.setBaseUri(ENDPOINT.BASE_URI);
        builder.setBasePath(ENDPOINT.BASE_PATH);
        RequestSpecification reqSpec = builder.build();
        Request = RestAssured.given().spec(reqSpec);

    }

    public Response getCapital(HashMap<String, String> paramValue, String path)  {
        Request.pathParams(paramValue);
        Response = Request.get(path);
        return Response;
    }
}