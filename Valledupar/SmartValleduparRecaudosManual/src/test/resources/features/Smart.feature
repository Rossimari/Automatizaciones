@Grind
Feature: Proceso para recaudar manual

@Escenario1
Scenario: Iniciar Sesion
    Given navegar a smart
    When  seleccionar cliente
    And   seleccionar suit
    And   ingresar usuario
    And   ingresar clave
    And   clic al boton entrar
    Then  obtener resultados

@Escenario2
Scenario: Ruta recaudo manual
    Given clic al boton gestion financiera
    When  clic a opcion recaudos
    And   clic al boton gestion registro recaudo manual
    And   clic al boton nuevo registro
    And   seleccionar tributo
    And   seleccionar sub tributo
    And   seleccionar banco
    And   seleccionar banco cuenta
    And   ingresar observacion registro recaudo manual
    And   clic al boton siguiente
    And   ingresar numero documento
    And   enter codigo barra
    And   ingresar observacion opcional
    And   clic al boton incluir recaudo
    And   clic al boton confirmar registro
    And   clic al boton aceptar modal
    Then  obtener resultados

@Escenario3
Scenario: Aplicar recaudo manual
    Given proceso aplicar recaudo