package tela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import banco.FabricaConexao;
import dominio.Supervisor;
import util.CriptografiaUtils;

public class CadastrarSupervisor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txf_email;
	private JTextField txf_nome;
	private JPasswordField senha2;
	private JPasswordField senha1;
	private JLabel lb_erro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarSupervisor frame = new CadastrarSupervisor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastrarSupervisor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 494);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(109, 35, 431, 381);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton bt_cadastrar = new JButton("Cadastrar");
		bt_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cadastrar();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		bt_cadastrar.setBounds(103, 330, 209, 21);
		panel.add(bt_cadastrar);
		bt_cadastrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel = new JLabel("Cadastrar Supervisor");
		lblNewLabel.setBounds(85, 22, 223, 25);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(148, 70, 96, 13);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		txf_nome = new JTextField();
		txf_nome.setBounds(103, 90, 211, 19);
		panel.add(txf_nome);
		txf_nome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txf_nome.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email");
		lblNewLabel_1_1.setBounds(148, 115, 96, 13);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txf_email = new JTextField();
		txf_email.setBounds(103, 135, 211, 19);
		panel.add(txf_email);
		txf_email.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txf_email.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Informe uma senha");
		lblNewLabel_1_2.setBounds(112, 160, 182, 25);
		panel.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Confirmar Senha");
		lblNewLabel_1_2_1.setBounds(112, 210, 182, 13);
		panel.add(lblNewLabel_1_2_1);
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		senha2 = new JPasswordField();
		senha2.setBounds(103, 230, 211, 21);
		panel.add(senha2);
		
		senha1 = new JPasswordField();
		senha1.setBounds(101, 185, 211, 21);
		panel.add(senha1);
		
		lb_erro = new JLabel("");
		lb_erro.setHorizontalAlignment(SwingConstants.CENTER);
		lb_erro.setBounds(20, 261, 401, 25);
		panel.add(lb_erro);
	}

	protected void cadastrar() throws ClassNotFoundException, SQLException {
		String nome = txf_nome.getText();
		String email = txf_email.getText();
		String senhaString1 = new String(senha1.getPassword());
		String senhaString2 = new String(senha2.getPassword());
		String senhaCriptografada;
		
	
	
		
		
		if(nome == null || nome.isEmpty()) {
			lb_erro.setText("O campo de nome não \npode estar vazio");
			return;
		}
		
		if(email == null || email.isEmpty()) {
			lb_erro.setText("O campo de nome não pode estar vazio");
			return;
		}
		
		if(senhaString1 == null || senhaString1.isEmpty() || senhaString1.length() <= 3) {
			lb_erro.setText("A senha não pode estar vazia ou conter menos de 4 caracteres.");
			lb_erro.setForeground(Color.red);
			senha1.setText("");
			senha2.setText("");
			return;
		}
		
		if(senhaString2 == null || senhaString2.isEmpty() || senhaString2.length() <= 3) {
			lb_erro.setText("A senha não pode estar vazia ou conter menos de 4 caracteres.");
			lb_erro.setForeground(Color.red);
			senha1.setText("");
			senha2.setText("");
			return;
		}
		
		if(!senhaString1.equals(senhaString2)) {
			lb_erro.setText("Senha não são iguais, digite novamente.");
			lb_erro.setForeground(Color.red);
			senha1.setText("");
			senha2.setText("");
			return;
		}else {
			senhaCriptografada = CriptografiaUtils.criptografarMD5(senhaString1);
			lb_erro.setText("");
			
		}
		
		Supervisor s = new Supervisor();
		s.setNome(nome);
		s.setEmail(email);
		s.setSenha(senhaCriptografada);
		
		Connection conexao = FabricaConexao.criarConexao();

		System.out.println("Inserindo dados...");

		String sql = " INSERT INTO supervisor (nome,email,senha) VALUES (?,?,?) ";

		PreparedStatement comando = conexao.prepareStatement(sql);
		comando.setString(1, s.getNome());
		comando.setString(2, s.getEmail());
		comando.setString(3, s.getSenha());
		comando.execute();

		

		comando.close();
		conexao.close();

		exibirMensagem("Usuário " + nome + " Cadastro com Sucesso, volte para tela inicial e faça o login.");

		// Limpando os Campos
		txf_email.setText("");
		txf_nome.setText("");
		senha1.setText("");
		senha2.setText("");
		
		
		
		
	}

	private void exibirMensagem(String string) {
		JOptionPane.showMessageDialog(contentPane, string);
		
	}
}
