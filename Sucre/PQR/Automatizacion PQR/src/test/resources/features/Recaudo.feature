Feature: Pruebas del modulo de Recaudo Manual

Scenario: Pruebas del modulo de Recaudo Manual
    Given Ingreso al Taxation Smart
    When Inicio de Sesion
    And  Modulo de PQR
    And Clic en el boton en modal
    When Datos Solicitud
    When Datos del Gestor
    When Datos del Solicitante
    And adjuntar
    When Solicitud Acuerdo de pago
    # When Ventana Emergente
    Then The results match the criteria