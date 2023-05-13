package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ConfigReader;
import utilities.Driver;

public class Hooks {


    @Before(value = "@us25")
    public void setUpScenarios() throws Exception {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

//    @Before(value = "@api20")
//    public void before() throws Exception {
//        setUp();
//    }
//    @Before(value = "@api25")
//    public void before1() throws Exception {
//        setUp1();
//    }



    @After(value = "@us25")
    public void tearDownScenarios(Scenario scenario) throws InterruptedException {
        //Eger bir Scenario FAIL ederse, ekran goruntusunu al ve rapora ekle
        if (scenario.isFailed()) {
            Thread.sleep(1000);
            final byte[] failedScreenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            //ekran goruntusu    file tipi                  ekran goruntusunun adi
            scenario.attach(failedScreenshot, "image/png", "failed_scenario_" + scenario.getName());
        }
        Driver.closeDriver();

    }



}