package soe.solid.appcrm.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soe.solid.appcrm.model.Cliente;
import soe.solid.appcrm.model.ResponseDto;
import soe.solid.appcrm.repository.IClienteRepo;
import soe.solid.appcrm.repository.IFabricanteRepo;
import soe.solid.appcrm.service.Valicaciones;
import soe.solid.appcrm.service.spc.IClienteService;
import soe.solid.appcrm.service.spc.IFabricanteService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImp implements IClienteService {

    private final IClienteRepo repo;
    @Override
    public ResponseDto registrar(Cliente producto)  {
        String validationMessage = validarCliente(producto);
        if (!validationMessage.isEmpty()) {
            return new ResponseDto(1, validationMessage);
        }
        boolean validarCorreo = Valicaciones.validarCorreo(producto.getEmail());
        if (!validarCorreo) {
            return new ResponseDto(1, "Formato de correo no valido");
        }
        boolean validarNumero = Valicaciones.validarCorreo(producto.getNumDocumento());
        if (!validarNumero) {
            return new ResponseDto(1, "Numero de documento no valido");
        }

        repo.save(producto);
        return new ResponseDto(0, "Cliente registrado correctamente");
    }

    @Override
    public Cliente obtenerPorId(Integer id) throws Exception {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Cliente> listarTodos() throws Exception {
        return repo.findAll();
    }

    public String validarCliente(Cliente cliente) {
        StringBuilder validationMessage = new StringBuilder();

        if (cliente.getNombre() == null || cliente.getNombre().isEmpty()) {
            validationMessage.append("Nombre es obligatorio, ");
        }
        if (cliente.getApellidos() == null || cliente.getApellidos().isEmpty()) {
            validationMessage.append("Apellidos es obligatorio, ");
        }
        if (cliente.getNumDocumento() == null || cliente.getNumDocumento().isEmpty()) {
            validationMessage.append("NumDocumento es obligatorio, ");
        }
        if (cliente.getTipoDocumento() == null || cliente.getTipoDocumento().isEmpty()) {
            validationMessage.append("TipoDocumento  es obligatorio, ");
        }
        if (cliente.getCodCliente() == null || cliente.getCodCliente().isEmpty()) {
            validationMessage.append("CodCliente es obligatorio, ");
        }
        if (cliente.getEmail() == null || cliente.getEmail().isEmpty()) {
            validationMessage.append("Email es obligatorio, ");
        }

        if (validationMessage.length() > 0) {
            validationMessage.setLength(validationMessage.length() - 2); // Remove trailing comma and space
        }

        return validationMessage.toString();
    }

    public String validarCorreo(String cliente) {
        return "";
    }
    private boolean esNumerico(String str) {
        return str != null && str.matches("\\d+");
    }

}
