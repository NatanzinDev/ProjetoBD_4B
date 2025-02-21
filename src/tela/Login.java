package tela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.border.TitledBorder;

import banco.SupervisorDao;
import dominio.Supervisor;
import util.CriptografiaUtils;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txf_email;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Fa\u00E7a o Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(140, 35, 200, 200);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txf_email = new JTextField();
		txf_email.setBounds(50, 35, 100, 20);
		panel.add(txf_email);
		txf_email.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Senha");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(75, 70, 45, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(75, 15, 45, 13);
		panel.add(lblNewLabel_1);
		
		JButton btEntrar = new JButton("Entrar");
		btEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					logar();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btEntrar.setBounds(50, 150, 100, 20);
		panel.add(btEntrar);
		
		JLabel lb_erro = new JLabel("");
		lb_erro.setBounds(50, 115, 100, 20);
		panel.add(lb_erro);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(50, 90, 100, 20);
		panel.add(passwordField);
	}

	protected void logar() throws ClassNotFoundException, SQLException {
		String email = txf_email.getText();
		String senha = new String(passwordField.getPassword());
		String senhaCriptografada = CriptografiaUtils.criptografarMD5(senha);

		SupervisorDao dao = new SupervisorDao();

		Supervisor s = dao.EncontrarSupervisor(email, senhaCriptografada);

		if (s == null) {

			JOptionPane.showMessageDialog(null, "Não foi encontrado usuários");
		} else {

			Principal a = new Principal();
			a.setLocationRelativeTo(null);
			a.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			a.setVisible(true);

		}
		
	}
}
