package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.Funcionario;

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
}
