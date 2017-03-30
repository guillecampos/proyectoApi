package ar.com.facu.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.facu.domain.dao.EmprendedorDao;
import ar.com.facu.domain.model.Emprendedor;


@Service
public class  EmprendedorService {
		
	private final EmprendedorDao emprendedorDAO;
	
	@Autowired
	public EmprendedorService(EmprendedorDao emprendedorDAO) {
		this.emprendedorDAO = emprendedorDAO;
	}
	
	public List<Emprendedor> getListEmprendedores() throws Exception {
		return emprendedorDAO.find();				
	}	
}
