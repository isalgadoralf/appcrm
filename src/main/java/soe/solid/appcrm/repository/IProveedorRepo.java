package soe.solid.appcrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soe.solid.appcrm.model.Fabricante;
import soe.solid.appcrm.model.Proveedor;

public interface IProveedorRepo extends JpaRepository<Proveedor, Integer> {
}
