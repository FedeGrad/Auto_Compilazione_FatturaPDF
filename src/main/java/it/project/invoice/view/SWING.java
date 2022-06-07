package it.project.invoice.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;

public class SWING {

	private JFrame frame;
	private JTextField txtFatturaNumero;
	private JTextField txtInData;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SWING window = new SWING();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SWING() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 760);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1010, 723);
		frame.getContentPane().add(tabbedPane);
		
		JPanel inserisciFattura = new JPanel();
		tabbedPane.addTab("Inserisci Fattura", null, inserisciFattura, null);
		inserisciFattura.setLayout(null);
		
		txtFatturaNumero = new JTextField();
		txtFatturaNumero.setHorizontalAlignment(SwingConstants.CENTER);
		txtFatturaNumero.setBounds(41, 44, 87, 41);
		inserisciFattura.add(txtFatturaNumero);
		txtFatturaNumero.setColumns(10);
		
		txtInData = new JTextField();
		txtInData.setHorizontalAlignment(SwingConstants.CENTER);
		txtInData.setColumns(10);
		txtInData.setBounds(168, 44, 87, 41);
		inserisciFattura.add(txtInData);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Cod. Art.", "Descrizione", "Q.ta", "Prezzo Unitario", "Sconto", "Importo", "IVA"
			}
		) {
			Class[] columnTypes = new Class[] {
				Long.class, Object.class, Integer.class, Double.class, Float.class, Double.class, Float.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(80);
		table.getColumnModel().getColumn(6).setPreferredWidth(50);
		table.setBounds(24, 245, 925, 349);
		inserisciFattura.add(table);
		
		JLabel lblNewLabel = new JLabel("Fattura numero");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(41, 25, 87, 13);
		inserisciFattura.add(lblNewLabel);
		
		JLabel lblInData = new JLabel("In data");
		lblInData.setHorizontalAlignment(SwingConstants.CENTER);
		lblInData.setBounds(168, 25, 87, 13);
		inserisciFattura.add(lblInData);
		
		JLabel lblNewLabel_1 = new JLabel("Cod. Articolo");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(24, 222, 104, 13);
		inserisciFattura.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Descrizione");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(180, 222, 104, 13);
		inserisciFattura.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Quantità");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setBounds(348, 222, 104, 13);
		inserisciFattura.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Prezzo unitario");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setBounds(469, 222, 104, 13);
		inserisciFattura.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Sconto");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setBounds(592, 221, 104, 13);
		inserisciFattura.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Importo");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setBounds(715, 221, 104, 13);
		inserisciFattura.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("IVA");
		lblNewLabel_1_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_6.setBounds(845, 221, 104, 13);
		inserisciFattura.add(lblNewLabel_1_6);
		
		JPanel modificaFattura = new JPanel();
		tabbedPane.addTab("Modifica Fattura", null, modificaFattura, null);
		modificaFattura.setLayout(null);
		
		JPanel eliminaFattura = new JPanel();
		tabbedPane.addTab("Elimina fattura", null, eliminaFattura, null);
	}
}
