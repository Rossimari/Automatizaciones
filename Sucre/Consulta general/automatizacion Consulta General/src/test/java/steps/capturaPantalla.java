package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.AfterStep;
import pages.RecaudoPage;

public class capturaPantalla extends RecaudoPage {

    public capturaPantalla() {
        super(driver);
    }

    // Para tomar capturas a cada paso
    @AfterStep
    public void tearDown(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
    }

}