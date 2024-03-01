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
    String rutaArchivoExcel = "C:\\SMART_AUTOMATIZACION\\EXCEL_SMART\\GestionDeRentas.xlsx";

    @Given("^leyendo excel$")
    public void leerArchivoExcel() throws IOException {
        smart.leerArchivoExcel(rutaArchivoExcel);
    }

    // Navego a smart
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

    // Botón entrar
    @And("^clic al boton entrar$")
    public void clicBtnEntrar() {
        smart.clicBtnEntrar();
    }

    // Boton gestion generacion tributo
    @When("^clic al boton generacion tributo$")
    public void clicBtnGeneracionTributo() {
        smart.clicBtnGeneracionTributo();
    }

    // Boton rentas varias
    @And("^clic a opcion rentas varias$")
    public void clicBtnRentasVarais() {
        smart.clicBtnRentasVarais();
    }

    // Boton gestion rentas varias
    @And("^clic a opcion gestion rentas varias$")
    public void clicBtnGestionRentasVarias() {
        smart.clicBtnGestionRentasVarias();
    }

    // Boton nueva renta
    @And("^clic al boton nueva renta$")
    public void clicBtnNuevaRenta() {
        smart.clicBtnNuevaRenta();
    }

    // Boton nueva renta
    @And("^select sub tributo$")
    public void selectSubTributo() throws IOException {
        smart.leerArchivoExcel(rutaArchivoExcel);
        smart.selectSubTributo();
    }

    // Boton nueva renta
    @And("^select acto$")
    public void selectActo() throws IOException {
        smart.selectActo();
    }

    // Marcar checkbox
    @And("^clic checkbox$")
    public void clicBtnCheck() throws IOException, InterruptedException {
        smart.clicBtnCheck();
    }

    // clic boton siguiente
    @And("^clic boton siguiente$")
    public void clicBtnSiguiente() throws IOException {
        smart.clicBtnSiguiente();
    }

    // ingresar identificacion
    @And("^ingresar identificacion$")
    public void ingresarIdentificacion() throws IOException {
        smart.ingresarIdentificacion();
    }

    // clic consultar
    @And("^clic consultar$")
    public void clicBtnConsultar() throws IOException, InterruptedException {
        smart.clicBtnConsultar();
    }

    // clic consultar
    @And("^ingresar numero vallas$")
    public void ingresarNumeroVallas() throws IOException {
        smart.ingresarNumeroVallas();
    }

    // clic consultar
    @And("^clic boton calendario$")
    public void clicBtnCalendario() throws IOException {
        smart.clicBtnCalendario();
    }

    // clic consultar
    @And("^seleccionar dia$")
    public void seleccionarDia() throws IOException {
        smart.seleccionarDia();
    }

    // clic boton siguiente ods
    @And("^clic boton siguiente dos$")
    public void clicBtnSiguienteDos() throws IOException {
        smart.clicBtnSiguienteDos();
    }

    // clic consultar
    @And("^clic boton calendario dos$")
    public void clicBtnCalendarioDos() throws IOException {
        smart.clicBtnCalendarioDos();
    }

    // clic consultar
    @And("^seleccionar dia dos$")
    public void seleccionarDiaDos() throws IOException {
        smart.seleccionarDiaDos();
    }

    // clic botón generar
    @And("^clic boton generar$")
    public void clicBtnGenerar() throws IOException {
        smart.clicBtnGenerar();
    }

    // clic botón generar
    @And("^seleccionar dia tres$")
    public void clicBtnSiguienteTres() throws IOException {
        smart.clicBtnSiguienteTres();
    }

    // clic seleccionar plantilla
    @And("^seleccionar plantilla$")
    public void selectPlantillaLiquidacion() throws IOException {
        smart.selectPlantillaLiquidacion();
    }

    // clic boton terminar
    @And("^clic boton terminar$")
    public void clicBtnTerminar() throws IOException {
        smart.clicBtnTerminar();
    }

    // clic boton imprimir
    @And("^clic boton imprimir$")
    public void clicBtnImprimir() throws IOException {
        smart.clicBtnImprimir();
    }

    // Obtengo resultados
    @Then("^obtener resultados$")
    public void validateResults() {

    }

}
