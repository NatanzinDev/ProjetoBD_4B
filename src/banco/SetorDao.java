package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

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
}
