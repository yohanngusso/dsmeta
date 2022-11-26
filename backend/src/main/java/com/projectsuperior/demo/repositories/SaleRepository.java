package com.projectsuperior.demo.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projectsuperior.demo.entities.Sale;

// Componente do sistema responsavel por acessar o banco de dados : salvar,atualizar,deletar,buscar
public interface SaleRepository extends JpaRepository<Sale, Long> {

	//função que recebe duas datas como argumento(min e max) -> SaleService( linha 31)
	//linguagem JPQL -> Parecido com SQL, só que é adaptado para o JPA
	// Seleciona todos os objeteos(obj) do tipo SALE obj(venda) onde a data do objeto esteja entre min e max(parametros da função)
	// ORDER BY: ordenar o resultado por o valor da venda(amount) DESC(decrescente)
	// Ou seja, vou buscar as 20 primeiras maiores vendas daquele intervalo de tempo
	// Relatório das 20 melhores vendas no intervalo de data que eu precisar 
	@Query("SELECT obj FROM Sale obj WHERE obj.date BETWEEN :min AND :max ORDER BY obj.amount DESC")
	Page<Sale> findSales(LocalDate min, LocalDate max, Pageable pageable);
}
