package ar.com.facu.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Producto")
public class Producto  implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7575041649134224414L;

	@Id
    @GeneratedValue
    @Column(name = "idProducto")
    private long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "url")
    private String url;

    @Column(name = "idEmprendedor")
    private Integer idEmprendedor;
    
    @Column(name = "precio")
    private Double precio;
    
    @Column(name = "telefono")
    private String telefono;
        	    	    	  

}
