package soe.solid.appcrm.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soe.solid.appcrm.model.Cliente;
import soe.solid.appcrm.repository.IClienteRepo;
import soe.solid.appcrm.repository.IFabricanteRepo;
import soe.solid.appcrm.service.spc.IClienteService;
import soe.solid.appcrm.service.spc.IFabricanteService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImp implements IClienteService {

    private final IClienteRepo repo;
    @Override
    public Cliente registrar(Cliente producto) throws Exception {
        repo.save(producto);
         return producto;
    }

    @Override
    public Cliente obtenerPorId(Integer id) throws Exception {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Cliente> listarTodos() throws Exception {
        return repo.findAll();
    }
}
