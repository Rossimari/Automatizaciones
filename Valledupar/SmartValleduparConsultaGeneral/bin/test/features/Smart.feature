@Grind
Feature: Proceso para emitir recibo

Scenario: Leer Excel
    Given leyendo excel

Scenario: Iniciar Sesion
    Given navegar a smart
    When  iniciar sesion
    Then  obtener resultados

Scenario: Consulta General
    Given  clic al boton gestion financiera
    And    clic a opcion consulta general
    And    ingresar identificacion
    And    clic al boton consultar
    And    clic impuesto predial
    Then   obtener resultados

Scenario: Consulta Cartera
    Given  clic a la opcion cartera

