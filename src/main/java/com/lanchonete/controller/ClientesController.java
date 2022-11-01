package com.lanchonete.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lanchonete.model.Clientes;
import com.lanchonete.repository.ClienteRepository;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/clientes")
public class ClientesController {
	

    @Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<Clientes> listPedidos() {
		return clienteRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOnePedido(@PathVariable(name="id")long id) {
		Optional<Clientes> funcionarioOptional = clienteRepository.findById(id);
		if (!funcionarioOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionario not found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(funcionarioOptional.get());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Clientes addPedido(@RequestBody @Valid Clientes cliente) {
		return clienteRepository.save(cliente);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable(name="id")long id, @RequestBody @Valid Clientes cliente){
		Optional<Clientes> clienteOptional = clienteRepository.findById(id);
		if (!clienteOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente not found");
		}
		
		Clientes clienteUpdt = new Clientes();
		BeanUtils.copyProperties(cliente, clienteUpdt);
		clienteUpdt.setId(clienteOptional.get().getId());
		
		return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.save(clienteUpdt));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletePedido(@PathVariable(name="id")long id) {
		Optional<Clientes> clienteOptional =clienteRepository.findById(id);
		if (!clienteOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente not found");
		}
		clienteRepository.delete(clienteOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Pedido deleted successfully");
	}
	
}
