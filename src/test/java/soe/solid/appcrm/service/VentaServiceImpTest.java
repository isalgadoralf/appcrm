package soe.solid.appcrm.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import soe.solid.appcrm.model.*;
import soe.solid.appcrm.repository.*;
import soe.solid.appcrm.service.imp.VentaServiceImp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VentaServiceImpTest {
    @InjectMocks
    VentaServiceImp ventaServiceImp;

    @Mock
    IFormaEntregaRepo iFormaEntregaRepo;
    @Mock
    IFormaPagoRepo iFormaPagoRepo;
    @Mock
    IAlmacenRepo iAlmacenRepo;
    @Mock
    IClienteRepo iClienteRepo;
    @Mock
    IVentaRepo ventaRepo;
    @Mock
    IProductoRepo repoProducto;
    @Mock
    IVentaDetalleRepo repoDetalleVenta;

    @Test
    void testSave() {

        Cliente cliente = new Cliente();
        cliente.setClienteId(1);
        when(iClienteRepo.findById(1)).thenReturn(Optional.of(cliente));

        Almacen almacen = new Almacen();
        almacen.setAlmacenId(1);
        when(iAlmacenRepo.findById(1)).thenReturn(Optional.of(almacen));

        FormaPago formaPago = new FormaPago();
        formaPago.setFormaPagoId(1);
        when(iFormaPagoRepo.findById(1)).thenReturn(Optional.of(formaPago));

        FormaEntrega formaEntrega = new FormaEntrega();
        formaEntrega.setFormaEntregaId(1);
        when(iFormaEntregaRepo.findById(1)).thenReturn(Optional.of(formaEntrega));


        Venta venta = new Venta();
        venta.setVentaId(1);
        venta.setFechaVenta(new Date());
        venta.setTotal(100.0);
       // venta.setEstado("Pendiente");
        venta.setCliente(cliente);
        venta.setAlmacen(almacen);
        venta.setFormaPago(formaPago);
        venta.setFormaEntrega(formaEntrega);

        List<VentaDetalle> lista = new ArrayList<>();
        VentaDetalle detalle = new VentaDetalle();
        detalle.setProductoId(2);
        detalle.setCantidad(1);
        detalle.setImporte(100.0);
        lista.add(detalle);
        //venta.setLista(lista);


        // Llamada al método a probar
        ResponseDto response = ventaServiceImp.registrar(venta);
//
//        verify(iClienteRepo).findById(1);
//        verify(iAlmacenRepo).findById(1);
//        verify(iFormaPagoRepo).findById(1);
//        verify(iFormaEntregaRepo).findById(1);

        assertNotNull(response);
        assertEquals(0, response.getCodigo());

        //assert("Pendiente".equals(venta.getEstado()));
        assertNotNull(venta.getFechaVenta());
        assertEquals(100.0, venta.getTotal());

    }


}
