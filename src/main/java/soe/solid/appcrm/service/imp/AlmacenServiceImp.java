package soe.solid.appcrm.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soe.solid.appcrm.model.Almacen;
import soe.solid.appcrm.repository.IAlmacenRepo;
import soe.solid.appcrm.repository.IClienteRepo;
import soe.solid.appcrm.service.spc.IAlmacenService;
import soe.solid.appcrm.service.spc.IClienteService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlmacenServiceImp implements IAlmacenService {

    private final IAlmacenRepo repo;
    @Override
    public Almacen registrar(Almacen producto) throws Exception {
        repo.save(producto);
         return producto;
    }

    @Override
    public Almacen obtenerPorId(Integer id) throws Exception {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Almacen> listarTodos() throws Exception {
        return repo.findAll();
    }
}
