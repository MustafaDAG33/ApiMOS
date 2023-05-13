package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ManagementOnSchoolAuthentication {


    public static String generateTokenDean(){
        String postBody = "{ \"password\": \"Ekrem123\",  \"username\": \"Ekrem\"\n" +"}";
        Response response = given().contentType(ContentType.JSON).body(postBody).post("http://164.92.252.42:8080/auth/login");
        return response.jsonPath().getString("token");
    }
    public static String generateTokenTeacher(){
        String postBody = "{ \"password\": \"AydinOnan\",  \"username\": \"Aydin Onan\"\n" +"}";
        Response response = given().contentType(ContentType.JSON).body(postBody).post("http://164.92.252.42:8080/auth/login");
        return response.jsonPath().getString("token");
    }
    public static String generateTokenViceDean(){
        String postBody = "{ \"password\": \"Munevver123\",  \"username\": \"Munevver\"\n" +"}";
        Response response = given().contentType(ContentType.JSON).body(postBody).post("http://164.92.252.42:8080/auth/login");
        return response.jsonPath().getString("token");
    }

    public static String generateToken(String password, String username){
        String postBody = "{ \"password\": \""+password+"\",  \"username\": \""+username+"\"\n" +"}";
        Response response = given().contentType(ContentType.JSON).body(postBody).post("http://164.92.252.42:8080/auth/login");
        return response.jsonPath().getString("token");
    }

    /*
    String url = "jdbc:postgresql://209.38.244.227:5432/school_management";
String user = "select_user";
String password = "43w5ijfso";
     */

}
