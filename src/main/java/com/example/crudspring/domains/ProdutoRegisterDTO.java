package com.example.crudspring.domains;

import jakarta.validation.constraints.NotBlank;

public record ProdutoRegisterDTO(

		@NotBlank
		String nome,
		double preco
) {
}
