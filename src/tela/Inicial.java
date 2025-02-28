package tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicial frame = new Inicial();
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
	public Inicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 369);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				l.setLocationRelativeTo(null);
				l.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(159, 133, 233, 53);
		contentPane.add(btnNewButton);
		
		JButton btnCadastrar = new JButton("Cadastrar Supervisor");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarSupervisor c  = new CadastrarSupervisor();
				c.setVisible(true);
				c.setLocationRelativeTo(null);
				c.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCadastrar.setBounds(160, 231, 232, 53);
		contentPane.add(btnCadastrar);
		
		JLabel lb_titulo = new JLabel("GERENCIA DE FUNCIONÁRIOS");
		lb_titulo.setBackground(new Color(255, 255, 255));
		lb_titulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		lb_titulo.setBounds(56, 36, 416, 44);
		contentPane.add(lb_titulo);
		
		lb_titulo.setForeground(Color.WHITE);
	}
}
