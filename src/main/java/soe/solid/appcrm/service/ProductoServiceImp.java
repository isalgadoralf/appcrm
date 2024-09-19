package soe.solid.appcrm.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soe.solid.appcrm.model.Producto;
import soe.solid.appcrm.repository.IProductoRepo;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductoServiceImp implements IProductoService {

    private final IProductoRepo productoRepo;
    @Override
    public Producto registrarProducto(Producto producto) throws Exception {
         productoRepo.save(producto);
         return producto;
    }

    @Override
    public Producto obtenerProductoPorId(Integer id) throws Exception {
        return productoRepo.findById(id).orElse(new Producto());
    }

    @Override
    public List<Producto> listarProductos() throws Exception {
        return productoRepo.findAll();
    }
}
