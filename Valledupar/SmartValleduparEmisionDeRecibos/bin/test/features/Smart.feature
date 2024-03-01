@Grind
Feature: Proceso para emitir recibo

Scenario: Iniciar Sesion
    Given navegar a smart
    When  seleccionar cliente
    And   seleccionar suit
    And   ingresar usuario
    And   ingresar clave
    And   clic al boton entrar
    Then  obtener resultados


Scenario: Ruta emision de recibos
    Given clic al boton gestion financiera
    When  clic a opcion documentos
    And   clic al boton emision de recibos puntuales
    And   clic select tributo
    And   clic select sub tributo
    And   clic identificacion
    And   ingresar identificacion
    And   clic al boton consultar
    And   clic al checkbox
    And   clic al checkbox liquidacion
    And   clic al boton siguiente
    And   enfocar ventana modal
    And   clic select 1
    And   clic select tipo recibo
    And   clic boton imprimir
    Then  obtener resultados