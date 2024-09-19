package soe.solid.appcrm.service;

import soe.solid.appcrm.model.Producto;

import java.util.List;

public interface IProductoService {
    Producto registrarProducto(Producto producto) throws Exception;
    Producto obtenerProductoPorId(Integer id) throws Exception;
    List<Producto> listarProductos() throws Exception;
}
