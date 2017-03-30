package ar.com.facu.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.facu.domain.dao.PaisDAO;
import ar.com.facu.domain.model.Pais;



@Service
public class  PaisService {
		
	private final PaisDAO paisDAO;
	
	@Autowired
	public PaisService(PaisDAO paisDAO) {
		this.paisDAO = paisDAO;
	}

	public List<Pais> getAll() {
		return paisDAO.find();		
	}
	
	public Pais getPaisById(Long paisId) {			
		return paisDAO.getById(paisId);
	}
}
