package tela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import banco.SetorDao;
import dominio.Setor;

public class CadastrarSetor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txf_nome;
	private JTextField txf_local;

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
		
		txf_nome = new JTextField();
		txf_nome.setBounds(101, 28, 96, 19);
		panel.add(txf_nome);
		txf_nome.setColumns(10);
		
		txf_local = new JTextField();
		txf_local.setColumns(10);
		txf_local.setBounds(101, 73, 96, 19);
		panel.add(txf_local);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(21, 31, 45, 13);
		panel.add(lblNewLabel);
		
		JLabel lblLocal = new JLabel("Local:");
		lblLocal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLocal.setBounds(21, 76, 45, 13);
		panel.add(lblLocal);
		
		JButton bt_cadastrar = new JButton("Cadastrar");
		bt_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarSetor();
			}
		});
		bt_cadastrar.setBounds(21, 126, 176, 21);
		panel.add(bt_cadastrar);
	}

	protected void cadastrarSetor() {
		Setor s = new Setor();
		s.setNome(txf_nome.getText());
		s.setLocal(txf_local.getText());

		

		try {
			SetorDao dao = new SetorDao();
			dao.CadastrarSetor(s);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro no Sistema");
			e.printStackTrace();
		}
		
		txf_nome.setText("");
		txf_local.setText("");
	}
}
