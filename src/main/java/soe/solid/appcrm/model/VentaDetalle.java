package soe.solid.appcrm.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class VentaDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer ventaDetalleId;

    private Integer cantidad;
    private Double precio;
    private Double importe;
    private Double descuento;
    @ManyToOne
    @JoinColumn(name = "prodcuto_id", nullable = false, foreignKey = @ForeignKey(name = "FK_venta_detalle_producto"))
    private Producto producto;
    @ManyToOne
    @JoinColumn(name = "venta_id", nullable = false, foreignKey = @ForeignKey(name = "FK_venta_detalle_venta"))
    private Venta venta;
}
