package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.util.Random;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JPanel;

import hilos.HiloMueveAve;
import mundo.Animal;
import mundo.Ave;
import mundo.Juego;
import mundo.Pato;

public class InterfazJuego extends JFrame {

	private PanelJugar panelJugar;
	private PanelAcercaDe panelAcerca;
	private PanelInicio panelInicio;
	private PanelEscenario panelEscenario;
	private PanelInstrucciones panelInstrucciones;
	private Juego mundo;

	public PanelAcercaDe getPanelAcerca() {
		return panelAcerca;
	}

	public void setPanelAcerca(PanelAcercaDe panelAcerca) {
		this.panelAcerca = panelAcerca;
	}

	public PanelInstrucciones getPanelInstrucciones() {
		return panelInstrucciones;
	}

	public void setPanelInstrucciones(PanelInstrucciones panelInstrucciones) {
		this.panelInstrucciones = panelInstrucciones;
	}

	public PanelInicio getPanelInicio() {
		return panelInicio;
	}

	public void setPanelJugar(PanelJugar panelJugar) {
		this.panelJugar = panelJugar;
	}

	public InterfazJuego() throws LineUnavailableException, IOException, UnsupportedAudioFileException {

		setTitle("DUCK HUNTER");
		setLayout(new BorderLayout());
		setSize(new Dimension(500, 700));
		setBackground(Color.BLACK);

		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		mundo = new Juego(null, 0);
		mundo.cargarPuntaje();
		panelJugar = new PanelJugar(this);
		panelAcerca = new PanelAcercaDe();
		panelInicio = new PanelInicio(this);
		panelEscenario = new PanelEscenario(this);
		panelInstrucciones = new PanelInstrucciones(this);

		add(panelInicio, BorderLayout.CENTER);

	}

	public PanelEscenario getPanelEscenario() {
		return panelEscenario;
	}

	public void refrescarEscenario() {
		panelEscenario.repaint();
	}

	public void setPanelEscenario(PanelEscenario panelEscenario) {
		this.panelEscenario = panelEscenario;
	}

	public PanelJugar getPanelJugar() {
		return panelJugar;
	}

	public void setPanel(PanelJugar panelJugar) {
		this.panelJugar = panelJugar;
	}

	public PanelAcercaDe getPanelPuntaje() {
		return panelAcerca;
	}

	public void setPanelPuntaje(PanelAcercaDe panelAcerca) {
		this.panelAcerca = panelAcerca;
	}

	public PanelInicio getPanelInformacion() {
		return panelInicio;
	}

	public void setPanelInicio(PanelInicio panelInicio) {
		this.panelInicio = panelInicio;
	}

	public Juego getMundo() {
		return mundo;
	}

	public void setMundo(Juego mundo) {
		this.mundo = mundo;
	}

	public void mostrarPanelEscenario() {
		panelEscenario.setVisible(true);
	}

	public void mostrarPanelInstrucciones() {
		panelInstrucciones.setVisible(true);
	}

	public void mostrarPanelAcercaDe() {
		panelAcerca.setVisible(true);

	}
	
	public void mostrarPanelJugar() {
		panelJugar.setVisible(true);
		
	}

	public static void main(String[] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		// TODO Auto-generated method stub
		InterfazJuego v = new InterfazJuego();
		v.setVisible(true);

	}

}
