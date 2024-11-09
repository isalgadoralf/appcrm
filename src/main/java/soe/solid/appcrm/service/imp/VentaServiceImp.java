package soe.solid.appcrm.service.imp;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soe.solid.appcrm.model.*;
import soe.solid.appcrm.repository.*;
import soe.solid.appcrm.service.spc.IVentaService;

import java.util.ArrayList;
import java.util.List;

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
        Cliente cliente;
        Almacen almacen;
        FormaPago formaPago;
        FormaEntrega formaEntrega;
        try {
            cliente = repoCliente.findById(venta.getCliente().getClienteId())
                    .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
            almacen = repoAlamacen.findById(venta.getAlmacen().getAlmacenId())
                    .orElseThrow(() -> new IllegalArgumentException("Almacén no encontrado"));
            formaPago = repoFormaPago.findById(venta.getFormaPago().getFormaPagoId())
                    .orElseThrow(() -> new IllegalArgumentException("Forma de pago no encontrada"));
            formaEntrega = repoFormaEntrega.findById(venta.getFormaEntrega().getFormaEntregaId())
                    .orElseThrow(() -> new IllegalArgumentException("Forma de entrega no encontrada"));
        } catch (IllegalArgumentException e) {
            return new ResponseDto(1, e.getMessage());
        }
        // Asignar los valores correctos a la venta y guardar la venta
        venta.setCliente(cliente);
        venta.setAlmacen(almacen);
        venta.setFormaPago(formaPago);
        venta.setFormaEntrega(formaEntrega);
        repoVenta.save(venta);  // Guardar la venta

       // registrarDetalle(venta);  // Registrar los detalles de la venta

        return new ResponseDto(0,"Venta registrada correctamente");
    }

    /*private void registrarDetalle(Venta venta) {
        for (VentaDetalle detalle : venta.getLista()) {
            Producto producto = repoProducto.findById(detalle.getProductoId())
                    .orElse(new Producto());
            detalle.setProducto(producto);
            detalle.setVenta(venta);
            repoDetalleVenta.save(detalle);
          }
    }*/

    public List<Venta> listarVentas() {
        return repoVenta.findAll();
    }
}

