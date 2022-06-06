package it.project.invoice.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfFormField;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;

import org.springframework.beans.factory.annotation.Autowired;

import it.project.invoice.repository.FatturaRepository;
import it.project.invoice.repository.RigaFatturaRepository;

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
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;

public class PdfGenerator2 {
	
	@Autowired
	FatturaRepository fatturaRepo;
	@Autowired
	RigaFatturaRepository rigaFatRepo;

	private JFrame frame;
	
	public static final String SRC = "src/pdf/provapdf.pdf";
	public static final String DEST = "src/pdf/fattura.pdf";

	public static void main(String[] args) throws IOException {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PdfGenerator2 window = new PdfGenerator2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PdfGenerator2() throws IOException {
		initialize();
	}

	@SuppressWarnings("deprecation")
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 1107, 708);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		frame.getContentPane().setLayout(null);
		
		Label label_1_2 = new Label("Descrizione servizio:");
		label_1_2.setBounds(522, 229, 101, 16);
		label_1_2.setForeground(Color.BLACK);
		label_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frame.getContentPane().add(label_1_2);
		
		JTextPane ID = new JTextPane();
		ID.setBounds(929, 70, 47, 16);
		frame.getContentPane().add(ID);
		
		JButton btnNewButton = new JButton("Genera PDF");
		btnNewButton.setBounds(820, 494, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnChiudi = new JButton("Chiudi");
		btnChiudi.setBounds(971, 494, 101, 29);
		btnChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnChiudi);
		
		Label label = new Label("ID cliente");
		label.setBounds(852, 70, 61, 16);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frame.getContentPane().add(label);
		
		Label label_1 = new Label("Partita IVA");
		label_1.setBounds(836, 112, 101, 16);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frame.getContentPane().add(label_1);
		
		JTextPane PIVA = new JTextPane();
		PIVA.setBounds(931, 112, 141, 16);
		frame.getContentPane().add(PIVA);
		
		JTextPane RAGIONE_SOCIALE = new JTextPane();
		RAGIONE_SOCIALE.setBounds(858, 157, 225, 16);
		frame.getContentPane().add(RAGIONE_SOCIALE);
		
		JTextPane INDIRIZZO = new JTextPane();
		INDIRIZZO.setBounds(617, 203, 225, 16);
		frame.getContentPane().add(INDIRIZZO);
		
		JTextPane CITTA = new JTextPane();
		CITTA.setBounds(867, 203, 141, 16);
		frame.getContentPane().add(CITTA);
		
		JTextPane CAP = new JTextPane();
		CAP.setBounds(1018, 203, 75, 16);
		frame.getContentPane().add(CAP);
		
		Label label_1_1 = new Label("Dati cliente:");
		label_1_1.setBounds(787, 158, 56, 15);
		label_1_1.setForeground(Color.BLACK);
		label_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frame.getContentPane().add(label_1_1);
		
		JTextPane DESCRIZIONE = new JTextPane();
		DESCRIZIONE.setBounds(629, 229, 464, 16);
		frame.getContentPane().add(DESCRIZIONE);
		
		JTextPane QUANTITA = new JTextPane();
		QUANTITA.setBounds(787, 304, 61, 16);
		QUANTITA.setContentType("application/octet-stream");
		frame.getContentPane().add(QUANTITA);
		
		Label label_1_2_1 = new Label("Quantità:");
		label_1_2_1.setBounds(703, 304, 101, 16);
		label_1_2_1.setForeground(Color.BLACK);
		label_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frame.getContentPane().add(label_1_2_1);
		
		Label label_1_2_1_1 = new Label("Importo unitario:");
		label_1_2_1_1.setBounds(596, 263, 101, 16);
		label_1_2_1_1.setForeground(Color.BLACK);
		label_1_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frame.getContentPane().add(label_1_2_1_1);
		
		Label label_1_2_1_1_1 = new Label("IVA");
		label_1_2_1_1_1.setBounds(906, 282, 47, 16);
		label_1_2_1_1_1.setForeground(Color.BLACK);
		label_1_2_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frame.getContentPane().add(label_1_2_1_1_1);
		
		JTextPane IMPORTO_IVA = new JTextPane();
		IMPORTO_IVA.setBounds(989, 357, 83, 16);
		IMPORTO_IVA.setContentType("application/octet-stream");
		IMPORTO_IVA.setEditable(false);
		frame.getContentPane().add(IMPORTO_IVA);
	
		Label label_1_2_1_1_1_1 = new Label("Importo IVA:");
		label_1_2_1_1_1_1.setBounds(884, 357, 92, 16);
		label_1_2_1_1_1_1.setForeground(Color.BLACK);
		label_1_2_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frame.getContentPane().add(label_1_2_1_1_1_1);
		
		Label label_1_2_1_1_1_1_1 = new Label("Totale:");
		label_1_2_1_1_1_1_1.setBounds(906, 319, 47, 16);
		label_1_2_1_1_1_1_1.setForeground(Color.BLACK);
		label_1_2_1_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frame.getContentPane().add(label_1_2_1_1_1_1_1);
		
		//final JTextPane IMPORTO_TOTALE = new JTextPane();
		final JTextField TOTALE = new JTextField("0");
		TOTALE.setBounds(1010, 413, 83, 16);
		TOTALE.setEditable(false);
		frame.getContentPane().add(TOTALE);
		
		JTextPane IMPORTO_TOTALE = new JTextPane();
		IMPORTO_TOTALE.setBounds(1000, 282, 83, 16);
		IMPORTO_TOTALE.setEditable(false);
		IMPORTO_TOTALE.setContentType("application/octet-stream");
		frame.getContentPane().add(IMPORTO_TOTALE);
		
		Label label_1_2_1_1_2 = new Label("Importo:");
		label_1_2_1_1_2.setBounds(781, 263, 101, 16);
		label_1_2_1_1_2.setForeground(Color.BLACK);
		label_1_2_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frame.getContentPane().add(label_1_2_1_1_2);
		
		JTextPane IMPORTO = new JTextPane();
		IMPORTO.setBounds(703, 263, 61, 16);
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
		frame.getContentPane().add(IMPORTO);
		
		JTextPane PERCENTUALE_IVA = new JTextPane();
		PERCENTUALE_IVA.setBounds(1022, 319, 61, 16);
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
		frame.getContentPane().add(PERCENTUALE_IVA);
		
		Label label_1_2_1_1_1_1_2 = new Label("Importo totale:");
		label_1_2_1_1_1_1_2.setBounds(884, 407, 92, 16);
		label_1_2_1_1_1_1_2.setForeground(Color.BLACK);
		label_1_2_1_1_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frame.getContentPane().add(label_1_2_1_1_1_1_2);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(20, 31, 492, 492);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);
		
		Label label_2 = new Label("ID cliente");
		label_2.setBounds(31, 10, 62, 22);
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		panel_2.add(label_2);
		
		
		PdfDocument pdf = new PdfDocument(new PdfReader(SRC), new PdfWriter(DEST));
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PdfAcroForm form = PdfAcroForm.getAcroForm(pdf, true);
				Map<String, PdfFormField> fields = form.getFormFields();
				fields.get("numero_fattura").setValue(ID.getText());
				fields.get("cliente").setValue(RAGIONE_SOCIALE.getText());
				fields.get("servizio").setValue(DESCRIZIONE.getText());
				fields.get("prezzo").setValue(IMPORTO.getText());
				fields.get("quantita").setValue(QUANTITA.getText());
				fields.get("prezzo_parziale").setValue(IMPORTO_TOTALE.getText());
				fields.get("iva").setValue(PERCENTUALE_IVA.getText());
//				fields.get("importo_iva").setValue(IMPORTO_IVA.getText());
//				fields.get("importo_totale").setValue(TOTALE.getText());
				pdf.close();
			}
		});
		

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