package main.java.piezas;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import main.java.interfaz.Casilla;

public class Caballo extends Pieza {

	public Caballo(ImageIcon icono, int posicionX, int posicionY) {
		super(icono, posicionX, posicionY);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Point> mostrarMovimientos(Casilla[][] casillas) {

		// Para guardar las coordenadas de las casillas que son validas
		ArrayList<Point> movimientosPosibles = new ArrayList<Point>();
		Point posicion = null;

		// posición de la casilla actual
		int posicionX = getPosicionX();
		int posicionY = getPosicionY();

		// Para guardar los movimientos posibles del caballo
		@SuppressWarnings("serial")
		ArrayList<Point> movimientosCaballo = new ArrayList<Point>() {
			{
				add(new Point(posicionX + 2, posicionY + 1));
				add(new Point(posicionX + 2, posicionY - 1));
				add(new Point(posicionX - 2, posicionY + 1));
				add(new Point(posicionX - 2, posicionY - 1));
				add(new Point(posicionX + 1, posicionY + 2));
				add(new Point(posicionX + 1, posicionY - 2));
				add(new Point(posicionX - 1, posicionY - 2));
				add(new Point(posicionX - 1, posicionY + 2));
			}
		};

		for (Point point : movimientosCaballo) {

			int x = (int) point.getX();
			int y = (int) point.getY();

			if (x < casillas.length && x >= 0 && y < casillas.length && y >= 0) {

				// se comprueban las casillas con los movimientos del caballo
				// casilla vacia
				if (casillas[x][y].getPieza() == null) {
					posicion = new Point(x, y);
					movimientosPosibles.add(posicion);
				}

				// pieza blanca
				else if (this.esBlanca()) {
					if (casillas[x][y].getPieza().esNegra()) {
						posicion = new Point(x, y);
						movimientosPosibles.add(posicion);
					}
				}

				// pieza negra
				else if (this.esNegra()) {
					if (casillas[x][y].getPieza().esBlanca()) {
						posicion = new Point(x, y);
						movimientosPosibles.add(posicion);
					}
				}
			}
		}

		return movimientosPosibles;
	}

}
