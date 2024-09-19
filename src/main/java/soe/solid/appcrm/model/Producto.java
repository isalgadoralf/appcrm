package soe.solid.appcrm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer productoId;
    private String sku;
    private String nombre;
    private String nombreExtranjero;
    private String codGrupoProducto;
    private String nombreGrupoProducto;
    private String skuFabricante;
    private String nmbFabricante;
    private String nmbProveedor;
    private double peso;
    private String um;
    private double precioLista;
    private String codBarra;
    private String skuAlternante;
}
