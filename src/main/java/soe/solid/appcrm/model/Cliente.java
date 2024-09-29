package soe.solid.appcrm.model;


import jakarta.persistence.*;
import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer clienteId;
    private String nombre;
    private String apellidos;
    private String numDocumento;
    private String tipoDocumento;
    private String codCliente;
    private String email;
    private String telefono;
    private String direccion;


    @ManyToOne
    @JoinColumn(name = "grupo_cliente_id", nullable = true, foreignKey = @ForeignKey(name = "FK_cliente_grupo_cliente"))
    private GrupoCliente grupoCliente;

}
