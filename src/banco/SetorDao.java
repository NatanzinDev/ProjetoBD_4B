package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


import dominio.Funcionario;
import dominio.Setor;

public class SetorDao {

	public void CadastrarSetor(Setor s) throws SQLException, ClassNotFoundException {

		Connection conexao = FabricaConexao.criarConexao();

		String sql = " INSERT INTO  setor (nome,lugar) VALUES (?,?) ";

		PreparedStatement comando = conexao.prepareStatement(sql);
		comando.setString(1, s.getNome());
		comando.setString(2, s.getLocal());
		comando.execute();

		comando.close();
		conexao.close();

		JOptionPane.showMessageDialog(null, "Setor Cadastrada com Sucesso");
	}

	// busca
	public List<Setor> buscarSetorPeloNome(String n) throws SQLException, ClassNotFoundException {
		Connection conexao = FabricaConexao.criarConexao();

		String sql = " SELECT * FROM setor WHERE 1 = 1 ";

		if (n != null && !n.isEmpty()) {
			sql += " AND upper(nome) LIKE ? ";

		}

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		int i = 1;

		if (n != null && !n.isEmpty()) {
			comando.setString(i++, "%" + n.toUpperCase() + "%");

		}

		ResultSet resultado = comando.executeQuery();

		List<Setor> setoresCadastrados = new ArrayList<>();

		while (resultado.next()) {
			Setor s = new Setor();
			s.setId_setor(resultado.getInt("id_setor"));
			s.setNome(resultado.getString("nome"));
			s.setLocal(resultado.getString("lugar"));

			setoresCadastrados.add(s);
		}

		return setoresCadastrados;
	}

	// cadastar funcionario no setor
	public void cadastrarFuncionarioNoSetor(Setor s, Funcionario f) throws SQLException, ClassNotFoundException {
		Connection conexao = FabricaConexao.criarConexao();
		s.getFuncionarios().add(f);
		String sql = "INSERT INTO funcionario(id_setor) VALUES(?) WHERE id_funcionario = ?";
	
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		
		comando.setInt(1, s.getId_setor());
		comando.setInt(2, f.getId());
		

		comando.execute();
		
		
		

		comando.close();
		conexao.close();

		JOptionPane.showMessageDialog(null, "Funcionário cadastrado no setor com sucesso.");
	}
	
	//busca
	public List<Setor> buscarSetor(String n, String l) throws ClassNotFoundException, SQLException{
		Connection conexao = FabricaConexao.criarConexao();
		String sql = " SELECT * FROM setor WHERE 1 = 1 ";

		if (n != null && !n.isEmpty()) {
			sql += " AND nome LIKE ? ";
		}
		
		if(l != null && !l.isEmpty()) {
			sql += "AND lugar LIKE ?";
		}

		

		

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		int i = 1;

		if (n != null && !n.isEmpty()) {
			comando.setString(i, "%" + n.toUpperCase() + "%");
			i++;
		}

		if (l != null && !l.isEmpty()) {
			comando.setString(i, "%" + l.toUpperCase() + "%");
			i++;
		}

		

		ResultSet resultado = comando.executeQuery();

		List<Setor> setoresCadastrados = new ArrayList<>();

		while (resultado.next()) {
			Setor s = new Setor();
			s.setNome(resultado.getString("nome"));
			s.setLocal(resultado.getString("lugar"));
			
			setoresCadastrados.add(s);
		
		}

		return setoresCadastrados;
	}
}
