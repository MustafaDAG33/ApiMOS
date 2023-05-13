package stepdefinitions.db;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static stepdefinitions.api.Api20_StepDefs.meetId;
import static utilities.ReusableMethods.preStatement;

public class DB20_StepDefs {

    static   ResultSet resultSet;
//    static Connection connection;
//    static Statement statement;

    @Given("Teacher hesabiyla olusturulan toplantiyi bul")
    public void teacher_hesabiyla_olusturulan_toplantiyi_bul() throws SQLException {
//        connection= DriverManager.getConnection("jdbc:postgresql://164.92.252.42:5432/school_management","select_user","43w5ijfso");
//        statement=  connection.createStatement();
//        resultSet=  statement.executeQuery("SELECT * FROM meet WHERE id='"+meetId+"'");
//        resultSet.next();
        resultSet =  preStatement("meet",meetId);
    }


    @Then("Toplantiyi dogrula")
    public void toplantiyi_dogrula() throws SQLException {

        int actId = resultSet.getInt("id");
        String actDate = resultSet.getString("date");
        String actDescription = resultSet.getString("description");
        String actStartTime = resultSet.getString("start_time");
        String actStopTime = resultSet.getString("stop_time");
        int actAdvisorTeacherId = resultSet.getInt("advisor_teacher_id");
        assertEquals("2024-09-03",actDate);
        assertEquals("Importance",actDescription);
        assertEquals("19:00:00",actStartTime);
        assertEquals("22:00:00",actStopTime);
        assertEquals(798,actAdvisorTeacherId);
    }

    @Then("toplantinin db'den silindigini dogrula")
    public void toplantininDbDenSilindiginiDogrula() throws SQLException {
        assertFalse(resultSet.next());
    }



}
