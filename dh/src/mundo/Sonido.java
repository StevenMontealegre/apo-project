package mundo;

import java.io.BufferedInputStream;
import java.io.IOException;
import javax.sound.sampled.*;


public interface Sonido {
	
	public void definirSonido(String ruta) throws LineUnavailableException, IOException,  UnsupportedAudioFileException ;

	
}
