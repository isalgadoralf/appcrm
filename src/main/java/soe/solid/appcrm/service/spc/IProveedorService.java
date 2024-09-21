package soe.solid.appcrm.service.spc;

import soe.solid.appcrm.model.Proveedor;

import java.util.List;

public interface IProveedorService {
    Proveedor registrar(Proveedor producto) throws Exception;
    Proveedor obtenerPorId(Integer id) throws Exception;
    List<Proveedor> listarTodos() throws Exception;
}
