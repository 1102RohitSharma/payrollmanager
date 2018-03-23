package stepdefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import frameworksupportmethods.GenericBaseClass;

import java.io.IOException;

import static webdriver.AppDriver.driver;
import static webdriver.AppDriver.getCurrentDriver;

public class CucumberHooks extends GenericBaseClass{

    @Before
    public void getScenario(Scenario sc){
        scenario = sc.getSourceTagNames ();
    }

    @Before
    public void launchBrowser() throws IOException {
        driver = getCurrentDriver ();
        dm.maximizeWindow ();
    }

    @After
    public void closeBrowser() throws IOException {
        dm.waitImplicitly ( 1000 );
        driver = null;
        driver.quit ();
    }
}
