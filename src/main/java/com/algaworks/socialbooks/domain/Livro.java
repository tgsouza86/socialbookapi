package com.algaworks.socialbooks.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;




@Entity
@Table(name="livro")
public class Livro implements Serializable {
	
	private static final long serialVersionUID = 1;
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	
	
	private String nome;

	
	@JsonFormat(pattern = "dd/MM/YYYY")
	@JsonInclude(Include.NON_NULL)
	private Date publicacao;
	
	private String editora;
	
	@JsonInclude(Include.NON_NULL)
	private String resumo;
	
	@JsonInclude(Include.NON_NULL)
	@OneToMany(mappedBy = "livro")	
	private List<Comentario> comentario;
	
	
	@ManyToOne
	@JoinColumn(name = "AUTOR_ID")
	private Autor autor;
	
	public Livro() {
		
	}
	
	public Livro(Long id, String nome, Date publicacao, String editora, String resumo) {
		super();
		this.id = id;
		this.nome = nome;
		this.publicacao = publicacao;
		this.editora = editora;
		this.resumo = resumo;
	}
	
	public Livro(String nome) {
		this.nome = nome;
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

	public Date getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(Date publicacao) {
		this.publicacao = publicacao;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public List<Comentario> getComentario() {
		return comentario;
	}

	public void setComentario(List<Comentario> comentario) {
		this.comentario = comentario;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public void orElse(Object object) {
		// TODO Auto-generated method stub
		
	}
	
}
