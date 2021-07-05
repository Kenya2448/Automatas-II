package codigo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;



public class Ventana extends JFrame implements ActionListener{
                    ArrayList<String> lista;
	
	Scanner s = new Scanner(System.in);
	
	private JTextField txt1;
	private JButton btnAnalizar, btnBorrar, btnImprimir, btnSalir;
	private JTextArea ta1,ta2,ta3;
	private JScrollPane scroll, scroll2,scroll3;
	private JPanel panel;
	private JMenuBar menubarra;
	private JMenu menuArchivo, acercaDe;
	private JMenuItem menuArchivoItem1, acercaDeItem1;
                    private JTable tabla;
	Ventana(){
		
		
		hazComponentes();
		hazInterfaz();
	}


	private void hazInterfaz() {
		
		//Ventana
		setTitle("Java Comp");
		setSize(800,800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(46, 64, 83));
		setIconImage(new ImageIcon("D:/Documents/AnalizadorLexico/src/res/hacked.png").getImage());
		setResizable(false);
		setLayout(null);
		setVisible(true);
                                        
		
	}
	
	private void hazComponentes() {
		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
		Border border2 = BorderFactory.createLineBorder(Color.WHITE, 1);
		//Barra de Menú
		menubarra = new JMenuBar();
		setJMenuBar(menubarra);
		
		//Menu Archivo
		menuArchivo = new JMenu("Archivo");
		menubarra.add(menuArchivo);
		
		//Menu Item "Cargar Archivo"
		menuArchivoItem1 = new JMenuItem("Cargar Archivo");
		menuArchivoItem1.addActionListener(this);
		menuArchivo.add(menuArchivoItem1);
		
		//Menu "Acerca De"
		acercaDe = new JMenu("Acerca De");
		menubarra.add(acercaDe);
		
		acercaDeItem1 = new JMenuItem("Versión 1.0.0 © 2020, Java Comp, All Rights Reserved ");
		acercaDe.add(acercaDeItem1);
		
		//Cuadro de texto principal
		ta1 = new JTextArea(16,58);
		ta1.setBackground(Color.WHITE);
		ta1.setSize(100,100);
		ta1.setLineWrap(true);
		ta1.setWrapStyleWord(true);
		ta1.setVisible(true);
		ta1.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 18));
		ta1.setToolTipText("Código");
		scroll = new JScrollPane(ta1);
		scroll.setBounds(20, 20, 600, 300);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBorder(border);
		getContentPane().add(scroll);
		
		//Cuadro de texto secundario
		ta2 = new JTextArea(16,58);
		ta2.setBackground(Color.WHITE);
		ta2.setSize(100,100);
		ta2.setLineWrap(true);
		ta2.setWrapStyleWord(true);
		ta2.setVisible(true);
		ta2.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 18));
		ta2.setEditable(false);
		scroll2 = new JScrollPane(ta2);
		scroll2.setBounds(20, 335, 600, 180);
		scroll2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll2.setBorder(border);
		getContentPane().add(scroll2);
                                        
                                        //Cuadro de texto terciario
		ta3 = new JTextArea(16,58);
		ta3.setBackground(Color.WHITE);
		ta3.setSize(100,100);
		ta3.setLineWrap(true);
		ta3.setWrapStyleWord(true);
		ta3.setVisible(true);
		ta3.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 18));
		ta3.setEditable(false);
		scroll3 = new JScrollPane(ta3);
		scroll3.setBounds(20, 530, 600, 180);
		scroll3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll3.setBorder(border);
		getContentPane().add(scroll3);
		
		//Botones
		btnAnalizar = new JButton();
		btnAnalizar.setBackground(Color.WHITE);
		btnAnalizar.setBounds(650,20,115,50);
		btnAnalizar.setIcon(new ImageIcon("D:/Documents/AnalizadorLexico/src/res/play-button-inside-a-rectangle.png"));
		btnAnalizar.setToolTipText("Ejecutar");
		btnAnalizar.setHorizontalAlignment(SwingConstants.CENTER);
		btnAnalizar.setBorder(border2);
		btnAnalizar.setRolloverEnabled(true);
		btnAnalizar.setRolloverIcon(new ImageIcon("D:/Documents/AnalizadorLexico/src/res/picc.png"));
		btnAnalizar.setVisible(true);
		btnAnalizar.addActionListener(this);
		add(btnAnalizar);
		
		btnBorrar = new JButton(); //#1550e3 BLUE
		btnBorrar.setBackground(Color.WHITE);
		btnBorrar.setBounds(650,85,115,50);
		btnBorrar.setIcon(new ImageIcon("D:/Documents/AnalizadorLexico/src/res/tcan.png"));
		btnBorrar.setRolloverEnabled(true);
		btnBorrar.setRolloverIcon(new ImageIcon("D:/Documents/AnalizadorLexico/src/res/tcanb.png"));
		btnBorrar.setBorder(border);
		btnBorrar.addActionListener(this);
		add(btnBorrar);
                                        
                                        btnImprimir = new JButton(); //#1550e3 BLUE
		btnImprimir.setBackground(Color.WHITE);
		btnImprimir.setBounds(650,150,115,50);
		btnImprimir.setIcon(new ImageIcon("D:/Documents/AnalizadorLexico/src/res/lupa.png"));
		btnImprimir.setRolloverEnabled(true);
		btnImprimir.setRolloverIcon(new ImageIcon("D:/Documents/AnalizadorLexico/src/res/lupa2.png"));
		btnImprimir.setBorder(border);
		btnImprimir.addActionListener(this);
		add(btnImprimir);
                                        
                                        btnSalir = new JButton(); //#1550e3 BLUE
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setBounds(650,660,115,50);
		btnSalir.setIcon(new ImageIcon("D:/Documents/AnalizadorLexico/src/res/logout.png"));
		btnSalir.setRolloverEnabled(true);
		btnSalir.setRolloverIcon(new ImageIcon("D:/Documents/AnalizadorLexico/src/res/logout2.png"));
		btnSalir.setBorder(border);
		btnSalir.addActionListener(this);
		add(btnSalir);
		
		
		
	}
                     

	@Override
	public void actionPerformed(ActionEvent evt) {
		
		if(evt.getSource() == menuArchivoItem1) {
			try {
				
				JFileChooser chooser = new JFileChooser();
				
				chooser.showOpenDialog(this);
				File f = chooser.getSelectedFile();
				
				String filename=f.getAbsolutePath();
			
				FileReader reader = new FileReader(filename);
				BufferedReader br = new BufferedReader(reader);
				ta1.read(br, null);
				br.close();
				ta1.requestFocus();
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, "Acción no Realizada");
				
			}
		}
		if(evt.getSource()== btnAnalizar) {
                                            //Analizador Léxico
                                            try {
                                                 analizarLexico();
                                             } catch (IOException ex) {
                                                 Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                                              }
                                             String ST = ta1.getText();
                                             //Analizador Sintáctico
                                              Sintax s = new Sintax(new codigo.LexerCup(new StringReader(ST)));
        
                                                try {
                                                   s.parse();
                                                    ta3.setText("Analisis sintáctico realizado correctamente");
                                                     ta3.setForeground(new Color(25, 111, 61));
                                                } catch (Exception ex) {
                                                    Symbol sym = s.getS();
                                                    ta3.setText("Error de sintaxis. Linea: " + (sym.right + 1) + " Columna: " + (sym.left + 1) + ", Texto: \"" + sym.value + "\"");
                                                      ta3.setForeground(Color.red);
                                                   }
		}
		
		if(evt.getSource() == btnBorrar) {
			ta1.setText("");
			ta2.setText("");
                                                            ta3.setText("");
                                                            lista.clear();
			ta1.requestFocus();
		}
                                        if(evt.getSource()== btnImprimir){
                                            ta3.setForeground(Color.BLUE);
                                            String resultado = "Tabla de Identificadores: \n\n";
                                       
                                            for(int i = 0; i<lista.size();i++){
                                                resultado += ">> "+lista.get(i)+"\n";
                                                
                                            }
                                            ta3.setText(resultado);
                                        }
                                        if (evt.getSource()==btnSalir) {
                                            System.exit(0);
                
            }
		
	}
         private void analizarLexico() throws IOException{
        int cont = 1;
        lista = new ArrayList<String>();
        
        String expr = (String) ta1.getText();
        Lexer lexer = new Lexer(new StringReader(expr));
        String resultado = "LINEA " + cont + "\t\tSIMBOLO\n";
        while (true) {
            Tokens token = lexer.yylex();
            if (token == null) {
                ta2.setText(resultado);
                return;
            }
            switch (token) {
                
                case Class:
                    cont++;
                    resultado += "<Reservada class>" + lexer.lexeme + "\n";
                    break;
                case Void:
                    cont++;
                    resultado += "<Reservada static>" + lexer.lexeme + "\n";
                    break;
                 case Static:
                    cont++;
                    resultado += "<Reservada static>" + lexer.lexeme + "\n";
                    break;
                case Modificador:
                    cont++;
                    resultado += "<Modificador> " + lexer.lexeme + "\n";
                    break;
                case Linea:
                    cont++;
                    resultado += "LINEA " + cont + "\n";
                    break;
                case Comillas:
                    resultado += "  <Comillas>\t\t" + lexer.lexeme + "\n";
                    break;
                case Cadena:
                    resultado += "  <Tipo de dato>\t" + lexer.lexeme + "\n";
                    break;
                case T_dato:
                    resultado += "  <Tipo de dato>\t" + lexer.lexeme + "\n";
                    break;
                case If:
                    resultado += "  <Reservada if>\t" + lexer.lexeme + "\n";
                    break;
                case Else:
                    resultado += "  <Reservada else>\t" + lexer.lexeme + "\n";
                    break;
                case Do:
                    resultado += "  <Reservada do>\t" + lexer.lexeme + "\n";
                    break;
                case While:
                    resultado += "  <Reservada while>\t" + lexer.lexeme + "\n";
                    break;
                case For:
                    resultado += "  <Reservada while>\t" + lexer.lexeme + "\n";
                    break;
                case Igual:
                    resultado += "  <Operador igual>\t" + lexer.lexeme + "\n";
                    break;
                case Suma:
                    resultado += "  <Operador suma>\t" + lexer.lexeme + "\n";
                    break;
                case Resta:
                    resultado += "  <Operador resta>\t" + lexer.lexeme + "\n";
                    break;
                case Multiplicacion:
                    resultado += "  <Operador multiplicacion>\t" + lexer.lexeme + "\n";
                    break;
                case Division:
                    resultado += "  <Operador division>\t" + lexer.lexeme + "\n";
                    break;
                case Op_logico:
                    resultado += "  <Operador logico>\t" + lexer.lexeme + "\n";
                    break;
                case Op_incremento:
                    resultado += "  <Operador incremento>\t" + lexer.lexeme + "\n";
                    break;
                case Op_relacional:
                    resultado += "  <Operador relacional>\t" + lexer.lexeme + "\n";
                    break;
                case Op_atribucion:
                    resultado += "  <Operador atribucion>\t" + lexer.lexeme + "\n";
                    break;
                case Op_booleano:
                    resultado += "  <Operador booleano>\t" + lexer.lexeme + "\n";
                    break;
                case Parentesis_a:
                    resultado += "  <Parentesis de apertura>\t" + lexer.lexeme + "\n";
                    break;
                case Parentesis_c:
                    resultado += "  <Parentesis de cierre>\t" + lexer.lexeme + "\n";
                    break;
                case Llave_a:
                    resultado += "  <Llave de apertura>\t" + lexer.lexeme + "\n";
                    break;
                case Llave_c:
                    resultado += "  <Llave de cierre>\t" + lexer.lexeme + "\n";
                    break;
                case Corchete_a:
                    resultado += "  <Corchete de apertura>\t" + lexer.lexeme + "\n";
                    break;
                case Corchete_c:
                    resultado += "  <Corchete de cierre>\t" + lexer.lexeme + "\n";
                    break;
                case Main:
                    resultado += "  <Reservada main>\t" + lexer.lexeme + "\n";
                    break;
                case P_coma:
                    resultado += "  <Punto y coma>\t" + lexer.lexeme + "\n";
                    break;
                case Identificador:
                    resultado += "  <Identificador>\t\t" + lexer.lexeme + "\n";
                    String aux = lexer.lexeme;
                    lista.add(aux);
                    break;
                case Numero:
                    resultado += "  <Numero>\t\t" + lexer.lexeme + "\n";
                    break;
                case ERROR:
                    resultado += "  Error Léxico: Simbolo no definido >> "+lexer.yycharat(0)+"\n";
                    break;
                default:
                    resultado += "  < " + lexer.lexeme + " >\n";
                    break;
            }
        }
      

             
    }
    public static void main(String[] args) {
        Ventana v = new Ventana();
    }

	
}
