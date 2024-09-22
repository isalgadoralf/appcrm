package soe.solid.appcrm.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soe.solid.appcrm.model.Fabricante;
import soe.solid.appcrm.model.Producto;
import soe.solid.appcrm.service.spc.IFabricanteService;
import soe.solid.appcrm.service.spc.IProductoService;

import java.util.List;

@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor
public class CtrProducto {

    private final IProductoService productoService;
    private final IFabricanteService fabricanteService;

    @GetMapping
    public List<Producto> listarProductos() throws Exception {
        return productoService.listarTodos();

    }
    @GetMapping("/{id}")
    public Producto readById(@PathVariable("id") Integer id   ) throws Exception {
        return productoService.obtenerPorId(id);

    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody  Producto producto   ) throws Exception {
        if (producto.getFabricante() != null) {
            Fabricante categoria = fabricanteService.obtenerPorId(producto.getFabricante().getFabricanteId());
            if (categoria != null) {
                producto.setFabricante(categoria);
            } else {
                return ResponseEntity.badRequest().body("Fabricante no  valido");
            }
        }
        Producto productoGuardado = productoService.registrar(producto);
        return ResponseEntity.ok(productoGuardado);

    }
}
