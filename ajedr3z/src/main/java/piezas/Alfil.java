package main.java.piezas;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import main.java.interfaz.Casilla;

public class Alfil extends Pieza{

	public Alfil(ImageIcon icono, int posicionX, int posicionY) {
		super(icono, posicionX, posicionY);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Point> mostrarMovimientos(Casilla[][] casillas) {
		
		ArrayList<Point> movimientosPosibles = new ArrayList<Point>();
		Point posicion = null;
		int posicionX = getPosicionX();
		int posicionY = getPosicionY();
		
		for (int i = 0; i < casillas.length; i++) {
			if(posicionX-i >= 0 && posicionX+i <casillas.length && posicionY-i >= 0 && posicionY+i <casillas.length ) {
			if(casillas[Math.abs(posicionX-i)][Math.abs(posicionY-i)].getPieza() == null ){
				posicion = new Point(posicionX-i,posicionY-i);
				movimientosPosibles.add(posicion);
			}
			}
			
		}
		return movimientosPosibles;
	}

}
