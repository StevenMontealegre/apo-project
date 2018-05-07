package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Polygon;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PanelInstrucciones extends JDialog {

	private JTextArea txtArea;
	private JScrollPane scroll;
	private InterfazJuego principal;
	private JPanel panelAux1;
	private JPanel panelAux2;

	public PanelInstrucciones(InterfazJuego p) {

		principal = p;

		setLayout(new GridLayout(2, 1));
		setSize(new Dimension(600, 600));
		setTitle("INSTRUCCIONES");
		Color azulCielo = new Color(135, 206, 255);
		this.setBackground(azulCielo);
		txtArea = new JTextArea();
		txtArea.setLineWrap(true);
		txtArea.setWrapStyleWord(true);
		txtArea.setBackground(new Color(50, 153, 204));
		Font fuente5 = new Font("Calibri", 3, 14);
		JLabel lbPuntaje = new JLabel(
				"¿Estás listo para cazar aves?   , ");
		lbPuntaje.setFont(fuente5);
		txtArea.setFont(fuente5);
		txtArea.setForeground(Color.GREEN);
		txtArea.append(lbPuntaje.getText());

		scroll = new JScrollPane(txtArea);
		scroll.setPreferredSize(new Dimension(220, 220));
		scroll.setBackground(Color.BLACK);
		panelAux1 = new JPanel();
		panelAux2 = new JPanel();

		panelAux1.setBackground(new Color(50, 153, 204));
		panelAux1.repaint();
		panelAux2.setBackground(new Color(127, 255, 0));

		add(panelAux1);
		add(panelAux2);
		

	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;

		// CONTORNO DEL ARBOL

		g2d.setColor(new Color(47, 79, 47));
		g2d.drawArc(80, 40, 70, 70, 40, 90);
		g2d.drawArc(40, 40, 70, 70, 40, 90);
		g2d.drawArc(40, 40, 70, 70, 130, 90);
		g2d.drawArc(30, 100, 70, 70, 130, 90);
		g2d.drawArc(30, 130, 70, 70, 150, 120);
		g2d.drawArc(20, 70, 90, 60, -115, -145);
		g2d.drawArc(50, 150, 90, 60, -90, -90);
		g2d.drawArc(80, 60, 70, 70, -40, -90);
		g2d.drawArc(40, 60, 70, 70, -40, -90);
		g2d.drawArc(110, 50, 70, 70, 20, 80);
		g2d.drawArc(120, 145, 70, 70, -40, -90);
		g2d.drawArc(80, 145, 70, 70, -40, -90);
		g2d.drawArc(135, 70, 70, 70, -280, -110);
		g2d.drawArc(135, 140, 70, 70, -330, -110);
		g2d.drawArc(135, 140, 70, 70, -310, -90);
		g2d.drawArc(135, 105, 70, 70, -330, -110);
		g2d.drawArc(135, 105, 70, 70, -310, -90);
		
		panelAux1.paint(g2d);
		g2d.drawString("HOLA!!!!!! \n ¿Estás listo para cazar aves?", 220, 70);
		g2d.drawString("has brotar tu potencial como cazador al enfrentarte", 220, 90);
		g2d.drawString("a ágiles aves como patos, perdices, y ganzos.", 220, 110);
		g2d.drawString("Apunta y dispara, contarás con tres disparos por partida.", 220, 130);
		g2d.drawString("Por cada disparo acertado sumaras puntos a tu score...", 220, 150);
		g2d.drawString("Establece puntajes altos y reta a tus amistades. No esperes más", 220, 170);
		g2d.drawString(" y a cazar!!!!!!!!!!!!!!! :v", 220, 190);
		
		
		
		// -----------------------------------------------------------------------

		// SOMBRA INFERIOR

		g2d.fillArc(30, 100, 70, 70, 130, 90);
		g2d.fillArc(30, 130, 70, 70, 150, 120);
		g2d.fillArc(50, 150, 90, 60, -90, -90);
		g2d.fillArc(50, 150, 90, 60, -90, -90);
		g2d.fillArc(120, 145, 70, 70, -40, -90);
		g2d.fillArc(80, 145, 70, 70, -40, -90);
		g2d.fillArc(135, 140, 70, 70, -330, -110);

		// ------------------------------------------------------------------------

		// RELLENO HOJAS DEL ARBOL

		g2d.setColor(new Color(127, 255, 0));
		g2d.fillOval(40, 40, 70, 70);
		g2d.fillOval(80, 40, 70, 70);
		g2d.fillOval(80, 80, 70, 70);
		g2d.fillOval(30, 100, 70, 70);
		g2d.fillOval(20, 70, 90, 60);
		g2d.fillOval(50, 140, 90, 60);
		g2d.fillOval(80, 60, 70, 70);
		g2d.fillOval(40, 60, 70, 70);
		g2d.fillOval(110, 50, 70, 70);
		g2d.fillOval(120, 135, 70, 70);
		g2d.fillOval(80, 135, 70, 70);
		g2d.fillOval(135, 70, 70, 70);
		g2d.fillOval(129, 130, 70, 70);
		g2d.fillOval(135, 105, 70, 70);

		// ------------------------------------------------------------------------
		// RAMAS Y TALLO

		g2d.setColor(new Color(205, 127, 50));
		g2d.fillRect(110, 190, 20, 132);
		Polygon polygon1 = new Polygon();
		polygon1.addPoint(78, 160);
		polygon1.addPoint(90, 160);
		polygon1.addPoint(120, 230);
		polygon1.addPoint(120, 260);

		g2d.fillPolygon(polygon1);
		Polygon polygon2 = new Polygon();
		polygon2.addPoint(170, 160);
		polygon2.addPoint(180, 160);
		polygon2.addPoint(130, 260);
		polygon2.addPoint(130, 230);
		g2d.fillPolygon(polygon2);

		// ---------------------------------------------------------------------------------------------

		// ARBUSTO

		g2d.setColor(new Color(127, 255, 0));
		int m = 15;
		int n = 10;
		int ñ = 20;
		for (int i = 0; i < 64; i++) {

			int[] vx0 = { m, n, ñ };
			int[] vy0 = { 270, 330, 330 };
			g2d.fillPolygon(vx0, vy0, 3);
			m += 10;
			n += 10;
			ñ += 10;

		}
		g2d.setColor(new Color(135, 206, 255));
		g2d.fillRect(0, 420, 643, 0);
		g2d.setColor(new Color(207, 181, 59));
		g2d.fillRect(8, 420, 643, 300);

	}

}
