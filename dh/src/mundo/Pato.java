package mundo;

import java.awt.Image;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Pato extends Ave {

	public Pato(int posX, int posY, double espera) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		super(posX, posY, espera);
		// TODO Auto-generated constructor stub
		definirImagen("img/patos/PatoEd.gif");
		
	}

}