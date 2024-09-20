package soe.solid.appcrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soe.solid.appcrm.model.Fabricante;
import soe.solid.appcrm.model.Producto;

public interface IFabricanteRepo extends JpaRepository<Fabricante, Integer> {
}
