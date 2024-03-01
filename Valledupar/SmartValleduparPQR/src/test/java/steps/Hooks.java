package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import cucumber.api.Scenario;
import cucumber.api.java.AfterStep;
import pages.BasePage;

public class Hooks extends BasePage {

    public Hooks() {
        super(driver);
    }

    // Para tomar capturas a cada paso
    @AfterStep
    public void tearDown(Scenario scenario) {
        // if (scenario.isFailed()) {
        // scenario.write("Esto fallo");
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
        // }

    }

}