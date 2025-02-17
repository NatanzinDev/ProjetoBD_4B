package tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class CadastrarSetor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarSetor frame = new CadastrarSetor();
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
	public CadastrarSetor() {
		setTitle("Cadastrrar Setor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Cadastrar Setor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(117, 41, 233, 157);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(101, 28, 96, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(101, 73, 96, 19);
		panel.add(textField_1);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(21, 31, 45, 13);
		panel.add(lblNewLabel);
		
		JLabel lblLocal = new JLabel("Local:");
		lblLocal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLocal.setBounds(21, 76, 45, 13);
		panel.add(lblLocal);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBounds(21, 126, 176, 21);
		panel.add(btnNewButton);
	}
}
