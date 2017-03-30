package ar.com.facu.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.facu.domain.dao.ProductoDao;
import ar.com.facu.domain.model.Producto;


@Service
public class  ProductoService {
		
	private final ProductoDao productoDAO;
	
	@Autowired
	public ProductoService(ProductoDao productoDAO) {
		this.productoDAO = productoDAO;
	}
	
	public List<Producto> getListProductos() throws Exception {
		return productoDAO.find();				
	}	
}
