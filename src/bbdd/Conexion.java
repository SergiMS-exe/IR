package bbdd;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class Conexion {

	private static String URL = "jdbc:mysql://eburyrequisitos.cobadwnzalab.eu-central-1.rds.amazonaws.com:3306/grupo06DB";
	private static String USER = "grupo06";
	private static String PASSWORD = "PZmvn9NhvQ4N4KUt";
	private String estado;
	
	public Conexion() {
		
	}
	
	public Connection conectar() {
		Connection conexion = null;		
		try {
			conexion = DriverManager.getConnection(URL,USER,PASSWORD);
			this.estado= "Conexion establecida con la Base de datos";
			//System.out.println("Conexion establecida con la Base de datos");
			
		}catch (SQLException e) {
			this.estado="Error en la conexion";
			//System.out.println("Error en la conexion");
			e.printStackTrace();
		}
		return conexion;
	}
	public String getEstado() {
		return estado;
	}

	
}
