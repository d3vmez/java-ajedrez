package main.java.piezas;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import main.java.interfaz.Casilla;

public class Torre extends Pieza {

	public Torre(ImageIcon icono, int posicionX, int posicionY) {
		super(icono, posicionX, posicionY);

	}

	@Override
	public ArrayList<Point> mostrarMovimientos(Casilla[][] casillas) {

		ArrayList<Point> movimientosPosibles = new ArrayList<Point>();
		Point posicion = null;

		// posición de la casilla actual
		int posicionX = getPosicionX();
		int posicionY = getPosicionY();

		// moviemiento horizontal
		// se itera sobre las columnas(y) de la derecha, posicionX fija ya que siempre
		// estaremos en la
		// misma fila
		for (int y = posicionY + 1; y < casillas.length; y++) {
			if (casillas[posicionX][y].getPieza() == null) {
				posicion = new Point(posicionX, y);
				movimientosPosibles.add(posicion);
			}

			else if (this.esBlanca()) {

				if (casillas[posicionX][y].getPieza().esNegra()) {
					posicion = new Point(posicionX, y);
					movimientosPosibles.add(posicion);
					break;
				} else if (casillas[posicionX][y].getPieza().esBlanca()) {
					break;
				}
			}

			else if (this.esNegra()) {
				if (casillas[posicionX][y].getPieza().esBlanca()) {
					posicion = new Point(posicionX, y);
					movimientosPosibles.add(posicion);
					break;
				} else if (casillas[posicionX][y].getPieza().esNegra()) {
					break;
				}
			}

		}

		// se itera sobre las columnas(y) de la izquierda, posicionX fija ya que siempre
		// estaremos en la
		// misma fila
		for (int y = posicionY - 1; y >= 0; y--) {
			if (casillas[posicionX][y].getPieza() == null) {
				posicion = new Point(posicionX, y);
				movimientosPosibles.add(posicion);
			} else if (this.esBlanca()) {
				if (casillas[posicionX][y].getPieza().esNegra()) {
					posicion = new Point(posicionX, y);
					movimientosPosibles.add(posicion);
					break;
				} else if (casillas[posicionX][y].getPieza().esBlanca()) {
					break;
				}

			}

			else if (this.esNegra()) {
				if (casillas[posicionX][y].getPieza().esBlanca()) {
					posicion = new Point(posicionX, y);
					movimientosPosibles.add(posicion);
					break;
				} else if (casillas[posicionX][y].getPieza().esNegra()) {
					break;
				}
			}
		}

		// movimiento vertical
		// se itera sobre las filas(x) de arriba hacia abajo, posicionY fija ya que siempre
		// estaremos en la
		// misma columna
		for (int x = posicionX + 1; x < casillas.length; x++) {
			if (casillas[x][posicionY].getPieza() == null) {
				posicion = new Point(x, posicionY);
				movimientosPosibles.add(posicion);
			} else if (this.esBlanca()) {

				if (casillas[x][posicionY].getPieza().esNegra()) {
					posicion = new Point(x, posicionY);
					movimientosPosibles.add(posicion);
					break;
				} else if (casillas[x][posicionY].getPieza().esBlanca()) {

					break;
				}
			}

			else if (this.esNegra()) {
				if (casillas[x][posicionY].getPieza().esBlanca()) {
					posicion = new Point(x, posicionY);
					movimientosPosibles.add(posicion);
					break;
				} else if (casillas[x][posicionY].getPieza().esNegra()) {

					break;
				}
			}
		}

		// movimiento vertical
		// se itera sobre las filas(x) de abajo hacia arriba, posicionY fija ya que siempre
		// estaremos en la
		// misma columna
		for (int x = posicionX - 1; x >= 0; x--) {

			if (casillas[x][posicionY].getPieza() == null) {
				posicion = new Point(x, posicionY);
				movimientosPosibles.add(posicion);
			} else if (this.esBlanca()) {

				if (casillas[x][posicionY].getPieza().esNegra()) {
					posicion = new Point(x, posicionY);
					movimientosPosibles.add(posicion);
					break;
				} else if (casillas[x][posicionY].getPieza().esBlanca()) {

					break;
				}
			}

			else if (this.esNegra()) {
				if (casillas[x][posicionY].getPieza().esBlanca()) {
					posicion = new Point(x, posicionY);
					movimientosPosibles.add(posicion);
					break;
				} else if (casillas[x][posicionY].getPieza().esNegra()) {

					break;
				}
			}
		}

		return movimientosPosibles;
	}

}
