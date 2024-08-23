package com.tienda.domain;

import jakarta.persistence.Id;
import jakarta.persistence.*;  // 
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data //capa de datos
@Entity // entiddad enlazada con (tabla de la basa)
@Table(name = "categoria") // especifica la identidad
/**
 *
 * @author malum
 */
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L; //autoincremento
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;
    
    
    @OneToMany
    @JoinColumn(name = "id_categoria", updatable=false)
    List<Producto> productos;

    public Categoria() {
        // Constructor predeterminado
    }

    public Categoria(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }

}
