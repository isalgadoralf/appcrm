package soe.solid.appcrm.service.spc;

import soe.solid.appcrm.model.GrupoProducto;

import java.util.List;

public interface IGrupoProducto {
    GrupoProducto registrar(GrupoProducto producto) throws Exception;
    GrupoProducto obtenerPorId(Integer id) throws Exception;
    List<GrupoProducto> listarTodos() throws Exception;
}
