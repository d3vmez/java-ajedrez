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

	private ArrayList<Point> casillasAmenazadas = null;

	private String turno = Pieza.BLANCA;
	
	private Historial historial;
	private Cronometro cronometro;
	


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
	public void actionPerformed(ActionEvent e) throws NullPointerException {

		// Se guarda que casilla se ha pulsado
		Casilla casilla = (Casilla) e.getSource();

		// Cuando se pulsa una casilla se resetea el color del tablero
		resetearColorCasillas();

		// Cronometro
		
		//cronometro.empezarBlancas();


		try {
			
			//comprobar jaque
			
			if(esJaque(this.turno)) {
				System.out.println("JAQUEEEEE");
			}
		
			// seleccionar
			if (casilla.tienePieza() && this.piezaTemporal == null
					&& casilla.getPieza().getColor().equals(this.turno)) {
				if (casilla.getPieza() instanceof Peon) {
					System.out.println("soy peon en la casilla" + casilla.getPieza().getPosicionX()
							+ casilla.getPieza().getPosicionY());

					
					this.movimientosTemporal = casilla.getPieza().mostrarMovimientos(casillas);
					dibujarMovimientosValidos(this.movimientosTemporal);

				}

				if (casilla.getPieza() instanceof Torre) {
					System.out.println("soy torre en la casilla" + casilla.getPieza().getPosicionX()
							+ casilla.getPieza().getPosicionY());

					
					this.movimientosTemporal = casilla.getPieza().mostrarMovimientos(casillas);
					dibujarMovimientosValidos(this.movimientosTemporal);

				}

				if (casilla.getPieza() instanceof Alfil) {
					System.out.println("soy alfil en la casilla" + casilla.getPieza().getPosicionX()
							+ casilla.getPieza().getPosicionY());

					
					this.movimientosTemporal = casilla.getPieza().mostrarMovimientos(casillas);
					dibujarMovimientosValidos(this.movimientosTemporal);

				}

				if (casilla.getPieza() instanceof Caballo) {
					System.out.println("soy alfil en la casilla" + casilla.getPieza().getPosicionX()
							+ casilla.getPieza().getPosicionY());

					
					this.movimientosTemporal = casilla.getPieza().mostrarMovimientos(casillas);
					dibujarMovimientosValidos(this.movimientosTemporal);

				}

				if (casilla.getPieza() instanceof Reina) {
					System.out.println("soy alfil en la casilla" + casilla.getPieza().getPosicionX()
							+ casilla.getPieza().getPosicionY());

					
					
			
					this.movimientosTemporal = casilla.getPieza().mostrarMovimientos(casillas);
					dibujarMovimientosValidos(this.movimientosTemporal);

				}

				if (casilla.getPieza() instanceof Rey) {
					System.out.println("soy alfil en la casilla" + casilla.getPieza().getPosicionX()
							+ casilla.getPieza().getPosicionY());

					String turno="";
					if (this.turno.equals(Pieza.BLANCA)) {
						turno = Pieza.NEGRA;
					} else {
						turno = Pieza.BLANCA;
					}
					
					ArrayList<Point> amenezasParaRey = casillasAmenazadasEnemigo(turno);
					
					this.movimientosTemporal = casilla.getPieza().mostrarMovimientos(casillas);
					
					this.movimientosTemporal.removeAll(amenezasParaRey);
					
					dibujarMovimientosValidos(this.movimientosTemporal);

				}
				this.casillaTemporal = casilla;
				this.casillaTemporal.setBackground(Color.GREEN);
				this.piezaTemporal = casilla.getPieza();

				System.out.println("tengo pieza");



			}

			// mover pieza a casilla, si esta ocupada por el enemigo comer casilla
			else {
				System.out.println("no tengo pieza");
				
			

				// comprobar que el movimiento es valido y existe pieza para mover
				if (esMovimientoValido(movimientosTemporal, casilla) && this.piezaTemporal != null) {
					
					
					
					System.out.println(casilla.getPosicionX());
					casilla.moverPieza(piezaTemporal);
					casillaTemporal.setPieza(null);
					this.casillaTemporal.setIcon(null);
					
					
					// una vez movida la pieza, puedar dar jaque al rey enemigo
					this.casillasAmenazadas = casillasAmenazadasEnemigo(this.turno);
					
					System.out.println("amenazas=" + this.casillasAmenazadas.size());
					for (Point point : this.casillasAmenazadas) {
						int x = (int) point.getX();
						int y = (int) point.getY();
						casillas[x][y].setBackground(Color.RED);
						System.out.println("casillas amenzadas"+x+" "+y);
					}
					
					casilla.getPieza().darJaque(casillasAmenazadas, casillas, turno);
					
					System.out.println(this.piezaTemporal.getPosicionX());
					System.out.println(this.piezaTemporal.getPosicionY());
					
					//escribir al jlist y bd

					String nombre = this.piezaTemporal.getIcono().getDescription();
					String jugada = String.valueOf(this.piezaTemporal.getPosicionX()+" "+this.piezaTemporal.getPosicionY());
					historial.modeloLista.addElement(jugada);
					
					//cronometro
	
					
					// Cambio de turno
					if (this.turno.equals(Pieza.BLANCA)) {
						this.turno = Pieza.NEGRA;
					} else {
						this.turno = Pieza.BLANCA;
					}

				}
				

				this.piezaTemporal = null;

			}
		} catch (NullPointerException e1) {
			// TODO Auto-generated catch block
			System.out.println("No has seleccionado ninguna ficha");
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
	private void dibujarMovimientosValidos(ArrayList<Point> movimientosValidos) {
		

		for (Point point : movimientosValidos) {
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
				if (this.piezaTemporal instanceof Peon) {
					System.out.println("ooooOOO");
					((Peon) this.piezaTemporal).seHaMovidoPeon();
				}
				return true;
			}
		}

		return false;

	}

	private ArrayList<Point> casillasAmenazadasEnemigo(String turno) {

		if (turno.equals(Pieza.BLANCA)) {
			
			turno = Pieza.BLANCA;
		} else {
			turno = Pieza.NEGRA;
		}

		ArrayList<Point> movimientosReales = new ArrayList<Point>();

		ArrayList<Point> temporal = new ArrayList<Point>();

		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {

				if (casillas[i][j].tienePieza() && casillas[i][j].getPieza().getColor().equals(turno)) {

					if (casillas[i][j].getPieza() instanceof Peon) {

						
					}

					if (casillas[i][j].getPieza() instanceof Torre) {
						temporal = casillas[i][j].getPieza().mostrarMovimientos(casillas);
						for (Point point : temporal) {
							movimientosReales.add(point);
						}
					}

					if (casillas[i][j].getPieza() instanceof Caballo) {
						temporal = casillas[i][j].getPieza().mostrarMovimientos(casillas);
						for (Point point : temporal) {
							movimientosReales.add(point);
						}
					}

					if (casillas[i][j].getPieza() instanceof Alfil) {
						temporal = casillas[i][j].getPieza().mostrarMovimientos(casillas);
						for (Point point : temporal) {
							movimientosReales.add(point);
						}
					}

					if (casillas[i][j].getPieza() instanceof Reina) {
						temporal = casillas[i][j].getPieza().mostrarMovimientos(casillas);
						for (Point point : temporal) {
							movimientosReales.add(point);
						}
					}

					if (casillas[i][j].getPieza() instanceof Rey) {
						temporal = casillas[i][j].getPieza().mostrarMovimientos(casillas);
						for (Point point : temporal) {
							movimientosReales.add(point);
						}
					}
				}
			}
		}

		return movimientosReales;
	}
	
	private boolean esJaque(String turno) {
		
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				if(casillas[i][j].getPieza() instanceof Rey && casillas[i][j].getPieza().getColor().equals(turno)) {
					
					Rey rey = (Rey)casillas[i][j].getPieza();
					if(rey.isEstaJaqueado()) {
						casillas[i][j].setBackground(Color.MAGENTA);
						return true;
					}
				}
			}
		}
		
		return false;
	}

}
