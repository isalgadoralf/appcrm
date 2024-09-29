package soe.solid.appcrm.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import soe.solid.appcrm.model.Cliente;
import soe.solid.appcrm.model.ResponseDto;
import soe.solid.appcrm.service.imp.ClienteServiceImp;
import soe.solid.appcrm.service.spc.IClienteService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ClienteDefinicion {
    @InjectMocks
    private ClienteServiceImp clienteService;

    private Cliente cliente;
    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Given("el sistema está preparado para registrar un cliente")
    public void elUsuarioEstaEnLaPaginaDeRegistroDeCliente() {
         cliente = new Cliente();
    }

    @When("el usuario ingresa el código {string}")
    public void elUsuarioIngresaElCodigo(String string) {
        cliente.setCodCliente(string);
    }

    @When("el usuario ingresa el nombre {string}")
    public void elUsuarioIngresaElNombre(String string) {
        cliente.setNombre(string);
    }

    @When("el usuario ingresa el numero de ci {string}")
    public void elUsuarioIngresaElNumeroDeCi(String string) {
        cliente.setNumDocumento(string);
    }

    @When("el usuario selecciona el tipo de documento {string}")
    public void elUsuarioSeleccionaElTipoDeDocumento(String string) {
        cliente.setTipoDocumento(string);
    }

    @When("el usuario ingresa el email {string}")
    public void elUsuarioIngresaElEmail(String string) {
        cliente.setEmail(string);
    }

    @Then("el cliente es registrado exitosamente")
    public void elClienteEsRegistradoExitosamente() {
        ResponseDto responseDto = clienteService.registrar(cliente);
        System.out.println(responseDto);
        System.out.println("Cliente registrado: " + cliente.toString());
    }

    @When("se envía la información del cliente sin completar todos los campos obligatorios")
    public void seEnviaLaInformacionDelClienteSinCompletarTodosLosCamposObligatorios() {
        cliente.setCodCliente("123");


    }
    @Then("se debe mostrar un mensaje de error indicando los campos faltantes")
    public void seDebeMostrarUnMensajeDeErrorIndicandoLosCamposFaltantes() {
        ResponseDto responseDto = clienteService.registrar(cliente);
        assertNotNull(responseDto);
        System.out.println(responseDto);
        assertEquals(1, responseDto.getCodigo());
    }

    @When("se envía un ci que no contiene solo números {string}")
    public void seEnviaUnCiQueNoContieneSoloNumeros(String string) {
        cliente.setNumDocumento(string);
    }
    @When("se envía un email con formato incorrecto {string}")
    public void seEnviaUnEmailConFormatoIncorrecto(String string) {
        cliente.setNumDocumento(string);
    }
    @Then("se debe mostrar un mensaje de error de validación para CI y email")
    public void seDebeMostrarUnMensajeDeErrorDeValidacionParaCiNitYEmail() {
        ResponseDto responseDto = clienteService.registrar(cliente);
        assertNotNull(responseDto);
        System.out.println(responseDto);
        assertEquals(1, responseDto.getCodigo());
    }


}