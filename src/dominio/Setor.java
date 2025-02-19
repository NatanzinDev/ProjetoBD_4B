package dominio;

import java.util.List;

public class Setor {
	private int id_setor;
	@Override
	public String toString() {
		return "Setor [id_setor=" + id_setor + ", nome=" + nome + ", local=" + local + ", funcionarios=" + funcionarios
				+ "]";
	}
	private String nome;
	private String local;
	
	
	private List<Funcionario> funcionarios;
	public int getId_setor() {
		return id_setor;
	}
	public void setId_setor(int id_setor) {
		this.id_setor = id_setor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	
	
}
