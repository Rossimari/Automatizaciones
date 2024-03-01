package steps;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.SmartPage;

public class SmartSteps {

    SmartPage smart = new SmartPage();
    WebDriver driver;
    String rutaArchivoExcel = "C:\\SMART_AUTOMATIZACION\\EXCEL_SMART\\PQR.xlsx";

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
    @When("^iniciar sesion$")
    public void iniciarSesion() throws InterruptedException, IOException {
        smart.leerArchivoExcel(rutaArchivoExcel);
        smart.iniciarSesion();
    }

    // Botón PQR
    @Given("^nuevo pqr$")
    public void nuevoPQR() throws InterruptedException, IOException {
        smart.leerArchivoExcel(rutaArchivoExcel);
        smart.nuevoPQR();
    }

    // LLenando datos solicitud
    @Given("^llenando datos solicitud$")
    public void datosSolicitud() throws InterruptedException, IOException {
        smart.leerArchivoExcel(rutaArchivoExcel);
        smart.datosSolicitud();
    }

    // LLenando datos gestor
    @Given("^llenando datos gestor$")
    public void datosGestor() throws InterruptedException, IOException {
        smart.leerArchivoExcel(rutaArchivoExcel);
        smart.datosGestor();
    }

    // LLenando datos solicitante
    @Given("^llenando datos solicitante$")
    public void datosSolicitante() throws InterruptedException, IOException {
        smart.leerArchivoExcel(rutaArchivoExcel);
        smart.datosSolicitante();
    }

    // LLenando datos solicitante
    @Given("^cargar documentos$")
    public void documentos() throws InterruptedException, IOException {
        smart.leerArchivoExcel(rutaArchivoExcel);
        smart.documentos();
    }

    // Obtengo resultados
    @Then("^obtener resultados$")
    public void validateResults() {

    }

}
