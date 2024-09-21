package soe.solid.appcrm.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soe.solid.appcrm.model.Fabricante;
import soe.solid.appcrm.model.GrupoProducto;
import soe.solid.appcrm.repository.IFabricanteRepo;
import soe.solid.appcrm.repository.IGrupoProductoRepo;
import soe.solid.appcrm.service.spc.IFabricanteService;
import soe.solid.appcrm.service.spc.IGrupoProducto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GrupoProductoServiceImp implements IGrupoProducto {

    private final IGrupoProductoRepo repo;
    @Override
    public GrupoProducto registrar(GrupoProducto producto) throws Exception {
        repo.save(producto);
         return producto;
    }

    @Override
    public GrupoProducto obtenerPorId(Integer id) throws Exception {
        return repo.findById(id).orElse(new GrupoProducto());
    }

    @Override
    public List<GrupoProducto> listarTodos() throws Exception {
        return repo.findAll();
    }
}
