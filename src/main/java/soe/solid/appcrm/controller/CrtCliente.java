package soe.solid.appcrm.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soe.solid.appcrm.model.Cliente;
import soe.solid.appcrm.model.Fabricante;
import soe.solid.appcrm.model.ResponseDto;
import soe.solid.appcrm.model.Venta;
import soe.solid.appcrm.service.spc.IClienteService;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class CrtCliente {

    private final IClienteService clienteService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDto> save(@RequestBody Cliente venta) {
        return new ResponseEntity<>(clienteService.registrar(venta), HttpStatus.OK);
    }
    @GetMapping
    public List<Cliente> listAll() throws Exception {
        return clienteService.listarTodos();

    }
}
