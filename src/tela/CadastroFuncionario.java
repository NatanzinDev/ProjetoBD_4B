package tela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import banco.FabricaConexao;
import dominio.Funcionario;

public class CadastroFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtF_nome;
	private JTextField txtF_salario;
	private JTextField txtF_cargo;
	private JTextField txtF_telefone;
	private JButton bt_cadastrar;
	private Funcionario funcionarioEdicao;
	private JList listar;
	private JLabel label_nome;
	private JLabel label_salario;
	private JLabel label_cargo;
	private JLabel label_telefone;
	 
	/*
	 * Cadastrar Supervisor 
	 * Cadastrar Setor
	 * Buscar setor
	 * Buscar funcionário
	 * */

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFuncionario frame = new CadastroFuncionario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public CadastroFuncionario() throws ClassNotFoundException, SQLException {
		setBackground(new Color(0, 0, 160));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 875, 505);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Cadastrar Funcion\u00E1rio", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(20, 21, 820, 99);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(74, 24, 55, 19);
		panel.add(lblNewLabel);
		
		txtF_nome = new JTextField();
		txtF_nome.setBounds(24, 47, 144, 19);
		panel.add(txtF_nome);
		txtF_nome.setColumns(10);
		
		JLabel lblSalrio = new JLabel("Salário");
		lblSalrio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSalrio.setBounds(222, 24, 55, 19);
		panel.add(lblSalrio);
		
		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCargo.setBounds(380, 24, 55, 19);
		panel.add(lblCargo);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefone.setBounds(528, 24, 64, 19);
		panel.add(lblTelefone);
		
		bt_cadastrar = new JButton("Cadastrar");
		bt_cadastrar.setBackground(new Color(128, 128, 128));
		bt_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					casdatrar();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		bt_cadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bt_cadastrar.setBounds(648, 44, 154, 21);
		panel.add(bt_cadastrar);
		
		txtF_salario = new JTextField();
		txtF_salario.setColumns(10);
		txtF_salario.setBounds(178, 47, 144, 19);
		panel.add(txtF_salario);
		
		txtF_cargo = new JTextField();
		txtF_cargo.setColumns(10);
		txtF_cargo.setBounds(332, 47, 144, 19);
		panel.add(txtF_cargo);
		
		txtF_telefone = new JTextField();
		txtF_telefone.setColumns(10);
		txtF_telefone.setBounds(486, 47, 144, 19);
		panel.add(txtF_telefone);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new TitledBorder(null, "Informa\u00E7\u00F5es sobre os funcion\u00E1rios", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_1.setBounds(20, 130, 820, 328);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton bt_exibirDados = new JButton("Exibir dados");
		bt_exibirDados.setBackground(new Color(128, 128, 128));
		bt_exibirDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(listar.getSelectedIndex() == -1) {
					exibirMensagemErro("Selecione um funcionário na lista.");
				}
				Funcionario fncselecionado = (Funcionario) listar.getSelectedValue();
				DecimalFormat d = new DecimalFormat("0.00");
				label_nome.setText(fncselecionado.getNome().toString());
				label_salario.setText("R$"+String.valueOf(d.format(fncselecionado.getSalario())));
				label_cargo.setText(fncselecionado.getCargo().toString());
				label_telefone.setText(fncselecionado.getTelefone().toString());
				
			}
		});
		bt_exibirDados.setBounds(415, 285, 114, 21);
		panel_1.add(bt_exibirDados);
		
		JButton bt_editar = new JButton("Editar");
		bt_editar.setBackground(new Color(128, 128, 128));
		bt_editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edicao();
			}
		});
		bt_editar.setBounds(550, 285, 114, 21);
		panel_1.add(bt_editar);
		
		JButton bt_excluir = new JButton("Excluir");
		bt_excluir.setBackground(new Color(128, 128, 128));
		bt_excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					excluir();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		bt_excluir.setBounds(683, 285, 114, 21);
		panel_1.add(bt_excluir);
		
		JLabel lblNewLabel_1 = new JLabel("Informações do funcionário");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(39, 23, 259, 21);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nome: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(22, 66, 57, 26);
		panel_1.add(lblNewLabel_2);
		
		label_telefone = new JLabel("");
		label_telefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_telefone.setBounds(89, 242, 205, 26);
		panel_1.add(label_telefone);
		
		JLabel lblNewLabel_2_2 = new JLabel("Salário:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(22, 119, 57, 26);
		panel_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Cargo:");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2_1.setBounds(22, 181, 57, 26);
		panel_1.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Telefone:");
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2_2.setBounds(22, 242, 69, 26);
		panel_1.add(lblNewLabel_2_2_2);
		
		label_cargo = new JLabel("");
		label_cargo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_cargo.setBounds(89, 181, 205, 26);
		panel_1.add(label_cargo);
		
		label_salario = new JLabel("");
		label_salario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_salario.setBounds(89, 119, 205, 26);
		panel_1.add(label_salario);
		
		label_nome = new JLabel("");
		label_nome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_nome.setBounds(89, 66, 205, 26);
		panel_1.add(label_nome);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(415, 62, 381, 206);
		panel_1.add(scrollPane);
		
		listar = new JList();
		listar.setBorder(new TitledBorder(null, "Lista de funcion\u00E1rios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setViewportView(listar);
		
		JButton bt_limpar = new JButton("Limpar");
		bt_limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		bt_limpar.setBackground(new Color(128, 128, 128));
		bt_limpar.setBounds(22, 285, 114, 21);
		panel_1.add(bt_limpar);
		
		atualizarListagem();
		
		//fim do local de criação
	}
	
	//função para limpar os labels de exibição
	protected void limparCampos() {
		label_nome.setText("");
		label_salario.setText("");
		label_cargo.setText("");
		label_telefone.setText("");
	}

	//função de exclusão
	protected void excluir() throws ClassNotFoundException, SQLException {
		if(listar.getSelectedIndex() == -1) {
			exibirMensagemErro("Selecione um funcionário na lista.");
		}
		
		funcionarioEdicao = (Funcionario) listar.getSelectedValue();
		
		Connection conexao = FabricaConexao.criarConexao();
		
		String sql = "DELETE FROM funcionario WHERE id_funcionario = ?";
		
		PreparedStatement comando = conexao.prepareStatement(sql);
		comando.setInt(1, funcionarioEdicao.getId());
		comando.executeUpdate();
		
		ExibirMsg("Funcionário removido");
		
		atualizarListagem();
		
		comando.close();
		conexao.close();
		
	}
	
	
	//função para mostrar os valores nos textfields
	protected void edicao() {
		if(listar.getSelectedIndex() == -1) {
			exibirMensagemErro("Selecione um funcionário na lista.");
		}
		
		funcionarioEdicao = (Funcionario) listar.getSelectedValue();
		
		DecimalFormat d = new DecimalFormat("0.00");
		
		txtF_nome.setText(funcionarioEdicao.getNome().toString());
		txtF_salario.setText(String.valueOf(d.format(funcionarioEdicao.getSalario())));
		txtF_cargo.setText(funcionarioEdicao.getCargo().toString());
		txtF_telefone.setText(funcionarioEdicao.getTelefone().toString());
		
		
		bt_cadastrar.setText("Editar");
		
	}

	//função de cadastro
	protected void casdatrar() throws ClassNotFoundException, SQLException {
		if(txtF_nome.getText() == null || txtF_nome.getText().isEmpty()) {
			exibirMensagemErro("Campo de nome não pode ser vazio.");
			return;
		}
		
		if(txtF_salario.getText() == null || txtF_salario.getText().isEmpty()) {
			exibirMensagemErro("Campo de salário não pode ser vazio.");
			return;
		}
		
		if(txtF_cargo.getText() == null || txtF_cargo.getText().isEmpty()) {
			exibirMensagemErro("Campo de cargo não pode ser vazio.");
			return;
		}
		
		if(txtF_telefone.getText() == null || txtF_telefone.getText().isEmpty()) {
			exibirMensagemErro("Telefone não pode ser vazio.");
			return;
		}
		
		
		//função de cadastro
		if(bt_cadastrar.getText().equals("Cadastrar")) {
			Connection conexao = FabricaConexao.criarConexao();
			
			String sql = "INSERT INTO FUNCIONARIO (nome,salario,cargo,telefone,id_setor) VALUES (?,?,?,?,?)";
			Funcionario f = new Funcionario();
			double aux = Double.parseDouble(txtF_salario.getText().toString().replace(",", "."));
			
			f.setNome(txtF_nome.getText());
			f.setSalario(aux);
			f.setCargo(txtF_cargo.getText());
			f.setTelefone(txtF_telefone.getText());	
			f.setIdsetor(1);			
			
			PreparedStatement comando = conexao.prepareStatement(sql);
			
			comando.setString(1, f.getNome());
			comando.setDouble(2, f.getSalario());
			comando.setString(3, f.getCargo());
			comando.setString(4, f.getTelefone());
			comando.setInt(5, f.getIdsetor());
			
			comando.execute();
			
			System.out.println("Fechando ...");
			comando.close();
			conexao.close();
			
			JOptionPane.showMessageDialog(null,"Funcionário foi cadastrado com sucesso","Info",JOptionPane.INFORMATION_MESSAGE);
			
			txtF_nome.setText("");
			txtF_salario.setText("");
			txtF_cargo.setText("");
			txtF_telefone.setText("");
			
			
			//função para edição de funcionário
		}else if(bt_cadastrar.getText().equals("Editar")) {
			Connection conexao = FabricaConexao.criarConexao();
			double aux = Double.parseDouble(txtF_salario.getText().toString().replace(",", "."));
			pegarIdDoSetor();
			funcionarioEdicao.setNome(txtF_nome.getText());
			funcionarioEdicao.setSalario(aux);
			funcionarioEdicao.setCargo(txtF_cargo.getText());
			funcionarioEdicao.setTelefone(txtF_telefone.getText());
			
			String sql = "UPDATE FUNCIONARIO SET nome = ?, salario = ?, cargo = ?, telefone = ? WHERE id_funcionario = ?" ;
			
			PreparedStatement comando = conexao.prepareStatement(sql);
			
			comando.setString(1, funcionarioEdicao.getNome());
			comando.setDouble(2, funcionarioEdicao.getSalario());
			comando.setString(3, funcionarioEdicao.getCargo());
			comando.setString(4, funcionarioEdicao.getTelefone());
			comando.setInt(5, funcionarioEdicao.getId());
			comando.executeUpdate();
			
			ExibirMsg("Dados atualizados");
			
			comando.close();
			conexao.close();
			
			funcionarioEdicao = null;
			
			
			txtF_nome.setText("");
			txtF_salario.setText("");
			txtF_cargo.setText("");
			txtF_telefone.setText("");
			bt_cadastrar.setText("Cadastrar");
		}
		
		atualizarListagem();
	}
	
	private void pegarIdDoSetor() throws ClassNotFoundException, SQLException {
		Connection conexao = FabricaConexao.criarConexao();
		
		String sql = "SELECT id_setor FROM Funcionario";
		
	}

	//função para atualizar lista
	private void atualizarListagem() throws ClassNotFoundException, SQLException {
		Connection conexao = FabricaConexao.criarConexao(); 
		
		String sql = "SELECT * FROM funcionario";
		
		PreparedStatement comando = conexao.prepareStatement(sql);
		
		ResultSet resultado = comando.executeQuery();
		
		List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
		
		while(resultado.next()) {
			Funcionario f = new Funcionario();
			
			f.setId(resultado.getInt("id_funcionario"));
			f.setNome(resultado.getString("nome"));
			f.setSalario(resultado.getDouble("salario"));
			f.setCargo(resultado.getString("cargo"));
			f.setTelefone(resultado.getString("telefone"));
			
			listaFuncionarios.add(f);
			
		}
		
		DefaultListModel<Funcionario> modelo = new DefaultListModel<>();
		
		for(int i = 0;i < listaFuncionarios.size();i++) {
			Funcionario f = listaFuncionarios.get(i);
			modelo.addElement(f);
		}
		
		listar.setModel(modelo);
		
		comando.close();
		conexao.close();
		
	}

	//exibir mensagem de erro
	private void exibirMensagemErro(String msg) {
		JOptionPane.showMessageDialog(null,msg,"Erro",JOptionPane.ERROR_MESSAGE);
		
	}
	
	//exibir mensagem
	protected void ExibirMsg(String msg) {
		JOptionPane.showMessageDialog(null,msg,"Info",JOptionPane.INFORMATION_MESSAGE);
		
	}
}
