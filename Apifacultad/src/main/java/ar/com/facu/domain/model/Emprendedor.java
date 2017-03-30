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
@Table(name = "Emprendedor")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Emprendedor implements Serializable {


		/**
	 * 
	 */
	private static final long serialVersionUID = -3237177991770623968L;

		@Id
	    @GeneratedValue
	    @Column(name = "idEmprendedor")
	    private long id;

	    @Column(name = "nombre")
	    private String nombre;

	    @Column(name = "apellido")
	    private String apellido;

	    @Column(name = "email")
	    private String email;
	    	    	   
	    @Column(name = "descripcion")
	    private String descripcion;

	    @Column(name = "calle")
	    private String calle;

	    @Column(name = "numero")
	    private String numero;
	    	    	    	   
	    @Column(name = "piso")
	    private String piso;
	    
	    @Column(name = "dpto")
	    private String dpto;
	    	    
	    @Column(name = "idUbicacion")
	    private Integer idUbicacion;
	    	    
	    @Column(name = "calleLocal")
	    private String calleLocal;
	    	    
	    @Column(name = "numeroLocal")
	    private Integer numeroLocal;
	    	    
	    @Column(name = "idUbicacionLocal")
	    private Integer idUbicacionLocal;
	    	    
	    @Column(name = "url")
	    private String url;

	    @Column(name = "lat")
	    private String lat;
	    	    	    	   
	    @Column(name = "long")
	    private String longitud;
	    
	    @Column(name = "urlLocal")
	    private String urlLocal;
	    	    
	    @Column(name = "latLocal")
	    private String latLocal;

	    @Column(name = "longLocal")
	    private String longLocal;
	    	    	    	   
	    @Column(name = "telefono")
	    private String telefono;
	    
	    @Column(name = "horario")
	    private String horario;

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

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public String getCalle() {
			return calle;
		}

		public void setCalle(String calle) {
			this.calle = calle;
		}

		public String getNumero() {
			return numero;
		}

		public void setNumero(String numero) {
			this.numero = numero;
		}

		public String getPiso() {
			return piso;
		}

		public void setPiso(String piso) {
			this.piso = piso;
		}

		public String getDpto() {
			return dpto;
		}

		public void setDpto(String dpto) {
			this.dpto = dpto;
		}

		public Integer getIdUbicacion() {
			return idUbicacion;
		}

		public void setIdUbicacion(Integer idUbicacion) {
			this.idUbicacion = idUbicacion;
		}

		public String getCalleLocal() {
			return calleLocal;
		}

		public void setCalleLocal(String calleLocal) {
			this.calleLocal = calleLocal;
		}

		public Integer getNumeroLocal() {
			return numeroLocal;
		}

		public void setNumeroLocal(Integer numeroLocal) {
			this.numeroLocal = numeroLocal;
		}

		public Integer getIdUbicacionLocal() {
			return idUbicacionLocal;
		}

		public void setIdUbicacionLocal(Integer idUbicacionLocal) {
			this.idUbicacionLocal = idUbicacionLocal;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getLat() {
			return lat;
		}

		public void setLat(String lat) {
			this.lat = lat;
		}

		public String getLongitud() {
			return longitud;
		}

		public void setLongitud(String longitud) {
			this.longitud = longitud;
		}

		public String getUrlLocal() {
			return urlLocal;
		}

		public void setUrlLocal(String urlLocal) {
			this.urlLocal = urlLocal;
		}

		public String getLatLocal() {
			return latLocal;
		}

		public void setLatLocal(String latLocal) {
			this.latLocal = latLocal;
		}

		public String getLongLocal() {
			return longLocal;
		}

		public void setLongLocal(String longLocal) {
			this.longLocal = longLocal;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public String getHorario() {
			return horario;
		}

		public void setHorario(String horario) {
			this.horario = horario;
		}
	    
	    
	    
	  	
}
