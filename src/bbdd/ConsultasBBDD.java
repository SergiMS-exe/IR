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
	
	public ResultSet obtenerClientesFiltrados(String desde,String hasta,String nombre, String apellidos, String numero,String codigoPostal,String pais) {
		rs=null;
		String[] tuplaNombre=nombre.split(" ");
		String[] tuplaApellido=apellidos.split(" ");
		String queryDatos="select * "
				+ "from Cliente c, Persona p, Direccion d "
				+ "where fechaInicio>='"+desde+"' and fechaInicio<='"+hasta+"' and p.id=c.id and c.id_direccion=d.id "
						+ "and p.nombre = '"+tuplaNombre[0]+"' and p.apellido='"+tuplaApellido[0]+"' "
						+ "and d.numero = '"+numero+"' and d.codigoPostal = '"+codigoPostal+"' and d.pais = '"+pais+"' ";
		if(tuplaNombre.length>1) {
			queryDatos+="and p.segundoNombre = '"+tuplaNombre[1]+"'";
		}
		if(tuplaApellido.length>1) {
			queryDatos+="and p.segundoApellido = '"+tuplaApellido[1]+"'";
		}
		try {
			stm = conexion.createStatement();
			rs = stm.executeQuery(queryDatos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
		
	}
	
	public ResultSet obtenerDireccionesCliente(String id) {
		rs=null;
		String queryCuentas="select * "
				+ "from Cliente c, Direccion d "
				+ "where c.id='"+id+"' and c.id_direccion=d.id;";
		System.out.println(queryCuentas);
		try {
			stm = conexion.createStatement();
			rs = stm.executeQuery(queryCuentas);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet obtenerCuentasDelCliente(String id,String Country) {
		rs=null;
		String queryCuentas="select * from CuentaEbury where propietario='"+id+"';";
		try {
			stm = conexion.createStatement();
			rs = stm.executeQuery(queryCuentas);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet obtenerCuentasAutorizadasCliente(String id,String Country) {
		rs=null;
		String queryCuentas="select * from PersonaRelacionadaCliente, CuentaEbury where id=id_cliente and id_personaRelacionada='"+id+"';";
		try {
			stm = conexion.createStatement();
			rs = stm.executeQuery(queryCuentas);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet obtenerPersonasAutorizadasCliente(String id) {
		String querypersonasAutorizadas="select * "
				+ "from PersonaRelacionadaCliente r, Persona p,  Direccion d "
				+ "where r.id_cliente="+id+" and p.id=r.id_personaRelacionada and p.id=d.id; ";
		try {
			stm = conexion.createStatement();
			rs = stm.executeQuery(querypersonasAutorizadas);
		} catch (Exception e) {
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
			if (IBAN.equals("") && !estado.equals(""))
				rs=stm.executeQuery("SELECT cuenta.numeroCuenta, cuenta.estadoCuenta, cuenta.fechaApertura, cuenta.fechaCierre, cuenta.propietario FROM CuentaEbury cuenta WHERE cuenta.estadoCuenta='"+estado+"';");
			else if (!IBAN.equals("") && estado.equals(""))
				rs=stm.executeQuery("SELECT cuenta.numeroCuenta, cuenta.estadoCuenta, cuenta.fechaApertura, cuenta.fechaCierre, cuenta.propietario FROM CuentaEbury cuenta WHERE cuenta.numeroCuenta='"+IBAN+"';");
			else 
				rs=stm.executeQuery("SELECT cuenta.numeroCuenta, cuenta.estadoCuenta, cuenta.fechaApertura, cuenta.fechaCierre, cuenta.propietario FROM CuentaEbury cuenta;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet getPropietario(String idProp) {
		rs = null;
		try {
			stm = conexion.createStatement();
			if (stm.executeQuery("Select * from Persona where id='"+idProp+"';").getFetchSize()==0) {
				rs = stm.executeQuery("Select DISTINCT cliente.estado, empresa.nombre from Cliente cliente, Empresa empresa where cliente.id="+idProp+" and empresa.id="+idProp+";");
			}
			else {
				rs = stm.executeQuery("Select DISTINCT cliente.estado, persona.nombre, persona.segundoNombre, persona.apellido, persona.segundoApellido from Cliente cliente, Persona persona where cliente.id="+idProp+" and persona.id="+idProp+";");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
}
