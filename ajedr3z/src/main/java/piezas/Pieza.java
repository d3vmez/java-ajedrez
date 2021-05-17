package main.java.piezas;


import main.java.interfaz.Casilla;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public abstract class Pieza {
	
	private ImageIcon icono;
	public static String directorio = System.getProperty("user.dir")+"//src//imagenes//";
	protected static final String NEGRA = "negra";
	protected static final String BLANCA = "blanca";
	
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
	
	
	/**
	 * 
	 * @param Matriz de las casillas, donde se encuentra la poscicion de cada una de las piezas
	 * @return casillas dónde se podrá mover la pieza
	 */
	public abstract  ArrayList<Point> mostrarMovimientos(Casilla [][] casillas);
	
	
	
	
	
}
