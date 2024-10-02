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
        ResponseDto responseDto = clienteService.registrar(venta);
        if (responseDto.getCodigo() == 0) {
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping
    public List<Cliente> listAll() throws Exception {
        return clienteService.listarTodos();

    }
}
