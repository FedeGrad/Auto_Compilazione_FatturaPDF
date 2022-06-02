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
		
		JPanel panel = new JPanel();
		panel.setBounds(41, 44, 87, 31);
		inserisciFattura.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(169, 44, 87, 31);
		inserisciFattura.add(panel_1);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(502, 44, 447, 167);
		inserisciFattura.add(tabbedPane_1);
		
		txtFatturaNumero = new JTextField();
		txtFatturaNumero.setHorizontalAlignment(SwingConstants.CENTER);
		txtFatturaNumero.setText("Fattura numero");
		txtFatturaNumero.setBounds(41, 25, 87, 19);
		inserisciFattura.add(txtFatturaNumero);
		txtFatturaNumero.setColumns(10);
		
		txtInData = new JTextField();
		txtInData.setHorizontalAlignment(SwingConstants.CENTER);
		txtInData.setText("In data");
		txtInData.setColumns(10);
		txtInData.setBounds(169, 25, 87, 19);
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
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(53);
		table.getColumnModel().getColumn(1).setPreferredWidth(103);
		table.setBounds(41, 212, 910, 329);
		inserisciFattura.add(table);
		
		JPanel modificaFattura = new JPanel();
		tabbedPane.addTab("Modifica Fattura", null, modificaFattura, null);
		modificaFattura.setLayout(null);
		
		JPanel eliminaFattura = new JPanel();
		tabbedPane.addTab("Elimina fattura", null, eliminaFattura, null);
	}
}
