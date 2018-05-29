package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.omg.CORBA.portable.IndirectionException;

import hilos.HiloMueveAve;
import hilos.HiloMuevePerro;
import mundo.Animal;
import mundo.Ave;
import mundo.Juego;
import mundo.Pato;
import mundo.Perro;
import mundo.Puntaje;

public class PanelEscenario extends JDialog implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private InterfazJuego principal;
	private JPanel panelAux1;
	private JPanel panelAux2;
	private ArrayList<Ave> aves;
	private Perro perro;
	private int indiceAves;
	public static final Image fondo = new ImageIcon("images/fondo.png").getImage();
	private Image dibujoAux;
	private Graphics gAux;
	private Dimension dimAux;
	private Dimension dimCanvas;

	public PanelEscenario(InterfazJuego p) {

		principal = p;
		aves = principal.getMundo().getAves();
		this.setIndiceAves(0);
		setTitle("Dunk_Hunt");
		setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		Color azulCielo = new Color(135, 206, 255);
		this.setBackground(azulCielo);
		setCursor(new Cursor(Cursor.MOVE_CURSOR));
		setBounds(50, 50, 1285, 730);
		dimCanvas = this.getSize();
		addMouseListener(this);

	}

	public JPanel getPanelAux1() {
		return panelAux1;
	}

	public void setPanelAux1(JPanel panelAux1) {
		this.panelAux1 = panelAux1;
	}

	public JPanel getPanelAux2() {
		return panelAux2;
	}

	public void setPanelAux2(JPanel panelAux2) {
		this.panelAux2 = panelAux2;
	}

	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		paint(g);
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		if (gAux == null || dimAux == null || dimCanvas.width != dimAux.width || dimCanvas.height != dimAux.height) {

			dimAux = dimCanvas;
			dibujoAux = createImage(dimAux.width, dimAux.height);
			gAux = dibujoAux.getGraphics();
		}

		gAux.drawImage(fondo, 0, 0, this);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(dibujoAux, 0, 0, this);

		Toolkit t = Toolkit.getDefaultToolkit();
		g2d.setColor(Color.white);
		g2d.drawString("Numero de aves sin atrapar: " + (10 - ((indiceAves % 10))) + "", 650, 665);
		g2d.drawString(principal.getMundo().getUsuarioActual().getDisparos() + "", 160, 660);
		g2d.drawString(principal.getMundo().getUsuarioActual().getScore() + "", 1120, 660);

		String nickname = "";
		int score = 0;

		if (!terminarPartida()) {

			if (perro.getPosX() <= ((Juego.ALTO_CIELO / 3.2) + 50)) {
				Image imagen5 = t.getImage(perro.getRutaImagen());
				g2d.drawImage(imagen5, perro.getPosX(), perro.getPosY(), this);
				if (perro.getPosX() == 161) {

					try {
						Thread.sleep(30);
						iniciarHiloAve(0);
					} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}

			if (perro.getPosX() > ((Juego.ALTO_CIELO / 3.2) + 35)) {

				if (aves.get(indiceAves).getRebotes() < 7) {
					if (aves.get(indiceAves).estaAtrapado() == false) {
						Image image6 = t.getImage(aves.get(indiceAves).getRutaImagen());
						g2d.drawImage(image6, aves.get(indiceAves).getPosX(), aves.get(indiceAves).getPosY(), this);

					} else {
						Image image7 = t.getImage("images/splat.png");

						g2d.drawImage(image7, aves.get(indiceAves).getPosX(), aves.get(indiceAves).getPosY(), this);
						try {
							Thread.sleep(300);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						indiceAves++;
						principal.getMundo().getUsuarioActual().setDisparos(3);

						try {
							iniciarHiloAve(indiceAves);
						} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} else {

					principal.getMundo().getUsuarioActual().setDisparos(3);
					principal.getMundo().verificarAveMuerta(aves.get(indiceAves).getPosX(),
							aves.get(indiceAves).getPosY(), indiceAves);
					principal.getMundo().setNumeroAtrapados(principal.getMundo().getNumeroAtrapados() - 1);
					principal.getMundo().getUsuarioActual()
							.setScore(principal.getMundo().getUsuarioActual().getScore() - 10);
					indiceAves++;
					try {
						iniciarHiloAve(indiceAves);
					} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}

		} else {

			g2d.setFont(new java.awt.Font("Tahoma", 1, 20));
			g2d.drawString("GAME OVER", 580, 350);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Puntaje sco = new Puntaje(principal.getMundo().getUsuarioActual().getScore());
			principal.getMundo().getUsuarioActual().insertarPuntaje(sco);

			nickname = principal.getMundo().getUsuarioActual().getNickname();
			score = principal.getMundo().getUsuarioActual().buscarMayorPuntaje();
			principal.getPanelInicio().pintarScore(nickname, score);
			//			principal.getMundo().salvarEstado();
			dispose();

		}

	}

	private int pivote = 0;

	public boolean terminarPartida() {
		boolean estado = false;
		if (indiceAves < 11 && indiceAves % 10 == 0) {
			if (indiceAves != 0) {
				if (principal.getMundo().getNumeroAtrapados() <= 5) {
					estado = true;
				} else {
					pivote = principal.getMundo().getNumeroAtrapados();
				}
			}
		} else if (indiceAves < 21 && indiceAves % 10 == 0) {

			if ((principal.getMundo().getNumeroAtrapados() - pivote) <= 5) {
				estado = true;
			} else {
				pivote = principal.getMundo().getNumeroAtrapados();
			}
		} else if (indiceAves >= 21 && indiceAves % 29 == 0) {
			if ((principal.getMundo().getNumeroAtrapados() - pivote) <= 5) {
				estado = true;
			}
		}

		return estado;
	}

	public int darAncho() {
		return panelAux1.getWidth();

	}

	public int darAlto() {
		return panelAux1.getHeight();
	}

	public InterfazJuego getPrincipal() {
		return principal;
	}

	public void setPrincipal(InterfazJuego principal) {
		this.principal = principal;

	}

	public ArrayList<Ave> getAve() {
		return aves;
	}

	public Perro getPerro() {
		return perro;
	}

	public void setPerro(Perro perro) {
		this.perro = perro;
	}

	public void iniciarHiloAve(int i) throws LineUnavailableException, IOException, UnsupportedAudioFileException {

		int x = (int) (Math.random() * Juego.ALTO_CIELO) + 1;
		int y = Juego.ALTO_CIELO - 80;
		aves.get(i).setPosX(x);
		aves.get(i).setPosY(y);
		HiloMueveAve hilo1 = new HiloMueveAve(aves.get(i), this);

		hilo1.start();
	}

	public void iniciarHiloPerro() {

		int x = 1;
		int y = Juego.ALTO_CIELO;
		perro = new Perro(x, y);
		HiloMuevePerro hilo2 = new HiloMuevePerro(perro, this);
		hilo2.start();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		principal.getMundo().verificarAveMuerta(x, y, indiceAves);
		if (e.getButton() == MouseEvent.BUTTON1) {
			principal.getMundo().getUsuarioActual()
					.setDisparos(principal.getMundo().getUsuarioActual().getDisparos() - 1);
		}
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

	public int getIndiceAves() {
		return indiceAves;
	}

	public void setIndiceAves(int indiceAves) {
		this.indiceAves = indiceAves;
	}

}
