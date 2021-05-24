package main.java.interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import main.java.bd.BaseDeDatos;

public class Login extends JFrame {

	private BaseDeDatos bd = new BaseDeDatos();

	public Login() {

		this.setTitle("Ajedrez Proyecto");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 450, 726);
		this.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		this.add(panel);

		JLabel lblInfo = new JLabel("Introduce tus credenciales");
		lblInfo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 14));
		lblInfo.setBounds(146, 31, 170, 14);
		panel.add(lblInfo);

		// login usuario 1
		// nombre
		JLabel lblNombreJ1 = new JLabel("Nombre");
		lblNombreJ1.setBounds(120, 82, 70, 14);
		panel.add(lblNombreJ1);

		JTextField txtNombreJ1 = new JTextField();
		txtNombreJ1.setBounds(120, 106, 183, 20);
		panel.add(txtNombreJ1);
		txtNombreJ1.setColumns(10);

		// contraseña
		JLabel lblPasswordJ1 = new JLabel("Contraseña");
		lblPasswordJ1.setBounds(120, 137, 70, 14);
		panel.add(lblPasswordJ1);

		JTextField txtPasswordJ1 = new JPasswordField();
		txtPasswordJ1.setBounds(120, 158, 183, 20);
		panel.add(txtPasswordJ1);
		txtPasswordJ1.setColumns(10);

		JLabel lblEspera = new JLabel("");
		lblEspera.setEnabled(false);
		lblEspera.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblEspera.setBounds(151, 277, 138, 14);
		panel.add(lblEspera);

		JButton btnLoginJ1 = new JButton("Entrar");
		btnLoginJ1.setBackground(Color.WHITE);
		btnLoginJ1.setForeground(Color.BLACK);
		btnLoginJ1.setBounds(167, 189, 89, 23);
		panel.add(btnLoginJ1);

		btnLoginJ1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNombreJ1.getText();
				String pass = txtPasswordJ1.getText();
				String passTemp = "", NameTemp = "";
				try {
					bd.conexionBBDD();
					passTemp = bd.selectPassword(nombre);
					NameTemp = nombre;// Nos devuelve la contraseña
				} catch (SQLException | IOException ex) {
					System.out.println(ex.getMessage());
				}

				if (pass.equals(passTemp) && !nombre.equals("") && !pass.equals("")) {
					btnLoginJ1.setBackground(Color.GREEN);
					lblEspera.setEnabled(true);
					lblEspera.setForeground(Color.RED);
					lblEspera.setText("Esperando a Jugador 2");
					System.out.println("hola");

				} else {
					JOptionPane.showMessageDialog(null, "Introduce un usuario correcto");
				}

			}
		});

		// login usario2

		JLabel lblNombreJ2 = new JLabel("Nombre");
		lblNombreJ2.setBounds(120, 338, 70, 14);
		panel.add(lblNombreJ2);

		JLabel lblPasswordJ2 = new JLabel("Contraseña");
		lblPasswordJ2.setBounds(120, 394, 70, 14);
		panel.add(lblPasswordJ2);

		JTextField txtNombreJ2 = new JTextField();
		txtNombreJ2.setColumns(10);
		txtNombreJ2.setBounds(120, 363, 183, 20);
		panel.add(txtNombreJ2);

		JTextField txtPasswordJ2 = new JPasswordField();
		txtPasswordJ2.setBounds(120, 422, 183, 20);
		panel.add(txtPasswordJ2);

		JButton btnLoginJ2 = new JButton("Entrar");
		btnLoginJ2.setBackground(Color.WHITE);
		btnLoginJ2.setForeground(Color.BLACK);
		btnLoginJ2.setBounds(167, 453, 89, 23);
		panel.add(btnLoginJ2);

		btnLoginJ2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNombreJ2.getText();
				String pass = txtPasswordJ2.getText();
				String passTemp = "", NameTemp = "";
				try {
					bd.conexionBBDD();
					passTemp = bd.selectPassword(nombre);
					NameTemp = nombre;// Nos devuelve la contraseña
				} catch (SQLException | IOException ex) {
					System.out.println(ex.getMessage());
				}

				if (pass.equals(passTemp)) {

					lblEspera.setEnabled(true);
					if (btnLoginJ1.getBackground() == Color.GREEN) {
						Interfaz interfaz = new Interfaz();
						interfaz.setVisible(true);
						dispose();

					}

				} else {
					JOptionPane.showMessageDialog(null, "Introduce un usuario correcto");
				}

			}
		});

		// registro
		JButton btnRegistro = new JButton("Registrarse");
		btnRegistro.setForeground(Color.WHITE);
		btnRegistro.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegistro.setBackground(new Color(46, 139, 87));
		btnRegistro.setBounds(10, 653, 109, 23);
		panel.add(btnRegistro);

	}

}
