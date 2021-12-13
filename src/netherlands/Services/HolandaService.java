package netherlands.Services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import bbdd.*;

public class HolandaService {
	
	private ConsultasBBDD miBD= new ConsultasBBDD();
	
	public String getEstado() {
		return miBD.getConexion();
	}
	public String filtrarCliente(String d, String h, String no, String a, String nu,
			String cp, String p) {
		if(getEstado()==Conexion.FAILURE_CONNECTION) {
			return "error";
		}
		//ResultSet rs= miBD.obtenerClientes(d,h,no,a,nu,cp,p);
		ResultSet rs= miBD.obtenerClientes();
		System.out.println(rs.toString());
		List<List<String>> l = new ArrayList<List<String>>();
		try {
			while (rs.next()) {
				String apellido = rs.getString(1);
				String nombre = rs.getString(2);
				String numeroCuenta = rs.getString(3);
				String calle = rs.getString(4);
				String ciudad = rs.getString(5);
				int codigoPostal = rs.getInt(6);
				String pais = rs.getString(7);
				String numeroIdentificacion = rs.getString(8);
				String fechaNacimiento = rs.getDate(9).toString();

				l.add(Arrays.asList(apellido, nombre, numeroCuenta, calle, ciudad, String.valueOf(codigoPostal), pais,
						numeroIdentificacion, fechaNacimiento));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ok";
	}
	
	public String filtrarCuentas(String estado, String iban) {
		if(getEstado()==Conexion.FAILURE_CONNECTION) {
			return "error";
		}
		ResultSet res = miBD.filtrarCuentas(estado, iban);
		List<HashMap<String, String>> cuentas = new ArrayList<HashMap<String, String>>();
		try {
			while (res.next()) {
				String[] keys= {"id", "numeroCuenta", "estadoCuenta", "fechaApertura", "fechaCierre", "entidadEbury", "propietario"};
				HashMap<String, String> cuenta = new HashMap<String, String>();
				for (int i=1; i<=keys.length; i++) {
					cuenta.put(keys[i-1], res.getString(i));
				}
				cuentas.add(cuenta);
			}
			
			List<JSONObject> jsonObj = new ArrayList<JSONObject>();

			for(HashMap<String, String> data : cuentas) {
			    JSONObject obj = new JSONObject(data);
			    jsonObj.add(obj);
			}

			JSONArray result = new JSONArray(jsonObj);
			return result.toString(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
}
