package main.java;

import java.awt.EventQueue;

import main.java.interfaz.Interfaz;


public class AjedrezApp {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz interfaz = new Interfaz();
					interfaz.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
