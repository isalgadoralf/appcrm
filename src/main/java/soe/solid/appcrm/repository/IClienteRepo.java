package soe.solid.appcrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soe.solid.appcrm.model.Cliente;
import soe.solid.appcrm.model.Fabricante;

public interface IClienteRepo extends JpaRepository<Cliente, Integer> {
}
