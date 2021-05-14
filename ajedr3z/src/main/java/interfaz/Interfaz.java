package main.java.interfaz;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Interfaz extends JFrame{

	private static final long serialVersionUID = 1L;

	public Interfaz() {
		this.setSize(1000,700);
		centrarVentana();
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Tablero tablero = new Tablero();
		this.add(tablero);
	}
	
	public void centrarVentana() {
		
		// obtener las dimensiones de la pantalla
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		int ancho = pantalla.width;
	    int alto = pantalla.height;

		//centrar ventana
		this.setLocation(ancho/4,alto/7);
	
	}
}
