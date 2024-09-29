package soe.solid.appcrm.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import soe.solid.appcrm.model.Cliente;
import soe.solid.appcrm.service.imp.ClienteServiceImp;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ClienteSeriviceImpTest {

    @InjectMocks
    ClienteServiceImp clienteServiceImp;

    @Test
    void testValidarRequeriodos() {
        Cliente cliente = new Cliente();
        cliente.setClienteId(1);
        cliente.setNombre("nombre");
        cliente.setDireccion("direccion");
        cliente.setEmail("email");
        cliente.setCodCliente("codCliente");
        cliente.setTelefono("telefono");
        cliente.setApellidos("apellidos");
        cliente.setNumDocumento("numDocumento");
        cliente.setTipoDocumento("tipoDocumento");
        String mensage = clienteServiceImp.validarCliente(cliente);
        assertEquals("", mensage);


    }
    @Test
    void testValidarFormatoCorreo() {
        boolean valor = Valicaciones.validarCorreo("correo@tes.com");
        assertEquals(true, valor);

    }
    @Test
    void testValidarCI() {
        boolean valor = Valicaciones.validarNumero("12314");
        assertEquals(true, valor);


    }


}
