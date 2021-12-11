package bbdd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultasBBDD {

	private Conexion c = new Conexion();
	private Connection conexion = c.conectar();
	private Statement stm = null;
	private ResultSet rs = null; 
	
	
	public ResultSet obtenerClientes() {
		rs = null;
		try {
			stm = conexion.createStatement();
			rs = stm.executeQuery("select * from Cliente");
			
			/*
			 * Así se recorrería el resultSet y se sacarían por pantalla todos los clientes de la bbdd
			 * 
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String numeroIdentificacion = rs.getString(2);
				String estado = rs.getString(3);
				String fechaInicio = rs.getDate(4).toString();
				int direccion = rs.getInt(5);
				
				System.out.println(id + " - " + numeroIdentificacion + " - " + estado + " - " + fechaInicio + " - " + direccion);
			}
			
			*/
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
	}
	
}
