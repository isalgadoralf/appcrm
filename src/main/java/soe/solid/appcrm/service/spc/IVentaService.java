package soe.solid.appcrm.service.spc;

import soe.solid.appcrm.model.ResponseDto;
import soe.solid.appcrm.model.Venta;

import java.util.List;

public interface IVentaService {
    ResponseDto registrar(Venta venta) ;
    List<Venta> listarVentas() ;
}
