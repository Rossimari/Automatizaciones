package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class SmartPage extends BasePage {

    // Ruta archivo excel
    String rutaArchivoExcel = "C:\\SMART_AUTOMATIZACION\\EXCEL_SMART\\PQR.xlsx";

    // -----------------------------------------------------------------
    // -----------------------------------------------------------------
    // -----------------Parametros iniciar sesion-----------------------
    // -----------------------------------------------------------------
    private String v_selectCliente = "//select[@id='P101_CDGO_CLNTE']";
    private String v_selectSuit = "//select[@id='P101_ID_APLCCION_GRPO']";
    private String v_txtUsuario = "//input[@id='P101_USERNAME']";
    private String v_txtClave = "//input[@id='P101_PASSWORD']";
    // Botón entrar
    private String v_btnEntrar = "//button[@id='B95351952122507356']";
    // -----------Datos Login---------------
    private String v_cliente;
    private String v_suit;
    private String v_usuario;
    private String v_clave;
    // -----------Datos Instancia-----------
    private String v_instanciaFlujo;
    private String v_observacionInstancia;
    // -----------Datos Solicitud-----------
    private String v_tipo;
    private String v_tipoPresentacion;
    private String v_tributo;
    private String v_motivo;
    private String v_subTributo;
    private String v_identificacion;
    private String v_observacion;
    // -----------Datos Gestor-----------
    private String v_tipoIdentificacion;
    private String v_identificacionGestor;
    private String v_primerNombre;
    private String v_primerApellido;
    // -----------Datos Solicitante-----------
    private String v_tipoSolicitante;
    private String v_tipoIdentificacionSolicitante;
    private String v_identificacionSolicitante;
    private String v_primerNombreSolicitante;
    private String v_primerApellidoSolicitante;
    private String v_pais;
    private String v_departamento;
    private String v_municipio;
    private String v_direccion;
    private String v_email;
    private String v_celular;
    // ----------Documentos------------
    private String v_documentos;
    private String v_observacionDocumentos;
    private String v_numeroFolios;
    private String v_rutaArchivo;
    // ----------------------------------------------------------------------

    // ----------------------------------------------------------------------
    // ----------------------RUTA NUEVA PQR----------------------------------
    // ----------------------------------------------------------------------
    // Ruta PQR ->
    private String v_btnPQR = "//header/div[2]/div[1]/ul[1]/li[9]/span[1]/span[1]";

    // Botón PQR
    private String v_btnNvPQR = "//li[@id='1_menubar_8_0']";

    // Botón nuevo PQR
    private String v_btnNuevoPQR = "//button[@id='B119104319729339002']";

    // Xpath de la ventana modal
    private String v_ventanaModal = "//body/div[14]/div[2]/iframe[1]";

    // Select instanciar flujos
    private String v_selectFlujo = "//select[@id='P17_FLUJOS']";

    // TxtArea Observación
    private String v_txtObservacionInstancia = "//textarea[@id='P17_OBSRVCION']";

    // Botón crear instancia
    private String v_btnCrearInstancia = "//button[@id='B33554374137715603']";
    // ----------------------------------------------------------------------
    // ----------------------DATOS SOLICITUD---------------------------------
    // ----------------------------------------------------------------------
    // Select tipo
    private String v_selectTipo = "//select[@id='P9_ID_TPO']";

    // Select tipo presentación
    private String v_selectTipoPresentacion = "//select[@id='P9_ID_PRSNTCION_TPO']";

    // Select tributo
    private String v_selectTributo = "//select[@id='P9_ID_IMPSTO']";

    // Select sub tributo
    private String v_selectSubTributo = "//select[@id='P9_ID_IMPSTO_SBMPSTO']";

    // Select motivo
    private String v_selectMotivo = "//select[@id='P9_ID_MTVO']";

    // Input identificación sujeto
    private String v_txtIdentificacion = "//input[@id='P9_IDNTFCCION_SJTO']";

    // Botón validar (verde)
    private String V_btnValidar = "//button[@id='BTN_VLDAR']";

    // TxtArea observación
    private String v_txtObservacion = "//textarea[@id='P9_OBSRVCION_S']";
    // ----------------------------------------------------------------------
    // ----------------------DATOS GESTOR------------------------------------
    // ----------------------------------------------------------------------
    // Clic datos gestor
    private String v_btnDatosGestor = "//li[@id='radicador_tab']";

    // Select tipo identificación
    private String v_selectTipoIdentificacion = "//select[@id='P9_CDGO_IDNTFCCION_TPO']";

    // Input identificación
    private String v_txtIdentificacionGestor = "//input[@id='P9_IDNTFCCION']";

    // Input primer nombre
    private String v_txtPrimerNombre = "//input[@id='P9_PRMER_NMBRE']";

    // Input primer apellido
    private String v_txtPrimerApellido = "//input[@id='P9_PRMER_APLLDO']";

    // ----------------------------------------------------------------------
    // ----------------------DATOS SOLICITANTE-------------------------------
    // ----------------------------------------------------------------------
    // Clic datos solicitante
    private String v_btnDatosSolicitante = "//li[@id='R72793294691887617_tab']";

    // Select tipo solicitante
    private String v_selectTipoSolicitante = "//select[@id='P9_CDGO_RSPNSBLE_TPO']";

    // Select tipo identificación solicitante
    private String v_selectTipoIdentificacionSolicitante = "//select[@id='P9_CDGO_IDNTFCCION_TPO_S']";

    // Input identificación
    private String v_txtIdentificacionSolicitante = "//input[@id='P9_IDNTFCCION_S']";

    // Input primer nombre
    private String v_txtPrimerNombreSolicitante = "//input[@id='P9_PRMER_NMBRE_S']";

    // Input primer apellido
    private String v_txtPrimerApellidoSolicitante = "//input[@id='P9_PRMER_APLLDO_S']";

    // Select pais
    private String v_selectPais = "//select[@id='P9_ID_PAIS_NTFCCION_S']";

    // Select departamento
    private String v_selectDepartamento = "//select[@id='P9_ID_DPRTMNTO_NTFCCION_S']";

    // Select municipio
    private String v_selectMunicipio = "//select[@id='P9_ID_MNCPIO_NTFCCION_S']";

    // Input dirección
    private String v_txtDireccion = "//input[@id='P9_DRCCION_NTFCCION_S']";

    // Input email
    private String v_txtEmail = "//input[@id='P9_EMAIL_S']";

    // Input celular
    private String v_txtCelular = "//input[@id='P9_CLLAR_S']";

    // ----------------------------------------------------------------------
    // ----------------------DOCUMENTOS--------------------------------------
    // ----------------------------------------------------------------------
    // Clic documentos
    private String v_btnDocumentos = "//li[@id='R72791954306887604_tab']";

    // Select documentos
    private String v_selectDocumentos = "//select[@id='P9_ID_MTVO_DCMNTO']";

    // Txt area observación
    private String v_txtObservacionDocumentos = "//textarea[@id='P9_OBSRVCION']";

    // Input cantidad número folios
    private String v_txtNumeroFolios = "//input[@id='P9_NMRO_FLIO']";

    // Botón agregar documentos
    private String v_btnAgregar = "//button[@id='BTN_AGRGAR']";

    // Botón aceptar carga de documentos seleccionados
    private String v_btnAceptarCargar = "/html[1]/body[1]/div[16]/div[3]/div[1]/button[2]";

    // Botón insertar
    private String v_btnInsertar = "//button[@id='B74203170231940602']";

    // Botón siguiente
    /* private String v_btnSiguiente = "//button[@id='wf_btn_siguiente']"; */

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
            Sheet hojaInstanciar = libroExcel.getSheet("v_instanciar");
            Sheet hojaDatosSolicitud = libroExcel.getSheet("v_datosSolicitud");
            Sheet hojaDatosGestor = libroExcel.getSheet("v_datosGestor");
            Sheet hojaDatosSolicitante = libroExcel.getSheet("v_datosSolicitante");
            Sheet hojaDocumentos = libroExcel.getSheet("v_documentos");
            // Hoja login
            for (int i = 1; i <= hojaLogin.getLastRowNum(); i++) {
                Row fila = hojaLogin.getRow(i);
                Cell cliente = fila.getCell(0);
                Cell suit = fila.getCell(1);
                Cell usuario = fila.getCell(2);
                Cell clave = fila.getCell(3);

                if (cliente != null) {
                    if (cliente.getCellType() == CellType.STRING) {
                        v_cliente = cliente.getStringCellValue();
                    } else if (cliente.getCellType() == CellType.NUMERIC) {
                        v_cliente = String.valueOf((int) cliente.getNumericCellValue());
                    }
                }
                if (suit != null) {
                    if (suit.getCellType() == CellType.STRING) {
                        v_suit = suit.getStringCellValue();
                    } else if (suit.getCellType() == CellType.NUMERIC) {
                        v_suit = String.valueOf((int) suit.getNumericCellValue());
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
            // Hoja instanciar
            for (int i = 1; i <= hojaInstanciar.getLastRowNum(); i++) {
                Row fila = hojaInstanciar.getRow(i);
                Cell instanciaFlujo = fila.getCell(0);
                Cell observacionInstancia = fila.getCell(1);

                if (instanciaFlujo != null) {
                    if (instanciaFlujo.getCellType() == CellType.STRING) {
                        v_instanciaFlujo = instanciaFlujo.getStringCellValue();
                    } else if (instanciaFlujo.getCellType() == CellType.NUMERIC) {
                        v_instanciaFlujo = String.valueOf((int) instanciaFlujo.getNumericCellValue());
                    }
                }
                if (observacionInstancia != null) {
                    if (observacionInstancia.getCellType() == CellType.STRING) {
                        v_observacionInstancia = observacionInstancia.getStringCellValue();
                    } else if (observacionInstancia.getCellType() == CellType.NUMERIC) {
                        v_observacionInstancia = String.valueOf((int) observacionInstancia.getNumericCellValue());
                    }
                }
            }
            // Hoja datos solicitud
            for (int i = 1; i <= hojaDatosSolicitud.getLastRowNum(); i++) {
                Row fila = hojaDatosSolicitud.getRow(i);
                Cell tipo = fila.getCell(0);
                Cell tipoPresentacion = fila.getCell(1);
                Cell tributo = fila.getCell(2);
                Cell subTributo = fila.getCell(3);
                Cell motivo = fila.getCell(4);
                Cell identificacion = fila.getCell(5);
                Cell observacion = fila.getCell(6);

                if (tipo != null) {
                    if (tipo.getCellType() == CellType.STRING) {
                        v_tipo = tipo.getStringCellValue();
                    } else if (tipo.getCellType() == CellType.NUMERIC) {
                        v_tipo = String.valueOf((int) tipo.getNumericCellValue());
                    }
                }
                if (tipoPresentacion != null) {
                    if (tipoPresentacion.getCellType() == CellType.STRING) {
                        v_tipoPresentacion = tipoPresentacion.getStringCellValue();
                    } else if (tipoPresentacion.getCellType() == CellType.NUMERIC) {
                        v_tipoPresentacion = String.valueOf((int) tipoPresentacion.getNumericCellValue());
                    }
                }
                if (tributo != null) {
                    if (tributo.getCellType() == CellType.STRING) {
                        v_tributo = tributo.getStringCellValue();
                    } else if (tributo.getCellType() == CellType.NUMERIC) {
                        v_tributo = String.valueOf((int) tributo.getNumericCellValue());
                    }
                }
                if (subTributo != null) {
                    if (subTributo.getCellType() == CellType.STRING) {
                        v_subTributo = subTributo.getStringCellValue();
                    } else if (subTributo.getCellType() == CellType.NUMERIC) {
                        v_subTributo = String.valueOf((int) subTributo.getNumericCellValue());
                    }
                }
                if (motivo != null) {
                    if (motivo.getCellType() == CellType.STRING) {
                        v_motivo = motivo.getStringCellValue();
                    } else if (motivo.getCellType() == CellType.NUMERIC) {
                        v_motivo = String.valueOf((int) motivo.getNumericCellValue());
                    }
                }
                if (identificacion != null) {
                    if (identificacion.getCellType() == CellType.STRING) {
                        v_identificacion = identificacion.getStringCellValue();
                    } else if (identificacion.getCellType() == CellType.NUMERIC) {
                        v_identificacion = String.valueOf((int) identificacion.getNumericCellValue());
                    }
                }
                if (observacion != null) {
                    if (observacion.getCellType() == CellType.STRING) {
                        v_observacion = observacion.getStringCellValue();
                    } else if (observacion.getCellType() == CellType.NUMERIC) {
                        v_observacion = String.valueOf((int) observacion.getNumericCellValue());
                    }
                }
            }
            // Hoja datos gestor
            for (int i = 1; i <= hojaDatosGestor.getLastRowNum(); i++) {
                Row fila = hojaDatosGestor.getRow(i);
                Cell tipoIdentificacion = fila.getCell(0);
                Cell identificacionGestor = fila.getCell(1);
                Cell primerNombre = fila.getCell(2);
                Cell primerApellido = fila.getCell(3);

                if (tipoIdentificacion != null) {
                    if (tipoIdentificacion.getCellType() == CellType.STRING) {
                        v_tipoIdentificacion = tipoIdentificacion.getStringCellValue();
                    } else if (tipoIdentificacion.getCellType() == CellType.NUMERIC) {
                        v_tipoIdentificacion = String.valueOf((int) tipoIdentificacion.getNumericCellValue());
                    }
                }
                if (identificacionGestor != null) {
                    if (identificacionGestor.getCellType() == CellType.STRING) {
                        v_identificacionGestor = identificacionGestor.getStringCellValue();
                    } else if (identificacionGestor.getCellType() == CellType.NUMERIC) {
                        v_identificacionGestor = String
                                .valueOf((int) identificacionGestor.getNumericCellValue());
                    }
                }
                if (primerNombre != null) {
                    if (primerNombre.getCellType() == CellType.STRING) {
                        v_primerNombre = primerNombre.getStringCellValue();
                    } else if (primerNombre.getCellType() == CellType.NUMERIC) {
                        v_primerNombre = String.valueOf((int) primerNombre.getNumericCellValue());
                    }
                }
                if (primerApellido != null) {
                    if (primerApellido.getCellType() == CellType.STRING) {
                        v_primerApellido = primerApellido.getStringCellValue();
                    } else if (primerApellido.getCellType() == CellType.NUMERIC) {
                        v_primerApellido = String.valueOf((int) primerApellido.getNumericCellValue());
                    }
                }
            }
            // Hoja datos solicitante
            for (int i = 1; i <= hojaDatosSolicitante.getLastRowNum(); i++) {
                Row fila = hojaDatosSolicitante.getRow(i);
                Cell tipoSolicitante = fila.getCell(0);
                Cell tipoIdentificacionSolicitante = fila.getCell(1);
                Cell identificacionSolicitante = fila.getCell(2);
                Cell primerNombre = fila.getCell(3);
                Cell primerApellido = fila.getCell(4);
                Cell pais = fila.getCell(5);
                Cell departamento = fila.getCell(6);
                Cell municipio = fila.getCell(7);
                Cell direccion = fila.getCell(8);
                Cell email = fila.getCell(9);
                Cell celular = fila.getCell(10);

                if (tipoSolicitante != null) {
                    if (tipoSolicitante.getCellType() == CellType.STRING) {
                        v_tipoSolicitante = tipoSolicitante.getStringCellValue();
                    } else if (tipoSolicitante.getCellType() == CellType.NUMERIC) {
                        v_tipoSolicitante = String.valueOf((int) tipoSolicitante.getNumericCellValue());
                    }
                }
                if (tipoIdentificacionSolicitante != null) {
                    if (tipoIdentificacionSolicitante.getCellType() == CellType.STRING) {
                        v_tipoIdentificacionSolicitante = tipoIdentificacionSolicitante.getStringCellValue();
                    } else if (tipoIdentificacionSolicitante.getCellType() == CellType.NUMERIC) {
                        v_tipoIdentificacionSolicitante = String
                                .valueOf((int) tipoIdentificacionSolicitante.getNumericCellValue());
                    }
                }
                if (identificacionSolicitante != null) {
                    if (identificacionSolicitante.getCellType() == CellType.STRING) {
                        v_identificacionSolicitante = identificacionSolicitante.getStringCellValue();
                    } else if (identificacionSolicitante.getCellType() == CellType.NUMERIC) {
                        v_identificacionSolicitante = String
                                .valueOf((int) identificacionSolicitante.getNumericCellValue());
                    }
                }
                if (primerNombre != null) {
                    if (primerNombre.getCellType() == CellType.STRING) {
                        v_primerNombreSolicitante = primerNombre.getStringCellValue();
                    } else if (primerNombre.getCellType() == CellType.NUMERIC) {
                        v_primerNombreSolicitante = String
                                .valueOf((int) primerNombre.getNumericCellValue());
                    }
                }
                if (primerApellido != null) {
                    if (primerApellido.getCellType() == CellType.STRING) {
                        v_primerApellidoSolicitante = primerApellido.getStringCellValue();
                    } else if (primerApellido.getCellType() == CellType.NUMERIC) {
                        v_primerApellidoSolicitante = String
                                .valueOf((int) primerApellido.getNumericCellValue());
                    }
                }
                if (pais != null) {
                    if (pais.getCellType() == CellType.STRING) {
                        v_pais = pais.getStringCellValue();
                    } else if (pais.getCellType() == CellType.NUMERIC) {
                        v_pais = String
                                .valueOf((int) pais.getNumericCellValue());
                    }
                }
                if (departamento != null) {
                    if (departamento.getCellType() == CellType.STRING) {
                        v_departamento = departamento.getStringCellValue();
                    } else if (departamento.getCellType() == CellType.NUMERIC) {
                        v_departamento = String
                                .valueOf((int) departamento.getNumericCellValue());
                    }
                }
                if (municipio != null) {
                    if (municipio.getCellType() == CellType.STRING) {
                        v_municipio = municipio.getStringCellValue();
                    } else if (municipio.getCellType() == CellType.NUMERIC) {
                        v_municipio = String
                                .valueOf((int) municipio.getNumericCellValue());
                    }
                }
                if (direccion != null) {
                    if (direccion.getCellType() == CellType.STRING) {
                        v_direccion = direccion.getStringCellValue();
                    } else if (direccion.getCellType() == CellType.NUMERIC) {
                        v_direccion = String
                                .valueOf((int) direccion.getNumericCellValue());
                    }
                }
                if (email != null) {
                    if (email.getCellType() == CellType.STRING) {
                        v_email = email.getStringCellValue();
                    } else if (email.getCellType() == CellType.NUMERIC) {
                        v_email = String
                                .valueOf((int) email.getNumericCellValue());
                    }
                }
                if (celular != null) {
                    if (celular.getCellType() == CellType.STRING) {
                        v_celular = celular.getStringCellValue();
                    } else if (celular.getCellType() == CellType.NUMERIC) {
                        double numericCellValue = celular.getNumericCellValue();
                        v_celular = String.valueOf((long) numericCellValue);
                    }
                }

            }
            // Hoja documentos
            for (int i = 1; i <= hojaDocumentos.getLastRowNum(); i++) {
                Row fila = hojaDocumentos.getRow(i);
                Cell documentos = fila.getCell(0);
                Cell observacionDocumentos = fila.getCell(1);
                Cell numeroFolios = fila.getCell(2);
                Cell x_rutaArchivo = fila.getCell(3);

                if (documentos != null) {
                    if (documentos.getCellType() == CellType.STRING) {
                        v_documentos = documentos.getStringCellValue();
                    } else if (documentos.getCellType() == CellType.NUMERIC) {
                        v_documentos = String.valueOf((int) documentos.getNumericCellValue());
                    }
                }
                if (observacionDocumentos != null) {
                    if (observacionDocumentos.getCellType() == CellType.STRING) {
                        v_observacionDocumentos = observacionDocumentos.getStringCellValue();
                    } else if (observacionDocumentos.getCellType() == CellType.NUMERIC) {
                        v_observacionDocumentos = String
                                .valueOf((int) observacionDocumentos.getNumericCellValue());
                    }
                }
                if (numeroFolios != null) {
                    if (numeroFolios.getCellType() == CellType.STRING) {
                        v_numeroFolios = numeroFolios.getStringCellValue();
                    } else if (numeroFolios.getCellType() == CellType.NUMERIC) {
                        v_numeroFolios = String
                                .valueOf((int) numeroFolios.getNumericCellValue());
                    }
                }
                if (x_rutaArchivo != null) {
                    if (x_rutaArchivo.getCellType() == CellType.STRING) {
                        v_rutaArchivo = x_rutaArchivo.getStringCellValue();
                    } else if (x_rutaArchivo.getCellType() == CellType.NUMERIC) {
                        v_rutaArchivo = String
                                .valueOf((int) x_rutaArchivo.getNumericCellValue());
                    }
                }
            }
            System.out.println("-------Datos Login-------");
            System.out.println("1: " + v_cliente);
            System.out.println("2: " + v_suit);
            System.out.println("3: " + v_usuario);
            System.out.println("4: " + v_clave);
            System.out.println("------Datos Instancia--------");
            System.out.println("5: " + v_instanciaFlujo);
            System.out.println("6: " + v_observacionInstancia);
            System.out.println("-------Datos Solicitud-------");
            System.out.println("7: " + v_tipo);
            System.out.println("8: " + v_tipoPresentacion);
            System.out.println("9: " + v_tributo);
            System.out.println("10: " + v_subTributo);
            System.out.println("11: " + v_motivo);
            System.out.println("12: " + v_identificacion);
            System.out.println("13: " + v_observacion);
            System.out.println("------Datos Gestor--------");
            System.out.println("14: " + v_tipoIdentificacion);
            System.out.println("15: " + v_identificacionGestor);
            System.out.println("16: " + v_primerNombre);
            System.out.println("17: " + v_primerApellido);
            System.out.println("------Datos Solicitante--------");
            System.out.println("18: " + v_tipoSolicitante);
            System.out.println("19: " + v_tipoIdentificacionSolicitante);
            System.out.println("20: " + v_identificacionSolicitante);
            System.out.println("21: " + v_primerNombreSolicitante);
            System.out.println("22: " + v_primerApellidoSolicitante);
            System.out.println("23: " + v_pais);
            System.out.println("24: " + v_departamento);
            System.out.println("25: " + v_municipio);
            System.out.println("26: " + v_direccion);
            System.out.println("27: " + v_email);
            System.out.println("-------Documentos-------");
            System.out.println("28: " + v_documentos);
            System.out.println("29: " + v_observacionDocumentos);
            System.out.println("30: " + v_numeroFolios);
            System.out.println("31: " + v_rutaArchivo);
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

    // -------------------------------------------------------------------------------------
    // Metodo proceso creación nuevo PQR
    public void nuevoPQR() throws InterruptedException {
        // Metodo para esperar
        esperando();
        // Clic botón gestión financiera
        clickElement(v_btnPQR);
        // Metodo para esperar
        esperando();
        // Clic botón documentos
        clickElement(v_btnNvPQR);
        // Metodo para esperar
        esperando();
        // Clic botón nuevo PQR
        clickElement(v_btnNuevoPQR);
        // Enfocar la ventana modal
        enfocarEnLaVentanaModal();
        // Clic select instancia flujo
        selectFromDropdownByValue(v_selectFlujo, v_instanciaFlujo);
        // Clic txtArea observación
        clickElement(v_txtObservacionInstancia);
        // Ingresar observación
        write(v_txtObservacionInstancia, v_observacionInstancia);
        // Clic botón crear instancia
        clickElement(v_btnCrearInstancia);
    }
    // -------------------------------------------------------------------------------------

    // -------------------------------------------------------------------------------------
    // Metodo flujo datos solicitud
    public void datosSolicitud() throws InterruptedException {
        // Metodo para esperar
        esperando();
        // Clic select tipo de solicitud
        selectFromDropdownByValue(v_selectTipo, v_tipo);
        // Clic select tipo presentación
        selectFromDropdownByValue(v_selectTipoPresentacion, v_tipoPresentacion);
        // Clic select tributo
        selectFromDropdownByValue(v_selectTributo, v_tributo);
        // Clic select subTributo
        selectFromDropdownByValue(v_selectSubTributo, v_subTributo);
        // Clic select motivo
        selectFromDropdownByValue(v_selectMotivo, v_motivo);
        // Clic input identificación sujeto
        clickElement(v_txtIdentificacion);
        // Ingresar identificación sujeto
        write(v_txtIdentificacion, v_identificacion);
        // Clic botón validar (verde)
        clickElement(V_btnValidar);
        // Clic input txtarea observación
        clickElement(v_txtObservacion);
        // Ingresar observación
        write(v_txtObservacion, v_observacion);
    }
    // -------------------------------------------------------------------------------------

    // -------------------------------------------------------------------------------------
    // Metodo flujo datos gestor
    public void datosGestor() throws InterruptedException {
        // Metodo para esperar
        esperando();
        // Clic datos gestor
        clickElement(v_btnDatosGestor);
        // Clic select tipo identificación
        selectFromDropdownByValue(v_selectTipoIdentificacion, v_tipoIdentificacion);
        // Clic txt identificación
        clickElement(v_txtIdentificacionGestor);
        // Ingresar identificación
        write(v_txtIdentificacionGestor, v_identificacionGestor);
        // Clic primer nombre
        clickElement(v_txtPrimerNombre);
        // Ingresar primer nombre
        write(v_txtPrimerNombre, v_primerNombre);
        // Clic primer apellido
        clickElement(v_txtPrimerApellido);
        // Ingresar primer apellido
        write(v_txtPrimerApellido, v_primerApellido);
    }
    // -------------------------------------------------------------------------------------

    // -------------------------------------------------------------------------------------
    // Metodo flujo datos solicitante
    public void datosSolicitante() throws InterruptedException {
        // Metodo para esperar
        esperando();
        // Clic datos gestor
        clickElement(v_btnDatosSolicitante);
        // select tipo solicitante
        selectFromDropdownByValue(v_selectTipoSolicitante, v_tipoSolicitante);
        // select tipo identificación
        selectFromDropdownByValue(v_selectTipoIdentificacionSolicitante, v_tipoIdentificacionSolicitante);
        // Clic txt identificación solicitante
        clickElement(v_txtIdentificacionSolicitante);
        // Ingresar identificación solic
        write(v_txtIdentificacionSolicitante, v_identificacionSolicitante);
        // Clic primer nombre sol
        clickElement(v_txtPrimerNombreSolicitante);
        // Ingresar primer nombre sol
        write(v_txtPrimerNombreSolicitante, v_primerNombreSolicitante);
        // Metodo para esperar
        esperando();
        // Clic primer apellido sol
        clickElement(v_txtPrimerApellidoSolicitante);
        // Ingresar primer apellido sol
        write(v_txtPrimerApellidoSolicitante, v_primerApellidoSolicitante);
        // Select pais
        selectFromDropdownByValue(v_selectPais, v_pais);
        // Select departamento
        selectFromDropdownByValue(v_selectDepartamento, v_departamento);
        // Select municipio
        selectFromDropdownByValue(v_selectMunicipio, v_municipio);
        // Clic txt dirección
        clickElement(v_txtDireccion);
        // Ingresar dirección
        write(v_txtDireccion, v_direccion);
        // Clic txt email
        clickElement(v_txtEmail);
        // Ingresar email
        write(v_txtEmail, v_email);
        // Clic txt celular
        clickElement(v_txtCelular);
        // Ingresar celular
        write(v_txtCelular, v_celular);
    }
    // -------------------------------------------------------------------------------------

    // -------------------------------------------------------------------------------------
    // Metodo flujo documentos
    public void documentos() throws InterruptedException {
        // Metodo para esperar
        esperando();
        // Clic datos gestor
        clickElement(v_btnDocumentos);
        // Select documentos
        selectFromDropdownByValue(v_selectDocumentos, v_documentos);
        // Clic txt area input observación
        clickElement(v_txtObservacionDocumentos);
        // Ingresar primer apellido sol
        write(v_txtObservacionDocumentos, v_observacionDocumentos);
        // Clic txt input número folios
        clickElement(v_txtNumeroFolios);
        // Ingresar número folios
        write(v_txtNumeroFolios, v_numeroFolios);
        // Cargar archivo
        cargaArchivo();
        // Clic botón agregar
        clickElement(v_btnAgregar);
        // Clic botón aceptar
        clickElement(v_btnAceptarCargar);
        // Metodo para esperar
        esperando();
        // Clic botón insertar
        clickElement(v_btnInsertar);
        // Metodo para esperar
        esperando();
        // Clic botón siguiente
        // clickElement(v_btnSiguiente);
    }
    // -------------------------------------------------------------------------------------

    // ------------------------------------------------------------------------------------
    // Metodo para cargar archivos ingresando la ruta en el excel
    public void cargaArchivo() {
        try {
            WebElement inputArchivo = driver.findElement(By.xpath("//input[@id='P9_FILE_BLOB']"));
            String rutaArchivo = v_rutaArchivo;
            String archivoSeleccionado = rutaArchivo;
            inputArchivo.sendKeys(archivoSeleccionado);
            System.out.println("Archivo cargado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al cargar el archivo.");
        }

    }
    // -------------------------------------------------------------------------------------

    // -------------------------------------------------------------------------------------
    // Metodo para enfocar la ventana modal: 'instanciar flujos'
    public void enfocarEnLaVentanaModal() {
        try {
            WebElement ventanaModal = driver.findElement(By.xpath(v_ventanaModal));
            ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", ventanaModal);
            driver.switchTo().frame(0);
            System.out.println("Ventana modal: instanciar flujos ENFOCADO");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ventana modal: instanciar flujos NO ENFOCADO");
        }
    }
    // -------------------------------------------------------------------------------------

}
