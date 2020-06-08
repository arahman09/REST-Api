package employeeinfo;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class AllEmployeeResourcesApi {

    String baseUrl = "http://info.venturepulse.org:8080/service-webapp";

    public void callAllEmployeeInfoWithValidRequest(){
        Response response = given().when().get(baseUrl+"/api/AllEmployeeResources").then().statusCode(200).extract().response();
        String statusLine = response.getStatusLine();
        int statusCode = response.statusCode();
        String body = response.getBody().prettyPrint();
        System.out.println(body);
        System.out.println(statusLine);
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
        Assert.assertEquals(statusCode,200);
    }
}
