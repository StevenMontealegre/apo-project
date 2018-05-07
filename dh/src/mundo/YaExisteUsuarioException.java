package mundo;

/**
 * Clase que representa la caso de excepci�n cuando se intenta agregar una prenda con un c�digo existente
 * @author Juan Manuel Reyes - jmreyes@icesi.edu.co
 */
@SuppressWarnings("serial")
public class YaExisteUsuarioException extends Exception{
	/**
	 * El c�digo de la prenda que ya existe
	 */
	private String nickYaExiste;
	/**
	 * El mensaje corto que indica que ocurri�
	 */
	private String mensaje;
	
	/**
	 * Construye una excepci�n para indicar que ya existe una prenda con el c�digo codYaExiste
	 * @param mens es el mensaje que indica que ocurri�
	 * @param codYaExiste es el c�digo de la prenda que ya existe
	 */
	public YaExisteUsuarioException(String mens, String codYaExiste){
		mensaje = mens;
		nickYaExiste = codYaExiste;
	}
	
	/**
	 * Retorna una cadena con el c�digo
	 * @return el c�digo que ya existe
	 */
	public String darNickYaExiste() {
		return nickYaExiste;
	}
	
	/**
	 * El mensaje corto que indica que ocurri�
	 * @return una cadena con el mensaje corto
	 */
	public String darMensaje() {
		return mensaje;
	}
}
