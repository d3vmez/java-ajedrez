package main.java.interfaz;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import main.java.piezas.*;


public class Tablero extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private Casilla[][] casillas = new Casilla[8][8];
	private Pieza piezaTemporal;
	private Casilla casillaTemporal;
	private Color colorTemporal;
	public Tablero() {
		this.setSize(600, 600);
		this.setBackground(Color.GRAY);
		this.setLayout(new GridLayout(8,8));
		
		int contadorCasillas = 0;
		
		for (int i = 0; i < 8; i++) {
			
			
			for (int j = 0; j < 8; j++) {
			
				casillas[i][j] = new Casilla(i,j);
				if( contadorCasillas%2 == 0) {
					
					casillas[i][j].setBackground(Color.WHITE);
					
				} else {
					
					casillas[i][j].setBackground(Color.GRAY);
					
				}
				
				// se colocan las piezas en el tablero
				ImageIcon imagen = null;
				if( i == 1 || i == 6) {
					if(i == 1) {
						imagen = new ImageIcon(Pieza.directorio+"PeonN.png");
					}else {
						imagen = new ImageIcon(Pieza.directorio+"PeonB.png");
					}
					Peon peon = new Peon(imagen,i,j);
					casillas[i][j].setIcon(peon.getIcono());
					casillas[i][j].setPieza(peon);
				}
					
				if( (i == 0 || i == 7) && (j == 0 || j == 7)) {
					if(i == 0) {
						imagen = new ImageIcon(Pieza.directorio+"TorreN.png");
					}else if (i == 7){
						imagen = new ImageIcon(Pieza.directorio+"TorreB.png");
					}
					Torre torre = new Torre(imagen,i,j);
					casillas[i][j].setIcon(torre.getIcono());
					casillas[i][j].setPieza(torre);
				}
				
				if( (i == 0 || i == 7) && (j == 1 || j == 6)) {
					if(i == 0) {
						imagen = new ImageIcon(Pieza.directorio+"CaballoN.png");
					}else if (i == 7){
						imagen = new ImageIcon(Pieza.directorio+"CaballoB.png");
					}
					Caballo caballo = new Caballo(imagen,i,j);
					casillas[i][j].setIcon(caballo.getIcono());
					casillas[i][j].setPieza(caballo);
				}
				
				if( (i == 0 || i == 7) && (j == 2 || j == 5)) {
					if(i == 0) {
						imagen = new ImageIcon(Pieza.directorio+"AlfilN.png");
					}else if (i == 7){
						imagen = new ImageIcon(Pieza.directorio+"AlfilB.png");
					}
					Alfil alfil = new Alfil(imagen,i,j);
					casillas[i][j].setIcon(alfil.getIcono());
					casillas[i][j].setPieza(alfil);
				}
				
				if( (i == 0 || i == 7) && j == 3) {
					if(i == 0) {
						imagen = new ImageIcon(Pieza.directorio+"ReinaN.png");
					}else if (i == 7){
						imagen = new ImageIcon(Pieza.directorio+"ReinaB.png");
					}
					Reina reina = new Reina(imagen,i,j);
					casillas[i][j].setIcon(reina.getIcono());
					casillas[i][j].setPieza(reina);
				}
				
				if( (i == 0 || i == 7)&& j == 4) {
					if(i == 0) {
						imagen = new ImageIcon(Pieza.directorio+"ReyN.png");
					}else if (i == 7){
						imagen = new ImageIcon(Pieza.directorio+"ReyB.png");
					}
					Rey rey = new Rey(imagen,i,j);
					casillas[i][j].setIcon(rey.getIcono());
					casillas[i][j].setPieza(rey);
				}
				
				this.add(casillas[i][j]);
				casillas[i][j].addActionListener(this);
		
				contadorCasillas ++;

			}
			
			
			contadorCasillas ++;
			
		}
		

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Casilla c = (Casilla) e.getSource();
		
		if(c.getPieza() != null) {
			this.colorTemporal = c.getBackground();
			this.casillaTemporal= c;
			this.casillaTemporal.setBackground(Color.GREEN);
			this.piezaTemporal = c.getPieza();

		System.out.println("tengo pieza");
		}else {
			System.out.println("no tengo pieza");
			if(c != null) {
				c.setPieza(this.piezaTemporal);
				c.setIcon(this.piezaTemporal.getIcono());
				this.casillaTemporal.setPieza(null);
				this.casillaTemporal.setBackground(colorTemporal);
				this.casillaTemporal.setIcon(null);

			System.out.println(this.piezaTemporal.getPosicionX());
			System.out.println(this.piezaTemporal.getPosicionY());
			}
		}
	}
	
}
