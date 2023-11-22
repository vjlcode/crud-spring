package com.example.crudspring.domains;

import jakarta.validation.constraints.NotBlank;

public record ProdutoUpdateDTO(

		Long id,
		String nome,
		double preco
) {
}
