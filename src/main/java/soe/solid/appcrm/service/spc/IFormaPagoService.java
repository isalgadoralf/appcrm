package soe.solid.appcrm.service.spc;

import soe.solid.appcrm.model.FormaPago;

import java.util.List;

public interface IFormaPagoService {
    FormaPago registrar(FormaPago producto) throws Exception;
    FormaPago obtenerPorId(Integer id) throws Exception;
    List<FormaPago> listarTodos() throws Exception;
}
