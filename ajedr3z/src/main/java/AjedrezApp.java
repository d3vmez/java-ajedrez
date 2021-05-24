package main.java;

import java.awt.EventQueue;

import main.java.interfaz.Interfaz;
import main.java.interfaz.Login;


public class AjedrezApp {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Login login = new Login();
					login.setVisible(false);
					
					Interfaz interfaz = new Interfaz();
					interfaz.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
