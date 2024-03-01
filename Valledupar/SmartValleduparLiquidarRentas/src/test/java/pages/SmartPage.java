package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SmartPage extends BasePage {

    // Ruta archivo excel
    String rutaArchivoExcel = "C:\\SMART_AUTOMATIZACION\\EXCEL_SMART\\GestionDeRentas.xlsx";

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
    private String v_subTributo;
    private String v_acto;
    private String v_identificacion;
    private String v_numeroVallas;
    private String v_plantillaLiquidacion;
    // -----------------------------------------------------------------
    // -----------------------------------------------------------------
    // -----------------------------------------------------------------

    // Botón entrar
    private String v_btnEntrar = "//button[@id='B95351952122507356']";

    // Ruta generacion del tributi
    private String v_btnGeneracionTributo = "//header/div[2]/div[1]/ul[1]/li[2]/span[1]/span[1]";

    // Boton
    private String v_btnRentasVarias = "//header/div[2]/div[1]/ul[1]/li[2]/div[1]/div[1]/ul[1]/li[8]/div[1]/span[1]";

    //
    private String v_btnGestionRentasVarias = "//a[@id='1_menubar_1_7_0i']";

    // btn nueva renta
    private String v_btnNuevaRenta = "//button[@id='B16221442115689119']";

    // Select sub tributo
    private String v_selectSubTributo = "//select[@id='P93_ID_IMPSTO_SBMPSTO']";

    // Select acto
    private String v_selectActo = "//select[@id='P93_ID_IMPSTO_ACTO']";

    // Marcar checkbox
    private String v_btnCheckbox = "//body[1]/form[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[5]/div[3]/div[1]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[1]/span[2]";

    // Botón siguiente
    private String v_btnSiguiente = "//button[@id='NEXT']";

    // Identificacion
    private String v_txtIdentificacion = "//input[@id='P91_IDENTIFICACION']";

    // Buscar
    private String v_btnConsultar = "//button[@id='B20359786849224958']";

    // Número vallas
    private String v_txtNumeroVallas = "//input[@id='P91_VLOR_BSE_GRVBLE']";

    // Botón calendario
    private String v_btnCalendario = "//body/form[@id='wwvFlowForm']/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/button[1]";

    // Botón siguiente
    private String v_btnSiguienteDos = "//button[@id='B20214638185190020']";

    // Botón calendario
    private String v_btnCalendarioDos = "//body/form[@id='wwvFlowForm']/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/button[1]";

    // Botón Generar
    private String v_btnGenerar = "//button[@id='B40651959989356919']";

    // Botón siguiente 3
    private String v_btnSiguienteTres = "//button[@id='NEXT']";

    // Select plantilla liquidación
    private String v_selectPlantillaLiquidacion = "//select[@id='P99_ID_RPRTE']";

    // Botón terminar
    private String v_btnTerminar = "//button[@id='B48823525893194314']";

    // Botón imprimir
    private String v_btnImprimir = "//button[@id='B48823455856194313']";

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
            Sheet hoja = libroExcel.getSheet("v_login");
            for (int i = 1; i <= hoja.getLastRowNum(); i++) { // Empezamos desde 1 para omitir la fila de encabezados
                Row fila = hoja.getRow(i);
                Cell x_v_cliente = fila.getCell(0);
                Cell x_v_suit = fila.getCell(1);
                Cell x_v_usuario = fila.getCell(2);
                Cell x_v_clave = fila.getCell(3);
                Cell x_v_subTributo = fila.getCell(4);
                Cell x_v_acto = fila.getCell(5);
                Cell x_v_identificacion = fila.getCell(6);
                Cell x_v_numeroVallas = fila.getCell(7);
                Cell x_v_plantillaLiquidacion = fila.getCell(8);

                // System.out.println("el documento es"+documento);
                // System.out.println("-----------------------");
                // N_Documento = String.valueOf(documento);
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
                if (x_v_subTributo != null) {
                    if (x_v_subTributo.getCellType() == CellType.STRING) {
                        v_subTributo = x_v_subTributo.getStringCellValue();
                    } else if (x_v_subTributo.getCellType() == CellType.NUMERIC) {
                        v_subTributo = String.valueOf((int) x_v_subTributo.getNumericCellValue());
                    }
                }
                if (x_v_acto != null) {
                    if (x_v_acto.getCellType() == CellType.STRING) {
                        v_acto = x_v_acto.getStringCellValue();
                    } else if (x_v_acto.getCellType() == CellType.NUMERIC) {
                        v_acto = String.valueOf((int) x_v_acto.getNumericCellValue());
                    }
                }
                if (x_v_identificacion != null) {
                    if (x_v_identificacion.getCellType() == CellType.STRING) {
                        v_identificacion = x_v_identificacion.getStringCellValue();
                    } else if (x_v_identificacion.getCellType() == CellType.NUMERIC) {
                        v_identificacion = String.valueOf((int) x_v_identificacion.getNumericCellValue());
                    }
                }
                if (x_v_numeroVallas != null) {
                    if (x_v_numeroVallas.getCellType() == CellType.STRING) {
                        v_numeroVallas = x_v_numeroVallas.getStringCellValue();
                    } else if (x_v_numeroVallas.getCellType() == CellType.NUMERIC) {
                        v_numeroVallas = String.valueOf((int) x_v_numeroVallas.getNumericCellValue());
                    }
                }
                if (x_v_plantillaLiquidacion != null) {
                    if (x_v_plantillaLiquidacion.getCellType() == CellType.STRING) {
                        v_plantillaLiquidacion = x_v_plantillaLiquidacion.getStringCellValue();
                    } else if (x_v_plantillaLiquidacion.getCellType() == CellType.NUMERIC) {
                        v_plantillaLiquidacion = String.valueOf((int) x_v_plantillaLiquidacion.getNumericCellValue());
                    }
                }
            }
            System.out.println("0: " + v_cliente);
            System.out.println("1: " + v_suit);
            System.out.println("2: " + v_usuario);
            System.out.println("3: " + v_clave);
            System.out.println("4: " + v_subTributo);
            System.out.println("5: " + v_acto);
            System.out.println("6: " + v_identificacion);
            System.out.println("7: " + v_numeroVallas);
            System.out.println("8: " + v_plantillaLiquidacion);
        }
    }

    // Abrir navegador -> smart sincelejo
    public void navegarASmart() {
        navigateTo("https://infortributos-test.taxationsmart.co/ords/f?p=70000:101:4605815084976:");
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

    // Clic botón generación del tributo
    public void clicBtnGeneracionTributo() {
        clickElement(v_btnGeneracionTributo);
    }

    // Clic botón rentas varias
    public void clicBtnRentasVarais() {
        clickElement(v_btnRentasVarias);
    }

    // Clic botón gestion rentas varias
    public void clicBtnGestionRentasVarias() {
        clickElement(v_btnGestionRentasVarias);
    }

    // Clic botón nueva retna
    public void clicBtnNuevaRenta() {
        clickElement(v_btnNuevaRenta);
    }

    // Clic select
    public void selectSubTributo() {
        selectFromDropdownByValue(v_selectSubTributo, v_subTributo);
    }

    // Clic select acto
    public void selectActo() {
        selectFromDropdownByValue(v_selectActo, v_acto);
    }

    // Marcar checkbox
    public void clicBtnCheck() throws InterruptedException {
        esperando();
        clickElement(v_btnCheckbox);
    }

    // Clic botón siguiente
    public void clicBtnSiguiente() {
        clickElement(v_btnSiguiente);
    }

    // Ingresar identificación
    public void ingresarIdentificacion() {
        write(v_txtIdentificacion, v_identificacion);
    }

    // Clic botón siguiente
    public void clicBtnConsultar() throws InterruptedException {
        esperando();
        clickElement(v_btnConsultar);
    }

    // Ingresar identificación
    public void ingresarNumeroVallas() {
        write(v_txtNumeroVallas, v_numeroVallas);
    }

    // Clic botón siguiente
    public void clicBtnCalendario() {
        clickElement(v_btnCalendario);
    }

    public static void scrollUp(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Desplaza la página hacia arriba usando JavaScript
        js.executeScript("window.scrollTo(0, 0);");
    }

    // Función para seleccionar el dia
    public void seleccionarDia() {
        try {
            esperando();
            scrollUp(driver);
            String mesActual = DateTimeFormatter.ofPattern("MMM").format(LocalDateTime.now());

            String diaActual = DateTimeFormatter.ofPattern("d")
                    .format(LocalDateTime.now());
            String mesEnElCalendario = "//option[contains(text(),'" + mesActual + "')]";
            String diaEnElCalendario = "//a[contains(text(),'" + diaActual + "')]";
            clickElement(mesEnElCalendario);
            clickElement(diaEnElCalendario);
            esperando();
            System.out.println("Se ha seleccionado el día actual en el calendario.");
        } catch (Exception e) {
            System.err.println("El elemento del día actual no se encontró en el calendario.");
            e.printStackTrace();
        }
    }

    // Clic botón siguiente
    public void clicBtnSiguienteDos() {
        clickElement(v_btnSiguienteDos);
    }

    // Clic botón siguiente dos
    public void clicBtnCalendarioDos() {
        clickElement(v_btnCalendarioDos);
    }

    // Función para seleccionar el dia
    public void seleccionarDiaDos() {
        try {
            // Función esperando
            esperando();
            // Hacer scroll hacia arriba
            scrollUp(driver);
            // Variables
            String mesActual = DateTimeFormatter.ofPattern("MMM").format(LocalDateTime.now());
            String diaActual = DateTimeFormatter.ofPattern("d").format(LocalDateTime.now());
            // Concatenación en el xpath
            String mesEnElCalendario = "//option[contains(text(),'" + mesActual + "')]";
            String diaEnElCalendario = "//a[contains(text(),'" + diaActual + "')]";

            int diaActualXXX = Integer.parseInt(diaActual) - 1;
            String diaEnElCalendarioX = "//tbody/tr[2]/td[" + diaActualXXX + "]/a[1]";
            String diaEnElCalendarioXXX = "//tbody/tr[2]/td[" + diaActualXXX + "]/a[1]";
            String tabla = "//body/div[@id='ui-datepicker-div']/table[1]";
            // Clic a los elementos
            clickElement(mesEnElCalendario);
            clickElement(diaEnElCalendario);

            // Función esperando
            esperando();
            System.out.println("diactual: " + diaActual);
            System.out.println("dia en el calendario: " + diaEnElCalendario);
            System.out.println("-----------------------------: ");
            System.out.println("diactualxxx : " + diaActualXXX);
            System.out.println("dia en el calendariox: " + diaEnElCalendarioX);
            System.out.println("dia en el calendarioxxx: " + diaEnElCalendarioXXX);
            System.out.println("Se ha seleccionado el día actual en el calendario.");
        } catch (Exception e) {
            System.err.println("El elemento del día actual no se encontró en el calendario.");
            e.printStackTrace();
        }
    }

    // Clic botón generar
    public void clicBtnGenerar() {
        clickElement(v_btnGenerar);
    }

    // Clic botón siguiente tres
    public void clicBtnSiguienteTres() {
        clickElement(v_btnSiguienteTres);
    }

    // Clic select
    public void selectPlantillaLiquidacion() {
        selectFromDropdownByValue(v_selectPlantillaLiquidacion, v_plantillaLiquidacion);
    }

    // Clic botón tarminar
    public void clicBtnTerminar() {
        clickElement(v_btnTerminar);
    }

    // Clic botón terminar
    public void clicBtnImprimir() {
        clickElement(v_btnImprimir);
    }

}
