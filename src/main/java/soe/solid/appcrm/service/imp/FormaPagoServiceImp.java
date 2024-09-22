package soe.solid.appcrm.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soe.solid.appcrm.model.FormaPago;
import soe.solid.appcrm.repository.IFabricanteRepo;
import soe.solid.appcrm.repository.IFormaPagoRepo;
import soe.solid.appcrm.service.spc.IFabricanteService;
import soe.solid.appcrm.service.spc.IFormaPagoService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FormaPagoServiceImp implements IFormaPagoService {

    private final IFormaPagoRepo repo;
    @Override
    public FormaPago registrar(FormaPago producto) throws Exception {
        repo.save(producto);
         return producto;
    }

    @Override
    public FormaPago obtenerPorId(Integer id) throws Exception {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<FormaPago> listarTodos() throws Exception {
        return repo.findAll();
    }
}
