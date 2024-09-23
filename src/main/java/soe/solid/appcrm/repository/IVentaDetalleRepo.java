package soe.solid.appcrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soe.solid.appcrm.model.Venta;
import soe.solid.appcrm.model.VentaDetalle;

public interface IVentaDetalleRepo extends JpaRepository<VentaDetalle, Integer> {
}
