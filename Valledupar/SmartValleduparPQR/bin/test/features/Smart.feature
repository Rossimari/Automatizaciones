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

