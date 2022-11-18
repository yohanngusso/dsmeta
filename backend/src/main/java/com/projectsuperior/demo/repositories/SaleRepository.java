package com.projectsuperior.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectsuperior.demo.entities.Sale;

// Componente do sistema responsavel por acessar o banco de dados : salvar,atualizar,deletar,buscar
public interface SaleRepository extends JpaRepository<Sale, Long> {

}
