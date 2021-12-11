package Alemania;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvWriter;

import bbdd.ConsultasBBDD;

public class Proceso {

	
	private int YEAR = 2021;
	private String Filename = "C:\\Users\\casti\\Desktop\\InterfazHolanda\\src\\files\\file.csv";

	public void rInicial() {
		ConsultasBBDD cuentas = new ConsultasBBDD();
		ResultSet rs = cuentas.reporteInicial();
		List<List<String>> rows = toList(rs);
		imprimirCSV(rows);

	}

	private List<List<String>> toList(ResultSet rs) {
		// TODO Auto-generated method stub
		List<List<String>> l = new ArrayList<List<String>>();
		ConsultasBBDD cuentas = new ConsultasBBDD();
		ResultSet dir=null;
		try {
			while (rs.next()) {
				String numeroCuenta = rs.getString(1);
				String apellido = rs.getString(2);
				String nombre = rs.getString(3);
				int direccion = rs.getInt(4);
				String numeroIdentificacion = rs.getString(5);
				String fechaNacimiento = rs.getDate(6).toString();

				dir=cuentas.obtenerDireccion(direccion);
				String calle="";
				String numero ="";
				String calleNumero = ""; 
				String ciudad = "";
				int codigoPostal = 0;
				String pais="";
				while(dir.next()) {
					calle=dir.getString(3);
					numero =String.valueOf(dir.getInt(4));
					calleNumero = calle + " " + numero; 
					ciudad = dir.getString(6);
					codigoPostal = dir.getInt(8);
					pais=dir.getString(9);
				}
				
				
				
				l.add(Arrays.asList(
						numeroCuenta, 
						apellido,
						nombre,
						calleNumero,
						ciudad,
						String.valueOf(codigoPostal),
						pais,
						String.valueOf(numeroIdentificacion),
						fechaNacimiento
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
	}

	public void rSemanal() {
		ConsultasBBDD cuentas = new ConsultasBBDD();
		ResultSet rs = cuentas.reporteSemanal();
		List<List<String>> rows = toList(rs);
		imprimirCSV(rows);

	}


	private void imprimirCSV(List<List<String>> rows) {
		boolean existe = new File(Filename).exists();

		if (existe) {
			File archivo = new File(Filename);
			archivo.delete();
		}

		try {

			FileWriter fw = new FileWriter(Filename);
			fw.append("IBAN");
			fw.append(", ");
			fw.append("Last_Name");
			fw.append(", ");
			fw.append("First_Name");
			fw.append(", ");
			fw.append("Street");
			fw.append(", ");
			fw.append("City");
			fw.append(", ");
			fw.append("Post_Code");
			fw.append(", ");
			fw.append("Country");
			fw.append(", ");
			fw.append("identification_Numbre");
			fw.append(", ");
			fw.append("Date_Of_Birth");
			fw.append("\r\n");
			
			for (List<String> rowData : rows) {
			    fw.append(String.join(", ", rowData));
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
