package soe.solid.appcrm.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soe.solid.appcrm.model.FormaEntrega;
import soe.solid.appcrm.repository.IFormaEntregaRepo;
import soe.solid.appcrm.repository.IFormaPagoRepo;
import soe.solid.appcrm.service.spc.IFormaEntregaService;
import soe.solid.appcrm.service.spc.IFormaPagoService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FormaEntregaServiceImp implements IFormaEntregaService {

    private final IFormaEntregaRepo repo;
    @Override
    public FormaEntrega registrar(FormaEntrega producto) throws Exception {
        repo.save(producto);
         return producto;
    }

    @Override
    public FormaEntrega obtenerPorId(Integer id) throws Exception {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<FormaEntrega> listarTodos() throws Exception {
        return repo.findAll();
    }
}
