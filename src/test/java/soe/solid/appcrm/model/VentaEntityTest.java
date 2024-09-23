package soe.solid.appcrm.model;

import org.junit.jupiter.api.Test;

import java.util.Date;

public class VentaEntityTest {

    @Test
    void testEquals() {
        Venta venta1 = new Venta();
        venta1.setVentaId(1);
        Cliente cliente = new Cliente();
        cliente.setClienteId(1);
        venta1.setCliente(cliente);
        FormaEntrega formaEntrega = new FormaEntrega();
        formaEntrega.setFormaEntregaId(1);
        FormaPago formaPago = new FormaPago();
        formaPago.setFormaPagoId(1);
        Almacen almacen = new Almacen();
        almacen.setAlmacenId(1);
        venta1.setFormaEntrega(formaEntrega);
        venta1.setFormaPago(formaPago);
        venta1.setAlmacen(almacen);
        venta1.setFechaVenta(new Date());
        venta1.setTotal(100.0);
        venta1.setEstado("Pendiente");
        venta1.setObservaciones("Observaciones");
        Venta venta2 = new Venta();
        venta2.setVentaId(1);
        assert(venta1.equals(venta2));
    }
}
