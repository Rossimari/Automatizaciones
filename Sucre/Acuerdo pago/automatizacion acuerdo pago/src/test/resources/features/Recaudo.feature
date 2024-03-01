Feature: Pruebas del modulo Proyeccion de Acuerdo de Pago

Scenario: Pruebas del modulo Proyeccion de Acuerdo de Pago
    Given Ingreso al Taxation Smart
    When seleccion del cliente
    When seleccion de suit
    When ingresar usuario
    When ingresar contrasena
    And Clic en el boton ingresar
    And Ingresa al menu Gestion financiera
    When Opcion Proyecccion de Acuerdo de Pago
    Then The results match the criteria