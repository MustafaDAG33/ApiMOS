package baseUrls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static utilities.ManagementOnSchoolAuthentication.generateToken;


public class MSBaseUrl {

    public static RequestSpecification spec;



//    public static void setUp() throws Exception {
//        spec=new RequestSpecBuilder().setContentType(ContentType.JSON)
//        .addHeader("Authorization",generateTokenTeacher()).
//                setBaseUri("http://164.92.252.42:8080/").build();
//    }
//
//    public static void setUp1() throws Exception {
//        spec=new RequestSpecBuilder().setContentType(ContentType.JSON)
//                .addHeader("Authorization",generateTokenDean()).
//                setBaseUri("http://164.92.252.42:8080/").build();
//    }

    public static void setUp2(String password, String username) {
        spec=new RequestSpecBuilder().setContentType(ContentType.JSON)
                .addHeader("Authorization",generateToken(password, username)).
                setBaseUri("http://164.92.252.42:8080/").build();
    }





}
