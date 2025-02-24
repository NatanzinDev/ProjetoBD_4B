package tela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
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

import banco.SetorDao;

import dominio.Setor;

public class BuscarSetor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txf_nome;
	private JTextField txf_local;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarSetor frame = new BuscarSetor();
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
	public BuscarSetor() {
		setTitle("Buscar Setor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 370);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Buscar", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(57, 38, 214, 229);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txf_nome = new JTextField();
		txf_nome.setBounds(51, 44, 96, 19);
		panel.add(txf_nome);
		txf_nome.setColumns(10);
		
		txf_local = new JTextField();
		txf_local.setColumns(10);
		txf_local.setBounds(51, 107, 96, 19);
		panel.add(txf_local);
		
		JLabel lblNewLabel = new JLabel("Nome do setor");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(51, 20, 96, 19);
		panel.add(lblNewLabel);
		
		JLabel lblLocal = new JLabel("Local");
		lblLocal.setHorizontalAlignment(SwingConstants.LEFT);
		lblLocal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLocal.setBounds(51, 83, 96, 19);
		panel.add(lblLocal);
		
		JButton bt_buscar = new JButton("Buscar");
		bt_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					buscarSetor();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		bt_buscar.setBounds(51, 154, 96, 21);
		panel.add(bt_buscar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Resultados", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_1.setBounds(379, 38, 283, 229);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 33, 214, 168);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome do Setor", "Local"
			}
		));
		scrollPane.setViewportView(table);
	}

	protected void buscarSetor() throws ClassNotFoundException, SQLException {
		if((txf_nome.getText() == null || txf_nome.getText().isEmpty()) && (txf_local.getText() == null || txf_local.getText().isEmpty())) {
			JOptionPane.showMessageDialog(null, "Algum campo precisa está preenchido para buscar.");
			return;
		}
		
		SetorDao dao = new SetorDao();
		List<Setor> encontrados = new ArrayList<>();
		
		encontrados = dao.buscarSetor(txf_nome.getText(), txf_local.getText());
		
		DefaultTableModel modelo = new DefaultTableModel(new String[] {  "Nome do Setor", "Local" }, 0);
		
		for (int i = 0; i < encontrados.size(); i++) {
			Setor s = encontrados.get(i);
			

			modelo.addRow(new String[] { s.getNome(), s.getLocal() ,});
		}

		table.setModel(modelo);
		
	}
}
