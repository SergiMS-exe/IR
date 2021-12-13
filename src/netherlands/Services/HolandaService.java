package netherlands.Services;

import bbdd.Conexion;

public class HolandaService {
	public String getEstado() {
		Conexion miBD = new Conexion() ;
		miBD.conectar();
		return miBD.getEstado();
	}
}
