package hilos;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import interfaz.PanelEscenario;
import mundo.Ave;
import mundo.*;

public class HiloMueveAve extends Thread {

	private Ave ave;
	private PanelEscenario panel;

	public HiloMueveAve(Ave a, PanelEscenario panelEscenario) {
		ave = a;
		panel = panelEscenario;
	}

	public void run() {

		int contador = 0;
		int contadorSonido = 6;
		while (contador < ave.getEspera() && ave.estaAtrapado() == false) {

			try {
				ave.mover();
				panel.repaint();
				Thread.sleep(50);
				if (contadorSonido >= 7) {
					if (ave instanceof Pato) {

						((Pato) ave).definirSonido("duck_1");

					} else if (ave instanceof Perdiz) {
						((Perdiz) ave).definirSonido("duck_2");
					} else {
						((Ganso) ave).definirSonido("duck_3");
					}

					contadorSonido = 0;
				}

				contador++;
				contadorSonido++;
			} catch (InterruptedException e) {

				e.printStackTrace();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedAudioFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
