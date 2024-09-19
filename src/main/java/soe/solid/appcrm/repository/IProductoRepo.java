package soe.solid.appcrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soe.solid.appcrm.model.Producto;

public interface IProductoRepo extends JpaRepository<Producto, Integer> {
}
