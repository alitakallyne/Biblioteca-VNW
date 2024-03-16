package Models;

public class Usuario {
	
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private String login;
	private String senha;
	
	
	public Usuario() {
		
	}
	
	
	
	public Usuario(String nome, String cpf, String email, String telefone, String login, String senha) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.login = login;
		this.senha = senha;
	}



	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public String getEmail() {
		return email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	public String getLogin() {
		return login;
	}



	public String getSenha() {
		return senha;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	
}
