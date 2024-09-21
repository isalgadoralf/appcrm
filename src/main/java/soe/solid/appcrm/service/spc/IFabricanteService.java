package soe.solid.appcrm.service.spc;

import soe.solid.appcrm.model.Fabricante;

import java.util.List;

public interface IFabricanteService {
    Fabricante registrar(Fabricante producto) throws Exception;
    Fabricante obtenerPorId(Integer id) throws Exception;
    List<Fabricante> listarTodos() throws Exception;
}
