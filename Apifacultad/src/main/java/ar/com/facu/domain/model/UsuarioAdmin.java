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
@Table(name = "UsuarioAdmin")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UsuarioAdmin implements Serializable {
	
	    /**
	 * 
	 */
	private static final long serialVersionUID = 5725606829430212240L;

		@Id
	    @GeneratedValue
	    @Column(name = "id")
	    private long id;

	    @Column(name = "nombre")
	    private String nombre;

	    @Column(name = "mail")
	    private String mail;

	    @Column(name = "pass")
	    private String pass;
	    
	    
	    @Column(name = "telefono")
	    private String telefono;
	    
	    @Column(name = "estado")
	    private Integer estado;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getNombre() {
			return this.nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getMail() {
			return this.mail;
		}

		public void setMail(String mail) {
			this.mail = mail;
		}

		public String getPass() {
			return this.pass;
		}

		public void setPass(String pass) {
			this.pass = pass;
		}

		public String getTelefono() {
			return this.telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public Integer getEstado() {
			return this.estado;
		}

		public void setEstado(Integer estado) {
			this.estado = estado;
		}
	    
	     
	
}
