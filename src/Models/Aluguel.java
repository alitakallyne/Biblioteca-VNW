package Models;

import java.sql.Date;

public class Aluguel {
	
    private Usuario usuario;
    private Livro livro;
    private Date dataAluguel;
    private Date dataDevolucao;
    
    
	public Aluguel() {
		
	}


	public Aluguel(Usuario usuario, Livro livro, Date dataAluguel, Date dataDevolucao) {
		super();
		this.usuario = usuario;
		this.livro = livro;
		this.dataAluguel = dataAluguel;
		this.dataDevolucao = dataDevolucao;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public Livro getLivro() {
		return livro;
	}


	public Date getDataAluguel() {
		return dataAluguel;
	}


	public Date getDataDevolucao() {
		return dataDevolucao;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public void setLivro(Livro livro) {
		this.livro = livro;
	}


	public void setDataAluguel(Date dataAluguel) {
		this.dataAluguel = dataAluguel;
	}


	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
    
    
	

}
