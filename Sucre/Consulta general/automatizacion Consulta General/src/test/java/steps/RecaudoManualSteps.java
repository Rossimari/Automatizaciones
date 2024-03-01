package steps;

import java.io.IOException;

import cucumber.api.java.en.*;
import pages.PagoRecaudo;

public class RecaudoManualSteps {

    PagoRecaudo RecaudoManual = new PagoRecaudo();

    @Given("^Ingreso al Taxation Smart$")
    public void navigateToGoogle() {
        RecaudoManual.navigateToGoogle();
    }

    @When("^seleccion del cliente$")
    public void selectCategory() throws IOException {
        RecaudoManual.selectCategory();
    }

    @When("^seleccion de suit$")
    public void selectSuit() throws IOException {
        RecaudoManual.selectSuit();
    }

    @When("^ingresar usuario$")
    public void ingresarusuario() throws IOException {
        RecaudoManual.ingresarusuario();
    }

    @When("^ingresar contraseña$")
    public void ingresarclave() throws IOException {
        RecaudoManual.ingresarclave();
    }

    @And("^Clic en el boton ingresar$")
    public void clickSearchButton() {
        RecaudoManual.clickGoogleSearch();
    }

    @And("^Ingresa al menu de Recaudo Manual$")
    public void clickMenuButton() {
        RecaudoManual.ClicRecaudoManualButton();
    }

    @When("^impuesto Rentas varias$")
    public void selectRenta() throws IOException {
        RecaudoManual.selectRenta();
    }

    @When("^SubImpuestos Rentas varias$")
    public void selectSubImpuestos() throws IOException {
        RecaudoManual.selectSubImpuestos();
    }

    @When("^Bancos$")
    public void selectBancos() throws IOException {
        RecaudoManual.selectBancos();
    }

    @When("^Cuenta Bancos$")
    public void selectCuentaBanco() throws IOException {
        RecaudoManual.selectCuentaBanco();
    }

    @When("^Observacion$")
    public void selectObservacion() throws IOException {
        RecaudoManual.selectObservacion();
    }

    @When("^Numero documento$")
    public void IngresarNumeroDocumento() throws IOException {
        RecaudoManual.IngresarNumeroDocumento();
    }

    @And("^Click Barra$")
    public void clickBarra() throws IOException, InterruptedException {
        RecaudoManual.clickBarra();
        RecaudoManual.clickIncluirRecaudo();
        RecaudoManual.clickConfirmarRecaudo();
        RecaudoManual.clickVentaEmergente();
        RecaudoManual.MenuGtionFcra();
    }

    @And("^Consulta General$")
    public void CsltaGeneralSujeto() throws IOException, InterruptedException {
        RecaudoManual.CsltaGeneralSujeto();
    }

    @Then("^The results match the criteria$")
    public void validateResults() {

    }

    @And("^Clic en el boton siguiente$")
    public void clickSiguiente() {
        RecaudoManual.clickSiguiente();

    }

}
