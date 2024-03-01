package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SmartPage extends BasePage {

    Actions actions = new Actions(driver);

    // Ruta archivo excel
    String rutaArchivoExcel = "C:\\SMART_AUTOMATIZACION\\EXCEL_SMART\\RecaudosManual.xlsx";

    // -----------------------------------------------------------------
    // -----------------------------------------------------------------
    // -----------------Parametros del excel-----------------------
    // -----------------------------------------------------------------
    private String v_cliente;
    private String v_suit;
    private String v_usuario;
    private String v_clave;
    private String v_tributo;
    private String v_subTributo;
    private String v_banco;
    private String v_bancoCuenta;
    private String v_observacionRegistroRecaudoManual;
    private String v_noDocumento;

    // -----------------------------------------------------------------
    // -----------------------------------------------------------------
    // -------------------Parametros de iniciar sesión-----------------
    // -----------------------------------------------------------------
    // -----------------------------------------------------------------
    private String v_selectCliente = "//select[@id='P101_CDGO_CLNTE']";
    private String v_selectSuit = "//select[@id='P101_ID_APLCCION_GRPO']";
    private String v_txtUsuario = "//input[@id='P101_USERNAME']";
    private String v_txtClave = "//input[@id='P101_PASSWORD']";

    // -----------------------------------------------------------------
    // -----------------------------------------------------------------

    // Botón entrar
    private String v_btnEntrar = "//button[@id='B95351952122507356']";

    // Botón gestion financiera
    private String v_btnGestionFinanciera = "//header/div[2]/div[1]/ul[1]/li[4]/span[1]/span[1]";

    // Botón recaudos
    private String v_btnRecaudos = "/html[1]/body[1]/form[1]/header[1]/div[2]/div[1]/ul[1]/li[4]/div[1]/div[1]/ul[1]/li[6]";

    // Botón registro recaudo manual
    private String v_btnGestionRegistroRecaudoManual = "//a[@id='1_menubar_3_5_1i']";

    // Botón nuevo registro
    private String v_btnNuevoRegistro = "//button[@id='B4864416461930702']";

    // Select tributo
    private String v_selectTributo = "//select[@id='P131_ID_IMPSTO']";

    // Select sub tributo
    private String v_selectSubTributo = "//select[@id='P131_ID_IMPSTO_SBMPSTO']";

    // Select banco
    private String v_selectBanco = "//select[@id='P131_ID_BNCO']";

    // Select banco cuenta
    private String v_selectBancoCuenta = "//select[@id='P131_ID_BNCO_CNTA']";

    // Calendario
    private String v_btnCalendario = "//body/form[@id='wwvFlowForm']/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/button[1]";

    // Textarea observación registro recaudo manual
    private String v_txtObservacionRegistroRecaudo = "//textarea[@id='P131_OBSRVCION']";

    // Botón siguiente flujo = recaudo control
    private String v_btnSiguiente = "//button[@id='B45077858345594157']";

    // Input número documento
    private String v_txtNoDocumento = "//input[@id='P132_BSCAR_NMRO_DCMNTO']";

    // Input codigo de barra
    private String v_txtCodigoBarra = "//input[@id='P132_CDGO_BRRA']";

    // Input observación flujo = recaudos
    private String v_txtObservacionRecaudo = "//textarea[@id='P132_OBSRVCION']";

    // Label número documento
    private String v_labelNoDocumento = "P132_NMRO_DCMNTO_DISPLAY";

    // Variable temporal número documento
    private String v_t_noDocumento;

    // Botón incluir recaudo
    private String v_btnIncluirRecaudo = "//button[@id='B45100639856725169']";

    // Botón confirmar registro
    private String v_btnConfirmarRegistro = "//button[@id='B45105391786729581']";

    // Botón aceptarde moda
    private String v_btnAceptar = "//button[contains(text(),'Aceptar')]";

    // Botón aplicación de recaudos //a[@id='1_menubar_3_5_1i']
    // private String v_btnAplicacionRecaudos = "//a[@id='1_menubar_3_5_4i']";
    private String v_btnAplicacionRecaudos = "/html[1]/body[1]/form[1]/header[1]/div[2]/div[1]/ul[1]/li[4]/div[1]/div[1]/ul[1]/li[6]/div[2]/div[1]/ul[1]/li[5]";

    // Input para buscar
    private String v_txtInputBuscar = "//input[@id='TCR_ig_toolbar_search_field']";

    // Botón ir (para buscar)
    private String v_btnIr = "//body/form[@id='wwvFlowForm']/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/ul[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/button[2]";

    // Constructor
    public SmartPage() {
        super(driver);
    }

    // Función para añadir tiempo de espera
    public void esperando() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Thread.sleep(3000);
        System.out.println("Ejecutando: función 'esperando()'");
    }

    // Leer archivo excel
    public void leerArchivoExcel(String rutaArchivo) throws IOException {
        FileInputStream fis = new FileInputStream(rutaArchivo);
        try (Workbook libroExcel = new XSSFWorkbook(fis)) {
            Sheet hoja = libroExcel.getSheet("v_login");
            // Iniciar fila 6 para omitir la fila de encabezados
            for (int i = 6; i <= hoja.getLastRowNum(); i++) {
                Row fila = hoja.getRow(i);
                Cell x_v_cliente = fila.getCell(1);
                Cell x_v_suit = fila.getCell(2);
                Cell x_v_usuario = fila.getCell(3);
                Cell x_v_clave = fila.getCell(4);
                Cell x_v_tributo = fila.getCell(5);
                Cell x_v_subTributo = fila.getCell(6);
                Cell x_v_banco = fila.getCell(7);
                Cell x_v_cuentaBanco = fila.getCell(8);
                Cell x_v_observacion = fila.getCell(9);
                Cell x_v_noDocumento = fila.getCell(10);

                if (x_v_cliente != null) {
                    if (x_v_cliente.getCellType() == CellType.STRING) {
                        v_cliente = x_v_cliente.getStringCellValue();
                    } else if (x_v_cliente.getCellType() == CellType.NUMERIC) {
                        v_cliente = String.valueOf((int) x_v_cliente.getNumericCellValue());
                    }
                }
                if (x_v_suit != null) {
                    if (x_v_suit.getCellType() == CellType.STRING) {
                        v_suit = x_v_suit.getStringCellValue();
                    } else if (x_v_suit.getCellType() == CellType.NUMERIC) {
                        v_suit = String.valueOf((int) x_v_suit.getNumericCellValue());
                    }
                }
                if (x_v_usuario != null) {
                    if (x_v_usuario.getCellType() == CellType.STRING) {
                        v_usuario = x_v_usuario.getStringCellValue();
                    } else if (x_v_usuario.getCellType() == CellType.NUMERIC) {
                        v_usuario = String.valueOf((int) x_v_usuario.getNumericCellValue());
                    }
                }
                if (x_v_clave != null) {
                    if (x_v_clave.getCellType() == CellType.STRING) {
                        v_clave = x_v_clave.getStringCellValue();
                    } else if (x_v_clave.getCellType() == CellType.NUMERIC) {
                        v_clave = String.valueOf((int) x_v_clave.getNumericCellValue());
                    }
                }
                if (x_v_tributo != null) {
                    if (x_v_tributo.getCellType() == CellType.STRING) {
                        v_tributo = x_v_tributo.getStringCellValue();
                    } else if (x_v_tributo.getCellType() == CellType.NUMERIC) {
                        v_tributo = String.valueOf((int) x_v_tributo.getNumericCellValue());
                    }
                }
                if (x_v_subTributo != null) {
                    if (x_v_subTributo.getCellType() == CellType.STRING) {
                        v_subTributo = x_v_subTributo.getStringCellValue();
                    } else if (x_v_subTributo.getCellType() == CellType.NUMERIC) {
                        v_subTributo = String.valueOf((int) x_v_subTributo.getNumericCellValue());
                    }
                }
                if (x_v_banco != null) {
                    if (x_v_banco.getCellType() == CellType.STRING) {
                        v_banco = x_v_banco.getStringCellValue();
                    } else if (x_v_banco.getCellType() == CellType.NUMERIC) {
                        v_banco = String.valueOf((int) x_v_banco.getNumericCellValue());
                    }
                }
                if (x_v_cuentaBanco != null) {
                    if (x_v_cuentaBanco.getCellType() == CellType.STRING) {
                        v_bancoCuenta = x_v_cuentaBanco.getStringCellValue();
                    } else if (x_v_cuentaBanco.getCellType() == CellType.NUMERIC) {
                        v_bancoCuenta = String.valueOf((int) x_v_cuentaBanco.getNumericCellValue());
                    }
                }
                if (x_v_observacion != null) {
                    if (x_v_observacion.getCellType() == CellType.STRING) {
                        v_observacionRegistroRecaudoManual = x_v_observacion.getStringCellValue();
                    } else if (x_v_observacion.getCellType() == CellType.NUMERIC) {
                        v_observacionRegistroRecaudoManual = String
                                .valueOf((int) x_v_observacion.getNumericCellValue());
                    }
                }
                if (x_v_noDocumento != null) {
                    if (x_v_noDocumento.getCellType() == CellType.STRING) {
                        v_noDocumento = x_v_noDocumento.getStringCellValue();
                    } else if (x_v_noDocumento.getCellType() == CellType.NUMERIC) {
                        v_noDocumento = String.valueOf((int) x_v_noDocumento.getNumericCellValue());
                    }
                }

            }
            System.out.println("1: " + v_cliente);
            System.out.println("2: " + v_suit);
            System.out.println("3: " + v_usuario);
            System.out.println("4: " + v_clave);
            System.out.println("5: " + v_tributo);
            System.out.println("6: " + v_subTributo);
            System.out.println("7: " + v_banco);
            System.out.println("8: " + v_bancoCuenta);
            System.out.println("9: " + v_observacionRegistroRecaudoManual);
            System.out.println("10: " + v_noDocumento);
        }
    }

    // Abrir navegador -> smart sincelejo
    public void navegarASmart() {
        navigateTo("https://infortributos-test.taxationsmart.co/ords/f?p=70000:101:4605815084976:");
    }

    public void iniciarSesion() throws InterruptedException {
        esperando();
        selectFromDropdownByValue(v_selectCliente, v_cliente);
        selectFromDropdownByValue(v_selectSuit, v_suit);
        clickElement(v_txtUsuario);
        clickElement(v_txtClave);
        write(v_txtUsuario, v_usuario);
        write(v_txtClave, v_clave);
        clickElement(v_btnEntrar);
    }

    // Clic select cliente
    public void selectCliente() throws InterruptedException {
        esperando();
        selectFromDropdownByValue(v_selectCliente, v_cliente);
    }

    // Clic select suit
    public void selectSuit() {
        selectFromDropdownByValue(v_selectSuit, v_suit);
    }

    // Clic input usuario
    public void clicUsuario() {
        clickElement(v_txtUsuario);
    }

    // Clic input clave
    public void clicClave() {
        clickElement(v_txtClave);
    }

    // Ingresar usuario
    public void ingresarUsuario() {
        write(v_txtUsuario, v_usuario);
    }

    // Ingresar clave
    public void ingresarClave() {
        write(v_txtClave, v_clave);
    }

    // Clic botón entrar
    public void clicBtnEntrar() {
        clickElement(v_btnEntrar);
    }

    // Clic botón gestión financiera
    public void clicGestionFinanciera() {
        clickElement(v_btnGestionFinanciera);
    }

    // Clic botón recaudos
    public void clicBtnRecaudos() {
        clickElement(v_btnRecaudos);
    }

    // Clic botón gestión registro recaudo manual
    public void clicBtnGestionRegistroRecaudoManual() {
        clickElement(v_btnGestionRegistroRecaudoManual);
    }

    // Clic botón nuevo registro
    public void clicBtnNuevoRegistro() {
        clickElement(v_btnNuevoRegistro);
    }

    // Select Tributo (value)
    public void selectTributo() {
        selectFromDropdownByValue(v_selectTributo, v_tributo);
    }

    // Select subTributo (value)
    public void selectSubTributo() {
        selectFromDropdownByValue(v_selectSubTributo, v_subTributo);
    }

    // Select banco (value)
    public void selectBanco() {
        selectFromDropdownByValue(v_selectBanco, v_banco);
    }

    // Select cuenta de banco (value)
    public void selectBancoCuenta() {
        selectFromDropdownByValue(v_selectBancoCuenta, v_bancoCuenta);
    }

    // Ingresar observación
    public void ingresarObservacion() {
        write(v_txtObservacionRegistroRecaudo, v_observacionRegistroRecaudoManual);
    }

    // CLic botón siguiente
    public void clicBtnSiguiente() {
        clickElement(v_btnSiguiente);
    }

    // Clic input clave
    public void clicNoDocumento() {
        clickElement(v_txtNoDocumento);
    }

    // Ingresar número documento
    public void ingresarNoDocumento() throws InterruptedException {
        esperando();
        write(v_txtNoDocumento, v_noDocumento);
        esperando();
        actions.sendKeys(Keys.ENTER).perform();
    }

    // Clic input codigo de barra
    public void clicCodigoBarra() throws InterruptedException {
        esperando();
        clickElement(v_txtCodigoBarra);
        esperando();
    }

    // Enter al input codigo de barra
    public void enterCodigoBarra() throws InterruptedException {
        clickElement(v_txtCodigoBarra);
        actions.sendKeys(Keys.ENTER).perform();
    }

    // Escanear número documento
    public void escanearLabelNoDocumento() throws InterruptedException {
        esperando();
        WebElement we_noDocumento = driver.findElement(By.id(v_labelNoDocumento));
        v_t_noDocumento = we_noDocumento.getText();
        System.out.println("Número documento: " + v_t_noDocumento);
    }

    // Ingresar observación opcional
    public void ingresarObservacionOpcional() throws InterruptedException {
        escanearLabelNoDocumento();
        clickElement(v_txtObservacionRecaudo);
        write(v_txtObservacionRecaudo, v_t_noDocumento);
    }

    // Clic botón incluir recaudo
    public void clicBtnIncluirRecaudo() {
        clickElement(v_btnIncluirRecaudo);
    }

    // Clic botón confirmar registro
    public void clicBtnConfirmarRegistro() throws InterruptedException {
        esperando();
        clickElement(v_btnConfirmarRegistro);
    }

    // Clic botón aceptar modal
    public void clicBtnAceptarModal() throws InterruptedException {
        esperando();
        clickElement(v_btnAceptar);
        esperando();
    }

    // Proceso para aplicar recaudo
    public void aplicarRecaudo() throws InterruptedException {
        // escanearLabelNoDocumento();
        // Clic botón gestión financiera
        esperando();
        clicGestionFinanciera();
        // Clic botón recaudos
        esperando();
        clicBtnRecaudos();
        // Clic aplicar recaudos
        esperando();
        clickElement(v_btnAplicacionRecaudos);

        // Clic al input buscar
        clickElement(v_txtInputBuscar);

        //
        if (v_t_noDocumento != null && !v_t_noDocumento.isEmpty()) {
            write(v_txtInputBuscar, v_t_noDocumento);
            System.out.println("xxx" + v_t_noDocumento);
        } else {
            System.err.println("El valor de v_t_noDocumento es nulo o vacío. No se puede enviar al campo de búsqueda.");
        }
    }

}
