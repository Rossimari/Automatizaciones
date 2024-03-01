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
    String rutaArchivoExcel = "C:\\SMART_AUTOMATIZACION\\EXCEL_SMART\\RecaudosManual.xlsx";

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
    @When("^seleccionar cliente$")
    public void seleccionarCliente() throws InterruptedException, IOException {
        smart.leerArchivoExcel(rutaArchivoExcel);
        smart.selectCliente();
    }

    // Seleccionar suit
    @And("^seleccionar suit$")
    public void seleccionarSuit() {
        smart.selectSuit();
    }

    // Ingresar usuario
    @And("^ingresar usuario$")
    public void ingresarUsuario() throws IOException {
        smart.leerArchivoExcel(rutaArchivoExcel);
        smart.ingresarUsuario();
    }

    // Ingresar clave
    @And("^ingresar clave$")
    public void ingresarClave() {
        smart.ingresarClave();
    }

    // Clic botón entrar
    @And("^clic al boton entrar$")
    public void clicBtnEntrar() {
        smart.clicBtnEntrar();
    }

    // Obtener resultados
    @Then("^obtener resultados$")
    public void validateResults() {

    }

    // Botón gestión financiera
    @Given("^clic al boton gestion financiera$")
    public void clicGestionFinanciera() throws IOException {
        smart.leerArchivoExcel(rutaArchivoExcel);
        smart.clicGestionFinanciera();
    }

    // Botón documentos
    @When("^clic a opcion recaudos$")
    public void clicBtnDocumentos() {
        smart.clicBtnRecaudos();
    }

    // Boton gestión registro recaudo manual
    @And("^clic al boton gestion registro recaudo manual$")
    public void clicBtnGestionRegistroRecaudoManual() {
        smart.clicBtnGestionRegistroRecaudoManual();
    }

    // CLic botón nuevo registro
    @And("^clic al boton nuevo registro$")
    public void clicBtnNuevoRegistro() {
        smart.clicBtnNuevoRegistro();
    }

    // Seleccionar tributo
    @And("^seleccionar tributo$")
    public void seleccionarTributo() {
        smart.selectTributo();
    }

    // Seleccionar sub tributo
    @And("^seleccionar sub tributo$")
    public void seleccionarSubTributo() {
        smart.selectSubTributo();
    }

    // Seleccionar banco
    @And("^seleccionar banco$")
    public void seleccionarBanco() {
        smart.selectBanco();
    }

    // Seleccionar banco cuenta
    @And("^seleccionar banco cuenta$")
    public void seleccionarBancoCuenta() {
        smart.selectBancoCuenta();
    }

    // Ingresar observacion registro recaudo manual
    @And("^ingresar observacion registro recaudo manual$")
    public void ingresarObservacion() {
        smart.ingresarObservacion();
    }

    // Clic botón siguiente
    @And("^clic al boton siguiente$")
    public void clicBtnSiguiente() {
        smart.clicBtnSiguiente();
    }

    // Ingresar número documento
    @And("^ingresar numero documento$")
    public void ingresarNoDocumento() throws InterruptedException {
        smart.ingresarNoDocumento();
    }

    // enter codigo barra
    @And("^enter codigo barra$")
    public void enterCodigoBarra() throws InterruptedException {
        smart.enterCodigoBarra();
    }

    // Ingresar observación opcional
    @And("^ingresar observacion opcional$")
    public void ingresarObservacionOpcional() throws InterruptedException {
        smart.ingresarObservacionOpcional();
    }

    // Clic botón incluir recaudo
    @And("^clic al boton incluir recaudo$")
    public void clicBtnIncluirRecaudo() {
        smart.clicBtnIncluirRecaudo();
    }

    // clic al boton confirmar registro
    @And("^clic al boton confirmar registro$")
    public void clicBtnConfirmarRegistro() throws InterruptedException {
        smart.clicBtnConfirmarRegistro();
    }

    // clic al boton aceptar modal
    @And("^clic al boton aceptar modal$")
    public void clicBtnAceptarModal() throws InterruptedException {
        smart.clicBtnAceptarModal();
    }

    // Proceso aplicar recaudo
    @When("^proceso aplicar recaudo$")
    public void aplicarRecaudo() throws InterruptedException, IOException {
        smart.leerArchivoExcel(rutaArchivoExcel);
        smart.aplicarRecaudo();
    }

}
