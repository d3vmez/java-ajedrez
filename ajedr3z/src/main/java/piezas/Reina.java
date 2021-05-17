package main.java.piezas;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import main.java.interfaz.Casilla;

public class Reina extends Pieza{

	public Reina(ImageIcon icono, int posicionX, int posicionY) {
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
