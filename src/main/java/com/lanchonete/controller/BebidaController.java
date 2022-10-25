package com.lanchonete.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lanchonete.model.Bebida;
import com.lanchonete.repository.BebidaRepository;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/bebidas")
public class BebidaController {
	@Autowired BebidaRepository bebidaRepository;
	
	@GetMapping
	public List<Bebida> listBebida() {
		return bebidaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneBebida(@PathVariable(name="id")long id) {
		Optional<Bebida> bebidaOptional = bebidaRepository.findById(id);
		if (!bebidaOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bebida not found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(bebidaOptional.get());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Bebida addBebida(@RequestBody @Valid Bebida bebidaDto) {
		Bebida bebida= new Bebida();
		BeanUtils.copyProperties(bebidaDto, bebida);
		return bebidaRepository.save(bebida);
	}
}
