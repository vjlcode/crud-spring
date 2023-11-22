package com.example.crudspring.controllers;

import com.example.crudspring.domains.Produto;
import com.example.crudspring.domains.ProdutoRegisterDTO;
import com.example.crudspring.domains.ProdutoUpdateDTO;
import com.example.crudspring.reposotories.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping
	public ResponseEntity getAllProdutos() {
		var allPrdutos = produtoRepository.findAll();
		return ResponseEntity.ok(allPrdutos);
	}

	@PostMapping
	public ResponseEntity addProduto(@RequestBody @Valid ProdutoRegisterDTO produtoRegisterDTO) {
		Produto produto = new Produto();
		produtoRepository.save(new Produto(produtoRegisterDTO));

		return ResponseEntity.ok().build();
	}

	@PutMapping
	@Transactional
	public ResponseEntity updateProduto(@RequestBody @Valid ProdutoUpdateDTO data) {
		Optional<Produto> optionalProduto = produtoRepository.findById(data.id());
		if (optionalProduto.isPresent()) {

			Produto produto = optionalProduto.get();
			produto.setNome(data.nome());
			produto.setPreco(data.preco());
			return ResponseEntity.ok(produto);

		} else {
			throw new EntityNotFoundException();
		}
	}
}