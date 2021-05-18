package main.java.interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import main.java.piezas.*;

public class Tablero extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private Casilla[][] casillas = new Casilla[8][8];

	private Pieza piezaTemporal;
	private Casilla casillaTemporal;
	private ArrayList<Point> movimientosTemporal = null;

	public Tablero() {
		this.setBounds(50, 30, 600, 600);
		this.setBackground(Color.GRAY);
		this.setLayout(new GridLayout(8, 8));

		int contadorCasillas = 0;

		for (int i = 0; i < 8; i++) {

			for (int j = 0; j < 8; j++) {

				casillas[i][j] = new Casilla(i, j);
				if (contadorCasillas % 2 == 0) {

					casillas[i][j].setBackground(Color.WHITE);

				} else {

					casillas[i][j].setBackground(Color.GRAY);

				}

				// se colocan las piezas en el tablero
				ImageIcon imagen = null;
				if (i == 1 || i == 6) {
					if (i == 1) {
						imagen = new ImageIcon(Pieza.directorio + "PeonN.png");
					} else {
						imagen = new ImageIcon(Pieza.directorio + "PeonB.png");
					}
					Peon peon = new Peon(imagen, i, j);
					casillas[i][j].setIcon(peon.getIcono());
					casillas[i][j].setPieza(peon);
				}

				if ((i == 0 || i == 7) && (j == 0 || j == 7)) {
					if (i == 0) {
						imagen = new ImageIcon(Pieza.directorio + "TorreN.png");
					} else if (i == 7) {
						imagen = new ImageIcon(Pieza.directorio + "TorreB.png");
					}
					Torre torre = new Torre(imagen, i, j);
					casillas[i][j].setIcon(torre.getIcono());
					casillas[i][j].setPieza(torre);
				}

				if ((i == 0 || i == 7) && (j == 1 || j == 6)) {
					if (i == 0) {
						imagen = new ImageIcon(Pieza.directorio + "CaballoN.png");
					} else if (i == 7) {
						imagen = new ImageIcon(Pieza.directorio + "CaballoB.png");
					}
					Caballo caballo = new Caballo(imagen, i, j);
					casillas[i][j].setIcon(caballo.getIcono());
					casillas[i][j].setPieza(caballo);
				}

				if ((i == 0 || i == 7) && (j == 2 || j == 5)) {
					if (i == 0) {
						imagen = new ImageIcon(Pieza.directorio + "AlfilN.png");
					} else if (i == 7) {
						imagen = new ImageIcon(Pieza.directorio + "AlfilB.png");
					}
					Alfil alfil = new Alfil(imagen, i, j);
					casillas[i][j].setIcon(alfil.getIcono());
					casillas[i][j].setPieza(alfil);
				}

				if ((i == 0 || i == 7) && j == 3) {
					if (i == 0) {
						imagen = new ImageIcon(Pieza.directorio + "ReinaN.png");
					} else if (i == 7) {
						imagen = new ImageIcon(Pieza.directorio + "ReinaB.png");
					}
					Reina reina = new Reina(imagen, i, j);
					casillas[i][j].setIcon(reina.getIcono());
					casillas[i][j].setPieza(reina);
				}

				if ((i == 0 || i == 7) && j == 4) {
					if (i == 0) {
						imagen = new ImageIcon(Pieza.directorio + "ReyN.png");
					} else if (i == 7) {
						imagen = new ImageIcon(Pieza.directorio + "ReyB.png");
					}
					Rey rey = new Rey(imagen, i, j);
					casillas[i][j].setIcon(rey.getIcono());
					casillas[i][j].setPieza(rey);
				}

				this.add(casillas[i][j]);
				casillas[i][j].addActionListener(this);

				contadorCasillas++;

			}

			contadorCasillas++;

		}

	} // Fin constructor

	/**
	 * Evento cuando se hace click sobre una casilla del tablero
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Casilla c = (Casilla) e.getSource();
		
		//comer
		if(c.getPieza() != null && this.piezaTemporal != null && esMovimientoValido(movimientosTemporal, c)) {
			System.out.println(c.getPosicionX());
			resetearColorCasillas();
			c.setPieza(this.piezaTemporal);
			c.setIcon(this.piezaTemporal.getIcono());
			c.getPieza().setPosicionX(c.getPosicionX());
			c.getPieza().setPosicionY(c.getPosicionY());
			this.casillaTemporal.setPieza(null);
			this.casillaTemporal.setIcon(null);
		}
		
		//seleccionar
		if (c.getPieza() != null) {
			if (c.getPieza() instanceof Peon) {
				System.out.println("soy peon en la casilla" + c.getPieza().getPosicionX() + c.getPieza().getPosicionY());

				dibujarMovimientosValidos(c.getPieza());
				this.movimientosTemporal = c.getPieza().mostrarMovimientos(casillas);

			}

			if (c.getPieza() instanceof Torre) {
				System.out
						.println("soy torre en la casilla" + c.getPieza().getPosicionX() + c.getPieza().getPosicionY());

				dibujarMovimientosValidos(c.getPieza());
				this.movimientosTemporal = c.getPieza().mostrarMovimientos(casillas);

			}

			if (c.getPieza() instanceof Alfil) {
				System.out
						.println("soy alfil en la casilla" + c.getPieza().getPosicionX() + c.getPieza().getPosicionY());

				dibujarMovimientosValidos(c.getPieza());
				this.movimientosTemporal = c.getPieza().mostrarMovimientos(casillas);

			}

			if (c.getPieza() instanceof Caballo) {
				System.out
						.println("soy alfil en la casilla" + c.getPieza().getPosicionX() + c.getPieza().getPosicionY());

				dibujarMovimientosValidos(c.getPieza());
				this.movimientosTemporal = c.getPieza().mostrarMovimientos(casillas);

			}

			if (c.getPieza() instanceof Reina) {
				System.out
						.println("soy alfil en la casilla" + c.getPieza().getPosicionX() + c.getPieza().getPosicionY());

				dibujarMovimientosValidos(c.getPieza());
				this.movimientosTemporal = c.getPieza().mostrarMovimientos(casillas);

			}

			if (c.getPieza() instanceof Rey) {
				System.out
						.println("soy alfil en la casilla" + c.getPieza().getPosicionX() + c.getPieza().getPosicionY());

				dibujarMovimientosValidos(c.getPieza());
				this.movimientosTemporal = c.getPieza().mostrarMovimientos(casillas);

			}
			this.casillaTemporal = c;
			this.casillaTemporal.setBackground(Color.GREEN);
			this.piezaTemporal = c.getPieza();

			System.out.println("tengo pieza");
		} else {
			System.out.println("no tengo pieza");
			//if (c != null) {

				// comprobar que el movimiento es valido
				if (esMovimientoValido(movimientosTemporal, c)) {
					

					System.out.println(c.getPosicionX());
					resetearColorCasillas();
					c.setPieza(this.piezaTemporal);
					c.setIcon(this.piezaTemporal.getIcono());
					c.getPieza().setPosicionX(c.getPosicionX());
					c.getPieza().setPosicionY(c.getPosicionY());
					this.casillaTemporal.setPieza(null);
					this.casillaTemporal.setIcon(null);

					System.out.println(this.piezaTemporal.getPosicionX());
					System.out.println(this.piezaTemporal.getPosicionY());
					
				}
				
			
			//}
		}
	}

	/**
	 * Función para que las casillas del tablero retomen su color original
	 */
	private void resetearColorCasillas() {
		int contadorCasillas = 0;

		for (int i = 0; i < 8; i++) {

			for (int j = 0; j < 8; j++) {

				if (contadorCasillas % 2 == 0) {

					this.casillas[i][j].setBackground(Color.WHITE);

				} else {

					this.casillas[i][j].setBackground(Color.GRAY);

				}

				contadorCasillas++;
			}
			contadorCasillas++;
		}
	}

	/**
	 * 
	 * @param Pieza pieza, se pasa como argumento la pieza seleccionada del tablero
	 */
	private void dibujarMovimientosValidos(Pieza pieza) {
		ArrayList<Point> mov = pieza.mostrarMovimientos(casillas);

		for (Point point : mov) {
			int x = (int) point.getX();
			int y = (int) point.getY();
			casillas[x][y].setBackground(Color.blue);
		}

	}

	private boolean esMovimientoValido(ArrayList<Point> movimientosTemporal, Casilla casilla) {

		for (Point point : movimientosTemporal) {
			int x = (int) point.getX();
			int y = (int) point.getY();
			
			if (casilla.getPosicionX() == x && casilla.getPosicionY() == y) {
				
				System.out.println(x);
				System.out.println(y);
				if(this.piezaTemporal instanceof Peon) {
					System.out.println("ooooOOO");
					((Peon) this.piezaTemporal).seHaMovidoPeon();
				}
				return true;
			}
		}

		return false;

	}

}
