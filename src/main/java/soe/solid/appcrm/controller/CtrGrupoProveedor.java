package soe.solid.appcrm.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import soe.solid.appcrm.model.GrupoProducto;
import soe.solid.appcrm.service.spc.IGrupoProducto;

import java.util.List;

@RestController
@RequestMapping("/grupo-proveedores")
@RequiredArgsConstructor
public class CtrGrupoProveedor {

    private final IGrupoProducto service;

    @GetMapping
    public List<GrupoProducto> listAll() throws Exception {
        return service.listarTodos();

    }
    @GetMapping("/{id}")
    public GrupoProducto readById(@PathVariable("id") Integer id   ) throws Exception {
        return service.obtenerPorId(id);

    }
    @PostMapping
    public GrupoProducto save(@RequestBody  GrupoProducto producto   ) throws Exception {
        return service.registrar(producto);

    }
}
