package tela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import banco.FuncionarioDao;
import banco.SetorDao;
import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.SortedList;
import ca.odell.glazedlists.swing.AutoCompleteSupport;

import dominio.Funcionario;
import dominio.Setor;

public class CadastrarFuncionarioNoSetor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private SortedList<Setor> setores = new SortedList<Setor>(new BasicEventList<Setor>());
	private SortedList<Funcionario> funcas = new SortedList<Funcionario>(new BasicEventList<Funcionario>());
	private JComboBox cb_setor;
	private JComboBox cb_funca;

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
		
		cb_setor = new JComboBox();
		cb_setor.setBounds(63, 55, 293, 21);
		panel.add(cb_setor);
		
		cb_funca = new JComboBox();
		cb_funca.setBounds(63, 137, 293, 21);
		panel.add(cb_funca);
		
		JButton bt_cadastrar = new JButton("Cadastrar");
		bt_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cadastrarFuncionarioNoSetor();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		bt_cadastrar.setFont(new Font("Tahoma", Font.BOLD, 10));
		bt_cadastrar.setBounds(137, 184, 170, 21);
		panel.add(bt_cadastrar);
		
		AutoCompleteSupport.install(cb_setor, setores);
		
		cb_setor.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					buscarSetor();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
		
		AutoCompleteSupport.install(cb_funca, funcas);
		cb_funca.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					buscarFunca();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	protected void cadastrarFuncionarioNoSetor() throws ClassNotFoundException {
		Setor s = (Setor) cb_setor.getSelectedItem();
		Funcionario f = (Funcionario) cb_funca.getSelectedItem();
		
	
		
		try {
			SetorDao dao = new SetorDao();
			dao.cadastrarFuncionarioNoSetor(s,f);
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro no Sistema");
			e.printStackTrace();
		}
		
		
	}

	protected void buscarSetor() throws ClassNotFoundException {
		if (cb_setor.getEditor().getItem() != null
				&& cb_setor.getEditor().getItem().toString().length() >= 3) {
			SetorDao dao = new SetorDao();
			List<Setor> setoresEncontrados = new ArrayList<>();

			try {
				String setorNome = cb_setor.getEditor().getItem().toString();
				setoresEncontrados = dao.buscarSetorPeloNome(setorNome);

				setores.clear();
				setores.addAll(setoresEncontrados);

				cb_setor.showPopup();
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro no Sistema");
			}
		}
		
	}

	protected void buscarFunca() throws ClassNotFoundException {
		if(cb_setor.getEditor().getItem() != null && cb_setor.getEditor().getItem().toString().length() >= 3) {
			FuncionarioDao dao = new FuncionarioDao();
			List<Funcionario> funcasEncontrados = new ArrayList<>();
			
			try {
				String nomeFunca = cb_funca.getEditor().getItem().toString();
				funcasEncontrados = dao.buscarFuncionarioPeloNome(nomeFunca);
				
				funcas.clear();
				funcas.addAll(funcasEncontrados);
				
				cb_funca.showPopup();
			}catch(SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro no Sistema");
			}
		}
		
	}
}
