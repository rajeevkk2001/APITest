package Tests;

import RestAssuredExtension.RestAssuredResposeBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import Common.ENDPOINT;
import java.util.HashMap;
import static org.hamcrest.Matchers.equalTo;

public class CountryAPITestwithTestNG implements ENDPOINT {
    Response response;

    // This is a sample implementation is with Rest Assured and TestNG framework
    @Test(priority = 1 )
    public void searhCapital() throws Exception {
        RestAssuredResposeBuilder restAssuredExtension = new RestAssuredResposeBuilder();
        String countryCode = "IND" ;
        HashMap<String, String> pathParameters = new HashMap<String, String>();
        pathParameters.put("CountryCode",countryCode);
        response = restAssuredExtension.getCapital(pathParameters,ENDPOINT.COUNTRY_CODE);
        String statusCode = String.valueOf(response.getStatusCode());
        if (statusCode.contains("200")) {
            System.out.println("PASSED");
            String capital = response.then().contentType(ContentType.JSON)
                    .body("alpha3Code",equalTo(countryCode))
                    .extract().path("capital");
            String country = response.then().contentType(ContentType.JSON).body("alpha3Code",equalTo(countryCode)).extract().path("name");
            System.out.println(" Capital of  "+country +" with country code "+ countryCode+" is "+capital);

        } else {
            System.out.println("API Response is ");
        }

    }





}