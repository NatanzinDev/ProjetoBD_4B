package dominio;

public class Supervisor {
	private int id_supervisor;
	private String nome;
	private String senha;
	private String email;
	
	
	public int getId_supervisor() {
		return id_supervisor;
	}
	public void setId_supervisor(int id_supervisor) {
		this.id_supervisor = id_supervisor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
