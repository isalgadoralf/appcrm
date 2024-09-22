package soe.solid.appcrm.service.spc;

import soe.solid.appcrm.model.GrupoCliente;

import java.util.List;

public interface IGrupoClienteService {
    GrupoCliente registrar(GrupoCliente producto) throws Exception;
    GrupoCliente obtenerPorId(Integer id) throws Exception;
    List<GrupoCliente> listarTodos() throws Exception;
}
