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

import com.lanchonete.dto.ProdutoDto;
import com.lanchonete.model.Bebida;
import com.lanchonete.model.Doce;
import com.lanchonete.model.Pedido;
import com.lanchonete.model.Salgado;
import com.lanchonete.repository.BebidaRepository;
import com.lanchonete.repository.DoceRepository;
import com.lanchonete.repository.PedidoRepository;
import com.lanchonete.repository.SalgadoRepository;


@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/pedidos")
public class PedidosController {
	@Autowired
	private PedidoRepository pedidoRepository;
	
	
	@GetMapping
	public List<Pedido> listPedidos() {
		return pedidoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOnePedido(@PathVariable(name="id")long id) {
		Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
		if (!pedidoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido not found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(pedidoOptional.get());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pedido addPedido(@RequestBody @Valid Pedido pedidoDto) {
		Pedido pedido= new Pedido();
		BeanUtils.copyProperties(pedidoDto, pedido);
		return pedidoRepository.save(pedido);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletePedido(@PathVariable(name="id")long id) {
		Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
		if (!pedidoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido not found");
		}
		pedidoRepository.delete(pedidoOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Pedido deleted successfully");
	}
	
	
//	
//	@DeleteMapping("/{id}")
//	public ResponseEntity<Object> delete(@PathVariable(name="id")long id) {
//		Optional<Produto> produtoOptional = produtoRepository.findById(id);
//		if (!produtoOptional.isPresent()) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto not found");
//		}
//		produtoRepository.delete(produtoOptional.get());
//		return ResponseEntity.status(HttpStatus.OK).body("Produto deleted successfully");
//	}
//	
//	@PutMapping("/{id}")
//	public ResponseEntity<Object> update(@PathVariable(name="id")long id, @RequestBody @Valid ProdutoDto produtoDto){
//		Optional<Produto> produtoOptional = produtoRepository.findById(id);
//		if (!produtoOptional.isPresent()) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto not found");
//		}
//		
//		Produto produto = new Produto();
//		BeanUtils.copyProperties(produtoDto, produto);
//		produto.setId(produtoOptional.get().getId());
//		
//		return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produto));
//	}
	
}
