package soe.solid.appcrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soe.solid.appcrm.model.GrupoCliente;
import soe.solid.appcrm.model.GrupoProducto;

public interface IGrupoClienteRepo extends JpaRepository<GrupoCliente, Integer> {
}
