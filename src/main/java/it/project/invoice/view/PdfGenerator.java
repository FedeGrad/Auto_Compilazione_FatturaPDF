package it.project.invoice.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfFormField;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;

import org.springframework.beans.factory.annotation.Autowired;

import it.project.invoice.dto.FatturaDTO;
import it.project.invoice.dto.RigaFatturaDTO;
import it.project.invoice.model.Citta;
import it.project.invoice.model.Cliente;
import it.project.invoice.model.Fattura;
import it.project.invoice.model.RigaFattura;
import it.project.invoice.repository.ArticoloRepository;
import it.project.invoice.repository.CittaRepository;
import it.project.invoice.service.FatturaService;
import it.project.invoice.service.RigaFatturaService;

import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import java.awt.event.KeyAdapter;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class PdfGenerator extends JFrame implements ActionListener {

	@Autowired
	FatturaService fatturaServ;
	@Autowired
	RigaFatturaService rigaFattServ;
	@Autowired
	ArticoloRepository articoloRepo;
	@Autowired
	CittaRepository cittaRepo;

	private static final long serialVersionUID = 1L;

	private JFrame frame = new JFrame("Invoice Generator");

	public static final String SRC = "src/pdf/matriceFattura.pdf";

	private JTextField importoIva;
	private JTextField valoreIva;
	private JTextField quantita;
	private JTextField prezzoUnitario;
	private JTextField totaleParziale;
	private JTextField valoreSconto;
	private JTextField importoSconto;
	private JTextField totaleGenerale;
	private JTextField NumFattura;
	private JTextField pIva;
	private JTextField ragioneSociale;
	private JTextField parzialeSingolo;
	private JTextField Indirizzo;
	private JTextField civico;
	private JTextField citta;
	private JTextField cap;
	private JTextField prov;
	private JTextField quantita2;
	private JTextField prezzoUnitario2;
	private JTextField parzialeSingolo2;
	private Timer timer;
	final JFileChooser fc = new JFileChooser();

	public PdfGenerator() throws IOException {
		initialize();
	}

	private void initialize() throws IOException {
		timer = new Timer(2000, this);
		timer.setInitialDelay(NORMAL);
		timer.start();
		frame.getContentPane().setFont(new Font("Lucida Grande", Font.PLAIN, 13));

		frame.setTitle("Invoice Generator");
		frame.setBounds(100, 100, 851, 595);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Genera PDF");
		btnNewButton.setBounds(251, 516, 117, 29);
		frame.getContentPane().add(btnNewButton);

		JButton btnChiudi = new JButton("Chiudi");
		btnChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnChiudi.setBounds(380, 516, 101, 29);
		frame.getContentPane().add(btnChiudi);

		JButton btnNewButton_1 = new JButton("+");

		btnNewButton_1.setBounds(648, 264, 25, 16);
		frame.getContentPane().add(btnNewButton_1);

		JLabel lblNumFattura = new JLabel();
		lblNumFattura.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNumFattura.setText("numero fattura");
		lblNumFattura.setBounds(45, 42, 101, 16);
		frame.getContentPane().add(lblNumFattura);

		JLabel lblData = new JLabel();
		lblData.setText("data fattura");
		lblData.setBounds(262, 42, 75, 16);
		frame.getContentPane().add(lblData);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(361, 31, 120, 26);
		frame.getContentPane().add(dateChooser);

		JLabel lblPIva = new JLabel();
		lblPIva.setText("P. IVA");
		lblPIva.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblPIva.setBounds(99, 80, 47, 16);
		frame.getContentPane().add(lblPIva);

		JLabel lblRagioneSociale = new JLabel();
		lblRagioneSociale.setText("Ragione Sociale");
		lblRagioneSociale.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblRagioneSociale.setBounds(25, 129, 122, 16);
		frame.getContentPane().add(lblRagioneSociale);

		JLabel lblIndirizzo = new JLabel();
		lblIndirizzo.setText("Indirizzo");
		lblIndirizzo.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblIndirizzo.setBounds(65, 157, 61, 16);
		frame.getContentPane().add(lblIndirizzo);

		JLabel lblNr = new JLabel();
		lblNr.setText("nr.");
		lblNr.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNr.setBounds(408, 157, 17, 16);
		frame.getContentPane().add(lblNr);

		JLabel lblCitt = new JLabel();
		lblCitt.setText("Città");
		lblCitt.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblCitt.setBounds(90, 185, 36, 16);
		frame.getContentPane().add(lblCitt);

		JLabel lblCap = new JLabel();
		lblCap.setText("CAP");
		lblCap.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblCap.setBounds(401, 185, 36, 16);
		frame.getContentPane().add(lblCap);

		JLabel lblPr = new JLabel();
		lblPr.setText("Prov.");
		lblPr.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblPr.setBounds(538, 185, 36, 16);
		frame.getContentPane().add(lblPr);

		JLabel lblQt = new JLabel();
		lblQt.setText("qt.");
		lblQt.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblQt.setBounds(112, 264, 25, 16);
		frame.getContentPane().add(lblQt);

		JLabel lblImpUnitario = new JLabel();
		lblImpUnitario.setText("imp. unitario");
		lblImpUnitario.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblImpUnitario.setBounds(246, 264, 83, 16);
		frame.getContentPane().add(lblImpUnitario);

		JLabel lblSelezionaOggetto = new JLabel();
		lblSelezionaOggetto.setText("Seleziona oggetto");
		lblSelezionaOggetto.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblSelezionaOggetto.setBounds(25, 236, 122, 16);
		frame.getContentPane().add(lblSelezionaOggetto);

		JLabel lblImpParziale = new JLabel();
		lblImpParziale.setText("imp. parziale");
		lblImpParziale.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblImpParziale.setBounds(441, 264, 83, 16);
		frame.getContentPane().add(lblImpParziale);

		JButton btnNewButton_1_1 = new JButton("-");
		btnNewButton_1_1.setVisible(false);
		btnNewButton_1_1.setBounds(648, 320, 25, 16);
		frame.getContentPane().add(btnNewButton_1_1);

		JLabel lblImpIva = new JLabel();
		lblImpIva.setText("IMPORTO IVA");
		lblImpIva.setBounds(627, 404, 91, 16);
		frame.getContentPane().add(lblImpIva);

		importoIva = new JTextField();
		importoIva.setEditable(false);
		importoIva.setBounds(727, 399, 100, 26);
		frame.getContentPane().add(importoIva);

		JLabel lblValIva = new JLabel();
		lblValIva.setText("% IVA");
		lblValIva.setBounds(493, 404, 43, 16);
		frame.getContentPane().add(lblValIva);

		valoreIva = new JTextField();
		valoreIva.setBounds(542, 399, 50, 26);
		frame.getContentPane().add(valoreIva);

		quantita = new JTextField();
		quantita.setBounds(159, 258, 50, 26);
		frame.getContentPane().add(quantita);

		JLabel lblTotParz = new JLabel();
		lblTotParz.setText("TOTALE PARZIALE");
		lblTotParz.setBounds(408, 357, 112, 16);
		frame.getContentPane().add(lblTotParz);

		prezzoUnitario = new JTextField();
		prezzoUnitario.setBounds(337, 258, 100, 26);
		frame.getContentPane().add(prezzoUnitario);
		prezzoUnitario.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (c == ',')
					e.setKeyChar('.');
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});

		totaleParziale = new JTextField();
		totaleParziale.setEditable(false);
		totaleParziale.setBounds(538, 352, 100, 26);
		frame.getContentPane().add(totaleParziale);

		parzialeSingolo = new JTextField();
		parzialeSingolo.setEditable(false);
		parzialeSingolo.setBounds(536, 258, 100, 26);
		frame.getContentPane().add(parzialeSingolo);

		JLabel lblSconto = new JLabel();
		lblSconto.setText("% SCONTO");
		lblSconto.setBounds(463, 436, 67, 16);
		frame.getContentPane().add(lblSconto);

		valoreSconto = new JTextField();
		valoreSconto.setBounds(542, 431, 50, 26);
		frame.getContentPane().add(valoreSconto);

		JLabel lblImportoSconto = new JLabel();
		lblImportoSconto.setText("IMPORTO SCONTO");
		lblImportoSconto.setBounds(596, 436, 119, 16);
		frame.getContentPane().add(lblImportoSconto);

		importoSconto = new JTextField();
		importoSconto.setEditable(false);
		importoSconto.setBounds(727, 431, 100, 26);
		frame.getContentPane().add(importoSconto);

		JLabel lblTotGen = new JLabel();
		lblTotGen.setText("TOTALE");
		lblTotGen.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblTotGen.setBounds(632, 478, 55, 16);
		frame.getContentPane().add(lblTotGen);

		totaleGenerale = new JTextField();
		totaleGenerale.setEditable(false);
		totaleGenerale.setBounds(699, 473, 128, 26);
		frame.getContentPane().add(totaleGenerale);

		NumFattura = new JTextField();
		NumFattura.setBounds(158, 42, 75, 16);
		frame.getContentPane().add(NumFattura);
		NumFattura.setColumns(10);

		pIva = new JTextField();
		pIva.setDocument(new LimitJTextField(11)); // la cella può contenere al massimo 11 caratteri
		pIva.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (c < '0' || c > '9' && c != KeyEvent.VK_BACK_SPACE) {
					e.consume(); // non fa inserire nessun dato diverso da un numero da 0 a 9
				}
			}
		});

		pIva.setColumns(10);
		pIva.setBounds(159, 80, 120, 16);
		frame.getContentPane().add(pIva);

		ragioneSociale = new JTextField();
		ragioneSociale.setColumns(10);
		ragioneSociale.setBounds(159, 129, 322, 16);
		frame.getContentPane().add(ragioneSociale);

		Indirizzo = new JTextField();
		Indirizzo.setColumns(10);
		Indirizzo.setBounds(158, 157, 226, 16);
		frame.getContentPane().add(Indirizzo);

		civico = new JTextField();
		civico.setColumns(10);
		civico.setBounds(447, 157, 61, 16);
		frame.getContentPane().add(civico);

		citta = new JTextField();
		citta.setColumns(10);
		citta.setBounds(159, 185, 226, 16);
		frame.getContentPane().add(citta);

		cap = new JTextField();
		cap.setDocument(new LimitJTextField(5)); // la cella può contenere al massimo 5 caratteri
		cap.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (c < '0' || c > '9' && c != KeyEvent.VK_BACK_SPACE) {
					e.consume(); // non fa inserire nessun dato diverso da un numero da 0 a 9
				}
			}
		});
		cap.setColumns(10);
		cap.setBounds(449, 185, 61, 16);
		frame.getContentPane().add(cap);

		prov = new JTextField();
		prov.setColumns(10);
		prov.setBounds(575, 185, 61, 16);
		frame.getContentPane().add(prov);

		// sostituire con l'elenco di prodotti nel DB e effettuare gli appositi
		// controlli
		String[] items = { "- seleziona oggetto", "Oggetto 1", "Oggetto 2", "Oggetto 3", "Oggetto 4" };
		JComboBox comboBox = new JComboBox(items);
		comboBox.setBounds(159, 232, 178, 27);
		frame.getContentPane().add(comboBox);

		// sostituire con l'elenco di prodotti nel DB e effettuare gli appositi
		// controlli
		String[] items2 = { "- seleziona servizio", "Servizio 1", "Servizio 2" };
		JComboBox comboBox_1 = new JComboBox(items2);
		comboBox_1.setVisible(false);
		comboBox_1.setBounds(159, 292, 178, 27);
		frame.getContentPane().add(comboBox_1);

		JLabel lblQt_1 = new JLabel();
		lblQt_1.setVisible(false);
		lblQt_1.setText("qt.");
		lblQt_1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblQt_1.setBounds(112, 324, 25, 16);
		frame.getContentPane().add(lblQt_1);

		quantita2 = new JTextField();
		quantita2.setVisible(false);
		quantita2.setBounds(159, 318, 50, 26);
		frame.getContentPane().add(quantita2);

		JLabel lblImpUnitario_1 = new JLabel();
		lblImpUnitario_1.setVisible(false);
		lblImpUnitario_1.setText("imp. unitario");
		lblImpUnitario_1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblImpUnitario_1.setBounds(246, 324, 83, 16);
		frame.getContentPane().add(lblImpUnitario_1);

		prezzoUnitario2 = new JTextField();
		prezzoUnitario2.setVisible(false);
		prezzoUnitario2.setBounds(337, 318, 100, 26);
		frame.getContentPane().add(prezzoUnitario2);
		prezzoUnitario2.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (c == ',')
					e.setKeyChar('.');
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});

		DocumentListener documentListener = new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				calcoloImportoTotale(null);
				calcoloImportoParziale(null);
				calcoloIva(null);
				calcoloSconto(null);
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				calcoloImportoTotale(null);
				calcoloImportoParziale(null);
				calcoloIva(null);
				calcoloSconto(null);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		};

		DocumentFilter numericFilter = new DocumentFilter() {
			// filtra le textbox in modo da accettare solo numeri e il "."
			@Override
			public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
					throws BadLocationException {
				fb.insertString(offset, string.replaceAll("[^\\d].", ""), attr);
			}

			// filtra le textbox in modo da accettare solo numeri e il "."
			@Override
			public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
					throws BadLocationException {
				fb.replace(offset, length, text.replaceAll("[^\\d].", ""), attrs);
			}
		};

		((AbstractDocument) quantita.getDocument()).setDocumentFilter(numericFilter);
		((AbstractDocument) prezzoUnitario.getDocument()).setDocumentFilter(numericFilter);
		((AbstractDocument) valoreIva.getDocument()).setDocumentFilter(numericFilter);
		((AbstractDocument) valoreSconto.getDocument()).setDocumentFilter(numericFilter);
		((AbstractDocument) quantita2.getDocument()).setDocumentFilter(numericFilter);
		((AbstractDocument) prezzoUnitario2.getDocument()).setDocumentFilter(numericFilter);

		quantita.getDocument().addDocumentListener(documentListener);
		prezzoUnitario.getDocument().addDocumentListener(documentListener);
		valoreIva.getDocument().addDocumentListener(documentListener);
		valoreSconto.getDocument().addDocumentListener(documentListener);
		quantita2.getDocument().addDocumentListener(documentListener);
		prezzoUnitario2.getDocument().addDocumentListener(documentListener);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JLabel lblImpParziale_1 = new JLabel();
		lblImpParziale_1.setVisible(false);
		lblImpParziale_1.setText("imp. parziale");
		lblImpParziale_1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblImpParziale_1.setBounds(441, 324, 83, 16);
		frame.getContentPane().add(lblImpParziale_1);

		parzialeSingolo2 = new JTextField();
		parzialeSingolo2.setVisible(false);
		parzialeSingolo2.setEditable(false);
		parzialeSingolo2.setBounds(536, 318, 100, 26);
		frame.getContentPane().add(parzialeSingolo2);

		JLabel lblSelezionaOggetto_1 = new JLabel();
		lblSelezionaOggetto_1.setVisible(false);
		lblSelezionaOggetto_1.setText("Seleziona oggetto");
		lblSelezionaOggetto_1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblSelezionaOggetto_1.setBounds(25, 296, 122, 16);
		frame.getContentPane().add(lblSelezionaOggetto_1);

		JLabel message = new JLabel();
		message.setForeground(Color.RED);
		message.setBounds(65, 436, 279, 16);
		frame.getContentPane().add(message);

		// tasto "+" che aggiunge una riga
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblSelezionaOggetto_1.setVisible(true);
				comboBox_1.setVisible(true);
				lblQt_1.setVisible(true);
				quantita2.setVisible(true);
				lblImpUnitario_1.setVisible(true);
				prezzoUnitario2.setVisible(true);
				lblImpParziale_1.setVisible(true);
				parzialeSingolo2.setVisible(true);
				btnNewButton_1_1.setVisible(true);
				btnNewButton_1.setVisible(false);
				items2[0] = "- seleziona oggetto";
			}
		});

		// tasto "-" che elimina una riga
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quantita2.setText("");
				prezzoUnitario2.setText("");
				parzialeSingolo2.setText("");
				lblSelezionaOggetto_1.setVisible(false);
				comboBox_1.setVisible(false);
				lblQt_1.setVisible(false);
				quantita2.setVisible(false);
				lblImpUnitario_1.setVisible(false);
				prezzoUnitario2.setVisible(false);
				lblImpParziale_1.setVisible(false);
				parzialeSingolo2.setVisible(false);
				btnNewButton_1_1.setVisible(false);
				btnNewButton_1.setVisible(true);
				items2[0] = "";
			}
		});

		NumFattura.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String s = NumFattura.getText();
				if (s.length() != -1) {
					message.setText("");
					NumFattura.setBackground(Color.WHITE);
				}
			}
		});

		pIva.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String s = pIva.getText();
				if (s.length() != -1) {
					message.setText("");
					pIva.setBackground(Color.WHITE);
				}
			}
		});

		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String oggetto = (String) comboBox.getSelectedItem();
				if (oggetto != "- seleziona oggetto") {
					message.setText("");
					comboBox.setBorder(new LineBorder(Color.WHITE));
					return;
				}
			}
		});

		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String oggetto = (String) comboBox_1.getSelectedItem();
				if (oggetto != "- seleziona servizio") {
					message.setText("");
					comboBox_1.setBorder(new LineBorder(Color.WHITE));
					return;
				}
			}
		});

		quantita.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String s = quantita.getText();
				if (s.length() != -1) {
					message.setText("");
					quantita.setBackground(Color.WHITE);
				}
			}
		});

		prezzoUnitario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String s = prezzoUnitario.getText();
				if (s.length() != -1) {
					message.setText("");
					prezzoUnitario.setBackground(Color.WHITE);
				}
			}
		});

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String s = NumFattura.getText();
				if (s.length() == 0) {
					message.setText("The number of invoice is required!");
					NumFattura.setBackground(Color.RED);
					return;
				}

				if (dateChooser.getDate() == null) {
					message.setText("The date is a required field!");
					dateChooser.setBackground(Color.RED);
					return;
				}

				String iva = pIva.getText();
				if (iva.length() < 11) {
					message.setText("The number of P.IVA has to be of 11 digits!");
					pIva.setBackground(Color.RED);
					return;
				}

				String oggetto = (String) comboBox.getSelectedItem();
				if (oggetto == "" || oggetto == "- seleziona oggetto") {
					message.setText("Please select at least one product!");
					comboBox.setBorder(new LineBorder(Color.RED));
					return;
				}

				String oggetto2 = (String) comboBox_1.getSelectedItem();
				if (oggetto2 == "- seleziona servizio" && !btnNewButton_1.isVisible()) {
					message.setText("Please select at least one product!");
					comboBox_1.setBorder(new LineBorder(Color.RED));
					return;
				}

				String qt = quantita.getText();
				if (qt.length() == 0) {
					message.setText("A quantity is required!");
					quantita.setBackground(Color.RED);
					return;
				}

				String prezzo = prezzoUnitario.getText();
				if (prezzo.length() == 0) {
					message.setText("A price per unit is required!");
					prezzoUnitario.setBackground(Color.RED);
					return;
				}

				// generatore di PDF
				if (e.getSource() == btnNewButton) {
					int returnVal = fc.showSaveDialog(PdfGenerator.this);
					if (returnVal == JFileChooser.APPROVE_OPTION) {

						File pdfDaSalvare = new File(fc.getSelectedFile() + ".pdf");
						PdfDocument pdf = null;
						try {

							pdf = new PdfDocument(new PdfReader(SRC), new PdfWriter(pdfDaSalvare));

						} catch (FileNotFoundException e1) {

							e1.printStackTrace();
						} catch (IOException e1) {

							e1.printStackTrace();
						}

						SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
						String data = dataFormat.format(dateChooser.getDate());

						PdfAcroForm form = PdfAcroForm.getAcroForm(pdf, true);
						Map<String, PdfFormField> fields = form.getFormFields();
						FatturaDTO newFattura = new FatturaDTO();
						Cliente newCliente = new Cliente();
						fields.get("nr_fattura").setValue(NumFattura.getText());
						// newFattura.setNumeroFattura();
						fields.get("data_fattura").setValue(data);
						// newFattura.setDataFattura();

						fields.get("cliente").setValue(ragioneSociale.getText());
						// newCliente.setNome();
						fields.get("piva").setValue(pIva.getText());
						// newCliente.setPIVA();
						fields.get("indirizzo").setValue(Indirizzo.getText());
						// newCliente.setIndirizzo();
						fields.get("civico").setValue(civico.getText());
						// newCliente.setCivico();

						fields.get("CAP").setValue(cap.getText());
						fields.get("citta").setValue(citta.getText());
						fields.get("prov").setValue(prov.getText());
						// Citta cittaTrov = cittaRepo.findByNome();
						// newCliente.setCitta(cittaTrov);

						// fields.get("id").setValue(XXXX.getText());
						RigaFatturaDTO riga1 = new RigaFatturaDTO();
						fields.get("descrizione").setValue((String) comboBox.getSelectedItem());
						fields.get("quantita").setValue(quantita.getText());
						fields.get("prezzo_unitario").setValue(prezzoUnitario.getText());
						fields.get("prezzo_parziale").setValue(parzialeSingolo.getText());
						// riga1.setNomeArticolo();
						// riga1.setQuantita();
						// riga1.setPrezzoUnitario();
						// riga1.setImportoParziale();
						// RigaFattura rigaUNO = rigaFattServ.associaRigheFattura(riga1);

						// fields.get("id1").setValue(XXXX.getText());
						RigaFatturaDTO riga2 = new RigaFatturaDTO();
						fields.get("descrizione1").setValue((String) comboBox_1.getSelectedItem());
						fields.get("quantita1").setValue(quantita2.getText());
						fields.get("prezzo_unitario1").setValue(prezzoUnitario2.getText());
						fields.get("prezzo_parziale1").setValue(parzialeSingolo2.getText());
						// riga2.setNomeArticolo();
						// riga2.setQuantita();
						// riga2.setPrezzoUnitario();
						// riga2.setImportoParziale();
						// RigaFattura rigaDUE = rigaFattServ.associaRigheFattura(riga2);

						// field.get all prize and IVA
						fields.get("totale_parziale").setValue(totaleParziale.getText());
						// newFattura.setTotaleParziale();
						fields.get("percentuale_iva").setValue(valoreIva.getText());
						fields.get("importo_iva").setValue(importoIva.getText());
						// newFattura.setIVA();
						fields.get("percentuale_sconto").setValue(valoreSconto.getText());
						fields.get("importo_sconto").setValue(importoSconto.getText());
						// newFattura.setSconto();
						fields.get("totale_generale").setValue(totaleGenerale.getText());
						// newFattura.setTotaleGenerale();
						form.flattenFields();
						pdf.close();

						// fatturaServ.inserisciFattura(newFattura, rigaUNO, rigaDUE);
					}
				}
			}
		});
	}

	class LimitJTextField extends PlainDocument {
		private int max;

		LimitJTextField(int max) {
			super();
			this.max = max;
		}

		public void insertString(int offset, String text, AttributeSet attr) throws BadLocationException {
			if (text == null)
				return;
			if ((getLength() + text.length()) <= max) {
				super.insertString(offset, text, attr);
			}
		}
	}

	private void calcoloImportoTotale(ActionEvent evt) {
		DecimalFormat df = new DecimalFormat("###,###,##0.00");
		double total = 0;
		if (totaleParziale.getText().trim().length() > 0) {
			try {
				total += Double.parseDouble(quantita.getText()) * Double.parseDouble(prezzoUnitario.getText());
			} catch (NumberFormatException nbx) {
			}
		}

		if (parzialeSingolo2.getText().trim().length() > 0) {
			try {
				total += Double.parseDouble(quantita2.getText()) * Double.parseDouble(prezzoUnitario2.getText());
			} catch (NumberFormatException nbx) {
			}
		}

		if (importoIva.getText().trim().length() > 0) {
			try {
				total += ((Double.parseDouble(quantita.getText()) * (Double.parseDouble(prezzoUnitario.getText()))
						* (Double.parseDouble(valoreIva.getText())))) / 100;
			} catch (NumberFormatException nbx) {
			}
		}

		if (importoSconto.getText().trim().length() > 0) {
			try {
				total -= ((Double.parseDouble(quantita.getText()) * (Double.parseDouble(prezzoUnitario.getText()))
						* (Double.parseDouble(valoreSconto.getText())))) / 100;
			} catch (NumberFormatException nbx) {
			}
		}

		String testoFormattato = df.format(total);
		totaleGenerale.setText(testoFormattato);

	}

	private void calcoloIva(ActionEvent evt) {
		DecimalFormat df = new DecimalFormat("###,###,##0.00");
		double total = 0;
		double total2 = 0;
		double total3 = 0;
		if (totaleParziale.getText().trim().length() > 0) {
			try {
				total = Double.parseDouble(quantita.getText()) * Double.parseDouble(prezzoUnitario.getText());
				total2 = total * (Double.parseDouble(valoreIva.getText()));
				total3 = total2 / 100;
			} catch (NumberFormatException nbx) {
			}
		}

		if (parzialeSingolo2.getText().trim().length() > 0) {
			try {
				total3 += ((Double.parseDouble(quantita2.getText()) * Double.parseDouble(prezzoUnitario2.getText()))
						* (Double.parseDouble(valoreIva.getText()))) / 100;
			} catch (NumberFormatException nbx) {
			}
		}
		String testoFormattato = df.format(total3);
		importoIva.setText(testoFormattato);
	}

	private void calcoloSconto(ActionEvent evt) {
		DecimalFormat df = new DecimalFormat("###,###,##0.00");
		double total = 0;
		double total2 = 0;
		double total3 = 0;
		if (totaleParziale.getText().trim().length() > 0) {
			try {
				total = Double.parseDouble(quantita.getText()) * Double.parseDouble(prezzoUnitario.getText());
				total2 = total * (Double.parseDouble(valoreSconto.getText()));
				total3 = total2 / 100;
			} catch (NumberFormatException nbx) {
			}
		}
		if (parzialeSingolo2.getText().trim().length() > 0) {
			try {
				total3 += ((Double.parseDouble(quantita2.getText()) * Double.parseDouble(prezzoUnitario2.getText()))
						* (Double.parseDouble(valoreSconto.getText()))) / 100;
			} catch (NumberFormatException nbx) {
			}
		}
		String testoFormattato = df.format(total3);
		importoSconto.setText(testoFormattato);
	}

	private void calcoloImportoParziale(ActionEvent evt) {
		DecimalFormat df = new DecimalFormat("###,###,##0.00");
		double total = 0;
		double total2 = 0;

		if (quantita.getText().trim().length() > 0) {
			try {
				total = Double.parseDouble(quantita.getText()) * Double.parseDouble(prezzoUnitario.getText());
			} catch (NumberFormatException nbx) {
			}
		}
		if (quantita2.getText().trim().length() > 0) {
			try {
				total2 = Double.parseDouble(quantita2.getText()) * Double.parseDouble(prezzoUnitario2.getText());
			} catch (NumberFormatException nbx) {
			}
		}

		String testoFormattato = df.format(total + total2);
		totaleParziale.setText(testoFormattato);

	}

	public static void main(String[] args) throws IOException {
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

	@Override
	public void actionPerformed(ActionEvent e) {
		DecimalFormat df = new DecimalFormat("###,###,##0.00");
		double tot = 0;
		DecimalFormat df2 = new DecimalFormat("###,###,##0.00");
		double tot2 = 0;
		if (quantita.getText().trim().length() > 0) {
			try {
				tot = Double.parseDouble(quantita.getText()) * Double.parseDouble(prezzoUnitario.getText());
			} catch (NumberFormatException nbx) {
			}
		}
		if (quantita2.getText().trim().length() > 0) {
			try {
				tot2 = Double.parseDouble(quantita2.getText()) * Double.parseDouble(prezzoUnitario2.getText());
			} catch (NumberFormatException nbx) {
			}
		}
		String testoFormattato = df.format(tot);
		parzialeSingolo.setText(testoFormattato);
		String testoFormattato2 = df2.format(tot2);
		parzialeSingolo2.setText(testoFormattato2);

	}
}