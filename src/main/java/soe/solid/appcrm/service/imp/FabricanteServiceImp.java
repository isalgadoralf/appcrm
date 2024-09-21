package soe.solid.appcrm.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soe.solid.appcrm.model.Fabricante;
import soe.solid.appcrm.model.Producto;
import soe.solid.appcrm.repository.IFabricanteRepo;
import soe.solid.appcrm.repository.IProductoRepo;
import soe.solid.appcrm.service.spc.IFabricanteService;
import soe.solid.appcrm.service.spc.IProductoService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FabricanteServiceImp implements IFabricanteService {

    private final IFabricanteRepo repo;
    @Override
    public Fabricante registrar(Fabricante producto) throws Exception {
        repo.save(producto);
         return producto;
    }

    @Override
    public Fabricante obtenerPorId(Integer id) throws Exception {
        return repo.findById(id).orElse(new Fabricante());
    }

    @Override
    public List<Fabricante> listarTodos() throws Exception {
        return repo.findAll();
    }
}
