package soe.solid.appcrm.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Producto {
    private String cSku;
    private String cNombre;
    private String cNombreExtranjero;
    private String cCodGrupoProducto;
    private String cNombreGrupoProducto;
    private String cSkuFabricante;
    private String cNmbFabricante;
    private String cNmbProveedor;
    private double nPeso;
    private String cUM;
    private double nPrecioLista;
    private String cCodBarra;
    private String cSkuAlternante;
}
