package bbdd;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class Conexion {

	private static String URL = "jdbc:mysql://eburyrequisitos.cobadwnzalab.eu-central-1.rds.amazonaws.com:3306/grupo06DB";
	private static String USER = "grupo06";
	private static String PASSWORD = "PZmvn9NhvQ4N4KUt";
	
	public static String SUCCESSFUL_CONNECTION= "Conexion establecida con la Base de datos";
	public static String FAILURE_CONNECTION="Error en la conexion";
	
	private String estado;
	
	public Conexion() {
		
	}
	
	public Connection conectar() {
		Connection conexion = null;		
		try {
			conexion = DriverManager.getConnection(URL,USER,PASSWORD);
			this.estado= SUCCESSFUL_CONNECTION;
			//System.out.println("Conexion establecida con la Base de datos");
			
		}catch (SQLException e) {
			this.estado=FAILURE_CONNECTION;
			//System.out.println("Error en la conexion");
			e.printStackTrace();
		}
		return conexion;
	}
	public String getEstado() {
		return estado;
	}

	
}
