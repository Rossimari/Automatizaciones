package pages;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PrcionAcuerdoPago extends PrcionAcuerdoPagoPage {

    private String CheckBoxCliente = "//select[@id='P101_CDGO_CLNTE']";
    private String CheckBoxSuid = "//select[@id='P101_ID_APLCCION_GRPO']";
    private String IngresarUsuario = "//input[@id='P101_USERNAME']";
    private String IngresarPassword = "//input[@id='P101_PASSWORD']";
    private String ClickButtonEntrar = "//button[@id='B95351952122507356']";
    private String MenuGtionFinanciera = "//header/div[2]/div[1]/ul[1]/li[4]/span[1]";
    private String AcuerdoPago = "//button[@id='1_menubar_3_6i']";
    private String PccionAcuerdoPago = "//a[@id='1_menubar_3_6_1i']";
    private String BtonNuevaProyeccion = "//button[@id='B73074662740865789']";
    private String SlccionTributo = "//select[@id='P41_ID_IMPSTO']";
    private String SbTributo = "//select[@id='P41_ID_IMPSTO_SBMPSTO']";
    private String identificacion = "//input[@id='P41_IDNTFCCION_PRMT']";
    private String BtonConsultar = "//button[@id='B42344258255115411']";
    private String BtonSiguiente = "//button[@id='B72666540293254402']";
    private String SccionarCartera = "//tbody/tr[1]/th[1]/span[1]";
    private String BtSiguiente = "//button[@id='B43452080506066310']";
    private String BSiguiente = "//button[@id='B52435615211317861']";
    private String NCuotas = "//input[@id='P44_NMRO_CTAS']";
    private String Btsiguiente = "//button[@id='B43456339035066312']";
    private String BtnImprimirCuotaInicial = "//button[@id='B73549342170728612']";
    private String BtnFinalizar = "//*[@id=\"B50998332639993270\"]";

    private String RutaArchivoExcel = "C:\\Data\\Proyeccion de Acuerdo de Pago\\Proyeccion de Acuerdo de Pago.xlsx";
    //
    private String cliente;
    private String suid;
    private String user;
    private String password;
    private String Tributo;
    private String SubTributo;
    private String Identificacion;
    private String NroCuotas;

    // Clases leerExcel
    public void leerxsl(String rutaArchivo) throws IOException {
        FileInputStream fis = new FileInputStream(rutaArchivo);
        try (Workbook libroExcel = new XSSFWorkbook(fis)) {
            Sheet hoja = libroExcel.getSheet("Hoja1");
            for (int i = 1; i <= hoja.getLastRowNum(); i++) { // Empezamos desde 1 para omitir la fila de encabezados
                Row fila = hoja.getRow(i);
                Cell client = fila.getCell(0);
                Cell suidTax = fila.getCell(1);
                Cell usuario = fila.getCell(2);
                Cell clave = fila.getCell(3);
                Cell tributo = fila.getCell(4);
                Cell SbTributo = fila.getCell(5);
                Cell Idtificacion = fila.getCell(6);
                Cell nroCuotas = fila.getCell(7);
                // Cell Numerodocumento = fila.getCell(8);
                // Cell sujeto = fila.getCell(9);
                System.out.println("Proceso terminado con exito");

                if (client != null) {
                    if (client.getCellType() == CellType.STRING) {
                        cliente = client.getStringCellValue();
                    } else if (client.getCellType() == CellType.NUMERIC) {
                        cliente = String.valueOf((int) client.getNumericCellValue());
                    }
                }
                if (usuario != null) {
                    if (usuario.getCellType() == CellType.STRING) {
                        user = usuario.getStringCellValue();
                    } else if (usuario.getCellType() == CellType.NUMERIC) {
                        user = String.valueOf((int) usuario.getNumericCellValue());
                    }
                }

                if (suidTax != null) {
                    if (suidTax.getCellType() == CellType.STRING) {
                        suid = suidTax.getStringCellValue();
                    } else if (suidTax.getCellType() == CellType.NUMERIC) {
                        suid = String.valueOf((int) suidTax.getNumericCellValue());
                    }
                }
                if (clave != null) {
                    if (clave.getCellType() == CellType.STRING) {
                        password = clave.getStringCellValue();
                    } else if (clave.getCellType() == CellType.NUMERIC) {
                        password = String.valueOf((int) clave.getNumericCellValue());
                    }
                }

                if (tributo != null) {
                    if (tributo.getCellType() == CellType.STRING) {
                        Tributo = tributo.getStringCellValue();
                    } else if (tributo.getCellType() == CellType.NUMERIC) {
                        Tributo = String.valueOf((int) tributo.getNumericCellValue());
                    }
                }

                if (SbTributo != null) {
                    if (SbTributo.getCellType() == CellType.STRING) {
                        SubTributo = SbTributo.getStringCellValue();
                    } else if (SbTributo.getCellType() == CellType.NUMERIC) {
                        SubTributo = String.valueOf((int) SbTributo.getNumericCellValue());
                    }
                }

                if (Idtificacion != null) {
                    if (Idtificacion.getCellType() == CellType.STRING) {
                        Identificacion = Idtificacion.getStringCellValue();
                    } else if (Idtificacion.getCellType() == CellType.NUMERIC) {
                        Identificacion = String.valueOf((int) Idtificacion.getNumericCellValue());
                    }
                }

                if (nroCuotas != null) {
                    if (nroCuotas.getCellType() == CellType.STRING) {
                        NroCuotas = nroCuotas.getStringCellValue();
                    } else if (nroCuotas.getCellType() == CellType.NUMERIC) {
                        NroCuotas = String.valueOf((int) nroCuotas.getNumericCellValue());
                    }
                }

                // if (Numerodocumento != null) {
                // if (Numerodocumento.getCellType() == CellType.STRING) {
                // numerodocumento = Numerodocumento.getStringCellValue();
                // } else if (Numerodocumento.getCellType() == CellType.NUMERIC) {
                // numerodocumento = String.valueOf((int)
                // Numerodocumento.getNumericCellValue());
                // }
                // }

                // if (sujeto != null) {
                // if (sujeto.getCellType() == CellType.STRING) {
                // IdSujeto = sujeto.getStringCellValue();
                // } else if (sujeto.getCellType() == CellType.NUMERIC) {
                // IdSujeto = String.valueOf((int) sujeto.getNumericCellValue());
                // }
                // }

            }
        }
    }

    public PrcionAcuerdoPago() {
        super(driver);
    }

    public void leerExcel() throws IOException {
        leerxsl(RutaArchivoExcel);
    }

    public void navigateToGoogle() {
        PrcionAcuerdoPagoPage.driver.manage().window().maximize();
        navigateTo("http://192.168.11.32:8032/ords/f?p=50000:101:2073602904197:::::");
    }

    public void selectCategory() throws IOException {
        leerxsl(RutaArchivoExcel);
        selectFromDropdownByValue(CheckBoxCliente, cliente);
    }

    public void selectSuit() throws IOException {
        leerxsl(RutaArchivoExcel);
        selectFromDropdownByValue(CheckBoxSuid, suid);
    }

    public void ingresarusuario() throws IOException {
        leerxsl(RutaArchivoExcel);
        write(IngresarUsuario, user);
    }

    public void ingresarclave() throws IOException {
        leerxsl(RutaArchivoExcel);
        write(IngresarPassword, password);
    }

    public void clickGoogleSearch() {
        findElement(ClickButtonEntrar);
    }

    public void ModuloGtionFinanciera() throws InterruptedException {
        Thread.sleep(1000);
        findElement(MenuGtionFinanciera);
        findElement(AcuerdoPago);
        findElement(PccionAcuerdoPago);
    }

    public void ProcesoProyeccionAcuerdoPago() throws IOException, InterruptedException {
        leerxsl(RutaArchivoExcel);
        findElement(BtonNuevaProyeccion);
        selectFromDropdownByValue(SlccionTributo, Tributo);
        selectFromDropdownByValue(SbTributo, SubTributo);
        write(identificacion, Identificacion);
        Thread.sleep(1000);
        findElement(BtonConsultar);
        Thread.sleep(1000);
        findElement(BtonSiguiente);
        Thread.sleep(1000);
        findElement(SccionarCartera);
        findElement(BtSiguiente);
        findElement(BSiguiente);
        write(NCuotas, NroCuotas);
        WebElement inputElement1 = driver.findElement(By.id("R89707615950993932_toolbar_controls"));
        Actions actions = new Actions(driver);
        actions.sendKeys(inputElement1, Keys.ENTER).perform();
        Thread.sleep(1000);
        findElement(Btsiguiente);
        Thread.sleep(1000);
        findElement(BtnImprimirCuotaInicial);
        Thread.sleep(1000);
        findElement(BtnFinalizar);

    }

}
