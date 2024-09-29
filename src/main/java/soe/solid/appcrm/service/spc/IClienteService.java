package soe.solid.appcrm.service.spc;

import soe.solid.appcrm.model.Cliente;

import java.util.List;

public interface IClienteService {
    Cliente registrar(Cliente producto);
    Cliente obtenerPorId(Integer id) throws Exception;
    List<Cliente> listarTodos() throws Exception;
}
