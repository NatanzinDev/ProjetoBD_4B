package tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txf_email;
	private JTextField txf_senha;

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
		
		txf_senha = new JTextField();
		txf_senha.setColumns(10);
		txf_senha.setBounds(50, 90, 100, 20);
		panel.add(txf_senha);
		
		JLabel lblNewLabel = new JLabel("Senha");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(75, 70, 45, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(75, 15, 45, 13);
		panel.add(lblNewLabel_1);
		
		JButton btEntrar = new JButton("Entrar");
		btEntrar.setBounds(50, 150, 100, 20);
		panel.add(btEntrar);
		
		JLabel lb_erro = new JLabel("");
		lb_erro.setBounds(50, 115, 100, 20);
		panel.add(lb_erro);
	}

}
