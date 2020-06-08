package employeeinfo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PayloadReader {

    public static String baseUrl = "http://info.venturepulse.org:8080/service-webapp";
    public static String resourcePath = "/api/SingleEmployeeResources";
    public static String moduleName = "/EmployeeInfoServices";

    public static int postPayload(String baseUrl, String resourcePath, String path) throws IOException{
        RestAssured.baseURI = baseUrl;
        String workingDirectory = System.getProperty("user.dir");
        File filePath = new File(workingDirectory+moduleName+path);

        String json = generateStringFromSource(filePath.getAbsolutePath());
        Response response = null;
        try{
            response = RestAssured.given().contentType((ContentType.JSON)).body(json).accept(ContentType.JSON).post(resourcePath);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println(response.getBody());

        return response.getStatusCode();
    }

    public static String generateStringFromSource(String path)throws IOException {
        String json = new String(Files.readAllBytes(Paths.get(path)));

     return json;
    }

    public static void main(String[] args)throws IOException {
        File file = new File(JsonFile.singleEmpProfile);
        System.out.println(file.getPath());
        int response = postPayload(baseUrl,resourcePath,JsonFile.singleEmpProfile);
        System.out.println(response);
    }
}
