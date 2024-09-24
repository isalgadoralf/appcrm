package soe.solid.appcrm.service.imp;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soe.solid.appcrm.model.*;
import soe.solid.appcrm.repository.*;
import soe.solid.appcrm.service.spc.IVentaService;

@Service
@RequiredArgsConstructor
public class VentaServiceImp implements IVentaService {

    private final IVentaRepo repoVenta;
    private final IClienteRepo repoCliente;
    private final IAlmacenRepo repoAlamacen;
    private final IFormaEntregaRepo repoFormaEntrega;
    private final IFormaPagoRepo repoFormaPago;



    @Override
    public ResponseDto registrar(Venta venta)  {
        Cliente cliente = repoCliente.findById(venta.getCliente().getClienteId())
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
        Almacen almacen = repoAlamacen.findById(venta.getAlmacen().getAlmacenId())
                .orElseThrow(() -> new IllegalArgumentException("Almacén no encontrado"));
        FormaPago formaPago = repoFormaPago.findById(venta.getFormaPago().getFormaPagoId())
                .orElseThrow(() -> new IllegalArgumentException("Forma de pago no encontrada"));
        FormaEntrega formaEntrega = repoFormaEntrega.findById(venta.getFormaEntrega().getFormaEntregaId())
                .orElseThrow(() -> new IllegalArgumentException("Forma de entrega no encontrada"));

        // Asignar los valores correctos a la venta y guardar la venta
        venta.setCliente(cliente);
        venta.setAlmacen(almacen);
        venta.setFormaPago(formaPago);
        venta.setFormaEntrega(formaEntrega);

        repoVenta.save(venta);  // Guardar la venta
        return new ResponseDto(0,"Venta registrada correctamente");
    }
}
