package com.projectsuperior.demo.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.projectsuperior.demo.entities.Sale;
import com.projectsuperior.demo.repositories.SaleRepository;

// componente responsavel por fazer operações de negocios com vendas 
// operação que busque no banco de dados as vendas 


@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	//pageble para paginar em 20 elementos limitando 
	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {
		
		//Criando uma data do dia de hoje 
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		/*
		//convertendo as datas que estão em texto para dados(tipo = localdate)
		LocalDate min = LocalDate.parse(minDate); // convertendo a data de texto para localdate
		LocalDate max = LocalDate.parse(maxDate);
		 */
		
		//criando função para caso não informe nenhuma data
		// Nesse caso o min vai ser de 1 ano atrás e o máximo hoje com o LocalDate today
		LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
		// minusDays subtrai 365, ou seja, pega o dia atual e volta 1 ano atrás
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
		//essa expressão se chama: expressão condicional ternaria 
		// condição para ser testada => maxDate.equals("") // podendo ser true or false
		// o que for colocado na frente da "?" vai ser o valor caso true, "today" 
		// caso contrario ":" vai ser o valor caso false, "LocalDate.parse(maxDate)"
		// Ou seja, maxDate é igual a String vazio(""), se for eu não tenho uma data
		// para converter, logo pega a data atual do sistema do usuario
		// caso contrario ai sim vai converter 
		
		
		return repository.findSales(min, max, pageable);
	}
}
