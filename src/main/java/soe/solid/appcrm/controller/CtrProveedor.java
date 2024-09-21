package soe.solid.appcrm.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import soe.solid.appcrm.model.Proveedor;
import soe.solid.appcrm.service.spc.IProveedorService;

import java.util.List;

@RestController
@RequestMapping("/proveedores")
@RequiredArgsConstructor
public class CtrProveedor {

    private final IProveedorService service;

    @GetMapping
    public List<Proveedor> listAll() throws Exception {
        return service.listarTodos();

    }
    @GetMapping("/{id}")
    public Proveedor readById(@PathVariable("id") Integer id   ) throws Exception {
        return service.obtenerPorId(id);

    }
    @PostMapping
    public Proveedor save(@RequestBody  Proveedor producto   ) throws Exception {
        return service.registrar(producto);

    }
}
