package main.java.piezas;


import javax.swing.ImageIcon;

public abstract class Pieza {
	
	private ImageIcon icono;
	public static String directorio = System.getProperty("user.dir")+"//src//imagenes//";
	
	private String color;
	private int peso;
	private int posicionX;
	private int posicionY;
	
	public Pieza(ImageIcon icono, int posicionX, int posicionY) {
		this.icono = icono;
		this.posicionX = posicionX;
		this.posicionY = posicionY;
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
	
	
	
	
	
	
	
}
