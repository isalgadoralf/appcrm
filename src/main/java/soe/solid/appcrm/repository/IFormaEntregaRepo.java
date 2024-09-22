package soe.solid.appcrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soe.solid.appcrm.model.FormaEntrega;
import soe.solid.appcrm.model.FormaPago;

public interface IFormaEntregaRepo extends JpaRepository<FormaEntrega, Integer> {
}
