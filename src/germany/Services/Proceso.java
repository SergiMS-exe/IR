package germany.Services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bbdd.*;

public class Proceso {

	//private int YEAR = 2021;
	private String inicial = "files/inicial.csv";
	private String semanal = "files/semanal.csv";

	public void rInicial() {
		ConsultasBBDD cuentas = new ConsultasBBDD();
		ResultSet rs = cuentas.reporteInicial1();
		List<List<String>> rows = toList(rs);
		rs = cuentas.reporteInicial2();
		List<List<String>> rows1 = toList(rs);
		imprimirCSV(rows,rows1,inicial);
	}

	private List<List<String>> toList(ResultSet rs) {
		// TODO Auto-generated method stub
		List<List<String>> l = new ArrayList<List<String>>();;
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


				l.add(Arrays.asList(apellido, nombre, numeroCuenta, calle,ciudad, String.valueOf(codigoPostal),
						pais, numeroIdentificacion, fechaNacimiento));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
	}

	public void rSemanal() {
		ConsultasBBDD cuentas = new ConsultasBBDD();
		ResultSet rs = cuentas.reporteSemanal1();
		List<List<String>> rows = toList(rs);
		rs = cuentas.reporteSemanal2();
		List<List<String>> rows1 = toList(rs);
		imprimirCSV(rows,rows1,semanal);

	}

	private void imprimirCSV(List<List<String>> rows, List<List<String>> rows1,String fileName) {
		boolean existe = new File(fileName).exists();

		if (existe) {
			File archivo = new File(fileName);
			archivo.delete();
		}

		try {

			FileWriter fw = new FileWriter(fileName);
			fw.append("IBAN");
			fw.append("; ");
			fw.append("Last_Name");
			fw.append("; ");
			fw.append("First_Name");
			fw.append("; ");
			fw.append("Street");
			fw.append("; ");
			fw.append("City");
			fw.append("; ");
			fw.append("Post_Code");
			fw.append("; ");
			fw.append("Country");
			fw.append("; ");
			fw.append("identification_Numbre");
			fw.append("; ");
			fw.append("Date_Of_Birth");
			fw.append("\r\n");

			for (List<String> rowData : rows) {
				fw.append(String.join("; ", rowData));
				fw.append("\r\n");
			}
			
			for (List<String> rowData : rows1) {
				fw.append(String.join("; ", rowData));
				fw.append("\r\n");
			}
			

			fw.flush();
			fw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
