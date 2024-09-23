package soe.solid.appcrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soe.solid.appcrm.model.Almacen;
import soe.solid.appcrm.model.Venta;

public interface IVentaRepo extends JpaRepository<Venta, Integer> {
}
