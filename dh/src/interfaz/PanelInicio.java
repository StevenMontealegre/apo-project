package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import exceptions.CasillaVaciaException;
import exceptions.YaExisteUsuarioException;
import mundo.Usuario;

public class PanelInicio extends JPanel implements ActionListener {

	private JLabel lbBanner;
	private JTextArea txtArea;
	private JScrollPane scroll;
	private JLabel lbNickname;
	private JTextField txtNickname;
	private JButton btnJugar;
	private JButton btnInstrucciones;
	private JButton btnAcerca;
	private InterfazJuego principal;

	public final static String JUGAR = "Jugar";
	public final static String INSTRUCCIONES = "Instrucciones";
	public final static String ACERCADE = "Acercade";

	public PanelInicio(InterfazJuego p) {

		principal = p;
		ImageIcon imagen = new ImageIcon("images/portada.png");
		lbBanner = new JLabel(imagen);
		txtArea = new JTextArea();
		txtArea.setLineWrap(true);
		txtArea.setWrapStyleWord(true);
		txtArea.setBackground(Color.BLACK);
		txtArea.setEditable(false);
		Font fuente5 = new Font("Calibri", 3, 25);
		JLabel lbPuntaje = new JLabel("TOP SCORE\n");
		lbPuntaje.setFont(fuente5);
		txtArea.setFont(fuente5);
		txtArea.setForeground(Color.GREEN);
		txtArea.append(lbPuntaje.getText());

		scroll = new JScrollPane(txtArea);
		scroll.setPreferredSize(new Dimension(220, 220));
		scroll.setBackground(Color.BLACK);

		lbNickname = new JLabel("NICKNAME: ");
		Font fuente4 = new Font("Calibri", 3, 18);
		txtNickname = new JTextField();
		lbNickname.setFont(fuente4);
		lbNickname.setForeground(Color.GREEN);

		btnJugar = new JButton("JUGAR");
		Font fuente = new Font("Calibri", 3, 18);
		btnJugar.setBackground(Color.BLACK);
		btnJugar.setForeground(Color.GREEN);
		btnJugar.setFont(fuente);
		btnJugar.setActionCommand(JUGAR);
		btnJugar.addActionListener(this);

		btnInstrucciones = new JButton("INSTRUCCIONES");
		Font fuente2 = new Font("Calibri", 3, 18);
		btnInstrucciones.setBackground(Color.BLACK);
		btnInstrucciones.setForeground(Color.GREEN);
		btnInstrucciones.setFont(fuente2);
		btnInstrucciones.setActionCommand(INSTRUCCIONES);
		btnInstrucciones.addActionListener(this);

		btnAcerca = new JButton("ACERCA DE");
		Font fuente3 = new Font("Calibri", 3, 18);
		btnAcerca.setBackground(Color.BLACK);
		btnAcerca.setForeground(Color.GREEN);
		btnAcerca.setFont(fuente3);
		btnAcerca.setActionCommand(ACERCADE);
		btnAcerca.addActionListener(this);

		setLayout(new BorderLayout());
		JPanel panelAux1 = new JPanel();
		panelAux1.setLayout(new GridLayout(1, 2));
		panelAux1.setBackground(Color.BLACK);
		panelAux1.add(lbNickname);
		panelAux1.add(txtNickname);

		JPanel panelAux2 = new JPanel();
		panelAux2.setLayout(new GridLayout(1, 3));
		panelAux2.add(btnJugar);
		panelAux2.add(btnInstrucciones);
		panelAux2.add(btnAcerca);

		JPanel panelAux3 = new JPanel();
		panelAux3.setLayout(new GridLayout(2, 1));
		panelAux3.add(panelAux1);
		panelAux3.add(panelAux2);

		add(lbBanner, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);
		add(panelAux3, BorderLayout.SOUTH);

	}

	public void pintarScore(String nick, int sc) {

		String resultado = nick + " " + sc + "";
		txtArea.append(resultado + "\n");

	}

	public void refrescarCampos() {
		txtNickname.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String comando = e.getActionCommand();
		if (comando.equalsIgnoreCase(INSTRUCCIONES)) {
			principal.mostrarPanelInstrucciones();
		} else if (comando.equalsIgnoreCase(ACERCADE)) {
			principal.mostrarPanelAcercaDe();
		} else {
			if (!txtNickname.getText().equals("")) {
				String usuario = txtNickname.getText();
				try {
					Usuario usu = new Usuario(usuario);
					principal.getMundo().agregarUsuario(usu);
					principal.getMundo().setUsuarioActual(usu);
					principal.mostrarPanelJugar();
					refrescarCampos();
				} catch (YaExisteUsuarioException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(this, "El usuario ya existe\n" + " Bienvenido \n "
							+ principal.getMundo().getUsuarioActual().getNickname());
					principal.mostrarPanelJugar();
				}

			} else {
				try {
					throw new CasillaVaciaException();
				} catch (CasillaVaciaException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
				}
			}

		}
	}
}
