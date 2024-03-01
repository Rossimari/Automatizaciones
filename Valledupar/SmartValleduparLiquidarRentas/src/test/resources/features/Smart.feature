@Grind
Feature: Proceso para emitir recibo

Scenario: Leer Excel
    Given leyendo excel

Scenario: Iniciar Sesion
    Given navegar a smart
    When  seleccionar cliente
    And   seleccionar suit
    And   ingresar usuario
    And   ingresar clave
    And   clic al boton entrar
    Then  obtener resultados

Scenario: Consulta General
    Given  clic al boton generacion tributo
    And    clic a opcion rentas varias
    And    clic a opcion gestion rentas varias
    And    clic al boton nueva renta
    And    select sub tributo
    And    select acto
    And    clic checkbox
    And    clic boton siguiente
    And    ingresar identificacion
    And    clic consultar
    And    ingresar numero vallas
    And    clic boton calendario
    And    seleccionar dia
    And    clic boton siguiente dos
    And    clic boton calendario dos
    And    seleccionar dia dos
    And    clic boton generar
    And    seleccionar dia tres
    And    seleccionar plantilla
    And    clic boton terminar
    And    clic boton imprimir
    Then   obtener resultados


