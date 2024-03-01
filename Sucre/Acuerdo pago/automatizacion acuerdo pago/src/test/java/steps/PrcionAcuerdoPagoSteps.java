package steps;

import java.io.IOException;

import cucumber.api.java.en.*;
import pages.PrcionAcuerdoPago;

public class PrcionAcuerdoPagoSteps {

    PrcionAcuerdoPago ProyeccionAuerdoPago = new PrcionAcuerdoPago();

    @Given("^Ingreso al Taxation Smart$")
    public void navigateToGoogle() {
        ProyeccionAuerdoPago.navigateToGoogle();
    }

    @When("^seleccion del cliente$")
    public void selectCategory() throws IOException {
        ProyeccionAuerdoPago.selectCategory();
    }

    @When("^seleccion de suit$")
    public void selectSuit() throws IOException {
        ProyeccionAuerdoPago.selectSuit();
    }

    @When("^ingresar usuario$")
    public void ingresarusuario() throws IOException {
        ProyeccionAuerdoPago.ingresarusuario();
    }

    @When("^ingresar contrasena$")
    public void ingresarclave() throws IOException {
        ProyeccionAuerdoPago.ingresarclave();
    }

    @And("^Clic en el boton ingresar$")
    public void clickSearchButton() {
        ProyeccionAuerdoPago.clickGoogleSearch();
    }

    @And("^Ingresa al menu Gestion financiera$")
    public void ModuloGtionFinanciera() throws InterruptedException {
        ProyeccionAuerdoPago.ModuloGtionFinanciera();
    }

    @When("^Opcion Proyecccion de Acuerdo de Pago$")
    public void ProcesoProyeccionAcuerdoPago() throws IOException, InterruptedException {
        ProyeccionAuerdoPago.ProcesoProyeccionAcuerdoPago();
    }

    @Then("^The results match the criteria$")
    public void validateResults() {

    }

}
