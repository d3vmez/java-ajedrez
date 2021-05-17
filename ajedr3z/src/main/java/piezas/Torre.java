package main.java.piezas;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import main.java.interfaz.Casilla;

public class Torre extends Pieza{

	public Torre(ImageIcon icono, int posicionX, int posicionY) {
		super(icono, posicionX, posicionY);
		
	}

	@Override
	public ArrayList<Point> mostrarMovimientos(Casilla[][] casillas) {
		
		ArrayList<Point> movimientosPosibles = new ArrayList<Point>();
		Point posicion = null;
		int posicionX = getPosicionX();
		int posicionY = getPosicionY();

		if(this.getColor().equals(Pieza.BLANCA)) {
		// moviemiento horizontal
		for (int i = posicionY+1 ; i < casillas.length; i++) {
			if(casillas[posicionX][i].getPieza() == null) {
				posicion = new  Point(posicionX,i);
				movimientosPosibles.add(posicion);
			}else if(casillas[posicionX][i].getPieza().getColor() == Pieza.NEGRA ) {
				posicion = new  Point(posicionX,i);
				movimientosPosibles.add(posicion);
				break;
			}else if(casillas[posicionX][i].getPieza().getColor() == Pieza.BLANCA ) {
				break;
			}
		}
		
		for (int i = posicionY-1 ; i>= 0; i--) {
			if(casillas[posicionX][i].getPieza() == null) {
				posicion = new  Point(posicionX,i);
				movimientosPosibles.add(posicion);
			}else if(casillas[posicionX][i].getPieza().getColor() == Pieza.NEGRA ) {
				posicion = new  Point(posicionX,i);
				movimientosPosibles.add(posicion);
				break;
			}else if(casillas[posicionX][i].getPieza().getColor() == Pieza.BLANCA ) {
				break;
			}
		}
		
		// movimiento vertical
		for (int i = posicionX+1 ; i < casillas.length; i++) {
			if(casillas[i][posicionY].getPieza() == null) {
				posicion = new  Point(i,posicionY);
				movimientosPosibles.add(posicion);
			}else if(casillas[i][posicionY].getPieza().getColor() == Pieza.NEGRA) {
				posicion = new  Point(i,posicionY);
				movimientosPosibles.add(posicion);
				break;
			}else if(casillas[i][posicionY].getPieza().getColor() == Pieza.BLANCA ) {

				break;
			}
		}
		
		for (int i = posicionX-1 ; i >= 0; i--) {
			if(casillas[i][posicionY].getPieza() == null) {
				posicion = new  Point(i,posicionY);
				movimientosPosibles.add(posicion);
			}else if(casillas[i][posicionY].getPieza().getColor() == Pieza.NEGRA ) {
				posicion = new  Point(i,posicionY);
				movimientosPosibles.add(posicion);
				break;
			}else if(casillas[i][posicionY].getPieza().getColor() == Pieza.BLANCA ) {
				break;
			}
		}
		
		}
		
		if(this.getColor().equals(Pieza.NEGRA)) {
		// moviemiento horizontal
		for (int i = posicionY+1 ; i < casillas.length; i++) {
			if(casillas[posicionX][i].getPieza() == null) {
				posicion = new  Point(posicionX,i);
				movimientosPosibles.add(posicion);
			}else if(casillas[posicionX][i].getPieza().getColor().equals(Pieza.BLANCA)) {
				posicion = new  Point(posicionX,i);
				movimientosPosibles.add(posicion);
				break;
			}else if(casillas[posicionX][i].getPieza().getColor() == Pieza.NEGRA ) {
				break;
			}
		}
		
		for (int i = posicionY-1 ; i>= 0; i--) {
			if(casillas[posicionX][i].getPieza() == null) {
				posicion = new  Point(posicionX,i);
				movimientosPosibles.add(posicion);
			}else if(casillas[posicionX][i].getPieza().getColor() == Pieza.BLANCA ) {
				posicion = new  Point(posicionX,i);
				movimientosPosibles.add(posicion);
				break;
			}else if(casillas[posicionX][i].getPieza().getColor() == Pieza.NEGRA ) {
				break;
			}
		}
		
		// movimiento vertical
		for (int i = posicionX+1 ; i < casillas.length; i++) {
			if(casillas[i][posicionY].getPieza() == null) {
				posicion = new  Point(i,posicionY);
				movimientosPosibles.add(posicion);
			}else if(casillas[i][posicionY].getPieza().getColor() == Pieza.BLANCA) {
				posicion = new  Point(i,posicionY);
				movimientosPosibles.add(posicion);
				break;
			}else if(casillas[i][posicionY].getPieza().getColor() == Pieza.NEGRA ) {

				break;
			}
		}
		
		for (int i = posicionX-1 ; i >= 0; i--) {
			if(casillas[i][posicionY].getPieza() == null) {
				posicion = new  Point(i,posicionY);
				movimientosPosibles.add(posicion);
			}else if(casillas[i][posicionY].getPieza().getColor() == Pieza.BLANCA ) {
				posicion = new  Point(i,posicionY);
				movimientosPosibles.add(posicion);
				break;
			}else if(casillas[i][posicionY].getPieza().getColor() == Pieza.NEGRA ) {
				break;
			}
		}
		
		}
		
		return movimientosPosibles;
		
	}


	
}
