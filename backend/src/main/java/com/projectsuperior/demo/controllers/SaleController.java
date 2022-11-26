package com.projectsuperior.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projectsuperior.demo.entities.Sale;
import com.projectsuperior.demo.services.SaleService;
import com.projectsuperior.demo.services.SmsService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@Autowired
	private SmsService smsService;  
	
	@GetMapping
	//pageble para paginar em 20 elementos limitando 
	// String minDate e maxDate como string, pois estamos no controlador e vamos receber os dados como texto. Na web os dados trafegam como texto depois converte para dado
	public Page<Sale> findSales(
			@RequestParam(value = "minDate", defaultValue = "") String minDate, 
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate, 
			Pageable pageable) {
		return service.findSales(minDate, maxDate, pageable);
	}
	
	@GetMapping("/{id}/notification")
	
	public void notify_sms(@PathVariable Long id) {
		smsService.sendSms(id);
	}
	
}
