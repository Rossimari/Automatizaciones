package steps;

import java.io.IOException;
import cucumber.api.java.en.*;
import pages.PQR;

public class PQRSteps {

    PQR ModuloPQR = new PQR();

    @Given("^Ingreso al Taxation Smart$")
    public void navigateToGoogle() {
        ModuloPQR.navigateToGoogle();
    }

    @When("^Inicio de Sesion$")
    public void IngresoDeIniciarSesion() throws IOException {
        ModuloPQR.IngresoDeIniciarSesion();
    }

    @And("^Modulo de PQR$")
    public void MenuPQR() throws IOException {
        ModuloPQR.MenuPQR();
    }

    @And("^Clic en el boton en modal$")
    public void ModalPQR() {
        ModuloPQR.ModalPQR("6");
    }

    @When("^Datos Solicitud$")
    public void DatosSolicitud() throws IOException {
        ModuloPQR.DatosSolicitud();
    }

    @When("^Datos del Gestor$")
    public void DatosGestor() throws IOException, InterruptedException {
        ModuloPQR.DatosGestor();
    }

    @When("^Datos del Solicitante$")
    public void DatosSolicitante() throws IOException, InterruptedException {
        ModuloPQR.DatosSolicitante();
    }

    @And("^adjuntar$")
    public void adjuntarArchivo() throws InterruptedException {
        String rutaArchivo = "C:\\Users\\jvalencia\\Downloads\\DOCUMENTO_20220470359.pdf";
        ModuloPQR.adjuntarArchivo(rutaArchivo);
    }

    @When("^Solicitud Acuerdo de pago$")
    public void SolicitudAcuerdoPago() throws IOException, InterruptedException {
        ModuloPQR.SolicitudAcuerdoPago();
    }

    // @When("^Ventana Emergente$") 
    //     public void InteractWithModal() throws IOException {
    //         ModuloPQR.InteractWithModal();
    //     }
    
    @Then("^The results match the criteria$")
    public void validateResults() {

    }
}
