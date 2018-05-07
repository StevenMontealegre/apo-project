package mundo;

import java.io.File;
import java.io.Serializable;

public class Puntaje implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int valor;
	private Puntaje izquierda;
	private Puntaje derecha;

	public Puntaje() {

	}

	public Puntaje(int valor) {
		this.valor = valor;
		this.derecha = null;
		this.izquierda = null;

	}

	public void insertarPuntaje(Puntaje p) {
		if (p.getValor() < getValor()) {
			if (izquierda == null) {
				izquierda = p;
			} else {
				izquierda.insertarPuntaje(p);
			}
		} else {
			if (derecha == null) {
				derecha = p;
			} else {
				derecha.insertarPuntaje(p);
			}
		}
	}

	public Puntaje darMayor() {
		if (derecha == null) {
			return this;
		} else {
			return derecha.darMayor();
		}

	}

	/**
	 * @return the cantidad
	 */
	public int getValor() {
		return valor;
	}

	/**
	 * @param cantidad
	 *            the cantidad to set
	 */
	public void setValor(int valor) {
		this.valor = valor;
	}

	/**
	 * @return the izquierda
	 */
	public Puntaje getIzquierda() {
		return izquierda;
	}

	/**
	 * @param izquierda
	 *            the izquierda to set
	 */
	public void setIzquierda(Puntaje izquierda) {
		this.izquierda = izquierda;
	}

	/**
	 * @return the derecha
	 */
	public Puntaje getDerecha() {
		return derecha;
	}

	/**
	 * @param derecha
	 *            the derecha to set
	 */
	public void setDerecha(Puntaje derecha) {
		this.derecha = derecha;
	}
}
