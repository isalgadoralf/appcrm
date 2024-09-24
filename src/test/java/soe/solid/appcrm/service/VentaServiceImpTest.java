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

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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

    @Test
    void testSave() {

        Cliente cliente = new Cliente();
        cliente.setClienteId(1);
        when(iClienteRepo.findById(1)).thenReturn(java.util.Optional.of(cliente));

        Almacen almacen = new Almacen();
        almacen.setAlmacenId(1);
        when(iAlmacenRepo.findById(1)).thenReturn(java.util.Optional.of(almacen));

        FormaPago formaPago = new FormaPago();
        formaPago.setFormaPagoId(1);
        when(iFormaPagoRepo.findById(1)).thenReturn(java.util.Optional.of(formaPago));

        FormaEntrega formaEntrega = new FormaEntrega();
        formaEntrega.setFormaEntregaId(1);
        when(iFormaEntregaRepo.findById(1)).thenReturn(java.util.Optional.of(formaEntrega));


        Venta venta = new Venta();
        venta.setVentaId(1);
        venta.setFechaVenta(new Date());
        venta.setTotal(100.0);
        venta.setEstado("Pendiente");
        venta.setCliente(cliente);
        venta.setAlmacen(almacen);
        venta.setFormaPago(formaPago);
        venta.setFormaEntrega(formaEntrega);

        // Llamada al método a probar
        ResponseDto response = ventaServiceImp.registrar(venta);
//        when(ventaRepo.save(venta)).thenReturn(venta);
        //when(ventaServiceImp.registrar(venta)).thenReturn(responseDto);

        //ventaServiceImp.registrar(venta);

        verify(iClienteRepo).findById(1);
        verify(iAlmacenRepo).findById(1);
        verify(iFormaPagoRepo).findById(1);
        verify(iFormaEntregaRepo).findById(1);

        assertNotNull(response);
        assertEquals(0, response.getCodigo());
        //ssertEquals("Venta registrada correctamente", response.getMensaje(


        // Opcionalmente, verificar el estado de la venta o cualquier otra lógica de negocio.
        assert("Pendiente".equals(venta.getEstado()));
        assertNotNull(venta.getFechaVenta());
        assertEquals(100.0, venta.getTotal());

    }

}
