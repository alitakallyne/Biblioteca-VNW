package Models;

import java.sql.Date;
import java.time.LocalDate;

public class Aluguel {
	
    private Usuario usuario;
    private Livro livro;
    private LocalDate dataAluguel;
    private LocalDate dataDevolucao;
    
    
	public Aluguel() {
		
	}
	
	


	public Aluguel(Usuario usuario, Livro livro, LocalDate localDate) {
		super();
		this.usuario = usuario;
		this.livro = livro;
		this.dataAluguel = localDate;
		this.dataDevolucao =  dataAluguel.plusDays(7);
	}




	public Usuario getUsuario() {
		return usuario;
	}


	public Livro getLivro() {
		return livro;
	}


	public LocalDate getDataAluguel() {
		return dataAluguel;
	}


	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public void setLivro(Livro livro) {
		this.livro = livro;
	}


	public void setDataAluguel(LocalDate dataAluguel) {
		this.dataAluguel = dataAluguel;
	}


	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
    
    
	

}
