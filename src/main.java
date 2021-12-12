import Vista.Inicio;
import bbdd.Conexion;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Inicio().setVisible(true);
		Conexion c = new Conexion();
		c.conectar();
	}

}
