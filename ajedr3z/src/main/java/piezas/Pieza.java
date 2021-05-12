package main.java.piezas;


import javax.swing.ImageIcon;

public abstract class Pieza {
	
	private ImageIcon icono;
	public static String directorio = System.getProperty("user.dir")+"//src//imagenes//";
	
	private String color;
	private int peso;
	private int posicionX;
	private int posicionY;
	
	public Pieza(ImageIcon icono) {
		this.icono = icono;
	}
	

	public ImageIcon getIcono() {
		return icono;
	}

	public void setIcono(ImageIcon icono) {
		this.icono = icono;
	}
	
	
	
	
	
}
