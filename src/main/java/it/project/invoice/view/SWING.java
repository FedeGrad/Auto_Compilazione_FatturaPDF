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
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(502, 44, 447, 167);
		inserisciFattura.add(tabbedPane_1);
		
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
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(64);
		table.getColumnModel().getColumn(1).setPreferredWidth(103);
		table.setBounds(26, 212, 925, 329);
		inserisciFattura.add(table);
		
		JLabel lblNewLabel = new JLabel("Fattura numero");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(41, 25, 87, 13);
		inserisciFattura.add(lblNewLabel);
		
		JLabel lblInData = new JLabel("In data");
		lblInData.setHorizontalAlignment(SwingConstants.CENTER);
		lblInData.setBounds(168, 25, 87, 13);
		inserisciFattura.add(lblInData);
		
		JPanel modificaFattura = new JPanel();
		tabbedPane.addTab("Modifica Fattura", null, modificaFattura, null);
		modificaFattura.setLayout(null);
		
		JPanel eliminaFattura = new JPanel();
		tabbedPane.addTab("Elimina fattura", null, eliminaFattura, null);
	}
}
