package main.java.interfaz;



import javax.swing.JButton;

import main.java.piezas.Pieza;

public class Casilla extends JButton{

	private static final long serialVersionUID = 1L;
	private int posicionX;
	private int posicionY;
	private Pieza pieza;

	
	public Casilla(int posicionX, int posicionY) {
		this.posicionX = posicionX;
		this.posicionY = posicionY;


	}

	public int getPosicionX() {
		return posicionX;
	}

	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}

	public int getPosicionY() {
		return posicionY;
	}

	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}

	public Pieza getPieza() {
		return pieza;
	}

	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}
	
}
