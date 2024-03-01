package pages;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
// import org.openqa.selenium.By;
// import org.openqa.selenium.Keys;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.interactions.Actions;
// import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PQR extends PQRPage {

    // Variable de ingreso
    private String CheckBoxCliente = "//select[@id='P101_CDGO_CLNTE']";
    private String CheckBoxSuid = "//select[@id='P101_ID_APLCCION_GRPO']";
    private String IngresarUsuario = "//input[@id='P101_USERNAME']";
    private String IngresarPassword = "//input[@id='P101_PASSWORD']";
    private String ClickButtonEntrar = "//button[@id='B95351952122507356']";
    private String MenuPQR = "//header/div[2]/div[1]/ul[1]/li[9]/span[1]/span[1]";
    private String NuevoPQR = "/html/body/form/header/div[2]/div/ul/li[9]/div/div/ul/li[2]/div/span[1]/a";
    private String ClickNvoPQR = "//button[@id='B119104319729339002']";
    private String SeleccionarTipo = "//select[@id='P9_ID_TPO']";
    private String SeleccionarTributo = "//select[@id='P9_ID_IMPSTO']";
    private String SeleccionarSubTributo = "//select[@id='P9_ID_IMPSTO_SBMPSTO']";
    private String SeleccionarMotivo = "//select[@id='P9_ID_MTVO']";
    private String IngresarNit = "//input[@id='P9_IDNTFCCION_SJTO']";
    private String ObvcionSolicitud = "//textarea[@id='P9_OBSRVCION_S']";
    private String TpoIdentificacion = "//select[@id='P9_CDGO_IDNTFCCION_TPO']";
    private String Identificacion = "//input[@id='P9_IDNTFCCION']";
    private String DtosGestor = "//li[@id='radicador_tab']";
    private String DtosSolicitante = "//*[@id=\"R72793294691887617_tab\"]";
    private String CpiarDtosGestor = "//button[@id='B75304008788808401']";
    private String TpoSolicitante = "//select[@id='P9_CDGO_RSPNSBLE_TPO']";
    private String Direccion = "//input[@id='P9_DRCCION_NTFCCION_S']";
    private String Departamento = "//select[@id='P9_ID_DPRTMNTO_NTFCCION_S']";
    private String Municipio = "//select[@id='P9_ID_MNCPIO_NTFCCION_S']";
    private String Email = "//input[@id='P9_EMAIL_S']";
    private String Celular = "//input[@id='P9_CLLAR_S']";
    private String Opciondocumento = "//li[@id='R72791954306887604_tab']";
    private String tpoDcoumento = "//select[@id='P9_ID_MTVO_DCMNTO']";
    private String btonAgregar = "//button[@id='BTN_AGRGAR']";
    private String bnAceptar = "//button[contains(text(),'Aceptar')]";
    private String BtonInsertar = "//button[@id='B74203170231940602']";
    private String BtonSiguiente = "//button[@id='wf_btn_siguiente']";
    private String BtonSgte = "//button[@id='B72753683746801524']";
    private String nroDcumento = "//*[@id=\"P69_NMRO_DCMNTO\"]";
    private String vldaDocumento = "//button[@id='BTN_VALIDAR_DOCUMENTO']";
    private String tpoAcuerdo = "//select[@id='P69_ID_CNVNIO_TPO']";
    private String bnSeguiente = "//button[@id='B73540285547721084']";
    private String sigBton = "//button[@id='B74457222361888460']";
    private String BtnTerminar = "//button[@id='B73552040269728639']";
    // private String MenuGtionFinanciera = "//header/div[2]/div[1]/ul[1]/li[4]/span[1]";
    // private String AcuerdoPago = "/html/body/form/header/div[2]/div/ul/li[4]/div/div/div[2]/ul/li[7]/div[1]/span[1]/button";
    // private String GtionAcuerdoPago = "/html/body/form/header/div[2]/div/ul/li[4]/div/div/div[2]/ul/li[7]/div[2]/div/div[2]/ul/li[3]/div/span[1]/a";
    // private String verAcuerdoPago = "//body[1]/form[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div[5]/div[3]/div[1]/div[3]/div[4]/table[1]/tbody[1]/tr[2]/td[3]";
    // private String BtonAprobarAcuerdo = "//button[@id='BTN_APROBAR_ACUERDO']";
    // private String verActo = "//button[@id='B85275115616343104']";

    // Url del excel
    private String RutaArchivoExcel = "C:\\Data\\PQR\\PQR.xlsx";

    //
    private String cliente;
    private String suid;
    private String user;
    private String password;
    private String tipo;
    private String tributo;
    private String subTributo;
    private String motivo;
    private String nit;
    private String Obvcionsolicitud;
    private String IdSujeto;
    private String IdGestor;
    private String Tposolicitante;
    private String direccion;
    private String departamento;
    private String municipio;
    private String email;
    private String celular;
    private String Tpodocumento;
    private String numeroDocumento;
    private String tpAcuerdo;

    // private String Prmerpellido;

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
                Cell Tipo = fila.getCell(4);
                Cell Tributo = fila.getCell(5);
                Cell SubTributo = fila.getCell(6);
                Cell Motivo = fila.getCell(7);
                Cell Nit = fila.getCell(8);
                Cell Obcionsolicitud = fila.getCell(9);
                Cell sujeto = fila.getCell(10);
                Cell IdGtor = fila.getCell(11);
                Cell Tpsolicitante = fila.getCell(12);
                Cell dreccion = fila.getCell(13);
                Cell dpartamento = fila.getCell(14);
                Cell mnicipio = fila.getCell(15);
                Cell clular = fila.getCell(16);
                Cell tpDocumento = fila.getCell(20);
                Cell emailCorr = fila.getCell(17);
                Cell NrDocumento = fila.getCell(18);
                Cell TipAcuerdo = fila.getCell(19);

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
                if (Tipo != null) {
                    if (Tipo.getCellType() == CellType.STRING) {
                        tipo = Tipo.getStringCellValue();
                    } else if (Tipo.getCellType() == CellType.NUMERIC) {
                        tipo = String.valueOf((int) Tipo.getNumericCellValue());
                    }
                }

                if (Tributo != null) {
                    if (Tributo.getCellType() == CellType.STRING) {
                        tributo = Tributo.getStringCellValue();
                    } else if (Tributo.getCellType() == CellType.NUMERIC) {
                        tributo = String.valueOf((int) Tributo.getNumericCellValue());
                    }
                }

                    if (SubTributo != null) {
                    if (SubTributo.getCellType() == CellType.STRING) {
                        subTributo = SubTributo.getStringCellValue();
                    } else if (SubTributo.getCellType() == CellType.NUMERIC) {
                        subTributo = String.valueOf((int) SubTributo.getNumericCellValue());
                    }
                }

                if (Motivo != null) {
                    if (Motivo.getCellType() == CellType.STRING) {
                        motivo = Motivo.getStringCellValue();
                    } else if (Motivo.getCellType() == CellType.NUMERIC) {
                        motivo = String.valueOf((int) Motivo.getNumericCellValue());
                    }
                }

                if (Nit != null) {
                    if (Nit.getCellType() == CellType.STRING) {
                        nit = Nit.getStringCellValue();
                    } else if (Nit.getCellType() == CellType.NUMERIC) {
                        nit = String.valueOf((int) Nit.getNumericCellValue());
                    }
                }

                if (Obcionsolicitud != null) {
                    if (Obcionsolicitud.getCellType() == CellType.STRING) {
                        Obvcionsolicitud = Obcionsolicitud.getStringCellValue();
                    } else if (Obcionsolicitud.getCellType() == CellType.NUMERIC) {
                        Obvcionsolicitud = String.valueOf((int) Obcionsolicitud.getNumericCellValue());
                    }
                }

                if (sujeto != null) {
                    if (sujeto.getCellType() == CellType.STRING) {
                        IdSujeto = sujeto.getStringCellValue();
                    } else if (sujeto.getCellType() == CellType.NUMERIC) {
                        IdSujeto = String.valueOf((int) sujeto.getNumericCellValue());
                    }
                }

                if (IdGtor != null) {
                    if (IdGtor.getCellType() == CellType.STRING) {
                        IdGestor = IdGtor.getStringCellValue();
                    } else if (IdGtor.getCellType() == CellType.NUMERIC) {
                        IdGestor = String.valueOf((int) IdGtor.getNumericCellValue());
                    }
                }

                if (Tpsolicitante != null) {
                    if (Tpsolicitante.getCellType() == CellType.STRING) {
                        Tposolicitante = Tpsolicitante.getStringCellValue();
                    } else if (Tpsolicitante.getCellType() == CellType.NUMERIC) {
                        Tposolicitante = String.valueOf((int) Tpsolicitante.getNumericCellValue());
                    }
                }

                if (dreccion != null) {
                    if (dreccion.getCellType() == CellType.STRING) {
                        direccion = dreccion.getStringCellValue();
                    } else if (dreccion.getCellType() == CellType.NUMERIC) {
                        direccion = String.valueOf((int) dreccion.getNumericCellValue());
                    }
                }

                if (dpartamento != null) {
                    if (dpartamento.getCellType() == CellType.STRING) {
                        departamento = dpartamento.getStringCellValue();
                    } else if (dpartamento.getCellType() == CellType.NUMERIC) {
                        departamento = String.valueOf((int) dpartamento.getNumericCellValue());
                    }
                }

                if (mnicipio != null) {
                    if (mnicipio.getCellType() == CellType.STRING) {
                        municipio = mnicipio.getStringCellValue();
                    } else if (mnicipio.getCellType() == CellType.NUMERIC) {
                        municipio = String.valueOf((int) mnicipio.getNumericCellValue());
                    }
                }

                if (emailCorr != null) {
                    if (emailCorr.getCellType() == CellType.STRING) {
                        email = emailCorr.getStringCellValue();
                    } else if (emailCorr.getCellType() == CellType.NUMERIC) {
                        email = String.valueOf((int) emailCorr.getNumericCellValue());
                    }
                }

                if (clular != null) {
                    if (clular.getCellType() == CellType.STRING) {
                        celular = clular.getStringCellValue();
                    } else if (clular.getCellType() == CellType.NUMERIC) {
                        celular = String.valueOf((int) clular.getNumericCellValue());
                    }
                }

                if (tpDocumento != null) {
                    if (tpDocumento.getCellType() == CellType.STRING) {
                    Tpodocumento = tpDocumento.getStringCellValue();
                    } else if (tpDocumento.getCellType() == CellType.NUMERIC) {
                    Tpodocumento = String.valueOf((int) tpDocumento.getNumericCellValue());
                    }
                    }

                if (NrDocumento != null) {
                if (NrDocumento.getCellType() == CellType.STRING) {
                numeroDocumento = NrDocumento.getStringCellValue();
                } else if (NrDocumento.getCellType() == CellType.NUMERIC) {
                numeroDocumento = String.valueOf((int) NrDocumento.getNumericCellValue());
                }
                }

                   if (TipAcuerdo != null) {
                if (TipAcuerdo.getCellType() == CellType.STRING) {
                    tpAcuerdo = TipAcuerdo.getStringCellValue();
                } else if (TipAcuerdo.getCellType() == CellType.NUMERIC) {
                   tpAcuerdo = String.valueOf((int) TipAcuerdo.getNumericCellValue());
                }
                }
            }
        }
    }

    public PQR() {
        super(driver);
    }

    public void leerExcel() throws IOException {
        leerxsl(RutaArchivoExcel);
    }

    public void navigateToGoogle() {
        PQR.driver.manage().window().maximize();
        navigateTo("http://192.168.11.32:8032/ords/f?p=50000:101:1101595995926:::::");
    }

    public void IngresoDeIniciarSesion() throws IOException {
        leerxsl(RutaArchivoExcel);
        selectFromDropdownByValue(CheckBoxCliente, cliente);
        selectFromDropdownByValue(CheckBoxSuid, suid);
        write(IngresarUsuario, user);
        write(IngresarPassword, password);
        findElement(ClickButtonEntrar);
    }

    public void MenuPQR() throws IOException {
        leerxsl(RutaArchivoExcel);
        findElement(MenuPQR);
        findElement(NuevoPQR);
        findElement(ClickNvoPQR);
    }

    public void ModalPQR(String ModalPQR) {
        interactWithModal();
    }

    public void DatosSolicitud() throws IOException {
        selectFromDropdownByValue(SeleccionarTipo, tipo);
        selectFromDropdownByValue(SeleccionarTributo, tributo);
        selectFromDropdownByValue(SeleccionarSubTributo, subTributo);
        selectFromDropdownByValue(SeleccionarMotivo, motivo);
        write(IngresarNit, nit);
        // findElement(BtonValidar);
        write(ObvcionSolicitud, Obvcionsolicitud);
    }

    public void DatosGestor() throws IOException, InterruptedException {
        findElement(DtosGestor);
        Thread.sleep(1000);
        selectFromDropdownByValue(TpoIdentificacion, IdSujeto);
        Thread.sleep(1000);
        write(Identificacion, IdGestor);
        Thread.sleep(1000);
        WebElement inputElement1 = driver.findElement(By.id("P9_IDNTFCCION"));

        Actions actions = new Actions(driver);
        actions.sendKeys(inputElement1, Keys.ENTER).perform();
        Thread.sleep(1000);

    }

    public void DatosSolicitante() throws IOException, InterruptedException {
        Thread.sleep(1000);
        findElement(DtosSolicitante);
        WebElement inputElement1 = driver.findElement(By.id("R72793294691887617_tab"));

        Actions actions = new Actions(driver);
        actions.sendKeys(inputElement1, Keys.ENTER).perform();
        findElement(CpiarDtosGestor);
        selectFromDropdownByValue(TpoSolicitante, Tposolicitante);
        write(Direccion, direccion);
        selectFromDropdownByValue(Departamento, departamento);
         Thread.sleep(1000);
        selectFromDropdownByValue(Municipio, municipio);
         Thread.sleep(1000);
        write(Email, email);
         Thread.sleep(1000);
        write(Celular, celular);
        Thread.sleep(1000);
        findElement(Opciondocumento);
 
    }
    public void adjuntarArchivo(String rutaArchivo) throws InterruptedException {
        Thread.sleep(1000);
       selectFromDropdownByValue(tpoDcoumento, Tpodocumento);
        Thread.sleep(1000);
       WebElement btnAdjunto = driver.findElement(By.xpath("//input[@id='P9_FILE_BLOB']"));
       btnAdjunto.sendKeys(rutaArchivo);
        Thread.sleep(1000);
        findElement(btonAgregar);
        Thread.sleep(1000);
        findElement(bnAceptar);
        Thread.sleep(1000);
        findElement(BtonInsertar);
        Thread.sleep(1000);
        findElement(BtonSiguiente);
        Thread.sleep(1000);
        findElement(BtonSgte);
        Thread.sleep(1000);
        
    }
    public void SolicitudAcuerdoPago() throws IOException, InterruptedException {
        Thread.sleep(1000);
        write(nroDcumento, numeroDocumento);
        Thread.sleep(1000);
        findElement(vldaDocumento);
        selectFromDropdownByValue(tpoAcuerdo,tpAcuerdo );
        Thread.sleep(1000);;
        findElement(bnSeguiente);
        Thread.sleep(1000);
        findElement(sigBton);
        Thread.sleep(1000);
        findElement(BtnTerminar);
        Thread.sleep(1000);
        PQRPage.driver.manage().window().maximize();
        // findElement(MenuGtionFinanciera);
        // Thread.sleep(5000);
        // findElement(AcuerdoPago);
        // Thread.sleep(5000);
        // findElement(GtionAcuerdoPago);
        // Thread.sleep(1000);
        // findElement(verAcuerdoPago);
        // Thread.sleep(1000);
        // findElement(BtonAprobarAcuerdo);
        // Thread.sleep(1000);
        // findElement(verActo);
        // Thread.sleep(1000);
    }

    // public void VentanaEmergente() {
    //     InteractWithModal();
    // }

}
