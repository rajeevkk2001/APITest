package Common;

public interface ENDPOINT {
    String BASE_URI = "https://restcountries.eu/rest";
    String BASE_PATH = "/v2";
    String COUNTRY_CODE = "/alpha/{CountryCode}";
    String COUNTRY_NAME = "/name/{CountryName}";
}
