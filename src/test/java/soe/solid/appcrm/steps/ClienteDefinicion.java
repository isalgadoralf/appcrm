package soe.solid.appcrm.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import soe.solid.appcrm.model.Cliente;
import soe.solid.appcrm.service.spc.IClienteService;

public class ClienteDefinicion {
    @Mock
    private IClienteService clienteService;

    private Cliente cliente;
    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Given("el usuario está en la página de registro de cliente")
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
        clienteService.registrar(cliente);
        System.out.println("Cliente registrado: " + cliente.toString());
    }

}