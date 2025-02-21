package tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

public class CadastrarFuncionarioNoSetor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarFuncionarioNoSetor frame = new CadastrarFuncionarioNoSetor();
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
	public CadastrarFuncionarioNoSetor() {
		setTitle("Cadastrar Funcionário  no Setor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 362);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Cadastrar Funcion\u00E1rio no Setor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(77, 49, 424, 215);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Selecione o Setor");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(97, 26, 208, 13);
		panel.add(lblNewLabel);
		
		JLabel lblSelecioneOFuncionrio = new JLabel("Selecione o funcionário");
		lblSelecioneOFuncionrio.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelecioneOFuncionrio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSelecioneOFuncionrio.setBounds(110, 113, 208, 13);
		panel.add(lblSelecioneOFuncionrio);
		
		JComboBox cb_setor = new JComboBox();
		cb_setor.setBounds(107, 55, 198, 21);
		panel.add(cb_setor);
		
		JComboBox cb_funca = new JComboBox();
		cb_funca.setBounds(107, 137, 198, 21);
		panel.add(cb_funca);
		
		JButton bt_cadastrar = new JButton("Cadastrar");
		bt_cadastrar.setFont(new Font("Tahoma", Font.BOLD, 10));
		bt_cadastrar.setBounds(167, 184, 85, 21);
		panel.add(bt_cadastrar);
	}
}
