package dominio;

import java.util.ArrayList;
import java.util.List;

public class Setor {
	
	@Override
	public String toString() {
		return  this.nome +" Local: " + this.local ;
	}
	
	private int id_setor;
	private String nome;
	private String local;
	private List<Funcionario> funcionarios = new ArrayList<>();
	
	
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
