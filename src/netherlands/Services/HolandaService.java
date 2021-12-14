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

	public String getEstado() {
		return miBD.getConexion();
	}

	public JSONArray filtrarCliente(String desde, String hasta, String nombre, String apellidos, String numero,
			String codigoPostal, String pais) {
		if (getEstado() == Conexion.FAILURE_CONNECTION) {
			return new JSONArray();
		}
		desde="2000-12-12";
		hasta="2200-12-12";
		nombre="pedro jesus";
		apellidos="vazquez figueroa";
		numero="1";
		codigoPostal="29010";
		pais="espana";
		JSONArray individual = new JSONArray();
		ResultSet rsData = miBD.obtenerClientesIndividualesFiltrados(desde, hasta, nombre, apellidos, numero,
				codigoPostal, pais);
		try {
			while (rsData.next()) {
				JSONObject data = new JSONObject();
				String id = rsData.getString("id");

				// clients autorized

				ResultSet rsAutorizedClients = miBD.obtenerPersonasAutorizadasCliente(id);
				List<JSONObject> autorizedClients = new ArrayList<JSONObject>();
				while (rsAutorizedClients.next()) {
					JSONObject autorizedClient = new JSONObject();
					
					String dateOfBirthAutorizedClient = rsAutorizedClients.getString("fechaNacimiento").toString();
					autorizedClient.put("dateOfBirth", dateOfBirthAutorizedClient);
					Map<String, String> nameAutorizedClient = new LinkedHashMap<String, String>();
					String firstnameAutorizedClient = rsAutorizedClients.getString("nombre");
					nameAutorizedClient.put("firstname", firstnameAutorizedClient);
					String lastNameAutorizedClient = rsAutorizedClients.getString("segundoNombre");
					nameAutorizedClient.put("lastName", lastNameAutorizedClient);
					autorizedClient.put("name", nameAutorizedClient);

					autorizedClients.add(autorizedClient);

					ResultSet rsAddressAutorizedClient = miBD.obtenerDireccionesCliente(id);
					autorizedClient.append("addresses", obtenerAddressCliente(rsAddressAutorizedClient));
				}
				data.put("Relatedperson", autorizedClients);
				
				// addresses
				ResultSet rsAddress = miBD.obtenerDireccionesCliente(id);
				data.put("addresses", obtenerAddressCliente(rsAddress));
				
				// personalData

				Boolean activeCostumer = rsData.getString("estado").equals("Activo");
				data.put("activeCostumer", activeCostumer);
				String dateOfBirth = rsData.getString("fechaNacimiento").toString();
				data.put("dateOfBirth", dateOfBirth);

				JSONObject name = new JSONObject();
				String firstname = rsData.getString("nombre");
				name.put("firstname", firstname);
				String lastName = rsData.getString("segundoNombre");
				name.put("lastName", lastName);
				data.put("name", name);
				
				// accounts
				ResultSet rsAccountsOwner = miBD.obtenerCuentasDelCliente(id, "ES");
				ResultSet rsAccountAutorized = miBD.obtenerCuentasAutorizadasCliente(id, "ES");
				List accounts=obtenerAccountsCliente(rsAccountsOwner,"Owner");
				accounts.addAll(obtenerAccountsCliente(rsAccountAutorized,"Autorized"));
				data.put("products", accounts);
				individual.put(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return individual;
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

	public List obtenerAddressCliente(ResultSet rsAddress){
		List<Map<String, String>> addresses = new ArrayList<Map<String, String>>();
		try {
			while (rsAddress.next()) {
				Map<String, String> address = new LinkedHashMap<String, String>();
				// address
				String city = rsAddress.getString("ciudad");
				address.put("city", city);
				String street = rsAddress.getString("calle");
				address.put("street", street);
				String number = rsAddress.getString("numero");
				address.put("number", number);
				int postalCode = rsAddress.getInt("codigoPostal");
				address.put("postalCode", String.valueOf(postalCode));
				String country = rsAddress.getString("pais");
				address.put("country", country);
				addresses.add(address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return addresses;
	}
	
	public List obtenerAccountsCliente(ResultSet rsAccounts,String type) {
		List<Map<String, String>> accounts = new ArrayList<Map<String, String>>();
		try {
			while (rsAccounts.next()) {
				Map<String, String> account = new LinkedHashMap<String, String>();
				// FALTA TYPE
				String productNumber = rsAccounts.getString("numeroCuenta");
				account.put("productNumber", productNumber);
				String status = rsAccounts.getString("estadoCuenta");
				account.put("status", status);
				String relationShip = type;
				account.put("relationShip", relationShip);
				accounts.add(account);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}
}
