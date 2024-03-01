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
    String rutaArchivoExcel = "C:\\SMART_AUTOMATIZACION\\EXCEL_SMART\\ConsultaGeneral.xlsx";

    // Leer excel
    @Given("^leyendo excel$")
    public void leerArchivoExcel() throws IOException {
        smart.leerArchivoExcel(rutaArchivoExcel);
    }

    // Navego a smart
    @Given("^navegar a smart$")
    public void navegarASmart() {
        smart.navegarASmart();
    }

    // Iniciar sesión
    @When("^iniciar sesion$")
    public void iniciarSesion() throws InterruptedException, IOException {
        smart.leerArchivoExcel(rutaArchivoExcel);
        smart.iniciarSesion();
    }

    // Boton gestion financiera
    @When("^clic al boton gestion financiera$")
    public void clicGestionFinanciera() {
        smart.clicGestionFinanciera();
    }

    // Boton documentos
    @And("^clic a opcion consulta general$")
    public void clicBtnConsultaGeneral() {
        smart.clicBtnConsultaGeneral();
    }

    // Ingresar identificacion
    @And("^ingresar identificacion$")
    public void ingresarIdentificacion() throws IOException {
        smart.leerArchivoExcel(rutaArchivoExcel);
        smart.ingresarIdentificacion();
    }

    // Clic botón consultar
    @And("^clic al boton consultar$")
    public void clicBtnConsultar() {
        smart.clicBtnConsultar();
    }

    // Clic impuesto
    @And("^clic impuesto predial$")
    public void clicImpuesto() {
        smart.clicImpuesto();
    }

    // Clic cartera
    @Given("^clic a la opcion cartera$")
    public void clicOpcionCartera() {
        smart.clicOpcionCartera();
    }

    // Obtengo resultados
    @Then("^obtener resultados$")
    public void validateResults() {

    }

}
