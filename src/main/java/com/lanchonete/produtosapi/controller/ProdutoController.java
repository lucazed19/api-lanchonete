package com.lanchonete.produtosapi.controller;

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

import com.lanchonete.produtosapi.dto.ProdutoDto;
import com.lanchonete.produtosapi.model.Produto;
import com.lanchonete.produtosapi.repository.ProdutoRepository;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public List<Produto> list() {
		return produtoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOne(@PathVariable(name="id")long id) {
		Optional<Produto> produtoOptional = produtoRepository.findById(id);
		if (!produtoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto not found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(produtoOptional.get());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto add(@RequestBody @Valid ProdutoDto produtoDto) {
		Produto produto = new Produto();
		BeanUtils.copyProperties(produtoDto, produto);
		return produtoRepository.save(produto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable(name="id")long id) {
		Optional<Produto> produtoOptional = produtoRepository.findById(id);
		if (!produtoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto not found");
		}
		produtoRepository.delete(produtoOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Produto deleted successfully");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable(name="id")long id, @RequestBody @Valid ProdutoDto produtoDto){
		Optional<Produto> produtoOptional = produtoRepository.findById(id);
		if (!produtoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto not found");
		}
		
		Produto produto = new Produto();
		BeanUtils.copyProperties(produtoDto, produto);
		produto.setId(produtoOptional.get().getId());
		
		return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produto));
	}
	
	
}
