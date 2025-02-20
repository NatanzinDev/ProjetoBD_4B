package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dominio.Supervisor;

public class SupervisorDao {
	public Supervisor EncontrarSupervisor(String email, String senha) throws ClassNotFoundException, SQLException {
		Connection conexao = FabricaConexao.criarConexao();

		String sql = " SELECT * FROM supervisor s WHERE s.email LIKE ? AND s.senha = ? ";

		PreparedStatement comando = conexao.prepareStatement(sql);

		comando.setString(1, email);
		comando.setString(2, senha);

		ResultSet resultado = comando.executeQuery();

		if (resultado.next()) {
			Supervisor s = new Supervisor();
			s.setId_supervisor(resultado.getInt("id_supervisor"));
			s.setNome(resultado.getString("nome"));
			s.setEmail(resultado.getString("email"));
			s.setSenha(resultado.getString("senha"));

			return s;
		}

		comando.close();
		conexao.close();

		return null;
	}
	
}
