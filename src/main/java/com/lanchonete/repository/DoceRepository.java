package com.lanchonete.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lanchonete.model.Doce;

@Repository
public interface DoceRepository extends JpaRepository<Doce, Long>{

}
