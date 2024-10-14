package soe.solid.appcrm.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer ventaId;
    private Date fechaVenta;
    private Double total;
    private Double descuentoGlobal;
    private String observaciones;
    //private Double recibeFactura;
    //private String estado;
    //private List<VentaDetalle> lista;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false, foreignKey = @ForeignKey(name = "FK_venta_cliente"))
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "almacen_id", nullable = false, foreignKey = @ForeignKey(name = "FK_venta_almacen"))
    private Almacen almacen;
    @ManyToOne
    @JoinColumn(name = "forma_pago_id", nullable = false, foreignKey = @ForeignKey(name = "FK_venta_forma_pago"))
    private FormaPago formaPago;
    @ManyToOne
    @JoinColumn(name = "forma_entrega_id", nullable = false, foreignKey = @ForeignKey(name = "FK_venta_forma_entrega"))
    private FormaEntrega formaEntrega;
    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false, foreignKey = @ForeignKey(name = "FK_venta_producto"))
    private Producto producto;

}
