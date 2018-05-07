package mundo;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Perdiz extends Ave {

	public Perdiz(int posX, int posY, double espera) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		super(posX, posY, espera);
		// TODO Auto-generated constructor stub

		definirImagen("img/patos/Pato_6.gif");
	}

}
