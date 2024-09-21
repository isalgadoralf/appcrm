package soe.solid.appcrm.service.spc;

import soe.solid.appcrm.model.Producto;

import java.util.List;

public interface IProductoService {
    Producto registrar(Producto producto) throws Exception;
    Producto obtenerPorId(Integer id) throws Exception;
    List<Producto> listarTodos() throws Exception;
}
