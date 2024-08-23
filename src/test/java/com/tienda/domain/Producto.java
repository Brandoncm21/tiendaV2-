package com.tienda.domain;

import jakarta.persistence.Id;
import jakarta.persistence.*;  // 
import java.io.Serializable;
import lombok.Data;

@Data //capa de datos
@Entity // entiddad enlazada con (tabla de la basa)
@Table(name = "producto") // especifica la identidad
/**
 *
 * @author malum
 */
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L; //autoincremento
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;
    private String descripcion;
    private String detalle;
    private int existencias;
    private double precio;
    private String rutaImagen;
    private boolean activo;

    //private Long idCategoria;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    public Producto() {
        // Constructor predeterminado
    }

    public Producto(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }

}
