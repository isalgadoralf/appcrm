package soe.solid.appcrm.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soe.solid.appcrm.model.GrupoCliente;
import soe.solid.appcrm.repository.IFormaPagoRepo;
import soe.solid.appcrm.repository.IGrupoClienteRepo;
import soe.solid.appcrm.service.spc.IFormaPagoService;
import soe.solid.appcrm.service.spc.IGrupoClienteService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GrupoClienteServiceImp implements IGrupoClienteService {

    private final IGrupoClienteRepo repo;
    @Override
    public GrupoCliente registrar(GrupoCliente producto) throws Exception {
        repo.save(producto);
         return producto;
    }

    @Override
    public GrupoCliente obtenerPorId(Integer id) throws Exception {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<GrupoCliente> listarTodos() throws Exception {
        return repo.findAll();
    }
}
