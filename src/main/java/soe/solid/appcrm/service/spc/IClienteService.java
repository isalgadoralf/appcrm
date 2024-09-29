package soe.solid.appcrm.service.spc;

import soe.solid.appcrm.model.Cliente;
import soe.solid.appcrm.model.ResponseDto;

import java.util.List;

public interface IClienteService {
    ResponseDto registrar(Cliente producto);
    Cliente obtenerPorId(Integer id) throws Exception;
    List<Cliente> listarTodos() throws Exception;
}
