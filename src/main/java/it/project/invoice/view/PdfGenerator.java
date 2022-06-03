package it.project.invoice.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Label;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PdfGenerator {

	private JFrame frame;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PdfGenerator window = new PdfGenerator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public PdfGenerator() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 692, 508);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		frame.getContentPane().setLayout(null);
		
		Label label_1_2 = new Label("Descrizione servizio:");
		label_1_2.setForeground(Color.BLACK);
		label_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_1_2.setBounds(25, 219, 101, 16);
		frame.getContentPane().add(label_1_2);
		
		JTextPane ID = new JTextPane();
		ID.setBounds(159, 70, 47, 16);
		frame.getContentPane().add(ID);
		
		JButton btnNewButton = new JButton("Genera PDF");
		btnNewButton.setBounds(252, 407, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnChiudi = new JButton("Chiudi");
		btnChiudi.setBounds(381, 407, 101, 29);
		frame.getContentPane().add(btnChiudi);
		
		Label label = new Label("ID cliente");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label.setBounds(65, 70, 61, 16);
		frame.getContentPane().add(label);
		
		Label label_1 = new Label("Partita IVA");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_1.setBounds(25, 98, 101, 16);
		frame.getContentPane().add(label_1);
		
		JTextPane PIVA = new JTextPane();
		PIVA.setBounds(159, 98, 141, 16);
		frame.getContentPane().add(PIVA);
		
		JTextPane RAGIONE_SOCIALE = new JTextPane();
		RAGIONE_SOCIALE.setBounds(159, 129, 225, 16);
		frame.getContentPane().add(RAGIONE_SOCIALE);
		
		JTextPane INDIRIZZO = new JTextPane();
		INDIRIZZO.setBounds(159, 157, 225, 16);
		frame.getContentPane().add(INDIRIZZO);
		
		JTextPane CITTA = new JTextPane();
		CITTA.setBounds(396, 157, 141, 16);
		frame.getContentPane().add(CITTA);
		
		JTextPane CAP = new JTextPane();
		CAP.setBounds(548, 157, 75, 16);
		frame.getContentPane().add(CAP);
		
		Label label_1_1 = new Label("Dati cliente:");
		label_1_1.setForeground(Color.BLACK);
		label_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_1_1.setBounds(25, 129, 56, 15);
		frame.getContentPane().add(label_1_1);
		
		JTextPane DESCRIZIONE = new JTextPane();
		DESCRIZIONE.setBounds(159, 219, 464, 16);
		frame.getContentPane().add(DESCRIZIONE);
		
		JTextPane QUANTITA = new JTextPane();
		QUANTITA.setContentType("application/octet-stream");
		QUANTITA.setBounds(159, 247, 61, 16);
		frame.getContentPane().add(QUANTITA);
		
		Label label_1_2_1 = new Label("Quantità:");
		label_1_2_1.setForeground(Color.BLACK);
		label_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_1_2_1.setBounds(25, 247, 101, 16);
		frame.getContentPane().add(label_1_2_1);
		
		Label label_1_2_1_1 = new Label("Importo unitario:");
		label_1_2_1_1.setForeground(Color.BLACK);
		label_1_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_1_2_1_1.setBounds(251, 247, 101, 16);
		frame.getContentPane().add(label_1_2_1_1);
		
		Label label_1_2_1_1_1 = new Label("IVA");
		label_1_2_1_1_1.setForeground(Color.BLACK);
		label_1_2_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_1_2_1_1_1.setBounds(477, 282, 47, 16);
		frame.getContentPane().add(label_1_2_1_1_1);
		
		JTextPane IMPORTO_IVA = new JTextPane();
		IMPORTO_IVA.setContentType("application/octet-stream");
		IMPORTO_IVA.setBounds(580, 319, 83, 16);
		IMPORTO_IVA.setEditable(false);
		frame.getContentPane().add(IMPORTO_IVA);
	
		
		Label label_1_2_1_1_1_1 = new Label("Importo IVA:");
		label_1_2_1_1_1_1.setForeground(Color.BLACK);
		label_1_2_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_1_2_1_1_1_1.setBounds(477, 319, 92, 16);
		frame.getContentPane().add(label_1_2_1_1_1_1);
		
		Label label_1_2_1_1_1_1_1 = new Label("Totale:");
		label_1_2_1_1_1_1_1.setForeground(Color.BLACK);
		label_1_2_1_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_1_2_1_1_1_1_1.setBounds(477, 322, 47, 16);
		frame.getContentPane().add(label_1_2_1_1_1_1_1);
		
		//final JTextPane IMPORTO_TOTALE = new JTextPane();
		final JTextField TOTALE = new JTextField("0");
		//IMPORTO_TOTALE.setContentType("application/octet-stream");
		TOTALE.setBounds(580, 357, 83, 16);
		TOTALE.setEditable(false);
		frame.getContentPane().add(TOTALE);
		
		JTextPane IMPORTO_TOTALE = new JTextPane();
		IMPORTO_TOTALE.setContentType("application/octet-stream");
		IMPORTO_TOTALE.setBounds(580, 247, 83, 16);
		frame.getContentPane().add(IMPORTO_TOTALE);
		
		Label label_1_2_1_1_2 = new Label("Importo:");
		label_1_2_1_1_2.setForeground(Color.BLACK);
		label_1_2_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_1_2_1_1_2.setBounds(468, 247, 101, 16);
		frame.getContentPane().add(label_1_2_1_1_2);
		
		JTextPane IMPORTO = new JTextPane();
		IMPORTO.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				double quantita = Double.parseDouble(QUANTITA.getText());
				double valoreUnitario = Double.parseDouble(IMPORTO.getText());
				double importoTotale = (quantita * valoreUnitario);
				String s = Double.toString(importoTotale);
				IMPORTO_TOTALE.setText(s);
			}
		});
		IMPORTO.setContentType("application/octet-stream");
		IMPORTO.setBounds(385, 247, 61, 16);
		frame.getContentPane().add(IMPORTO);
		
		JTextPane PERCENTUALE_IVA = new JTextPane();
		PERCENTUALE_IVA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				double importo = Double.parseDouble(IMPORTO_TOTALE.getText());
				double valoreIva = Double.parseDouble(PERCENTUALE_IVA.getText());
				double importoIva = (importo * valoreIva)/100;
				String s = Double.toString(importoIva);
				IMPORTO_IVA.setText(s);
			
				double impTot = Double.parseDouble(IMPORTO_TOTALE.getText());
				double totGen = (impTot + importoIva);
				String tot = Double.toString(totGen);
				TOTALE.setText(tot);
				
			}
		});
		PERCENTUALE_IVA.setContentType("application/octet-stream");
		PERCENTUALE_IVA.setBounds(602, 282, 61, 16);
		frame.getContentPane().add(PERCENTUALE_IVA);
		
		Label label_1_2_1_1_1_1_2 = new Label("Importo totale:");
		label_1_2_1_1_1_1_2.setForeground(Color.BLACK);
		label_1_2_1_1_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_1_2_1_1_1_1_2.setBounds(477, 357, 92, 16);
		frame.getContentPane().add(label_1_2_1_1_1_1_2);
		

		
		/*
		 DocumentFilter df = new DocumentFilter() {
	            @Override
	            public void insertString(FilterBypass fb, int i, String string, AttributeSet as) throws BadLocationException {

	                if (isDigit(string)) {
	                    super.insertString(fb, i, string, as);
	                    calcAndSetTotal();
	                }
	            }

	            @Override
	            public void remove(FilterBypass fb, int i, int i1) throws BadLocationException {
	                super.remove(fb, i, i1);
	                calcAndSetTotal();
	            }

	            @Override
	            public void replace(FilterBypass fb, int i, int i1, String string, AttributeSet as) throws BadLocationException {
	                if (isDigit(string)) {
	                    super.replace(fb, i, i1, string, as);
	                    calcAndSetTotal();

	                }
	            }

	            private boolean isDigit(String string) {
	                for (int n = 0; n < string.length(); n++) {
	                    char c = string.charAt(n);//get a single character of the string
	                    //System.out.println(c);
	                    if (!Character.isDigit(c)) {//if its an alphabetic character or white space
	                        return false;
	                    }
	                }
	                return true;
	            }

	            void calcAndSetTotal() {
	                int sum = 0;

	                if (!PERCENTUALE_IVA.getText().isEmpty() || !IMPORTO_TOTALE.getText().isEmpty()) {
	                    
	                	sum += ((Integer.parseInt(IMPORTO_TOTALE.getText())) * (Integer.parseInt(PERCENTUALE_IVA.getText())))/100;
	                }
	               

	                IMPORTO_IVA.setText(String.valueOf(sum));
	            }
	        };
	        
	        frame.getContentPane().add(PERCENTUALE_IVA);
	        frame.pack();
	        frame.setVisible(true);
	      
		
		*/
		
	}
}

