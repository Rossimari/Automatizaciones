package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SmartPage extends BasePage {

    // Ruta archivo excel
    String rutaArchivoExcel = "C:\\SMART_AUTOMATIZACION\\EXCEL_SMART\\EmisionDeRecibos.xlsx";

    // -----------------------------------------------------------------
    // -----------------------------------------------------------------
    // -----------------Parametros iniciar sesion-----------------------
    // -----------------------------------------------------------------
    private String v_selectCliente = "//select[@id='P101_CDGO_CLNTE']";
    private String v_selectSuit = "//select[@id='P101_ID_APLCCION_GRPO']";
    private String v_txtUsuario = "//input[@id='P101_USERNAME']";
    private String v_txtClave = "//input[@id='P101_PASSWORD']";

    private String v_cliente;
    private String v_suit;
    private String v_usuario;
    private String v_clave;
    // -----------------------------------------------------------------
    // -----------------------------------------------------------------

    // Botón entrar
    private String v_btnEntrar = "//button[@id='B95351952122507356']";

    // Ruta emision de recibo - Boton gestion financiera
    private String v_btnGestionFinanciera = "//header/div[2]/div[1]/ul[1]/li[4]/span[1]/span[1]";

    // Boton documentos
    private String v_btnDocumentos = "//li[@id='1_menubar_3_3']";

    // Boton emision de recibos puntuales
    private String v_btnEmisionRecibosPuntuales = "/html[1]/body[1]/form[1]/header[1]/div[2]/div[1]/ul[1]/li[4]/div[1]/div[1]/ul[1]/li[4]/div[2]/div[1]/ul[1]/li[1]";

    // Select tributo
    private String v_selectTributo = "//select[@id='P45_ID_IMPSTO']";

    // Select sub tributo
    private String v_selectSubTributo = "//select[@id='P45_ID_IMPSTO_SBMPSTO']";

    // Identificacion
    private String v_txtIdentificacion = "//input[@id='P45_IDNTFCCION_PRMT']";

    // Boton consultar
    private String v_btnConsultar = "//button[@id='B175614080196849590']";

    // CLic al checkbox para desmarcar a todos
    private String v_checkBox = "//body[1]/form[1]/div[1]/div[1]/div[2]/div[2]/div[3]/div[2]/div[2]/div[1]/div[5]/div[3]/div[1]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[1]/span[2]";

    // Clic al checkbox del recibo a escoger [0]
    private String v_checkBoxUno = "//tbody/tr[1]/th[1]";

    // Boton siguiente
    private String v_btnSiguiente = "//button[@id='B178951229533947498']";

    // Xpath de la ventana modal
    private String v_ventanaModal = "//body/div[1]";

    // Select plantilla del documento
    private String v_selectPlantilla = "//select[@id='P48_ID_RPRTE']";

    // Select
    private String v_tipoRecibo = "//select[@id='P48_CDGO_RCBO_TPO']";

    // Botón imprimir
    private String v_btnImprimir = "//button[@id='B182542050849889005']";

    public SmartPage() {
        super(driver);
    }

    // Esperando
    public void esperando() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Thread.sleep(3000);
    }

    // Función para convertir valores a string
    public void leerArchivoExcel(String rutaArchivo) throws IOException {
        FileInputStream fis = new FileInputStream(rutaArchivo);
        try (Workbook libroExcel = new XSSFWorkbook(fis)) {
            Sheet hojaLogin = libroExcel.getSheet("v_login");
            // Sheet hojaConsulta = libroExcel.getSheet("v_consultaGeneral");
            // Hoja Login
            for (int i = 1; i <= hojaLogin.getLastRowNum(); i++) {
                Row fila = hojaLogin.getRow(i);
                Cell client = fila.getCell(1);
                Cell suitt = fila.getCell(2);
                Cell usuario = fila.getCell(3);
                Cell clave = fila.getCell(4);
                // Cell identificacion = fila.getCell(5);

                if (client != null) {
                    if (client.getCellType() == CellType.STRING) {
                        v_cliente = client.getStringCellValue();
                    } else if (client.getCellType() == CellType.NUMERIC) {
                        v_cliente = String.valueOf((int) client.getNumericCellValue());
                    }
                }
                if (suitt != null) {
                    if (suitt.getCellType() == CellType.STRING) {
                        v_suit = suitt.getStringCellValue();
                    } else if (suitt.getCellType() == CellType.NUMERIC) {
                        v_suit = String.valueOf((int) suitt.getNumericCellValue());
                    }
                }
                if (usuario != null) {
                    if (usuario.getCellType() == CellType.STRING) {
                        v_usuario = usuario.getStringCellValue();
                    } else if (usuario.getCellType() == CellType.NUMERIC) {
                        v_usuario = String.valueOf((int) usuario.getNumericCellValue());
                    }
                }
                if (clave != null) {
                    if (clave.getCellType() == CellType.STRING) {
                        v_clave = clave.getStringCellValue();
                    } else if (clave.getCellType() == CellType.NUMERIC) {
                        v_clave = String.valueOf((int) clave.getNumericCellValue());
                    }
                }
            }

            System.out.println("H-Login: 1-1: " + v_cliente);
            System.out.println("H-Login: 1-2: " + v_suit);
            System.out.println("H-Login: 1-3: " + v_usuario);
            System.out.println("H-Login: 1-4: " + v_clave);
            // System.out.println("H-Consulta: 2-5: " + v_identificacion);
        }
    }

    // Abrir navegador -> smart sincelejo
    public void navegarASmart() {
        navigateTo("https://infortributos-test.taxationsmart.co/ords/f?p=70000:101:4605815084976:");
    }

    // -------------------------------------------------------------------------------------
    // Metodo para inicar sesión
    public void iniciarSesion() throws InterruptedException {
        // Metodo para esperar
        esperando();
        // Clic select cliente
        selectFromDropdownByValue(v_selectCliente, v_cliente);
        // Clic select suit
        selectFromDropdownByValue(v_selectSuit, v_suit);
        // Clic input usuario
        clickElement(v_txtUsuario);
        // Clic input clave
        clickElement(v_txtClave);
        // Ingresar usuario
        write(v_txtUsuario, v_usuario);
        // Ingresar clave
        write(v_txtClave, v_clave);
        // Metodo para esperar
        esperando();
        // Clic botón entrar
        clickElement(v_btnEntrar);
    }
    // -------------------------------------------------------------------------------------

    /*
     * // Clic select cliente
     * public void selectCliente(String selectCliente) {
     * selectFromDropdownByValue(v_selectCliente, selectCliente);
     * }
     * 
     * // Clic select suit
     * public void selectSuit(String selectSuit) {
     * selectFromDropdownByValue(v_selectSuit, selectSuit);
     * }
     * 
     * // Clic input usuario
     * public void clicUsuario() {
     * clickElement(v_txtUsuario);
     * }
     * 
     * // Clic input clave
     * public void clicClave() {
     * clickElement(v_txtClave);
     * }
     * 
     * // Ingresar usuario
     * public void ingresarUsuario(String usuario) {
     * write(v_txtUsuario, usuario);
     * }
     * 
     * // Ingresar clave
     * public void ingresarClave(String clave) {
     * write(v_txtClave, clave);
     * }
     * 
     * // Clic botón entrar
     * public void clicBtnEntrar() {
     * clickElement(v_btnEntrar);
     * }
     */
    // Clic botón gestión financiera
    public void clicGestionFinanciera() {
        clickElement(v_btnGestionFinanciera);
    }

    // Clic botón documentos
    public void clicBtnDocumentos() {
        clickElement(v_btnDocumentos);
    }

    // Clic botón emisión de recibos puntuales
    public void clicBtnEmisionRecibosPuntuales() {
        clickElement(v_btnEmisionRecibosPuntuales);
    }

    // Select Tributo (value)
    public void selectTributo(String Tributo) {
        selectFromDropdownByValue(v_selectTributo, Tributo);
    }

    // Select Sub Tributo (value)
    public void selectSubTributo(String SubTributo) {
        selectFromDropdownByValue(v_selectSubTributo, SubTributo);
    }

    // Clic input identificacion
    public void clicTxtIdentificacion() {
        clickElement(v_txtIdentificacion);
    }

    // Ingresar identificacion
    public void ingresarIdentificacion(String indentificacion) {
        write(v_txtIdentificacion, indentificacion);
    }

    // Clic botón consultar
    public void clicBtnConsultar() {
        clickElement(v_btnConsultar);
    }

    // Clic checkBox desmarcar todas las liquidaciones
    public void clicCheckBox() {
        clickElement(v_checkBox);
    }

    // Clic checkBox liquidación [0]
    public void clicCheckBoxUno() {
        clickElement(v_checkBoxUno);
    }

    // Clic botón siguiente
    public void btnSiguiente() {
        clickElement(v_btnSiguiente);
    }

    // Enfocar la ventana modal
    public void enfocarEnLaVentanaModal() {
        try {
            WebElement ventanaModal = driver.findElement(By.xpath(v_ventanaModal));
            ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", ventanaModal);
            driver.switchTo().frame(0);
            System.out.println("Enfocado");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No enfocado");
        }
    }

    // Clic select plantilla
    public void selectPlantilla(String seplantilla) {
        selectFromDropdownByValue(v_selectPlantilla, seplantilla);
    }

    // Clic select tipo recibo - DAB Abono - DNO Normal
    public void selectTipoRecibo(String tipoRecibo) {
        selectFromDropdownByValue(v_tipoRecibo, tipoRecibo);
    }

    // Clic botón imprimir
    public void clicImprimir() {
        clickElement(v_btnImprimir);
    }

}
