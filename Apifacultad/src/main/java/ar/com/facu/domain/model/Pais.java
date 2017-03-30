package ar.com.facu.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import ar.com.facu.domain.model.base.BussinessObject;
@Entity
@Table(name = "T_PAIS")
public class Pais extends BussinessObject {

	private static final long serialVersionUID = 1L;
	
	
	@Column(name = "a_nombre")
	private String nombre;
	
	@Column(name = "f_geo_location_id")
	private Integer geoLocation;
		


	public Integer getGeoLocation() {
		return geoLocation;
	}

	public void setGeoLocation(Integer geoLocation) {
		this.geoLocation = geoLocation;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



		
}
