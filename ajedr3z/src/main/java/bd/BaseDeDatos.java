package main.java.bd;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class BaseDeDatos {

	Connection conexion = null;
	Statement sentencia = null;
	PreparedStatement statement = null;
	Properties prop = new Properties();
	InputStream is = null;
	String user, password, url;

	/**
	 * Nos permite conectarnos a la BBDD
	 * 
	 * @throws IOException
	 * @throws SQLException
	 */
	public void conexionBBDD() throws IOException, SQLException {
		String ruta = System.getProperty("user.dir");
		System.out.println(ruta);
		is = new FileInputStream(ruta+"\\main.java.resources\\bd.properties");
		prop.load(is);
		user = prop.getProperty("user", "");
		password = prop.getProperty("password", "");
		url = prop.getProperty("url", "");
		conexion = DriverManager.getConnection(url, user, password);
		sentencia = conexion.createStatement();
	}

	/**
	 * Nos sirve para el login del usuario
	 * 
	 * @param nombre
	 * @return
	 * @throws SQLException
	 */

	public String selectPassword(String nombre) throws SQLException {
		// "Select * from usuario where nombre ="+nombre+" and password ="+password
		String sql = "Select password from usuario where nombreUsuario ='" + nombre + "'";
		ResultSet rs = sentencia.executeQuery(sql);

		String password = "";
		while (rs.next()) {
			password = rs.getString("password");
			System.out.println(password); // Quitar traza
		}
		return password;
	}

	/**
	 * Nos muestra los usuarios Con mejor puntuacion registrados
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String selectNombreTop10() throws SQLException {

		String concatenador = "";
		String nombreUsuario = "", puntuacion = "";
		for (int top10 = 0; top10 < 10; top10++) {
			// select nombreUsuario, puntuacion from usuario group by
			// puntuacion,nombreUsuario asc limit 10;
			String sql = "select nombreUsuario,puntuacion from usuario order by puntuacion desc ,nombreUsuario limit "
					+ top10 + ",1";
			ResultSet rs = sentencia.executeQuery(sql);

			while (rs.next()) {
				nombreUsuario = rs.getString("nombreUsuario");
				System.out.println(nombreUsuario);
				puntuacion = rs.getString("puntuacion");
				System.out.println(puntuacion);
			}
			concatenador += ("Usuario = " + nombreUsuario + ", Puntuacion =  " + puntuacion + "\n");

		}

		return concatenador;
	}

	/**
	 * Nos sirve para comprobar si el usuario existe, en caso de que devuelve "", el
	 * usuario no existe
	 * 
	 * @param nombre
	 * @return
	 * @throws SQLException
	 */
	public String selectIdUsuario(String nombre) throws SQLException {

		String id = "";
		String sql = "select id_usuario from usuario where nombreUsuario = '" + nombre + "'";
		ResultSet rs = sentencia.executeQuery(sql);

		while (rs.next()) {
			id = rs.getString("id_usuario");
			System.out.println(id);
		}
		return id;
	}

	/**
	 * Nos permite insertar un usuario en el Registro
	 * 
	 * @param nombre
	 * @param password
	 * @throws SQLException
	 */
	public void insertRegistro(String nombre, String password) throws SQLException {
		statement = conexion.prepareStatement("insert into usuario (nombreUsuario, password) values (?,?)");
		statement.setString(1, nombre);
		statement.setString(2, password);
		statement.executeUpdate();
		statement.close();
	}

	public void insertPartida(String blancas, String negras) throws SQLException {
		statement = conexion.prepareStatement("insert into partida (blancas, negras) values (?,?)");
		statement.setString(1, blancas);
		statement.setString(2, negras);
		statement.executeUpdate();
		statement.close();
	}

	public void insertHistorial(String descripcion, String movimientos, String id_partida) throws SQLException {
		statement = conexion
				.prepareStatement("insert into historial (descripcion, movimientos, id_partida) values (?,?,?)");
		statement.setString(1, descripcion);
		statement.setString(2, movimientos);
		statement.setString(3, id_partida);
		statement.executeUpdate();
		statement.close();
	}

	public String selectIdPartida(String blancas, String negras) throws SQLException {
		String maxId = "";
		String sql = "select max(id_partida) from partida where blancas = '" + blancas + "' and negras = '" + negras
				+ "'";
		ResultSet rs = sentencia.executeQuery(sql);

		while (rs.next()) {
			maxId = rs.getString("max(id_partida)");
			System.out.println(maxId);
		}
		return maxId;
	}

}
