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
	private String inicialPersonaIndividual = "select persona.apellido, persona.nombre, cuenta.numeroCuenta, direccion.calle, direccion.ciudad, direccion.codigoPostal, direccion.pais, cliente.numeroIdentificacion, persona.fechaNacimiento"
			+ " from Cliente cliente, CuentaEbury cuenta, Direccion direccion, Persona persona"
			+ " where cliente.id in (select propietario from CuentaEbury) and cuenta.propietario=cliente.id"
			+ " and direccion.id = cliente.id_direccion and persona.id = cliente.id and (select TIMESTAMPDIFF(YEAR, cuenta.fechaApertura, '2021-01-01'))<=5";
	private String inicialPersonaRelacionadaEmpresa = "select persona.apellido, persona.nombre, cuenta.numeroCuenta, direccion.calle, direccion.ciudad, direccion.codigoPostal, direccion.pais, cliente.numeroIdentificacion, persona.fechaNacimiento"
			+ " from Cliente cliente, CuentaEbury cuenta, Direccion direccion, Persona persona\n"
			+ " where cliente.id in( select persona.id_personaRelacionada from Cliente cliente, PersonaRelacionadaCliente persona"
			+ " where cliente.id in(select propietario from CuentaEbury) and persona.id_cliente=cliente.id)"
			+ " and cuenta.propietario=(select id_cliente from PersonaRelacionadaCliente where id_personaRelacionada=cliente.id)"
			+ " and persona.id = cliente.id and direccion.id = cliente.id_direccion and (select TIMESTAMPDIFF(YEAR, cuenta.fechaApertura, '2021-01-01'))<=5 ";
	private String semanalPersonaIndividual = "select persona.apellido, persona.nombre, cuenta.numeroCuenta, direccion.calle, direccion.ciudad, direccion.codigoPostal, direccion.pais, cliente.numeroIdentificacion, persona.fechaNacimiento \n"
			+ " from Cliente cliente, CuentaEbury cuenta, Direccion direccion, Persona persona"
			+ " where cliente.id in (select propietario from CuentaEbury where estadoCuenta = 'activa') and cliente.estado = 'Activo' and cuenta.propietario=cliente.id"
			+ " and direccion.id = cliente.id_direccion and persona.id = cliente.id and (select TIMESTAMPDIFF(YEAR, cuenta.fechaApertura, '2021-01-01'))<=5";
	private String semanalPersonaRelacionadaEmpresa = "select persona.apellido, persona.nombre, cuenta.numeroCuenta, direccion.calle, direccion.ciudad, direccion.codigoPostal, direccion.pais, cliente.numeroIdentificacion, persona.fechaNacimiento"
			+ " from Cliente cliente, CuentaEbury cuenta, Direccion direccion, Persona persona"
			+ " where cliente.id in( select persona.id_personaRelacionada from Cliente cliente, PersonaRelacionadaCliente persona"
			+ " where cliente.id in(select propietario from CuentaEbury where estadoCuenta='activa') and persona.id_cliente=cliente.id and cliente.estado='Activo')"
			+ " and cuenta.propietario=(select id_cliente from PersonaRelacionadaCliente where id_personaRelacionada=cliente.id) and cuenta.estadoCuenta = 'activa'"
			+ " and persona.id = cliente.id and direccion.id = cliente.id_direccion and (select TIMESTAMPDIFF(YEAR, cuenta.fechaApertura, '2021-01-01'))<=5";
	
	public String getConexion() {
		return c.getEstado();
	}
	
	public ResultSet obtenerClientes() {
		rs = null;
		try {
			stm = conexion.createStatement();
			rs = stm.executeQuery("select * from Cliente");
			
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
	
	public ResultSet reporteInicial1() {
		rs = null;
		try {
			stm = conexion.createStatement();
			rs = stm.executeQuery(inicialPersonaIndividual);
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet reporteInicial2() {
		rs = null;
		try {
			stm = conexion.createStatement();
			rs = stm.executeQuery(inicialPersonaRelacionadaEmpresa);
	
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
	
	public ResultSet reporteSemanal1() {
		rs = null;
		try {
			stm = conexion.createStatement();
			rs = stm.executeQuery(semanalPersonaIndividual);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet reporteSemanal2() {
		rs = null;
		try {
			stm = conexion.createStatement();
			rs = stm.executeQuery(semanalPersonaRelacionadaEmpresa);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet filtrarCuentas(String estado, String IBAN) {
		rs=null;
		try {
			stm = conexion.createStatement();
			System.out.println(IBAN+" "+estado);
			if (!IBAN.equals("") && !estado.equals(""))
				rs=stm.executeQuery("SELECT * FROM CuentaEbury cuenta WHERE cuenta.numeroCuenta='"+IBAN+"' AND cuenta.estadoCuenta='"+estado+"';");
			else if (IBAN.equals("") && !estado.equals(""))
				rs=stm.executeQuery("SELECT * FROM CuentaEbury cuenta WHERE cuenta.estadoCuenta='"+estado+"';");
			else if (!IBAN.equals("") && estado.equals(""))
				rs=stm.executeQuery("SELECT * FROM CuentaEbury cuenta WHERE cuenta.numeroCuenta='"+IBAN+"';");
			else 
				rs=stm.executeQuery("SELECT * FROM CuentaEbury");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
}
