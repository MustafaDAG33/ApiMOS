package stepdefinitions.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.ObjectPojo;
import pojos.StudentsPojo;

import static baseUrls.MSBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Api25_StepDefs {

    Response response;
    public static int userId;
    public static StudentsPojo studentBody;
    @Given("student olustur")
    public void student_olustur() {
        spec.pathParams("first","students","second","save");

        studentBody = new StudentsPojo(3,
                "2012-07-08","Urfa","KafKaf1@gmail.com","Alex","MALE","Marry","David","KafKaf13302","556-170-2549","495-27-2549","James","KafKaf1");

        response=given(spec).body(studentBody).post("/{first}/{second}");
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        userId =  jsonPath.get("object.userId");

    }

    @When("beklenen student oldugunu dogrula")
    public void beklenen_student_oldugunu_dogrula() throws JsonProcessingException {
        ObjectPojo expectedData = new ObjectPojo(studentBody,"Student saved Successfully");
        ObjectPojo  actualData =   new ObjectMapper().readValue(response.asString(),ObjectPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(expectedData.getObject().getName(),actualData.getObject().getName());
        assertEquals(expectedData.getObject().getSurname(),actualData.getObject().getSurname());
    }

    @Given("user id no ile student hesabini cagir")
    public void userIdNoIleStudentHesabiniCagir() {
        spec.pathParams("first","students","second","getStudentById").queryParam("id",userId);
        response = given(spec).get("{first}/{second}");
        response.prettyPrint();
    }

    @Then("status kodunu dogrula")
    public void statusKodunuDogrula() {
        response.then().statusCode(200);
    }

    @Given("user id no ile student hesabini sil")
    public void userIdNoIleStudentHesabiniSil() {
        spec.pathParams("first","students","second","delete","third",userId);
        response=given(spec).delete("/{first}/{second}/{third}");
        response.prettyPrint();
    }

    @Then("student hesabinin silindigini dogrula")
    public void studentHesabininSilindiginiDogrula() {
        response.then().statusCode(200);
    }



}
