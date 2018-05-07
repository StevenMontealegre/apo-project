package mundo;

public class Usuario implements Comparable<Usuario> {

	private String nickname;
	private int score;
	private Usuario anterior;
	private Usuario siguiente;
	private Puntaje raiz;
	private int disparos;

	public Usuario(String nickname) {
		super();
		this.nickname = nickname;
		this.anterior = null;
		this.siguiente = null;
		this.setScore(0);
		this.setDisparos(3);

	}

	public boolean isVacio() {
		return raiz == null;
	}

	public void insertarPuntaje(Puntaje p) {

		if (isVacio()) {
			raiz = p;
		} else {
			if (p.getValor() > raiz.getValor()) {
				raiz.getDerecha().insertarPuntaje(p);
			}
			if (p.getValor() < raiz.getValor()) {
				raiz.getIzquierda().insertarPuntaje(p);
			}
		}

	}

	public int buscarMayorPuntaje() {
		int mayor = 0;
		if (!isVacio()) {
			if (raiz.getDerecha() != null) {
				Puntaje actual = raiz.getDerecha();
				while (actual.getDerecha() != null) {
					actual = actual.getDerecha();
				}
				mayor = actual.getValor();
			} else {
				mayor = raiz.getValor();
			}
		} else {
			mayor = 0;
		}

		return mayor;
	}

	public Usuario getAnterior() {
		return anterior;
	}

	public void setAnterior(Usuario anterior) {
		this.anterior = anterior;
	}

	public Usuario getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Usuario siguiente) {
		this.siguiente = siguiente;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getDisparos() {
		return disparos;
	}

	public void setDisparos(int disparos) {
		if (disparos < 0) {
			disparos = 0;
		}

		this.disparos = disparos;

	}

	@Override
	public int compareTo(Usuario o) {
		// TODO Auto-generated method stub
		if (score == o.getScore()) {
			return 0;
		} else if (score > o.getScore()) {
			return 1;
		} else {
			return -1;
		}

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nickname;
	}

}
