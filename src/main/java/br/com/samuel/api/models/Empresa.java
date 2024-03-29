package br.com.samuel.api.models;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.samuel.api.repositorys.EmpresaRepository;

@Entity
public class Empresa {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull @NotEmpty
	private String nome;
	@NotNull @NotEmpty
	private String endereco;
	@NotNull @NotEmpty
	private String email;
	@NotNull @NotEmpty
	private String areaOperacao;
	@NotNull @NotEmpty
	private BigDecimal valor_acao;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "empresa")
	 private List<Acao> acoes;
	 
	
	public List<Acao> getAcoes() {
		return acoes;
	}
	public void setAcoes(List<Acao> acoes) {
		this.acoes = acoes;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAreaOperacao() {
		return areaOperacao;
	}
	public void setAreaOperacao(String areaOperacao) {
		this.areaOperacao = areaOperacao;
	}
	
	
	
	
	public BigDecimal getValor_acao() {
		return valor_acao;
	}
	public void setValor_acao(BigDecimal valor_acao) {
		this.valor_acao = valor_acao;
	}
	
	
	
	
	public Empresa atualizar(Long id, EmpresaRepository empresaReposity) {
		Empresa empresa = empresaReposity.getOne(id);
		empresa.setNome(this.nome);
		empresa.setEndereco(this.endereco);
		empresa.setEmail(this.email);
		empresa.setAreaOperacao(this.areaOperacao);
		
		return empresa;
		
	}
	

}
