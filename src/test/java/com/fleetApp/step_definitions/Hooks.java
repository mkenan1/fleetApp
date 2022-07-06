package com.fleetApp.step_definitions;

import com.fleetApp.utilities.BrowserUtils;
import com.fleetApp.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setupScenario() {
        System.out.println("====Setting up browser using cucumber @Before");
    }
    @After
    public void teardownScenario(Scenario scenario) {

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        BrowserUtils.sleep(5);
        Driver.closeDriver();
        //System.out.println("====Closing browser using cucumber @After");
        //System.out.println("====Scenario ended/Take screenshot if failed");
    }
}
