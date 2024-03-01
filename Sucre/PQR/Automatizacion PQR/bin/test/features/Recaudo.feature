Feature: Pruebas del modulo de Recaudo Manual

Scenario: Pruebas del modulo de Recaudo Manual
    Given Ingreso al Taxation Smart
    When Inicio de Sesion
    And Modulo de PQR
    When hago clic en el botón dentro de la modal
    When Datos Solicitud
    When Datos del Gestor
    When Datos del Solicitante
    Then The results match the criteria