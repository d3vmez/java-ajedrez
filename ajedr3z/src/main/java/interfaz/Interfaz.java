package main.java.interfaz;

import javax.swing.JFrame;

public class Interfaz extends JFrame{

	private static final long serialVersionUID = 1L;

	public Interfaz() {
		this.setSize(1000,700);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Tablero tablero = new Tablero();
		this.add(tablero);
	}
}
