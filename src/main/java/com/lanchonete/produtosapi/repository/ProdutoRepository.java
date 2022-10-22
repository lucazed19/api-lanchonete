package com.lanchonete.produtosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lanchonete.produtosapi.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
}
