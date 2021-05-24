package main.java.piezas;


import main.java.interfaz.Casilla;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public abstract class Pieza {
	
	private ImageIcon icono;
	public static String directorio = System.getProperty("user.dir")+"//src//imagenes//";
	public static final String NEGRA = "negra";
	public static final String BLANCA = "blanca";
	
	private String color;
	private int peso;
	private int posicionX;
	private int posicionY;
	
	public Pieza(ImageIcon icono, int posicionX, int posicionY) {
		this.icono = icono;
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		
		if(this.posicionX == 0 || this.posicionX == 1) {
			this.color="negra";
		}
		
		if(this.posicionX == 6 || this.posicionX == 7) {
			this.color="blanca";
		}
	}
	

	public ImageIcon getIcono() {
		return icono;
	}

	public void setIcono(ImageIcon icono) {
		this.icono = icono;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public int getPeso() {
		return peso;
	}


	public void setPeso(int peso) {
		this.peso = peso;
	}


	public int getPosicionX() {
		return posicionX;
	}


	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}


	public int getPosicionY() {
		return posicionY;
	}


	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}
	
	/*
	 * @return Devuelve true si la pieza es blanca
	 */
	public boolean esBlanca() {
		if(	this.color.equals(Pieza.BLANCA)) {
			return true;
		}else {
			return false;
		}
	}
	
	/*
	 * @return Devuelve true si la pieza es negra
	 */
	public boolean esNegra() {
		if(	this.color.equals(Pieza.NEGRA)) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 
	 * @param casillasAmenazadas
	 * @param casillas estado actual del tablero
	 * @param turno necesaria para distinguir al rey del otro color
	 */
	public void darJaque(ArrayList<Point> casillasAmenazadas, Casilla[][]casillas, String turno) {
		
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				// niego la segunda comparación para que seleccione el rey enemigo
				if(casillas[i][j].getPieza() instanceof Rey  && !casillas[i][j].getPieza().getColor().equals(turno)) {
					
					for (Point casilla : casillasAmenazadas) {
						int x = (int)casilla.getX();
						int y = (int)casilla.getY();
						
						
						
						if(x == i && y == j) {
							System.out.println("jaque");
							Rey rey = (Rey) casillas[i][j].getPieza();
							rey.setEstaJaqueado(true);
						}
					}
				}
			}
		}
	}
	
	
	/**
	 * 
	 * @param Matriz de las casillas, donde se encuentra la poscicion de cada una de las piezas
	 * @return casillas dónde se podrá mover la pieza
	 */
	public abstract  ArrayList<Point> mostrarMovimientos(Casilla [][] casillas);
	
	
	
	
	
}
