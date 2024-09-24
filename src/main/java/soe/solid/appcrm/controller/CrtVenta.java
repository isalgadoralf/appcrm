package soe.solid.appcrm.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import soe.solid.appcrm.model.ResponseDto;
import soe.solid.appcrm.model.Venta;
import soe.solid.appcrm.service.spc.IVentaService;

@RestController
@RequestMapping("/venta")
@RequiredArgsConstructor
public class CrtVenta {

    private final IVentaService ventaService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDto> save(@RequestBody Venta venta) {
        return new ResponseEntity<>(ventaService.registrar(venta), HttpStatus.OK);
    }
}
