package soe.solid.appcrm.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soe.solid.appcrm.model.Fabricante;
import soe.solid.appcrm.model.Proveedor;
import soe.solid.appcrm.repository.IFabricanteRepo;
import soe.solid.appcrm.repository.IProductoRepo;
import soe.solid.appcrm.repository.IProveedorRepo;
import soe.solid.appcrm.service.spc.IFabricanteService;
import soe.solid.appcrm.service.spc.IProveedorService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProveedorServiceImp implements IProveedorService {

    private final IProveedorRepo repo;
    @Override
    public Proveedor registrar(Proveedor producto) throws Exception {
        repo.save(producto);
         return producto;
    }

    @Override
    public Proveedor obtenerPorId(Integer id) throws Exception {
        return repo.findById(id).orElse(new Proveedor());
    }

    @Override
    public List<Proveedor> listarTodos() throws Exception {
        return repo.findAll();
    }
}
