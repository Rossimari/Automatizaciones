package pages;

import java.util.concurrent.TimeUnit;

// import java.io.IOException;

// import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
// import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
// import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PQRPage {
    // private String RutaArchivoExcel =
    // "C:\\Data\\RecaudoManual\\RecaudoManualTax.xlsx";
    // private CharSequence numeroDocumento;
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    static {
        System.setProperty("webdriver.chrome.driver",
                "C:\\chromedriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);
    }

    public PQRPage(WebDriver driver) {
        PQRPage.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    public static void navigateTo(String url) {
        driver.get(url);
    }

    private WebElement find(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void write(String locator, String textToWrite) {
        find(locator).clear();
        find(locator).sendKeys(textToWrite);
    }

    public void selectFromDropdownByValue(String locator, String valueToSelect) {
        Select dropdown = new Select(find(locator));
        dropdown.selectByValue(valueToSelect);
    }

    public void selectFromDropdownByIndex(String locator, int valueToSelect) {
        Select dropdown = new Select(find(locator));
        dropdown.selectByIndex(valueToSelect);
    }

    public void selectFromDropdownByText(String locator, String valueToSelect) {
        Select dropdown = new Select(find(locator));
        dropdown.selectByVisibleText(valueToSelect);
    }

    public void findElement(String locator) {
        find(locator).click();
    }

    public void ventaEmergente() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement modal = driver.findElement(By.xpath("//body/div[6]"));
        js.executeScript("arguments[0].focus();", modal);
    }

    public void salirfocus() {
        driver.switchTo().defaultContent();
    }

    public void interactWithModal() {

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Cambia el controlador a la nueva ventana/modal.
        String mainWindowHandle = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // Espera a que la ventana modal esté completamente cargada.
        WebDriverWait modalWait = new WebDriverWait(driver, 30);
        modalWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[14]")));

        // Encuentra el elemento que bloquea
        WebElement blockingElement = driver.findElement(By.cssSelector("div.ui-widget-overlay.ui-front"));

        // Mueve el cursor del mouse fuera del elemento que bloquea
        Actions actions = new Actions(driver);
        actions.moveToElement(blockingElement, 0, 0).perform();

        // Ejecuta JavaScript para hacer clic en el elemento dentro de la modal
        WebElement elementInModal = driver.findElement(By.xpath("//body/div[14]/div[2]/iframe[1]"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].focus();", elementInModal);
        driver.switchTo().frame(0);

        // Ejemplo: Seleccionar un elemento de un combobox.
        WebElement comboBox = driver.findElement(By.xpath("//select[@id='P17_FLUJOS']"));
        Select select = new Select(comboBox);
        select.selectByVisibleText("VENTANILLA DE PQR");

        WebElement botonImprimir = driver.findElement(By.xpath("//button[@id='B33554374137715603']"));
        botonImprimir.click();

        // By confirmationElementLocator = By.cssSelector("#B182542050849889005");
        // WebDriverWait printWait = new WebDriverWait(driver, 60); // Espera hasta 60
        // segundos
        // printWait.until(ExpectedConditions.visibilityOfElementLocated(confirmationElementLocator));

    }

    //     public void InteractWithModal() {

    //     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    //     // Cambia el controlador a la nueva ventana/modal.
    //     String mainWindowHandle = driver.getWindowHandle();
    //     for (String windowHandle : driver.getWindowHandles()) {
    //         if (!windowHandle.equals(mainWindowHandle)) {
    //             driver.switchTo().window(windowHandle);
    //             break;
    //         }
    //     }
    //     WebDriverWait modalWait = new WebDriverWait(driver, 30);
    //     modalWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[14]")));

    //      WebElement botonAceptar = driver.findElement(By.xpath("//button[contains(text(),'Aceptar')]"));
    //     botonAceptar.click();
    // }
}
