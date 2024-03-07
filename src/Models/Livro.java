package Models;

import java.time.LocalDate;

public class Livro {

	private String nomeLivro;
	private String nomeAutor;
	private LocalDate dataPublicacao;
	private boolean isAlugado;
	
	public Livro() {
		
	}
	
	public Livro(String nomeLivro, String nomeAutor, LocalDate dataPublicacao,boolean isAlugado) {
		super();
		this.nomeLivro = nomeLivro;
		this.nomeAutor = nomeAutor;
		this.dataPublicacao = LocalDate.now();
		this.isAlugado = isAlugado;
	}
	
	public String getNomeLivro() {
		return nomeLivro;
	}
	public String getNomeAutor() {
		return nomeAutor;
	}
	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}
	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public boolean isAlugado() {
		return isAlugado;
	}

	public void setAlugado(boolean isAlugado) {
		this.isAlugado = isAlugado;
	}
	
	
}
