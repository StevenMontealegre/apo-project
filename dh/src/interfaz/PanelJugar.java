package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import mundo.Usuario;

public class PanelJugar extends JDialog implements MouseListener, ActionListener {

	private JLabel lbImagen1;
	private JLabel lbImagen2;
	private InterfazJuego principal;
	private JButton btnGameA;
	private JButton btnGameB;
	private JButton btnScore;

	final static String GAMEA = "GameA";
	final static String GAMEB = "GameB";
	final static String SCORE = "Score";

	public PanelJugar(InterfazJuego p) {

		principal = p;

		setLayout(new BorderLayout());
		setSize(new Dimension(410, 650));
		this.setBackground(Color.BLACK);
		setLocationRelativeTo(null);
		JPanel panelAux2 = new JPanel();
		panelAux2.setLayout(new GridLayout(1, 2));

		ImageIcon imagen1 = new ImageIcon("images/image_title.jpg");
		ImageIcon imagen2 = new ImageIcon("images/giphy.gif");
		lbImagen1 = new JLabel(imagen1);
		lbImagen2 = new JLabel(imagen2);
		panelAux2.setBackground(Color.BLACK);
		// panelAux2.add(lbImagen1);
		panelAux2.add(lbImagen2);

		Font fuente = new Font("Broadway", 3, 24);

		btnGameA = new JButton("GAME A     1 DUCK");
		btnGameA.setFont(fuente);
		btnGameA.setBackground(Color.BLACK);
		btnGameA.setForeground(Color.YELLOW);
		btnGameA.setActionCommand(GAMEA);
		btnGameA.addActionListener(this);

		btnGameB = new JButton("GAME B     2 DUCK");
		btnGameB.setFont(fuente);
		btnGameB.setBackground(Color.BLACK);
		btnGameB.setForeground(Color.YELLOW);
		btnGameB.setActionCommand(GAMEB);
		btnGameB.addActionListener(this);

		btnScore = new JButton("SCORE");
		btnScore.setFont(fuente);
		btnScore.setBackground(Color.BLACK);
		btnScore.setForeground(Color.GREEN);
		btnScore.setActionCommand(SCORE);
		btnScore.addActionListener(this);

		JPanel panelAux = new JPanel();
		panelAux.setLayout(new GridLayout(3, 1));
		panelAux.add(btnGameA);
		panelAux.add(btnGameB);
		panelAux.add(btnScore);

		add(panelAux2, BorderLayout.CENTER);
		add(panelAux, BorderLayout.SOUTH);
		add(lbImagen1, BorderLayout.NORTH);

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String comando = e.getActionCommand();
		if (comando.equalsIgnoreCase(GAMEA)) {
			//
			principal.mostrarPanelEscenario();
			principal.getPanelEscenario().iniciarHiloPerro();

		}
		if (comando.equalsIgnoreCase(SCORE)) {
			String sol = JOptionPane.showInputDialog("Ingrese el score que quiere buscar", this);
			if (sol != "") {
				int sco = Integer.parseInt(sol);
				Usuario usu = principal.getMundo().buscarJugador(sco);
				JOptionPane.showMessageDialog(this, "El usuario con ese score es: " + usu);

			}

		}

	}

}
