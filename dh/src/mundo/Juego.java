package mundo;

import java.awt.Image;
import java.awt.List;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Juego {

	private Usuario primero;
	private Usuario usuarioActual;
	private int nivel;
	private int numeroAtrapados;
	private Puntaje elPuntaje;
	private ArrayList<Ave> aves;
	private ArrayList<Usuario> usuarios;
	public final static int ANCHO_CIELO = 1280;
	public final static int ALTO_CIELO = 491;
	public final static String RUTA_PUNTAJE = "doc/estado_del_mundo.txt";

	public Juego(Usuario primero, int nivel)
			throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		super();
		this.primero = primero;
		this.nivel = nivel;
		this.setNumeroAtrapados(0);
		this.setUsuarioActual(null);
		aves = new ArrayList<>();
		usuarios = new ArrayList<>();
		elPuntaje = new Puntaje();

		for (int i = 0; i < 30; i++) {

			int x = (int) (Math.random() * 3) + 1;
			System.out.println(x);
			if (x == 1) {
				aves.add(new Pato(150, 100, 10000));

			} else if (x == 2) {
				aves.add(new Ganso(700, 300, 10000));

			} else {
				aves.add(new Perdiz(720, 100, 10000));
			}
		}

	}

	public void cargarPuntaje() {
		File archivo = new File(RUTA_PUNTAJE);

		if (archivo.exists()) {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
				elPuntaje = (Puntaje) ois.readObject();
				ois.close();

			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();

			}
		} else {
			elPuntaje = new Puntaje();
		}

	}

	public void salvarPuntaje() {
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(RUTA_PUNTAJE));
			oos.writeObject(elPuntaje);
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean listaVacia() {
		return primero == null;
	}

	public String darJugadores() {
		String reporte = "";

		Usuario jugadorActual = primero;

		while (jugadorActual != null) {
			reporte += "" + jugadorActual.getNickname() + "\n";
			jugadorActual = jugadorActual.getSiguiente();

		}
		return reporte;
	}

	public void agregarUsuario(Usuario p) throws YaExisteUsuarioException {
		if (primero != null) {
			Usuario variable = primero;
			boolean parar = false;

			while (variable != null && !parar) {

				if (variable.getNickname().compareTo(p.getNickname()) == 0) {
					usuarioActual = variable;
					throw new YaExisteUsuarioException("El jugador ya existe", variable.getNickname());
				} else if (variable.getNickname().compareTo(p.getNickname()) > 0) {
					if (variable.getAnterior() == null) {
						primero.setAnterior(p);
						p.setSiguiente(primero);
						primero = p;
						parar = true;

					} else {

						p.setAnterior(variable.getAnterior());
						p.setSiguiente(variable);
						variable.getAnterior().setSiguiente(p);
						variable.setAnterior(p);
						parar = true;

					}
				} else if (variable.getSiguiente() == null && !parar) {
					variable.setSiguiente(p);
					p.setAnterior(variable);
					parar = true;
				}
				variable = variable.getSiguiente();
			}
		} else {
			primero = p;
		}
	}

	public ArrayList<Usuario> arregloUsuarios() {

		if (!listaVacia()) {
			Usuario actual = (Usuario) primero;
			usuarios.add(actual);
			while (actual.getSiguiente() != null) {
				actual = actual.getSiguiente();
				usuarios.add(actual);

			}
		}

		return usuarios;
	}

	public void ordenarBurbuja(ArrayList<Usuario> usu) {
		for (int i = usu.size(); i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				if (usu.get(j).compareTo(usu.get(j + 1)) == 0) {
					Usuario temp = usu.get(j);
					usu.add(j, usu.get(j + 1));
					usu.add(j + 1, temp);

				}
			}
		}

	}

	public Usuario buscarJugador(int valor) {

		ordenarBurbuja(arregloUsuarios());
		boolean esta = false;
		Usuario jugador = null;
		int inicio = 0;
		int fin = usuarios.size() - 1;
		while (inicio <= fin && !esta) {

			int medio = (inicio + fin) / 2;
			if (usuarios.get(medio).getScore() == valor) {
				jugador = usuarios.get(medio);
				esta = true;
			} else if (usuarios.get(medio).getScore() > valor) {
				fin = medio - 1;
			} else {
				inicio = medio + 1;
			}
		}

		return jugador;

	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getPrimero() {
		return primero;
	}

	public void setPrimero(Usuario primero) {
		this.primero = primero;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public ArrayList<Ave> getAves() {
		return aves;
	}

	public void setAves(ArrayList<Ave> aves) {
		this.aves = aves;
	}

	public void verificarAveMuerta(int x, int y, int pos) {
		// TODO Auto-generated method stub
		if (aves.get(pos) != null) {
			Ave b = aves.get(pos);

			if (b.isAtrapado(x, y)) {
				numeroAtrapados++;
				usuarioActual.setScore(usuarioActual.getScore() + 10);
				b.setAtrapado(true);
			}

		}
	}

	public Usuario getUsuarioActual() {
		return usuarioActual;
	}

	public void setUsuarioActual(Usuario usuarioActual) {
		this.usuarioActual = usuarioActual;
	}

	public int getNumeroAtrapados() {
		return numeroAtrapados;
	}

	public void setNumeroAtrapados(int numeroAtrapados) {
		this.numeroAtrapados = numeroAtrapados;
	}

}