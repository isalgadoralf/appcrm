Feature: Crear cliente en la aplicación

  Scenario: Registro exitoso de un cliente con datos válidos
    Given el usuario está en la página de registro de cliente
    When el usuario ingresa el código "C12345"
    And el usuario ingresa el nombre "Juan Perez"
    And el usuario ingresa el numero de ci "12345678"
    And el usuario selecciona el tipo de documento "CI"
    And el usuario ingresa el email "juan.perez@example.com"
    Then el cliente es registrado exitosamente
