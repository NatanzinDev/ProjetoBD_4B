package tela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "Cadastro de funcion\u00E1rios ", TitledBorder.CENTER,
				TitledBorder.TOP, null, null));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton bt_bf = new JButton("Buscar Funcionário");
		bt_bf.setBackground(new Color(240, 240, 240));
		bt_bf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bt_bf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarFuncionario a = null;

				a = new BuscarFuncionario();
				a.setLocationRelativeTo(null);
				a.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				a.setVisible(true);

			}
		});
		bt_bf.setBounds(224, 245, 301, 40);
		contentPane.add(bt_bf);

		JButton btnCadastrarsetor = new JButton("Cadastrar Funcionário");
		btnCadastrarsetor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				CadastroFuncionario a = null;
				try {
					a = new CadastroFuncionario();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				;

				a.setLocationRelativeTo(null);
				a.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				a.setVisible(true);
			}
		});
		btnCadastrarsetor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCadastrarsetor.setBackground(UIManager.getColor("Button.background"));
		btnCadastrarsetor.setBounds(224, 102, 301, 40);
		contentPane.add(btnCadastrarsetor);

		JButton bt_bs = new JButton("Buscar Setor");
		bt_bs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarSetor a = null;

				a = new BuscarSetor();
				a.setLocationRelativeTo(null);
				a.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				a.setVisible(true);
			}
		});
		bt_bs.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bt_bs.setBackground(UIManager.getColor("Button.background"));
		bt_bs.setBounds(224, 313, 298, 40);
		contentPane.add(bt_bs);

		JButton bt_cf = new JButton("Cadastrar Setor");
		bt_cf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarSetor a = null;

				a = new CadastrarSetor();
				a.setLocationRelativeTo(null);
				a.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				a.setVisible(true);

			}
		});
		bt_cf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bt_cf.setBackground(UIManager.getColor("Button.background"));
		bt_cf.setBounds(224, 42, 301, 40);
		contentPane.add(bt_cf);

		JButton bt_fs = new JButton("Cadastrar Funcionário no Setor");
		bt_fs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				CadastrarFuncionarioNoSetor a = null;
				a = new CadastrarFuncionarioNoSetor();
				a.setLocationRelativeTo(null);
				a.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				a.setVisible(true);
			}
		});
		bt_fs.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bt_fs.setBackground(UIManager.getColor("Button.background"));
		bt_fs.setBounds(224, 166, 301, 40);
		contentPane.add(bt_fs);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/imgfuncionarios.png")));
		lblNewLabel.setBounds(0, 20, 758, 382);
		contentPane.add(lblNewLabel);
	}

}
