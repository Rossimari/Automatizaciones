package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.AfterStep;
import pages.PQRPage;

public class capturaPantalla extends PQRPage {

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