package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.Funcionario;
import dominio.Setor;

public class FuncionarioDao {
	public List<Funcionario> buscarFuncionarioPeloNome(String n) throws SQLException, ClassNotFoundException{
		Connection conexao = FabricaConexao.criarConexao();

		String sql = " SELECT * FROM funcionario WHERE 1 = 1 ";

		if (n != null && !n.isEmpty()) {
			sql += " AND upper(nome) LIKE ? ";

		}

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		int i = 1;

		if (n != null && !n.isEmpty()) {
			comando.setString(i++, "%" + n.toUpperCase() + "%");

		}

		ResultSet resultado = comando.executeQuery();

		List<Funcionario> funcasCadastrados = new ArrayList<>();

		while (resultado.next()) {
			Funcionario f = new Funcionario();
			f.setId(resultado.getInt("id_funcionario"));
			f.setNome(resultado.getString("nome"));
			f.setSalario(resultado.getDouble("salario"));
			f.setCargo(resultado.getString("cargo"));
			f.setTelefone(resultado.getString("telefone"));

			funcasCadastrados.add(f);
		}

		return funcasCadastrados;
	}
	
	public List<Funcionario> buscarFuncionario(String n, String c, String t) throws ClassNotFoundException, SQLException{
		Connection conexao = FabricaConexao.criarConexao();
		String sql = "SELECT f.nome, f.cargo, f.telefone, f.salario, s.nome AS nomesetor  FROM funcionario f JOIN setor s ON f.id_setor = s.id_setor";

		boolean temFiltro = false;

		if (n != null && !n.isEmpty()) {
		    sql += " WHERE f.nome LIKE ?";
		    temFiltro = true;
		}

		if (c != null && !c.isEmpty()) {
		    sql += temFiltro ? " AND f.cargo LIKE ?" : " WHERE f.cargo LIKE ?";
		    temFiltro = true;
		}

		if (t != null && !t.isEmpty()) {
		    sql += temFiltro ? " AND f.telefone LIKE ?" : " WHERE f.telefone LIKE ?";
		}

		System.out.println("parte 1");
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		int i = 1;
		
		if (n != null && !n.isEmpty()) {
			comando.setString(i, "%" + n.toUpperCase() + "%");
			i++;
		}

		if (c != null && !c.isEmpty()) {
			comando.setString(i, "%" + c.toUpperCase() + "%");
			i++;
		}
		
		if (t != null && !t.isEmpty()) {
			comando.setString(i, "%" + t.toUpperCase() + "%");
			i++;
		}
		
		System.out.println("parte 2");
		
		ResultSet resultado = comando.executeQuery();

		List<Funcionario> funcionariosCadastrados = new ArrayList<>();

		while (resultado.next()) {
			Funcionario f = new Funcionario();
			f.setNome(resultado.getString("nome"));
			f.setCargo(resultado.getString("cargo"));
			f.setSalario(resultado.getDouble("salario"));
			f.setTelefone(resultado.getString("telefone"));
			

		    Setor s = new Setor(); 
		    s.setNome(resultado.getString("nomesetor"));
		    f.setSetor(s);
			
			funcionariosCadastrados.add(f);
		
		}
		System.out.println("SQL gerado: " + sql);
		System.out.println("Fim");
		return funcionariosCadastrados;
		
	}
}
