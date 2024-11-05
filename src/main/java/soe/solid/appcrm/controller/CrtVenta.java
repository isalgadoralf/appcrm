package soe.solid.appcrm.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soe.solid.appcrm.model.Fabricante;
import soe.solid.appcrm.model.ResponseDto;
import soe.solid.appcrm.model.Venta;
import soe.solid.appcrm.service.spc.IVentaService;

import java.util.List;

@RestController
@RequestMapping("/venta")
@RequiredArgsConstructor
public class CrtVenta {

    private final IVentaService ventaService;
    @GetMapping
    public ResponseEntity<String> listAll()  {
        return new ResponseEntity<>("Servicio de VENTA...", HttpStatus.OK);

    }
    @PostMapping("/save")
    public ResponseEntity<ResponseDto> save(@RequestBody Venta venta) {
        return new ResponseEntity<>(ventaService.registrar(venta), HttpStatus.OK);
    }
}
