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
	private String Filename = "..\\files\\file.csv";

	public void rInicial() {
		ConsultasBBDD cuentas = new ConsultasBBDD();
		ResultSet rs = cuentas.obtenerClientes();
		List<List<String>> rows = toList(rs);
		imprimirCSV(rows);

	}

	private List<List<String>> toList(ResultSet rs) {
		// TODO Auto-generated method stub
		List<List<String>> l = new ArrayList<List<String>>();

		try {
			while (rs.next()) {
				int id = rs.getInt(1);
				String numeroIdentificacion = rs.getString(2);
				String estado = rs.getString(3);
				String fechaInicio = rs.getDate(4).toString();
				int direccion = rs.getInt(5);

				l.add(Arrays.asList(String.valueOf(id), numeroIdentificacion, estado, fechaInicio,
						String.valueOf(direccion)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
	}

	public void rSemanal() {
		ConsultasBBDD cuentas = new ConsultasBBDD();
		ResultSet rs = cuentas.obtenerClientes();
		List<List<String>> rows = toList(rs);
		rows = filtrarSemanal(rows);
		imprimirCSV(rows);

	}

	private List<List<String>> filtrarSemanal(List<List<String>> rows) {
		// TODO Auto-generated method stub
		List<List<String>> l = new ArrayList<List<String>>();;
		for (List<String> rowData : rows) {
		   String estado = rowData.get(2);
		   String fecha = rowData.get(3);
		   fecha = getAño(fecha);
		   int dif =YEAR- Integer.valueOf(fecha);
		   System.out.println(estado);
		   System.out.println(dif + " " + fecha + " " + YEAR);
		   if (estado.equals("Activo")&& dif<=5) {
			   l.add(rowData);
		   }
		   
		}
		return l;
	}



	private String getAño(String fecha) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<4;i++) {
			sb.append(fecha.charAt(i));
		}
		return sb.toString();
	}

	private void imprimirCSV(List<List<String>> rows) {
		boolean existe = new File(Filename).exists();

		if (existe) {
			File archivo = new File(Filename);
			archivo.delete();
		}

		try {

			FileWriter fw = new FileWriter(Filename);
			fw.append("ID");
			fw.append(", ");
			fw.append("Numero Identificacion");
			fw.append(", ");
			fw.append("Estado Cuenta");
			fw.append(", ");
			fw.append("Fecha Inicio");
			fw.append(", ");
			fw.append("Direccion");
			fw.append("\r\n");
			
			for (List<String> rowData : rows) {
			    fw.append(String.join(",", rowData));
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
