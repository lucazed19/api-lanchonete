package com.lanchonete.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lanchonete.model.Bebida;

@Repository
public interface BebidaRepository extends JpaRepository<Bebida, Long>{

}
