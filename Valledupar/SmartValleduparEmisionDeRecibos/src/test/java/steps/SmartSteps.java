package steps;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.SmartPage;

public class SmartSteps {

    SmartPage smart = new SmartPage();
    WebDriver driver;
    String rutaArchivoExcel = "C:\\SMART_AUTOMATIZACION\\EXCEL_SMART\\EmisionDeRecibos.xlsx";

    // Leer excel
    @Given("^leyendo excel$")
    public void leerArchivoExcel() throws IOException {
        smart.leerArchivoExcel(rutaArchivoExcel);
    }

    // Navegar a smart
    @Given("^navegar a smart$")
    public void navegarASmart() {
        smart.navegarASmart();
    }

    // Seleccionar cliente
    @When("^iniciar sesion$")
    public void iniciarSesion() throws InterruptedException, IOException {
        smart.leerArchivoExcel(rutaArchivoExcel);
        smart.iniciarSesion();
    }

    // Obtener resultados
    @Then("^obtener resultados$")
    public void validateResults() {

    }

    // Botón gestión financiera
    @Given("^clic al boton gestion financiera$")
    public void clicGestionFinanciera() {
        smart.clicGestionFinanciera();
    }

    // Botón documentos
    @When("^clic a opcion documentos$")
    public void clicBtnDocumentos() {
        smart.clicBtnDocumentos();
    }

    // Boton emision de recibos puntuales
    @And("^clic al boton emision de recibos puntuales$")
    public void clicBtnEmisionRecibosPuntuales() {
        smart.clicBtnEmisionRecibosPuntuales();
    }

    // Select tributo por value(html) 101 IPU - 102 ICA - 103 REN - 105 SBT - 106
    // ALB - 107 DLU
    @And("^clic select tributo$")
    public void selectTributo() {
        smart.selectTributo("101");
    }

    // Select Sub Tributo = Impuesto Predial (value)
    @And("^clic select sub tributo$")
    public void selectSubTributo() {
        smart.selectSubTributo("1011");
    }

    // Clic input identificación
    @And("^clic identificacion$")
    public void clicTxtIdentificacion() {
        smart.clicTxtIdentificacion();
    }

    // Ingreso identificación - REF. Catastral
    @And("^ingresar identificacion$")
    public void ingresarIdentificacion() {
        smart.ingresarIdentificacion("1201000000010001500000004");
    }

    // CLic botón consultar
    @And("^clic al boton consultar$")
    public void clicBtnConsultar() {
        smart.clicBtnConsultar();
    }

    // Clic checkbox desmarcar todas las liquidaciones
    @And("^clic al checkbox$")
    public void clicCheckBox() {
        smart.clicCheckBox();
    }

    // Clic checkbox marcar una liquidación [0]
    @And("^clic al checkbox liquidacion$")
    public void clicCheckBoxUno() {
        smart.clicCheckBoxUno();
    }

    // Clic botón siguiente
    @And("^clic al boton siguiente$")
    public void btnSiguiente() {
        smart.btnSiguiente();
    }

    // Enfocar ventana modal
    @And("^enfocar ventana modal$")
    public void enfocarVentanaModal() {
        smart.enfocarEnLaVentanaModal();
    }

    // Clic select plantilla - 20 - Recibo De Pago
    @And("^clic select 1$")
    public void seplantilla() {
        smart.selectPlantilla("20");
    }

    // Clic select tipo recibo - DNO Normal - DAB Abono
    @And("^clic select tipo recibo$")
    public void selectTipoRecibo() {
        smart.selectTipoRecibo("DNO");
    }

    // Clic botón imprimir
    @And("^clic boton imprimir$")
    public void imprimir() {
        smart.clicImprimir();
    }
}
