package soe.solid.appcrm.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soe.solid.appcrm.model.Producto;
import soe.solid.appcrm.repository.IProductoRepo;
import soe.solid.appcrm.service.spc.IProductoService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductoServiceImp implements IProductoService {

    private final IProductoRepo productoRepo;
    @Override
    public Producto registrar(Producto producto) throws Exception {
         productoRepo.save(producto);
         return producto;
    }

    @Override
    public Producto obtenerPorId(Integer id) throws Exception {
        return productoRepo.findById(id).orElse(new Producto());
    }

    @Override
    public List<Producto> listarTodos() throws Exception {
        return productoRepo.findAll();
    }
}
