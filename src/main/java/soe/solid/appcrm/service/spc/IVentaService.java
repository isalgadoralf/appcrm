package soe.solid.appcrm.service.spc;

import soe.solid.appcrm.model.ResponseDto;
import soe.solid.appcrm.model.Venta;

public interface IVentaService {
    ResponseDto registrar(Venta venta) ;
}
