Feature: Crear cliente en la aplicación

  Scenario: Registro exitoso de un cliente con datos válidos
    Given el sistema está preparado para registrar un cliente
    When el usuario ingresa el código "C12345"
    And el usuario ingresa el nombre "Juan Perez"
    And el usuario ingresa el numero de ci "12345678"
    And el usuario selecciona el tipo de documento "CI"
    And el usuario ingresa el email "juan.perez@example.com"
    Then el cliente es registrado exitosamente

  Scenario: Registrar un cliente con campos obligatorios faltantes
    Given el sistema está preparado para registrar un cliente
    When se envía la información del cliente sin completar todos los campos obligatorios
    Then se debe mostrar un mensaje de error indicando los campos faltantes

  Scenario: Registrar un cliente con un formato incorrecto en CI/NIT y email
    Given el sistema está preparado para registrar un cliente
    When se envía un ci que no contiene solo números "C12345"
    And se envía un email con formato incorrecto "juan.perez@@example"
    Then se debe mostrar un mensaje de error de validación para CI y email