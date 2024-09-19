package soe.solid.appcrm.service;

import soe.solid.appcrm.model.Producto;

import java.util.List;

public interface ProductoService {
    void registrarProducto(Producto producto);
    Producto obtenerProductoPorSku(String sku);
    List<Producto> listarProductos();
}
