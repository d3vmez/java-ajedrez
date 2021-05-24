package main.java.interfaz;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Historial extends JPanel{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static DefaultListModel modeloLista;
	
	public Historial() {
		this.setBounds(700, 30, 250, 300);
		this.setBackground(Color.GRAY);

		JScrollPane scrollPaneList = new JScrollPane();
		scrollPaneList.setBounds(700, 30, 250, 300);
		this.add(scrollPaneList);
		

		
		JList<String> historial = new JList<String>();
		historial.setBounds(700, 30, 250, 300);
		modeloLista = new DefaultListModel();
	
		historial.setModel(modeloLista);
		scrollPaneList.setViewportView(historial);
		
	
	}
	
	public void añadirAHistorial(String jugada) {
		getModeloLista().addElement(jugada);
	}

	public static DefaultListModel<String> getModeloLista() {
		return modeloLista;
	}

	public static void setModeloLista(DefaultListModel modeloLista) {
		Historial.modeloLista = modeloLista;
	}
}
