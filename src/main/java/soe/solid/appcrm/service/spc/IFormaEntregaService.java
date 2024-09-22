package soe.solid.appcrm.service.spc;

import soe.solid.appcrm.model.FormaEntrega;

import java.util.List;

public interface IFormaEntregaService {
    FormaEntrega registrar(FormaEntrega producto) throws Exception;
    FormaEntrega obtenerPorId(Integer id) throws Exception;
    List<FormaEntrega> listarTodos() throws Exception;
}
