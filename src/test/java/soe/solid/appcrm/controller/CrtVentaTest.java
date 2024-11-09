package soe.solid.appcrm.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import soe.solid.appcrm.model.ResponseDto;
import soe.solid.appcrm.model.Venta;
import soe.solid.appcrm.service.imp.VentaServiceImp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CrtVentaTest {
    @InjectMocks
    private CrtVenta crtVenta;

    @Mock
    private VentaServiceImp ventaServiceImp;

    @Test
    void testRegistrar() {
        Venta venta = new Venta();
        ResponseDto responseDto = new ResponseDto(0, "Venta registrada");
        when(ventaServiceImp.registrar(venta)).thenReturn(responseDto);

        ResponseEntity<ResponseDto> response = crtVenta.save(venta);
        ResponseDto bo = response.getBody();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(bo);
        assertEquals(responseDto,bo);
    }
    @Test
    void testListarVentas() {
        when(ventaServiceImp.listarVentas()).thenReturn(null);
        ResponseEntity<?> response = crtVenta.list();
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }
}
