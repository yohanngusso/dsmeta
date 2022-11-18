package com.projectsuperior.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectsuperior.demo.entities.Sale;
import com.projectsuperior.demo.repositories.SaleRepository;

// componente responsavel por fazer operações de negocios com vendas 
// operação que busque no banco de dados as vendas 

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	public List<Sale> findSales() {
		return repository.findAll();
	}
}
