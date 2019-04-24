package br.com.jloja.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@NamedQueries({
	@NamedQuery(name = "ProdutoEntity.listar", query = "SELECT p FROM ProdutoEntity p"),
	@NamedQuery(name = "ProdutoEntity.buscarPorId", query = "SELECT p FROM ProdutoEntity p WHERE p.id = :id"),
	@NamedQuery(name = "ProdutoEntity.estoqueBaixo", query = "SELECT p FROM ProdutoEntity p WHERE p.estoque < p.estoqueIdeal")
})

@Entity
@Table(name = "produto")
public class ProdutoEntity {
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column
	private int id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column
	private String descricao;
	
	@Column(nullable = false)
	private int estoque;
	
	@Column(nullable = false, precision = 7, scale = 2)
	private BigDecimal valor;
	
	@Column(nullable = false)
	private int estoqueIdeal;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usuario_id",  nullable = false)
	private UsuarioEntity usuarioCadastro;

	public void saida(int qtde) {
		estoque = estoque - qtde;
	}
	
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public UsuarioEntity getUsuarioCadastro() {
		return usuarioCadastro;
	}

	public void setUsuarioCadastro(UsuarioEntity usuarioCadastro) {
		this.usuarioCadastro = usuarioCadastro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public int getEstoqueIdeal() {
		return estoqueIdeal;
	}

	public void setEstoqueIdeal(int estoqueIdeal) {
		this.estoqueIdeal = estoqueIdeal;
	}
	
	
	

}
