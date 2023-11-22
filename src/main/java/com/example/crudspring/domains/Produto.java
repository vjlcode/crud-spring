package com.example.crudspring.domains;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "produto")
@Entity(name = "produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private double preco;

	public Produto(ProdutoRegisterDTO produtoRegisterDTO) {
		this.nome = produtoRegisterDTO.nome();
		this.preco = produtoRegisterDTO.preco();
	}
}
