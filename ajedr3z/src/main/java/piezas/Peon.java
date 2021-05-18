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

		// posición de la casilla actual
		int x = this.getPosicionX();
		int y = this.getPosicionY();

		if (this.esNegra()) {

			System.out.println("soy negra");
			if (casillas[x + 1][y].getPieza() == null) {
				Point posicion = new Point(x + 1, y);
				movimientosPosibles.add(posicion);

				if (casillas[x + 2][y].getPieza() == null && this.haSidoMovida == false) {
					posicion = new Point(x + 2, y);
					movimientosPosibles.add(posicion);
				}

				
			}

			if (y + 1 < casillas.length) {
				System.out.println("derecha");
				if (casillas[x + 1][y + 1].getPieza() != null && casillas[x + 1][y + 1].getPieza().esBlanca() ) {
					Point posicion = new Point(x + 1, y + 1);
					movimientosPosibles.add(posicion);
					
				}
			}

			if (y - 1 >= 0) {
				System.out.println("izquierda");
				if (casillas[x + 1][y - 1].getPieza() != null && casillas[x + 1][y - 1].getPieza().esBlanca() ) {
					Point posicion = new Point(x + 1, y - 1);
					movimientosPosibles.add(posicion);
					
				}
			}
		}

		if (this.esBlanca()) {
			System.out.println("soy blanca");
			if (casillas[x - 1][y].getPieza() == null) {
				Point posicion = new Point(x - 1, y);
				movimientosPosibles.add(posicion);

				if (casillas[x - 2][y].getPieza() == null && this.haSidoMovida == false) {
					posicion = new Point(x - 2, y);
					movimientosPosibles.add(posicion);
				}

				
			}

			if (y + 1 < casillas.length) {
				System.out.println("soy derecha");
				if (casillas[x - 1][y + 1].getPieza() != null && casillas[x - 1][y + 1].getPieza().esNegra() ) {
					Point posicion = new Point(x - 1, y + 1);
					movimientosPosibles.add(posicion);
					
				}
			}

			if (y - 1 >= 0) {
				System.out.println("soy izquierda");
				if (casillas[x - 1][y - 1].getPieza() != null && casillas[x - 1][y - 1].getPieza().esNegra() ) {
					Point posicion = new Point(x - 1, y - 1);
					movimientosPosibles.add(posicion);
				
				}
			}

		}
		return movimientosPosibles;
	}
	
	public void seHaMovidoPeon() {
		this.haSidoMovida = true;
	}

}
