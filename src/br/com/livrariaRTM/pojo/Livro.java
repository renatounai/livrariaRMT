package br.com.livrariaRTM.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Livro extends ObjetoPadrao implements Serializable {
	private static final long serialVersionUID = 5807702345280962264L;

	@Id
	private int ISBN;
	
	private String titulo;
	
	private String Autor;
	
	private int quantidadeEstoque;
	
	private BigDecimal preco;
	
	private BigDecimal precoPromocao;
	
	private boolean promocao;
	
	@Lob
	@Column(name="sinopse")
	private String sinopse;
	
	private String formato;
	
	private String acabamento;
	
	private String idioma;
	
	private String origem;
	
	private int edicao;
	
	private int numeroPaginas;
	
	@Lob
	private byte[] imagem;
	
	private String categoria;
	

	@Temporal(TemporalType.DATE)
	private Date dataLancamento;

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int isbn) {
		ISBN = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return Autor;
	}

	public void setAutor(String autor) {
		Autor = autor;
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public BigDecimal getPrecoPromocao() {
		return precoPromocao;
	}

	public void setPrecoPromocao(BigDecimal precoPromocao) {
		this.precoPromocao = precoPromocao;
	}

	public boolean isPromocao() {
		return promocao;
	}

	public void setPromocao(boolean promocao) {
		this.promocao = promocao;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getAcabamento() {
		return acabamento;
	}

	public void setAcabamento(String acabamento) {
		this.acabamento = acabamento;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	@Override
	public int hashCode() {
		return ISBN;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (ISBN != other.ISBN)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return ISBN+"/"+titulo;
	}
	
	
	
	
}
