package com.lanchonete.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lanchonete.model.Salgado;

@Repository
public interface SalgadoRepository extends JpaRepository<Salgado, Long>{

}
