package soe.solid.appcrm.model;


import org.junit.jupiter.api.Test;

public class VentaDetalleEntityTest {
    @Test
    void testEquals() {
        VentaDetalle ventaDetalle1 = new VentaDetalle();
        ventaDetalle1.setVentaDetalleId(1);
        Venta venta = new Venta();
        venta.setVentaId(1);
        ventaDetalle1.setVenta(venta);
        Producto producto = new Producto();
        producto.setProductoId(1);
        ventaDetalle1.setProducto(producto);
        ventaDetalle1.setCantidad(1);
        ventaDetalle1.setPrecio(100.0);
        ventaDetalle1.setDescuento(100.0);
        VentaDetalle ventaDetalle2 = new VentaDetalle();
        ventaDetalle2.setVentaDetalleId(1);
        assert(ventaDetalle1.equals(ventaDetalle2));
    }
}
