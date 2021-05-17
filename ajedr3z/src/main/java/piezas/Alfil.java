package main.java.piezas;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import main.java.interfaz.Casilla;

public class Alfil extends Pieza {

	public Alfil(ImageIcon icono, int posicionX, int posicionY) {
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

		// diagonal principal
		// parte de arriba
		for (int i = 0; i < casillas.length; i++) {
			if (posicionX - i >= 0 && posicionX - i < casillas.length && posicionY - i >= 0
					&& posicionY - i < casillas.length) {

				// posibles posiciones correctas para la pieza
				int x = posicionX - i;
				int y = posicionY - i;

				if (casillas[x][y].getPieza() == null) {
					System.out.println("movimiento perfil");
					posicion = new Point(x, y);
					movimientosPosibles.add(posicion);
				}

				else if (this.esBlanca()) {

					// si en la casilla hay una pieza blanca, paramos de añadir casillas correctas
					if (casillas[x][y].getPieza().esBlanca() && casillas[x][y].getPieza() != this) {
						System.out.println("hola");
						break;
					}

					// si en la casillas hay una pieza negra , añadimos una casilla correcta para
					// poder comer a la pieza negra y paramos
					else if (casillas[x][y].getPieza().esNegra() && casillas[x][y].getPieza() != this) {
						posicion = new Point(x, y);
						movimientosPosibles.add(posicion);
						break;
					}

				}

				else if (this.esNegra()) {

					// si en la casilla hay una pieza blanca, paramos de añadir casillas correctas
					if (casillas[x][y].getPieza().esNegra() && casillas[x][y].getPieza() != this) {
						System.out.println("hola");
						break;
					}

					// si en la casillas hay una pieza negra , añadimos una casilla correcta para
					// poder comer a la pieza negra y paramos
					else if (casillas[x][y].getPieza().esBlanca() && casillas[x][y].getPieza() != this) {
						posicion = new Point(x, y);
						movimientosPosibles.add(posicion);
						break;
					}

				}

			}

		}

		// parte de abajo

		for (int i = 0; i < casillas.length; i++) {
			if (posicionX + i >= 0 && posicionX + i < casillas.length && posicionY + i >= 0
					&& posicionY + i < casillas.length) {
				// posibles posiciones correctas para la pieza
				int x = posicionX + i;
				int y = posicionY + i;

				if (casillas[x][y].getPieza() == null) {
					System.out.println("movimiento perfil");
					posicion = new Point(x, y);
					movimientosPosibles.add(posicion);
				}

				else if (this.esBlanca()) {

					// si en la casilla hay una pieza blanca, paramos de añadir casillas correctas
					if (casillas[x][y].getPieza().esBlanca() && casillas[x][y].getPieza() != this) {
						System.out.println("hola");
						break;
					}

					// si en la casillas hay una pieza negra , añadimos una casilla correcta para
					// poder comer a la pieza negra y paramos
					else if (casillas[x][y].getPieza().esNegra() && casillas[x][y].getPieza() != this) {
						posicion = new Point(x, y);
						movimientosPosibles.add(posicion);
						break;
					}

				}

				else if (this.esNegra()) {

					// si en la casilla hay una pieza blanca, paramos de añadir casillas correctas
					if (casillas[x][y].getPieza().esNegra() && casillas[x][y].getPieza() != this) {
						System.out.println("hola");
						break;
					}

					// si en la casillas hay una pieza negra , añadimos una casilla correcta para
					// poder comer a la pieza negra y paramos
					else if (casillas[x][y].getPieza().esBlanca() && casillas[x][y].getPieza() != this) {
						posicion = new Point(x, y);
						movimientosPosibles.add(posicion);
						break;
					}

				}
			}

		}

		// diagonal inversa
		// parte de arriba
		for (int i = 0; i < casillas.length; i++) {
			if (posicionX - i >= 0 && posicionX - i < casillas.length && posicionY + i >= 0
					&& posicionY + i < casillas.length) {
				// posibles posiciones correctas para la pieza
				int x = posicionX - i;
				int y = posicionY + i;

				if (casillas[x][y].getPieza() == null) {
					System.out.println("movimiento perfil");
					posicion = new Point(x, y);
					movimientosPosibles.add(posicion);
				}

				else if (this.esBlanca()) {

					// si en la casilla hay una pieza blanca, paramos de añadir casillas correctas
					if (casillas[x][y].getPieza().esBlanca() && casillas[x][y].getPieza() != this) {
						System.out.println("hola");
						break;
					}

					// si en la casillas hay una pieza negra , añadimos una casilla correcta para
					// poder comer a la pieza negra y paramos
					else if (casillas[x][y].getPieza().esNegra() && casillas[x][y].getPieza() != this) {
						posicion = new Point(x, y);
						movimientosPosibles.add(posicion);
						break;
					}

				}

				else if (this.esNegra()) {

					// si en la casilla hay una pieza blanca, paramos de añadir casillas correctas
					if (casillas[x][y].getPieza().esNegra() && casillas[x][y].getPieza() != this) {
						System.out.println("hola");
						break;
					}

					// si en la casillas hay una pieza negra , añadimos una casilla correcta para
					// poder comer a la pieza negra y paramos
					else if (casillas[x][y].getPieza().esBlanca() && casillas[x][y].getPieza() != this) {
						posicion = new Point(x, y);
						movimientosPosibles.add(posicion);
						break;
					}

				}
			}

		}

		// parte de abajo
		for (int i = 0; i < casillas.length; i++) {
			if (posicionX + i >= 0 && posicionX + i < casillas.length && posicionY - i >= 0
					&& posicionY - i < casillas.length) {
				// posibles posiciones correctas para la pieza
				int x = posicionX + i;
				int y = posicionY - i;

				if (casillas[x][y].getPieza() == null) {
					System.out.println("movimiento perfil");
					posicion = new Point(x, y);
					movimientosPosibles.add(posicion);
				}

				else if (this.esBlanca()) {

					// si en la casilla hay una pieza blanca, paramos de añadir casillas correctas
					if (casillas[x][y].getPieza().esBlanca() && casillas[x][y].getPieza() != this) {
						System.out.println("hola");
						break;
					}

					// si en la casillas hay una pieza negra , añadimos una casilla correcta para
					// poder comer a la pieza negra y paramos
					else if (casillas[x][y].getPieza().esNegra() && casillas[x][y].getPieza() != this) {
						posicion = new Point(x, y);
						movimientosPosibles.add(posicion);
						break;
					}

				}

				else if (this.esNegra()) {

					// si en la casilla hay una pieza blanca, paramos de añadir casillas correctas
					if (casillas[x][y].getPieza().esNegra() && casillas[x][y].getPieza() != this) {
						System.out.println("hola");
						break;
					}

					// si en la casillas hay una pieza negra , añadimos una casilla correcta para
					// poder comer a la pieza negra y paramos
					else if (casillas[x][y].getPieza().esBlanca() && casillas[x][y].getPieza() != this) {
						posicion = new Point(x, y);
						movimientosPosibles.add(posicion);
						break;
					}

				}
			}

		}

		return movimientosPosibles;
	}

}
