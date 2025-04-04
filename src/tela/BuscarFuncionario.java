package tela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import banco.FuncionarioDao;
import dominio.Funcionario;
import dominio.Setor;

public class BuscarFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txf_nome;
	private JTextField txf_cargo;
	private JTextField txf_telefone;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarFuncionario frame = new BuscarFuncionario();
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
	public BuscarFuncionario() {
		setTitle("Buscar Funcionário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 839, 544);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Buscar", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(45, 59, 208, 310);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txf_nome = new JTextField();
		txf_nome.setBounds(40, 49, 123, 19);
		panel.add(txf_nome);
		txf_nome.setColumns(10);
		
		txf_cargo = new JTextField();
		txf_cargo.setColumns(10);
		txf_cargo.setBounds(40, 97, 123, 19);
		panel.add(txf_cargo);
		
		txf_telefone = new JTextField();
		txf_telefone.setColumns(10);
		txf_telefone.setBounds(40, 145, 123, 19);
		panel.add(txf_telefone);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(40, 30, 123, 19);
		panel.add(lblNewLabel);
		
		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCargo.setBounds(40, 78, 123, 19);
		panel.add(lblCargo);
		
		JLabel lblNewLabel_1_1 = new JLabel("Telefone");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(40, 126, 123, 19);
		panel.add(lblNewLabel_1_1);
		
		JButton bt_buscar = new JButton("Buscar");
		bt_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					buscarFuncionario();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		bt_buscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		bt_buscar.setBounds(40, 215, 123, 21);
		panel.add(bt_buscar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Resultados", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_1.setBounds(341, 59, 437, 310);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 48, 378, 234);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Salário", "Cargo", "Telefone", "Setor"
			}
		));
		scrollPane.setViewportView(table);
	}

	protected void buscarFuncionario() throws ClassNotFoundException, SQLException {
		if((txf_nome.getText() == null || txf_nome.getText().isEmpty()) && (txf_cargo.getText() == null || txf_cargo.getText().isEmpty()) && (txf_telefone.getText() == null || txf_telefone.getText().isEmpty())) {
			JOptionPane.showMessageDialog(null, "Algum campo precisa está preenchido para buscar.");
			return;
		}
		
		FuncionarioDao dao = new FuncionarioDao();
		List<Funcionario> encontrado = new ArrayList<>();
		
		encontrado = dao.buscarFuncionario(txf_nome.getText(), txf_cargo.getText(), txf_telefone.getText());
		DefaultTableModel modelo = new DefaultTableModel(new String[] { "Nome", "Salário", "Cargo", "Telefone", "Setor" }, 0);
		
		for (int i = 0; i < encontrado.size(); i++) {
			Funcionario f = encontrado.get(i);
			DecimalFormat d = new DecimalFormat("0.00");
			System.out.println(f.getNome()+String.valueOf(f.getSalario())+f.getCargo()+f.getTelefone()+f.getSetor().getNome());
			modelo.addRow(new String[] { f.getNome(),String.valueOf(d.format(f.getSalario())),f.getCargo(),f.getTelefone(),f.getSetor().getNome() ,});
		}
		
		table.setModel(modelo);
		
		System.out.println("Tela de busca");
		
	}
}
