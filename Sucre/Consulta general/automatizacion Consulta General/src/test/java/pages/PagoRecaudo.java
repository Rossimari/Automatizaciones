package pages;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PagoRecaudo extends RecaudoPage {

    private String CheckBoxCliente = "//select[@id='P101_CDGO_CLNTE']";
    private String CheckBoxSuid = "//select[@id='P101_ID_APLCCION_GRPO']";
    private String IngresarUsuario = "//input[@id='P101_USERNAME']";
    private String IngresarPassword = "//input[@id='P101_PASSWORD']";
    private String ClickButtonEntrar = "//button[@id='B95351952122507356']";
    private String MenuGtionFinanciera = "//header/div[2]/div[1]/ul[1]/li[4]/span[1]/span[1]";

    public PagoRecaudo() {
        super(driver);
    }

    // public void leerExcel() throws IOException {
    // leerxsl(RutaArchivoExcel);
    // }

    public void navigateToGoogle() {
        RecaudoPage.driver.manage().window().maximize();
        navigateTo("http://192.168.11.32:8032/ords/f?p=50000:101:2073602904197:::::");
    }

    public void selectCategory(String criteria) {
        // leerxsl(RutaArchivoExcel);
        selectFromDropdownByValue(CheckBoxCliente, criteria);
    }

    public void selectSuit(String criteria) {
        // leerxsl(RutaArchivoExcel);
        selectFromDropdownByValue(CheckBoxSuid, criteria);
    }

    public void ingresarusuario(String criteria) {
        // leerxsl(RutaArchivoExcel);
        write(IngresarUsuario, criteria);
    }

    public void ingresarclave(String criteria) {
        // leerxsl(RutaArchivoExcel);
        write(IngresarPassword, criteria);
    }

    public void GtionFciera(String criteria) {
        findElement(MenuGtionFinanciera, criteria);
    }
}