package soe.solid.appcrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soe.solid.appcrm.model.Almacen;
import soe.solid.appcrm.model.Cliente;

public interface IAlmacenRepo extends JpaRepository<Almacen, Integer> {
}
