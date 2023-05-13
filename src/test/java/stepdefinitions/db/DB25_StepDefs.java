package stepdefinitions.db;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.sql.ResultSet;
import java.sql.SQLException;

import static stepdefinitions.api.Api25_StepDefs.userId;
import static utilities.ReusableMethods.preStatement;


public class DB25_StepDefs {

    static ResultSet resultSet;
    @Given("db'den olusan student'i bul")
    public void db_den_olusan_student_i_bul() throws SQLException {
        resultSet= preStatement("student",userId);
        System.out.println("resultSet.getString(2) = " + resultSet.getString(2));
    }

    @Then("student'i dogrula")
    public void student_i_dogrula() {

    }



}
