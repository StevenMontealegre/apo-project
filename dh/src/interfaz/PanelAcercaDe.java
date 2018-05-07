package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PanelAcercaDe extends JDialog {

	private JTextArea txtArea;
	private JScrollPane scroll;
	private JLabel lbImagen;

	public PanelAcercaDe() {

		
		setLayout(new BorderLayout());
		setSize(new Dimension(400, 300));
		setTitle("INSTRUCCIONES");
	
		txtArea = new JTextArea();
		txtArea.setLineWrap(true);
		txtArea.setWrapStyleWord(true);
		txtArea.setBackground(Color.BLACK);
		Font fuente5 = new Font("Calibri", 3, 14);
		JLabel lbPuntaje = new JLabel("James Montealegre A00014976 - John Urbano A00292788\n Algoritmos y programacion II \n UNIVERSIDAD ICESI " );
		lbPuntaje.setFont(fuente5);
		txtArea.setFont(fuente5);
		txtArea.setForeground(Color.GREEN);
		txtArea.append(lbPuntaje.getText());

		scroll = new JScrollPane(txtArea);
		scroll.setPreferredSize(new Dimension(220, 220));
		scroll.setBackground(Color.BLACK);
		add(scroll, BorderLayout.CENTER);
	
	}
}