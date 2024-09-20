package soe.solid.appcrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soe.solid.appcrm.model.GrupoProducto;
import soe.solid.appcrm.model.Proveedor;

public interface IGrupoProductoRepo extends JpaRepository<GrupoProducto, Integer> {
}
