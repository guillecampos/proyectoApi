package ar.com.facu.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.facu.domain.dao.CategoriaDao;
import ar.com.facu.domain.model.Categoria;


@Service
public class  CategoriaService {
		
	private final CategoriaDao categoriaDao;
	
	@Autowired
	public CategoriaService(CategoriaDao categoriaDao) {
		this.categoriaDao = categoriaDao;
	}
	
	public List<Categoria> getLisCategorias() throws Exception {
		return categoriaDao.find();				
	}	
}
