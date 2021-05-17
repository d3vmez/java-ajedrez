package main.java.piezas;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import main.java.interfaz.Casilla;

public class Peon extends Pieza {

	private boolean haSidoMovida = false;

	public Peon(ImageIcon icono, int posicionX, int posicionY) {
		super(icono, posicionX, posicionY);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Point> mostrarMovimientos(Casilla[][] casillas) {

		ArrayList<Point> movimientosPosibles = new ArrayList<Point>();

		if (this.getColor().equals(Pieza.NEGRA)) {

			System.out.println("soy negra");
			if (casillas[getPosicionX() + 1][getPosicionY()].getPieza() == null) {
				Point posicion = new Point(getPosicionX() + 1, getPosicionY());
				movimientosPosibles.add(posicion);

				if (casillas[getPosicionX() + 2][getPosicionY()].getPieza() == null && this.haSidoMovida == false) {
					posicion = new Point(getPosicionX() + 2, getPosicionY());
					movimientosPosibles.add(posicion);
				}

				this.haSidoMovida = true;
			}

			if (getPosicionY() + 1 < casillas.length ) {
				System.out.println("derecha");
				if (casillas[getPosicionX() + 1][getPosicionY() + 1].getPieza() != null) {
					Point posicion = new Point(getPosicionX() + 1, getPosicionY() + 1);
					movimientosPosibles.add(posicion);
					this.haSidoMovida = true;
				}
			}
			
			if (getPosicionY() - 1 >= 0 ) {
				System.out.println("izquierda");
				if (casillas[getPosicionX() + 1][getPosicionY() - 1].getPieza() != null) {
					Point posicion = new Point(getPosicionX() + 1, getPosicionY() - 1);
					movimientosPosibles.add(posicion);
					this.haSidoMovida = true;
				}
			}

			

		}

		System.out.println("soy peon en la casilla" + this.getPosicionX() + this.getPosicionY());

		if (this.getColor().equals(Pieza.BLANCA)) {
			System.out.println("soy blanca");
			if (casillas[getPosicionX() - 1][getPosicionY()].getPieza() == null) {
				Point posicion = new Point(getPosicionX() - 1, getPosicionY());
				movimientosPosibles.add(posicion);

				if (casillas[getPosicionX() - 2][getPosicionY()].getPieza() == null && this.haSidoMovida == false) {
					posicion = new Point(getPosicionX() - 2, getPosicionY());
					movimientosPosibles.add(posicion);
				}

				this.haSidoMovida = true;
			}

			if (getPosicionY() + 1 < casillas.length ) {
				System.out.println("soy derecha");
				if (casillas[getPosicionX() - 1][getPosicionY() + 1].getPieza() != null) {
					Point posicion = new Point(getPosicionX() - 1, getPosicionY() + 1);
					movimientosPosibles.add(posicion);
					this.haSidoMovida = true;
				}
			}
			
			if(getPosicionY() - 1 >= 0) {
				System.out.println("soy izquierda");
				if (casillas[getPosicionX() - 1][getPosicionY() - 1].getPieza() != null) {
					Point posicion = new Point(getPosicionX() - 1, getPosicionY() - 1);
					movimientosPosibles.add(posicion);
					this.haSidoMovida = true;
				}
			}
			
		}
		return movimientosPosibles;
	}

}
