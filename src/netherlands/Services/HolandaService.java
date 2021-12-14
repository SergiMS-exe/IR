package netherlands.Services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import bbdd.*;

public class HolandaService {

	private ConsultasBBDD miBD = new ConsultasBBDD();
	
	private static final String ERROR_CONEXION="No se ha podido establecer conexi�n";
	private static final String ERROR_FILTRO_CLIENTES="No se ha encontrado ninguna cuenta bancaria que coincida con los datos introducidos";

	public String getEstado() {
		return miBD.getConexion();
	}

	public String filtrarCliente(String desde, String hasta, String nombre, String apellidos, String numero,
			String codigoPostal, String pais) {
		if (getEstado() == Conexion.FAILURE_CONNECTION) {
			return ERROR_CONEXION;
		}
		desde="2000-12-12";
		hasta="2200-12-12";
		nombre="pedro";
		apellidos="vazquez";
		numero="1";
		codigoPostal="29010";
		pais="espana";
		
		JSONObject clientes= new JSONObject();
		String output=ERROR_FILTRO_CLIENTES;
		ResultSet rsData = miBD.obtenerClientesFiltrados(desde, hasta, nombre, apellidos, numero,codigoPostal, pais);
		try {
			while (rsData.next()) {
				JSONObject data = new JSONObject();
				
				String id = rsData.getString("id");				
				// addresses
				data.put("addresses", obtenerAddressCliente(miBD.obtenerDireccionesCliente(id)));
				
				// personalData
				data.put("activeCostumer", rsData.getString("estado").equals("Activo"));
				data.put("dateOfBirth", rsData.getString("fechaNacimiento").toString());
					//name
				JSONObject name = new JSONObject();
				name.put("firstname", rsData.getString("nombre"));
				name.put("lastName", rsData.getString("segundoNombre"));
				data.put("name", name);
				
				// accounts
				List<Map<String, String>> accounts=obtenerAccountsCliente(miBD.obtenerCuentasDelCliente(id, "ES"),"Owner");
				accounts.addAll(obtenerAccountsCliente(miBD.obtenerCuentasAutorizadasCliente(id, "ES"),"Authorized"));
				
				data.put("products", accounts);
				clientes.put("Individual",data);
				
				// clients authorized
				ResultSet rsAutorizedClients = miBD.obtenerPersonasAutorizadasCliente(id);
				List<JSONObject> autorizedClients = new ArrayList<JSONObject>();
				while (rsAutorizedClients.next()) {
					JSONObject autorizedClient = new JSONObject();
						//personalData
					autorizedClient.put("dateOfBirth", rsAutorizedClients.getString("fechaNacimiento").toString());
							//name
					Map<String, String> nameAutorizedClient = new LinkedHashMap<String, String>();
					nameAutorizedClient.put("firstname", rsAutorizedClients.getString("nombre"));
					nameAutorizedClient.put("lastName",rsAutorizedClients.getString("segundoNombre"));
					autorizedClient.put("name", nameAutorizedClient);
					
						//addresses
					autorizedClients.add(autorizedClient);
					autorizedClient.put("addresses", obtenerAddressCliente(miBD.obtenerDireccionesCliente(id)));
				}
				clientes.put("Relatedperson", autorizedClients);
				
				System.out.println(clientes);
			}
			output=clientes.toString(2);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return output;
	}
	
	public String filtrarCuentas(String estado, String iban) {
		if(getEstado()==Conexion.FAILURE_CONNECTION) {
			return "error";
		}
		ResultSet res = miBD.filtrarCuentas(estado, iban);
		JSONObject result = new JSONObject();
		List<JSONObject> cuentas = new ArrayList<>();
		try {
			while (res.next()) {
				JSONObject cuenta = new JSONObject();	
				
				cuenta.put("productNumber", res.getString("numeroCuenta"));
				cuenta.put("status", res.getString("estadoCuenta"));
				cuenta.put("startDate", res.getString("fechaApertura"));
				cuenta.put("endDate", res.getString("fechaCierre"));
				cuenta.put("accountHolder", getPropietario(res.getString("propietario")));
				
				cuentas.add(cuenta);
			}
			result.put("products", cuentas);
			
			return result.toString(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
	
	private List getPropietario(String idProp) {
		ResultSet res = miBD.getPropietario(idProp);
		List<JSONObject> propietarios = new ArrayList<JSONObject>();
		try {
			while (res.next()) {
				JSONObject propietario = new JSONObject();
				propietario.put("accountStatus", res.getString("cliente.estado"));
				
				//Nombre
				JSONObject nombre = new JSONObject();
				try {
					nombre.put("firstName", res.getString("persona.nombre"));
					nombre.put("secondName", res.getString("persona.segundNombre"));
					nombre.put("surname", res.getString("persona.apellido")+" "+res.getString("persona.segundoApellido"));
				} catch (Exception e) {
					nombre.put("name", res.getString("empresa.nombre"));
				}
				nombre.put("name", nombre);
				
				// addresses
				ResultSet rsAddress = miBD.obtenerDireccionesCliente(idProp);
				propietario.put("addresses", obtenerAddressCliente(rsAddress));
				
				propietarios.add(propietario);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return propietarios;
	}

	public List<Map<String, String>> obtenerAddressCliente(ResultSet rsAddress){
		List<Map<String, String>> addresses = new ArrayList<Map<String, String>>();
		try {
			while (rsAddress.next()) {
				Map<String, String> address = new LinkedHashMap<String, String>();
				// address
				address.put("city", rsAddress.getString("ciudad"));
				address.put("street", rsAddress.getString("calle"));
				address.put("number", rsAddress.getString("numero"));
				address.put("postalCode", String.valueOf(rsAddress.getInt("codigoPostal")));
				address.put("country", rsAddress.getString("pais"));
				addresses.add(address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return addresses;
	}
	
	public List<Map<String, String>> obtenerAccountsCliente(ResultSet rsAccounts,String type) {
		List<Map<String, String>> accounts = new ArrayList<Map<String, String>>();
		try {
			while (rsAccounts.next()) {
				String productNumber= rsAccounts.getString("numeroCuenta");
				if(!productNumber.substring(0, 2).equals("NL")) continue;
				Map<String, String> account = new LinkedHashMap<String, String>();
				// FALTA TYPE
				account.put("productNumber", productNumber);
				account.put("status", rsAccounts.getString("estadoCuenta"));
				account.put("relationShip", type);
				accounts.add(account);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}
}
