package mundo;

import java.io.BufferedInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Perro extends Animal {

	public Clip sonido;
	
	public Perro(int posX, int posY) {
		super(posX, posY, 50);
		// TODO Auto-generated constructor stub

		definirImagen("img/perro/Perro_1.gif");
	}

	@Override
	public void mover() {
		
			posX+=5;
		if(posX>=150) {posY-=20;}
		
	}
	@Override
	public void definirSonido(String ruta) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		// TODO Auto-generated method stub
		super.rutaSonido = ruta;
		BufferedInputStream bufInS = new BufferedInputStream(getClass().getResourceAsStream("/sonidos/" + ruta + ".wav"));
		AudioInputStream audInS = AudioSystem.getAudioInputStream(bufInS);
		sonido = AudioSystem.getClip();
		sonido.open(audInS);
		sonido.start();
	}

	@Override
	public void definirImagen(String ruta) {
		// TODO Auto-generated method stub
		super.rutaImagen = ruta;
	}

	
}
