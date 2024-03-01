package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SmartPage extends BasePage {

    // Ruta archivo excel
    String rutaArchivoExcel = "C:\\SMART_AUTOMATIZACION\\EXCEL_SMART\\ConsultaGeneral.xlsx";

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

    // Botón entrar
    private String v_btnEntrar = "//button[@id='B95351952122507356']";

    // -----------------------------------------------------------------
    // -----------------------------------------------------------------
    // -----------------------------------------------------------------

    // Ruta emision de recibo - Boton gestion financiera
    private String v_btnGestionFinanciera = "//header/div[2]/div[1]/ul[1]/li[4]/span[1]/span[1]";

    // Boton documentos
    private String v_btnConsultaGeneral = "//li[@id='1_menubar_3_2']";

    // Variable Identificación
    private String v_identificacion;

    // Input identificación
    private String v_txtIdentificacion = "//input[@id='P2_IDNTFCCION']";

    // Botón consultar
    private String v_btnConsultar = "//button[@id='B23580819527693204']";

    // Botón impuesto
    private String v_btnImpuesto = "//body/form[@id='wwvFlowForm']/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/ul[1]/li[1]";

    // Botón opcion cartera
    private String v_btnCartera = "//body/form[@id='wwvFlowForm']/div[1]/div[1]/div[2]/div[2]/div[3]/div[2]/div[2]/div[1]/ul[1]/li[3]";

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
            Sheet hojaConsulta = libroExcel.getSheet("v_consultaGeneral");
            // Hoja Login
            for (int i = 1; i <= hojaLogin.getLastRowNum(); i++) {
                Row fila = hojaLogin.getRow(i);
                Cell client = fila.getCell(1);
                Cell suitt = fila.getCell(2);
                Cell usuario = fila.getCell(3);
                Cell clave = fila.getCell(4);
                Cell identificacion = fila.getCell(5);

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
                if (identificacion != null) {
                    if (identificacion.getCellType() == CellType.STRING) {
                        v_identificacion = identificacion.getStringCellValue();
                    } else if (identificacion.getCellType() == CellType.NUMERIC) {
                        v_identificacion = String.valueOf((int) identificacion.getNumericCellValue());
                    }
                }
            }
            // Hoja Consulta Excel
            for (int i = 1; i <= hojaConsulta.getLastRowNum(); i++) {
                Row fila = hojaConsulta.getRow(i);
                Cell identificacion = fila.getCell(1);

                if (identificacion != null) {
                    if (identificacion.getCellType() == CellType.STRING) {
                        v_identificacion = identificacion.getStringCellValue();
                    } else if (identificacion.getCellType() == CellType.NUMERIC) {
                        v_identificacion = String.valueOf((int) identificacion.getNumericCellValue());
                    }
                }
            }
            System.out.println("H-Login: 1-1: " + v_cliente);
            System.out.println("H-Login: 1-2: " + v_suit);
            System.out.println("H-Login: 1-3: " + v_usuario);
            System.out.println("H-Login: 1-4: " + v_clave);
            System.out.println("H-Consulta: 2-5: " + v_identificacion);
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

    // Clic botón gestión financiera
    public void clicGestionFinanciera() {
        clickElement(v_btnGestionFinanciera);
    }

    // Clic botón documentos
    public void clicBtnConsultaGeneral() {
        clickElement(v_btnConsultaGeneral);
    }

    // Clic input identificación
    public void clicIdentificacion() {
        clickElement(v_txtIdentificacion);
    }

    // Ingresar identificación
    public void ingresarIdentificacion() {
        if (v_identificacion != null && !v_identificacion.isEmpty()) {
            write(v_txtIdentificacion, v_identificacion);
        } else {
            System.out.println("El campo de identificación es nulo o vacío.");
        }
    }

    // Clic botón consultar
    public void clicBtnConsultar() {
        clickElement(v_btnConsultar);
    }

    // Clic impuesto
    public void clicImpuesto() {
        clickElement(v_btnImpuesto);
    }

    // Clic opción cartera
    public void clicOpcionCartera() {
        clickElement(v_btnCartera);
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
        }
    }

}
