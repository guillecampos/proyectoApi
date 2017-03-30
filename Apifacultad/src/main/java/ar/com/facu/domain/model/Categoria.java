/**
 * 
 */
package ar.com.facu.domain.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author guille campos
 *
*/

@Entity
@Table(name = "categoria")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Categoria implements Serializable {

	private static final long serialVersionUID = -3237177991770623968L;

		@Id
	    @GeneratedValue
	    @Column(name = "idcategoria")
	    private long id;

	    @Column(name = "nombre")
	    private String nombre;

	    @Column(name = "estado")
	    private Integer estado;
	    
	    @Column(name = "idparent")
	    private Integer idparent;

	    
	    @Column(name = "nombreamigable")
	    private String nombreamigable;


		public long getId() {
			return id;
		}
		
		public void setId(long id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public Integer getEstado() {
			return estado;
		}

		public void setEstado(Integer estado) {
			this.estado = estado;
		}

		public Integer getIdparent() {
			return idparent;
		}

		public void setIdparent(Integer idparent) {
			this.idparent = idparent;
		}

		public String getNombreamigable() {
			return nombreamigable;
		}

		public void setNombreamigable(String nombreamigable) {
			this.nombreamigable = nombreamigable;
		}
	    	    
	   	    	 	  
}
