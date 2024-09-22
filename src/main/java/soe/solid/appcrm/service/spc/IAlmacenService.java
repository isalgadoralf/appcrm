package soe.solid.appcrm.service.spc;

import soe.solid.appcrm.model.Almacen;

import java.util.List;

public interface IAlmacenService {
    Almacen registrar(Almacen producto) throws Exception;
    Almacen obtenerPorId(Integer id) throws Exception;
    List<Almacen> listarTodos() throws Exception;
}
