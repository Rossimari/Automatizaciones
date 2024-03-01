@Grind
Feature: Proceso para emitir recibo

Scenario: Leer Excel
    Given leyendo excel

Scenario: Iniciar Sesion
    Given navegar a smart
    When  iniciar sesion
    Then  obtener resultados

Scenario: PQR
    Given  nuevo pqr
    Then   obtener resultados

Scenario: Datos Solicitud
    Given  llenando datos solicitud
    Then   obtener resultados

Scenario: Datos Gestor
    Given  llenando datos gestor
    Then   obtener resultados

Scenario: Datos Solicitante
    Given  llenando datos solicitante
    Then   obtener resultados

Scenario: Documentos
    Given  cargar documentos
    Then   obtener resultados