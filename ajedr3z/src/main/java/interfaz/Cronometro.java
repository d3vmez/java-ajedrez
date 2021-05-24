package main.java.interfaz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Cronometro extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private short minutosN, minutosB = 0;
	private byte segundosN, segundosB = 0;
	private byte centesimasN, centesimasB = 0;
	private DecimalFormat timeFormatter;
	private Timer timerN, timerB ;

	public Cronometro() {
		
		
		this.setBounds(700, 350, 250, 25);
		this.setBackground(Color.RED);

		JLabel tiempoBlancas = new JLabel();
		this.add(tiempoBlancas);
		timerB = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			
				if (centesimasB > 0) {
					centesimasB--;
				} else {
					if (segundosB == 0 && minutosB == 0) {
						timerB.stop();

					} else if (segundosB > 0) {
						segundosB--;
						centesimasB = 99;
					} else if (minutosB > 0) {
						minutosB--;
						segundosB = 59;
						centesimasB = 99;
					}
				}

				tiempoBlancas.setText(timeFormatter.format(minutosB) + ":" + timeFormatter.format(segundosB) + "."
						+ timeFormatter.format(centesimasB));
			}

		});
		
		

		JLabel tiempoNegras = new JLabel();
		this.add(tiempoNegras);
		timerN = new Timer(10, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (centesimasN > 0) {
					centesimasN--;
				} else {
					if (segundosN == 0 && minutosN == 0) {
						timerN.stop();
						

					} else if (segundosN > 0) {
						segundosN--;
						centesimasN = 99;
					} else if (minutosN > 0) {
						minutosN--;
						segundosN = 59;
						centesimasN = 99;
					}
				}
				tiempoNegras.setText(timeFormatter.format(minutosN) + ":" + timeFormatter.format(segundosN) + "."
						+ timeFormatter.format(centesimasN));

			}
		});
		
		
		
		

	}
	
	

	
	
	
}
