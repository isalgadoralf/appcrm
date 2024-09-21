package soe.solid.appcrm.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import soe.solid.appcrm.model.Fabricante;
import soe.solid.appcrm.service.spc.IFabricanteService;

import java.util.List;

@RestController
@RequestMapping("/fabricantes")
@RequiredArgsConstructor
public class CtrFabricante {

    private final IFabricanteService service;

    @GetMapping
    public List<Fabricante> listAll() throws Exception {
        return service.listarTodos();

    }
    @GetMapping("/{id}")
    public Fabricante readById(@PathVariable("id") Integer id   ) throws Exception {
        return service.obtenerPorId(id);

    }
    @PostMapping
    public Fabricante save(@RequestBody  Fabricante producto   ) throws Exception {
        return service.registrar(producto);

    }
}
