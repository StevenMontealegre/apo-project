package mundo;

import java.io.BufferedInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Ave extends Animal {

	protected boolean atrapado;
	protected String direccionX;
	protected String direccionY;
	protected int rebotes;

	public final static String IZQUIERDA = "IZQUIERDA";
	public final static String DERECHA = "DERECHA";
	public final static String ARRIBA = "ARRIBA";
	public final static String ABAJO = "ABAJO";

	public final static int MOVIMIENTO = 10;
	public final static int DIAMETRO_AVE = 60;
	public Clip sonido;

	public Ave(int posX, int posY, double espera)
			throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		super(posX, posY, espera);
		this.atrapado = false;
		this.rebotes = 0;

		int pos = (int) (Math.random() * 10) + 1;
		if (pos < 5) {
			this.direccionX = DERECHA;
		} else {
			this.direccionX = IZQUIERDA;
		}
	}

	public boolean isAtrapado(int x, int y) {

		if (posX <= x + (DIAMETRO_AVE) && x <= posX + (2 * DIAMETRO_AVE) && posY <= y + (DIAMETRO_AVE)
				&& y <= posY + (2 * DIAMETRO_AVE)) {
			return true;

		} else {
			return false;
		}
	}

	public void setAtrapado(boolean atrapado) {
		this.atrapado = atrapado;
	}

	public boolean estaAtrapado() {
		return atrapado;
	}

	public Clip getSonido() {
		return sonido;
	}

	public void mover() {
		if (direccionX == IZQUIERDA && direccionY == ARRIBA) {
			posX -= MOVIMIENTO;
			posY -= MOVIMIENTO;
		} else if (direccionX == IZQUIERDA && direccionY == ABAJO) {
			posX -= MOVIMIENTO;
			posY += MOVIMIENTO;
		} else if (direccionX == DERECHA && direccionY == ARRIBA) {
			posX += MOVIMIENTO;
			posY -= MOVIMIENTO;
		} else {
			posX += MOVIMIENTO;
			posY += MOVIMIENTO;
		}

		validarFueraDeCancha();
	}

	private void validarFueraDeCancha() {
		if (posX > (Juego.ANCHO_CIELO - 50)) {
			direccionX = IZQUIERDA;
			rebotes++;
			posX = Juego.ANCHO_CIELO - 50;

		}
		if (posX < 0) {
			direccionX = DERECHA;
			posX = 0;
			rebotes++;

		}
		if (posY > Juego.ALTO_CIELO) {
			direccionY = ARRIBA;
			posY = Juego.ALTO_CIELO;
			rebotes++;

		}
		if (posY < 0) {
			direccionY = ABAJO;
			posY = 0;
			rebotes++;

		}
	}

	public int getRebotes() {
		return rebotes;
	}

	public void setRebotes(int rebotes) {
		this.rebotes = rebotes;
	}

	@Override
	public void definirSonido(String ruta) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		// TODO Auto-generated method stub
		super.rutaSonido = ruta;

		BufferedInputStream bufInS = new BufferedInputStream(
				getClass().getResourceAsStream("/sonidos/" + ruta + ".wav"));
		AudioInputStream audInS = AudioSystem.getAudioInputStream(bufInS);
		sonido = AudioSystem.getClip();
		sonido.open(audInS);
		sonido.start();

	}

	public void matarSonido() {
		sonido.close();
	}

	@Override
	public void definirImagen(String ruta) {
		// TODO Auto-generated method stub

		super.rutaImagen = ruta;
	}

}
