package main.java.interfaz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import main.java.piezas.Pieza;

public class Casilla extends JButton implements ActionListener {

	private static final long serialVersionUID = 1L;
	private int posicionX;
	private int posicionY;
	private Pieza pieza;
	private boolean activada;
	
	public Casilla(int posicionX, int posicionY) {
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.activada = false;

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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this) {
			if(this.activada == false) {
			this.setBackground(Color.green);
			System.out.println(this.posicionX);
			this.activada = true;
			}else {
				this.setBackground(Color.RED);
			}
		}
		
	}
	
	
	
	
}
