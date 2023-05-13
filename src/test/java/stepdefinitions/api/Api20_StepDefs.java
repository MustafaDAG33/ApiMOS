package stepdefinitions.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.MeetCreatePojo;
import pojos.MeetRootPojo;
import pojos.MeetValidatePojo;
import pojos.StudentsPojo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static baseUrls.MSBaseUrl.setUp2;
import static baseUrls.MSBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static stepdefinitions.api.Api25_StepDefs.studentBody;

public class Api20_StepDefs {

    static Response response;
    static ArrayList<Integer> studentId;
    static List<StudentsPojo> studentPojoId;
    public static int meetId;
    static MeetCreatePojo meetUpdateBody;

    @Given("teacher hesabiyla tum toplantilari cagir")
    public void teacher_hesabiyla_tum_toplantilari_cagir() {
        spec.pathParams("first","meet","second","getAllMeetByAdvisorTeacherAsList");
        response=given(spec).get("{first}/{second}");
        response.prettyPrint();
    }
    @When("toplantilarin geldigini dogrula")
    public void toplantilarin_geldigini_dogrula() {
        response.then().statusCode(200);
        ArrayList toplantilar = response.as(ArrayList.class);
        assertEquals(8, toplantilar.size());
    }
    @Given("teacher hesabiyla bir toplanti olustur")
    public void teacherHesabiylaBirToplantiOlustur() {
        spec.pathParams("first","meet","second","save");

        studentId= new ArrayList<>();
        studentId.add(578);
        MeetCreatePojo meetCreatePojo = new MeetCreatePojo("2024-09-03","Importance","19:00","22:00",studentId);
        System.out.println("meetPojo = " + meetCreatePojo);
        response=given(spec).body(meetCreatePojo).post("{first}/{second}");
        response.prettyPrint();
        JsonPath jsonPath = response.jsonPath();
        meetId =  jsonPath.get("object.id");
    }
    @Then("beklenen toplantinin oldugunu dogrula")
    public void beklenenToplantininOldugunuDogrula() throws IOException {
        studentPojoId = new ArrayList<>();
        studentPojoId.add(studentBody);
        MeetValidatePojo meetValidatePojo = new MeetValidatePojo("Importance",
                "2024-09-03","19:00:00","22:00:00",798,"Aydin","528-78-1456",studentPojoId);
        MeetRootPojo expectedData = new MeetRootPojo(meetValidatePojo,"Meet Saved Successfully","CREATED");
        MeetRootPojo actualData = new ObjectMapper().readValue(response.asString(),MeetRootPojo.class);
        assertEquals(meetValidatePojo.getAdvisorTeacherId(),actualData.getObject().getAdvisorTeacherId());
        assertEquals(meetValidatePojo.getDate(),actualData.getObject().getDate());
        assertEquals(meetValidatePojo.getStartTime(),actualData.getObject().getStartTime());
        assertEquals(meetValidatePojo.getStopTime(),actualData.getObject().getStopTime());
        assertEquals(meetValidatePojo.getDescription(),actualData.getObject().getDescription());
        assertEquals(expectedData.getMessage(),actualData.getMessage());
        assertEquals(expectedData.getHttpStatus(),actualData.getHttpStatus());
        assertTrue(actualData.getObject().getStudents().toString().contains("David"));
        assertTrue(actualData.getObject().getStudents().toString().contains("James"));
        assertTrue(actualData.getObject().getStudents().toString().contains("5.James"));
        assertTrue(actualData.getObject().getStudents().toString().contains("398-22-2547"));
        assertTrue(actualData.getObject().getStudents().toString().contains("2014-05-02"));
        assertTrue(actualData.getObject().getStudents().toString().contains("Tokyo"));
        assertTrue(actualData.getObject().getStudents().toString().contains("556-628-2547"));
        assertTrue(actualData.getObject().getStudents().toString().contains("MALE"));
        assertTrue(actualData.getObject().getStudents().toString().contains("Marry"));
        assertTrue(actualData.getObject().getStudents().toString().contains("Alex"));
        assertTrue(actualData.getObject().getStudents().toString().contains("tokyo@gmail.com"));
    }
    @Given("toplanti id no ile toplantiyi editle")
    public void toplantiIdNoIleToplantiyiEditle() {
        spec.pathParams("first","meet","second","update","third",meetId);
        ArrayList<Integer> studentId = new ArrayList<>();
        studentId.add(578);
        meetUpdateBody = new MeetCreatePojo("2024-09-07","Most Importance","19:00","22:00",studentId);
        response=given(spec).body(meetUpdateBody).put("{first}/{second}/{third}");
        response.prettyPrint();
    }
    @Then("toplantinin editlendigini dogrula")
    public void toplantininEditlendiginiDogrula() {
        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("description","Most Importance");
        expectedData.put("date","2024-09-07");
        expectedData.put("startTime","19:00:00");
        expectedData.put("stopTime","22:00:00");
        Map<String,Object> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);
        response.then().statusCode(200);
        assertEquals(expectedData.get("date"), ((Map) actualData.get("object")).get("date"));
        assertEquals(expectedData.get("description"),((Map) actualData.get("object")).get("description"));
        assertEquals(expectedData.get("startTime"),((Map) actualData.get("object")).get("startTime"));
        assertEquals(expectedData.get("stopTime"),((Map) actualData.get("object")).get("stopTime"));
    }
    @Given("user id no ile toplantiyi sil")
    public void userIdNoIleToplantiyiSil() {
        spec.pathParams("first","meet","second","delete","third",meetId);
        response=given(spec).delete("{first}/{second}/{third}");
        response.prettyPrint();
    }
    @Then("toplantinin silindigini dogrula")
    public void toplantininSilindiginiDogrula() {
        response.then().statusCode(200);
    }


    @Given("{string} ve {string} ile token al")
    public void veIleTokenAl(String arg0, String arg1){
        setUp2(arg0,arg1);
    }
}
