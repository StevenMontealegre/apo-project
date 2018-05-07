package hilos;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import interfaz.PanelEscenario;
import mundo.Juego;
import mundo.Perro;

public class HiloMuevePerro extends Thread {

	private Perro perro;
	private PanelEscenario panel;
	

	public HiloMuevePerro(Perro p, PanelEscenario pl) {
		perro = p;
		panel = pl;
	}

	public void run() {

		int contadorSonido = 5;

		while (perro.getPosX() <= ((Juego.ALTO_CIELO/3.2)+50)) {
			try {
				perro.mover();
				Thread.sleep(100);
				if(contadorSonido >= 7 && perro.getPosX() <= ((Juego.ALTO_CIELO/2)+20)){
					perro.definirSonido("dog");
					contadorSonido = 0;
				}
				contadorSonido++;
			} catch (InterruptedException e) {

				e.printStackTrace();
			} catch (UnsupportedAudioFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		perro = null;
	}

}
