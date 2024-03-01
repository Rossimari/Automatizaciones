Feature: Test Recaudo search functionality

Scenario: As a user I enter a search criteria in Recaudo
    Given Ingreso al Taxation Smart
    When seleccion del cliente
    When seleccion de suit
    When ingresar usuario
    When ingresar contraseña
    And Clic en el boton ingresar
    And Ingresa al menu de Recaudo Manual
    When impuesto Rentas varias
    When SubImpuestos Rentas varias
    When Bancos
    When Cuenta Bancos
    When Observacion
    And Clic en el boton siguiente
    When Numero documento
    And Click Barra
    And Consulta General
    Then The results match the criteria