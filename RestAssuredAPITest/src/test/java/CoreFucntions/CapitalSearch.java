package CoreFucntions;

import RestAssuredExtension.RestAssuredResposeBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import Common.ENDPOINT;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.Matchers.equalTo;

public class CapitalSearch {
    static Response response;

    /*
      This  is to search by country code and display ,capital and country Name
     */

    public static void getCapital_CountryCode() throws Exception {

        RestAssuredResposeBuilder restAssuredExtension = new RestAssuredResposeBuilder();
        HashMap<String, String> pathParameters = new HashMap<String, String>();
        String capital = "", alphaCode = "";

        System.out.println(" Please enter a country code");
        Scanner in = new Scanner(System.in);
        System.out.print(">>>");
        String countryCode = in.next();

        pathParameters.put("CountryCode", countryCode);
        response = restAssuredExtension.getCapital(pathParameters, ENDPOINT.COUNTRY_CODE);
        String statusCode = String.valueOf(response.getStatusCode());
        if (statusCode.contains("200")) {
            System.out.println("Got success response from API");
            if (countryCode.length() == 2) {
                alphaCode = "alpha2Code";
                capital = response.then().contentType(ContentType.JSON).body(alphaCode, equalTo(countryCode.toUpperCase()))
                        .extract().path("capital");
            }

            if (countryCode.length() == 3) {
                alphaCode = "alpha3Code";
                capital = response.then().contentType(ContentType.JSON).body(alphaCode, equalTo(countryCode.toUpperCase()))
                        .extract().path("capital");
            }
            String countryName = response.then().contentType(ContentType.JSON).body(alphaCode, equalTo(countryCode.toUpperCase()))
                    .extract().path("name");

            System.out.println(" User entered Country code : " + countryCode + "\n Capital :" + capital + "\n Country Name :" + countryName);

        } else {
            System.out.println(" API Response code is " + statusCode + " Result not found for the country code " + countryCode);


        }

    }

/*
      This  is to search by country name and display ,capital and country code , and native name
     */

    public static void getCapital_CountryName() throws Exception {

        RestAssuredResposeBuilder restAssuredExtension = new RestAssuredResposeBuilder();
        HashMap<String, String> pathParameters = new HashMap<String, String>();
        String capital = "", alphaCode = "";

        System.out.println(" Please enter a country Name ");
        Scanner in = new Scanner(System.in);
        System.out.print(">>>");
        String countryName = in.next();

        pathParameters.put("CountryName", countryName);
        response = restAssuredExtension.getCapital(pathParameters, ENDPOINT.COUNTRY_NAME);
        String statusCode = String.valueOf(response.getStatusCode());
        if (statusCode.contains("200")) {
            System.out.println("Got success  response from API");

            List<String> capitals = response.jsonPath().getList("capital");
            List<String> countryCodes = response.jsonPath().getList("alpha3Code");
            List<String> nativeNames = response.jsonPath().getList("nativeName");
            System.out.println(" User entered Country Name :" + countryName);
            System.out.println("***********************************************");

            for (int i = 0; i < capitals.size(); i++) {
                System.out.println("Native Name :" + nativeNames.get(i) + ",  Country Code :" + countryCodes.get(i) + ", Capital  :" + capitals.get(i));
            }

        } else {
            System.out.println(" API Response code is " + statusCode + " Result not found for the country code ");


        }
    }
}