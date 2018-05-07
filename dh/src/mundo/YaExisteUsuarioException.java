package mundo;

/**
 * Clase que representa la caso de excepción cuando se intenta agregar una prenda con un código existente
 * @author Juan Manuel Reyes - jmreyes@icesi.edu.co
 */
@SuppressWarnings("serial")
public class YaExisteUsuarioException extends Exception{
	/**
	 * El código de la prenda que ya existe
	 */
	private String nickYaExiste;
	/**
	 * El mensaje corto que indica que ocurrió
	 */
	private String mensaje;
	
	/**
	 * Construye una excepción para indicar que ya existe una prenda con el código codYaExiste
	 * @param mens es el mensaje que indica que ocurrió
	 * @param codYaExiste es el código de la prenda que ya existe
	 */
	public YaExisteUsuarioException(String mens, String codYaExiste){
		mensaje = mens;
		nickYaExiste = codYaExiste;
	}
	
	/**
	 * Retorna una cadena con el código
	 * @return el código que ya existe
	 */
	public String darNickYaExiste() {
		return nickYaExiste;
	}
	
	/**
	 * El mensaje corto que indica que ocurrió
	 * @return una cadena con el mensaje corto
	 */
	public String darMensaje() {
		return mensaje;
	}
}
