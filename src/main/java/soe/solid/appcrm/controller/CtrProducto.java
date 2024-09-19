package soe.solid.appcrm.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import soe.solid.appcrm.model.Producto;
import soe.solid.appcrm.service.IProductoService;

import java.util.List;

@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor
public class CtrProducto {

    private final IProductoService productoService;

    @GetMapping
    public List<Producto> listarProductos() throws Exception {
        return productoService.listarProductos();

    }
    @GetMapping("/{id}")
    public Producto readById(@PathVariable("id") Integer id   ) throws Exception {
        return productoService.obtenerProductoPorId(id);

    }
    @PostMapping
    public Producto save(@RequestBody  Producto producto   ) throws Exception {
        return productoService.registrarProducto(producto);

    }
}
