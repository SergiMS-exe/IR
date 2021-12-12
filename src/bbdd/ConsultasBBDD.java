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
	private String personaRel = "select from PersonaRelacionada pr, Cliente c, CuentaEbury e, PersonaRelacionadaCliente prcl, PersonaRelacionadaCuenta prc where c.id=prcl.id_cliente and prcl.id_personaRelacionada= pr.id and pr.id=prc.idPersona and prc.idCuenta=";
	private String semanal ="select E.numeroCuenta, P.apellido, P.nombre, C.id_direccion, C.numeroIdentificacion, P.fechaNacimiento,E.id from Cliente C, CuentaEbury E, Persona P where E.propietario = C.id and  E.estadoCuenta != 'cerrada' and E.estadoCuenta = 'activa' and  TIMESTAMPDIFF (YEAR,E.fechaApertura,curdate())<=5";
	
	
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
	
	public ResultSet obtenerPersona(int id) {
		rs = null;
		try {
			stm = conexion.createStatement();
			rs = stm.executeQuery("select * from Persona where id =" + id);
			
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
	
	public ResultSet personasRelacionadas(int id) {
		rs = null;
		try {
			stm = conexion.createStatement();
			rs = stm.executeQuery("select *\n"
					+ "from PersonaRelacionada pr, Cliente c, CuentaEbury e, PersonaRelacionadaCliente prcl, PersonaRelacionadaCuenta prc\n"
					+ "where c.id=prcl.id_cliente and prcl.id_personaRelacionada= pr.id and pr.id=prc.idPersona and prc.idCuenta=" + id);		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet reporteInicial() {
		rs = null;
		try {
			stm = conexion.createStatement();
			rs = stm.executeQuery("SELECT E.numeroCuenta, P.apellido, P.nombre, C.id_direccion, C.numeroIdentificacion, P.fechaNacimiento,E.id "
					+				"FROM Cliente C, CuentaEbury E, Persona P "
					+ 				"WHERE E.propietario = C.id");
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet obtenerDireccion(int id) {
		rs = null;
		try {
			stm = conexion.createStatement();
			rs = stm.executeQuery("SELECT * "
					+ 				"FROM Direccion "
					+ 				"WHERE id =" +id);

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet reporteSemanal() {
		rs = null;
		try {
			stm = conexion.createStatement();
			rs = stm.executeQuery(semanal);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
}
