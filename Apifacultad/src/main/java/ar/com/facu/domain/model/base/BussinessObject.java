package ar.com.facu.domain.model.base;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class BussinessObject implements Serializable {

   private static final long serialVersionUID = 1L;
	    
   @Id   
   @GeneratedValue
   @Column(name = "p_id")
   private Long id;
		            
		            
   public BussinessObject() {
	   super();
    }
    
    public BussinessObject(Long id) {
    	super();
    	this.id = id;
    }    	        	     
    public Long getId() {
    	return id;
    }
    
    public void setId(Long id) {
    	this.id = id;
    }	        
	    
}
