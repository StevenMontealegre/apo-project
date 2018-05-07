package mundo;

public abstract class Animal implements Movimiento, Sonido, Imagen {

	protected int posX;
	protected int posY;
	protected String rutaImagen;
	protected String rutaSonido;
	protected double espera;

	public Animal(int posX, int posY, double espera) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.espera = espera;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	public String getRutaSonido() {
		return rutaSonido;
	}

	public void setRutaSonido(String rutaSonido) {
		this.rutaSonido = rutaSonido;
	}

	public double getEspera() {
		return espera;
	}

	public void setEspera(double espera) {
		this.espera = espera;
	}

}
