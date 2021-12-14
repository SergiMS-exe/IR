package netherlands.Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import javax.swing.Box;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.GridBagConstraints;

import netherlands.Services.*;

public class VentanaHolandaFiltrarClientes extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDesde;
	private JTextField textFieldHasta;
	private JTextField textFieldPais;
	private JTextField textFieldNumero;
	private JTextField textFieldCodigoPostal;
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JButton btnFiltrar;

	private static VentanaHolandaFiltrarClientes frame;

	private HolandaService services;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new VentanaHolandaFiltrarClientes(new HolandaService());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaHolandaFiltrarClientes(HolandaService services) {
		this.services=services;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 856, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Top = new JPanel();
		Top.setBounds(5, 5, 832, 104);
		contentPane.add(Top);
		
		JButton btnRetroceder = new JButton("< Retroceder");
		btnRetroceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new VentanaHolanda(services).setVisible(true);
			}
		});
		btnRetroceder.setBounds(38, 29, 111, 21);
		Top.setLayout(null);
		Top.add(btnRetroceder);
		
		JPanel TOP_Titulo = new JPanel();
		TOP_Titulo.setBounds(0, 31, 832, 73);
		Top.add(TOP_Titulo);
		TOP_Titulo.setLayout(null);
		
		JLabel lblHolanda = new JLabel("Holanda");
		lblHolanda.setBounds(328, 5, 176, 63);
		lblHolanda.setFont(new Font("Tahoma", Font.PLAIN, 38));
		lblHolanda.setHorizontalAlignment(SwingConstants.CENTER);
		lblHolanda.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		TOP_Titulo.add(lblHolanda);
		
		JPanel Center = new JPanel();
		Center.setBounds(5, 109, 832, 325);
		contentPane.add(Center);
		Center.setLayout(null);
		
		JPanel C_BusquedaDeClientes = new JPanel();
		C_BusquedaDeClientes.setBounds(0, 0, 832, 78);
		Center.add(C_BusquedaDeClientes);
		C_BusquedaDeClientes.setLayout(null);
		
		JPanel C_BDC_Center = new JPanel();
		C_BDC_Center.setBounds(0, 33, 832, 45);
		C_BusquedaDeClientes.add(C_BDC_Center);
		C_BDC_Center.setLayout(null);
		
		JPanel C_BDC_C_Desde = new JPanel();
		C_BDC_C_Desde.setBounds(227, 5, 188, 35);
		C_BDC_Center.add(C_BDC_C_Desde);
		C_BDC_C_Desde.setLayout(null);
		
		JLabel lblDesde = new JLabel("Desde:");
		lblDesde.setBounds(5, 8, 47, 19);
		lblDesde.setFont(new Font("Tahoma", Font.PLAIN, 15));
		C_BDC_C_Desde.add(lblDesde);
		
		textFieldDesde = new JTextField();
		textFieldDesde.setBounds(57, 8, 96, 19);
		C_BDC_C_Desde.add(textFieldDesde);
		textFieldDesde.setColumns(10);
		textFieldDesde.addKeyListener( new KeyListener(){
            @Override
			public void keyTyped(KeyEvent e) {
				checkInputs();
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(158, 5, 25, 25);
		lblNewLabel_5.setIcon(new ImageIcon(VentanaHolandaFiltrarClientes.class.getResource("/res/calendarioPeque.png")));
		C_BDC_C_Desde.add(lblNewLabel_5);
		
		JPanel C_BDC_C_Hasta = new JPanel();
		C_BDC_C_Hasta.setBounds(420, 5, 184, 35);
		C_BDC_Center.add(C_BDC_C_Hasta);
		C_BDC_C_Hasta.setLayout(null);
		
		JLabel lblHasta = new JLabel("Hasta:");
		lblHasta.setBounds(5, 8, 43, 19);
		lblHasta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		C_BDC_C_Hasta.add(lblHasta);
		
		textFieldHasta = new JTextField();
		textFieldHasta.setBounds(53, 8, 96, 19);
		textFieldHasta.setColumns(10);
		C_BDC_C_Hasta.add(textFieldHasta);
		textFieldHasta.addKeyListener( new KeyListener(){
            @Override
			public void keyTyped(KeyEvent e) {
				checkInputs();
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setBounds(154, 5, 25, 25);
		lblNewLabel_5_1.setIcon(new ImageIcon(VentanaHolandaFiltrarClientes.class.getResource("/res/calendarioPeque.png")));
		C_BDC_C_Hasta.add(lblNewLabel_5_1);
		
		JPanel C_BDC_Top = new JPanel();
		C_BDC_Top.setBounds(0, 0, 832, 33);
		C_BusquedaDeClientes.add(C_BDC_Top);
		C_BDC_Top.setLayout(null);
		
		JLabel lblBusquedaDeClientes = new JLabel("Busqueda de clientes:");
		lblBusquedaDeClientes.setBounds(208, 7, 167, 19);
		lblBusquedaDeClientes.setFont(new Font("Tahoma", Font.BOLD, 15));
		C_BDC_Top.add(lblBusquedaDeClientes);
		
		JPanel C_Datos = new JPanel();
		C_Datos.setBounds(0, 78, 832, 247);
		Center.add(C_Datos);
		C_Datos.setLayout(null);
		
		JPanel C_DatosPersonales = new JPanel();
		C_DatosPersonales.setBounds(0, 0, 832, 99);
		C_Datos.add(C_DatosPersonales);
		C_DatosPersonales.setLayout(null);
		
		JPanel C_DP_Top = new JPanel();
		C_DP_Top.setBounds(0, 0, 832, 33);
		C_DatosPersonales.add(C_DP_Top);
		C_DP_Top.setLayout(null);
		
		JLabel lblDatosPersonales = new JLabel("Datos personales:");
		lblDatosPersonales.setBounds(210, 7, 137, 19);
		lblDatosPersonales.setFont(new Font("Tahoma", Font.BOLD, 15));
		C_DP_Top.add(lblDatosPersonales);
		
		JPanel C_DP_Center = new JPanel();
		C_DP_Center.setBounds(0, 33, 832, 66);
		C_DatosPersonales.add(C_DP_Center);
		C_DP_Center.setLayout(null);
		
		JPanel C_DP_C_Nombre = new JPanel();
		C_DP_C_Nombre.setBounds(0, 0, 832, 33);
		C_DP_Center.add(C_DP_C_Nombre);
		C_DP_C_Nombre.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(227, 7, 64, 19);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		C_DP_C_Nombre.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(295, 7, 303, 19);
		textFieldNombre.setColumns(33);
		textFieldNombre.addKeyListener( new KeyListener(){
            @Override
			public void keyTyped(KeyEvent e) {
				checkInputs();
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		C_DP_C_Nombre.add(textFieldNombre);
		
		JPanel C_DP_C_Apellidos = new JPanel();
		C_DP_C_Apellidos.setBounds(0, 33, 832, 33);
		C_DP_Center.add(C_DP_C_Apellidos);
		
		JPanel C_Direccion = new JPanel();
		C_Direccion.setBounds(0, 99, 832, 148);
		C_Datos.add(C_Direccion);
		C_Direccion.setLayout(null);
		
		JPanel C_D_Top = new JPanel();
		C_D_Top.setBounds(0, 0, 832, 33);
		C_Direccion.add(C_D_Top);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(210, 7, 77, 19);
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDatosPersonales.setFont(new Font("Tahoma", Font.BOLD, 15));
		C_D_Top.setLayout(null);
		C_D_Top.add(lblDireccion);
		
		JPanel C_D_Center = new JPanel();
		C_D_Center.setBounds(0, 33, 832, 115);
		C_Direccion.add(C_D_Center);
		C_D_Center.setLayout(null);
		
		JPanel C_D_C_Numero = new JPanel();
		C_D_C_Numero.setBounds(0, 0, 832, 33);
		C_D_Center.add(C_D_C_Numero);
		C_D_C_Numero.setLayout(null);
		
		JLabel lblNumero = new JLabel("N\u00FAmero: ");
		lblNumero.setBounds(233, 7, 64, 19);
		C_D_C_Numero.add(lblNumero);
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(301, 7, 299, 19);
		C_D_C_Numero.add(textFieldNumero);
		textFieldNumero.setColumns(33);
		textFieldNumero.addKeyListener( new KeyListener(){
            @Override
			public void keyTyped(KeyEvent e) {
				checkInputs();
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JPanel C_D_C_More = new JPanel();
		C_D_C_More.setBounds(0, 33, 832, 82);
		C_D_Center.add(C_D_C_More);
		C_D_C_More.setLayout(null);
		
		JPanel C_D_C_CodigoPostal = new JPanel();
		C_D_C_CodigoPostal.setBounds(0, 0, 832, 33);
		C_D_C_More.add(C_D_C_CodigoPostal);
		
		JLabel lblNewLabel_9 = new JLabel("Apellidos:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		C_DP_C_Apellidos.setLayout(null);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(227, 7, 64, 19);
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		C_DP_C_Apellidos.add(lblApellidos);
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setBounds(295, 7, 303, 19);
		textFieldApellidos.setColumns(33);
		textFieldApellidos.addKeyListener( new KeyListener(){
            @Override
			public void keyTyped(KeyEvent e) {
				checkInputs();
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		C_DP_C_Apellidos.add(textFieldApellidos);
		C_D_C_CodigoPostal.setLayout(null);
		
		JLabel lblCodigoPostal = new JLabel("C\u00F3digo postal:");
		lblCodigoPostal.setBounds(201, 7, 95, 19);
		C_D_C_CodigoPostal.add(lblCodigoPostal);
		lblCodigoPostal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textFieldCodigoPostal = new JTextField();
		textFieldCodigoPostal.setBounds(300, 7, 303, 19);
		C_D_C_CodigoPostal.add(textFieldCodigoPostal);
		textFieldCodigoPostal.setColumns(33);
		textFieldCodigoPostal.addKeyListener( new KeyListener(){
            @Override
			public void keyTyped(KeyEvent e) {
				checkInputs();
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JPanel C_D_C_Pais = new JPanel();
		C_D_C_Pais.setBounds(0, 33, 832, 49);
		C_D_C_More.add(C_D_C_Pais);
		C_D_C_Pais.setLayout(null);
		
		JLabel lblPais = new JLabel("Pa\u00EDs: ");
		lblPais.setBounds(262, 7, 36, 19);
		lblPais.setFont(new Font("Tahoma", Font.PLAIN, 15));
		C_D_C_Pais.add(lblPais);
		
		textFieldPais = new JTextField();
		textFieldPais.setBounds(302, 7, 299, 19);
		C_D_C_Pais.add(textFieldPais);
		textFieldPais.setColumns(33);
		textFieldPais.addKeyListener( new KeyListener(){
            @Override
			public void keyTyped(KeyEvent e) {
				checkInputs();
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JPanel Bottom = new JPanel();
		Bottom.setBounds(5, 434, 832, 41);
		contentPane.add(Bottom);
		
		btnFiltrar = new JButton("Filtrar Clientes");
		btnFiltrar.setBounds(338, 5, 155, 31);
		btnFiltrar.setEnabled(false);
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String desde = textFieldDesde.getText();
				String hasta = textFieldHasta.getText();
				String nombre=textFieldNombre.getText();
				String apellidos= textFieldApellidos.getText();
				String numero = textFieldNumero.getText();
				String codigoPostal= textFieldCodigoPostal.getText();
				String pais=textFieldPais.getText();
				String output=services.filtrarCliente(desde,hasta,nombre,apellidos,numero,codigoPostal,pais);
				setVisible(false);
				new VentanaHolandaResultado(services,output).setVisible(true);
			}
		});
		Bottom.setLayout(null);
		btnFiltrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Bottom.add(btnFiltrar);
	}
	private void checkInputs() {
		String desde = textFieldDesde.getText();
		String hasta = textFieldHasta.getText();
		String nombre=textFieldNombre.getText();
		String apellidos= textFieldApellidos.getText();
		String numero = textFieldNumero.getText();
		String codigoPostal= textFieldCodigoPostal.getText();
		String pais=textFieldPais.getText();
		if(desde.equals("")||hasta.equals("")||nombre.equals("")||apellidos.equals("")||numero.equals("")||codigoPostal.equals("")||pais.equals("")) {
			btnFiltrar.setEnabled(false);
		}
		else
			btnFiltrar.setEnabled(true);
		
	}
}
