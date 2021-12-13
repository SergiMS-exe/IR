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
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import javax.swing.Box;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

public class VentanaHolandaFiltrarClientes extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_6;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_2;
	private JTextField textField_3;

	private static VentanaHolandaFiltrarClientes frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new VentanaHolandaFiltrarClientes();
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
	public VentanaHolandaFiltrarClientes() {
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
		
		JButton btnNewButton = new JButton("< Retroceder");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new VentanaHolanda().setVisible(true);
			}
		});
		btnNewButton.setBounds(38, 29, 111, 21);
		Top.setLayout(null);
		Top.add(btnNewButton);
		
		JPanel TOP_Titulo = new JPanel();
		TOP_Titulo.setBounds(0, 31, 832, 73);
		Top.add(TOP_Titulo);
		TOP_Titulo.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Holanda");
		lblNewLabel.setBounds(328, 5, 176, 63);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 38));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		TOP_Titulo.add(lblNewLabel);
		
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
		
		JLabel lblNewLabel_3 = new JLabel("Desde:");
		lblNewLabel_3.setBounds(5, 8, 47, 19);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		C_BDC_C_Desde.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(57, 8, 96, 19);
		C_BDC_C_Desde.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(158, 5, 25, 25);
		lblNewLabel_5.setIcon(new ImageIcon(VentanaHolandaFiltrarClientes.class.getResource("/res/calendarioPeque.png")));
		C_BDC_C_Desde.add(lblNewLabel_5);
		
		JPanel C_BDC_C_Hasta = new JPanel();
		C_BDC_C_Hasta.setBounds(420, 5, 184, 35);
		C_BDC_Center.add(C_BDC_C_Hasta);
		C_BDC_C_Hasta.setLayout(null);
		
		JLabel lblNewLabel_3_1 = new JLabel("Hasta:");
		lblNewLabel_3_1.setBounds(5, 8, 43, 19);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		C_BDC_C_Hasta.add(lblNewLabel_3_1);
		
		textField = new JTextField();
		textField.setBounds(53, 8, 96, 19);
		textField.setColumns(10);
		C_BDC_C_Hasta.add(textField);
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setBounds(154, 5, 25, 25);
		lblNewLabel_5_1.setIcon(new ImageIcon(VentanaHolandaFiltrarClientes.class.getResource("/res/calendarioPeque.png")));
		C_BDC_C_Hasta.add(lblNewLabel_5_1);
		
		JPanel C_BDC_Top = new JPanel();
		C_BDC_Top.setBounds(0, 0, 832, 33);
		C_BusquedaDeClientes.add(C_BDC_Top);
		C_BDC_Top.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Busqueda de clientes:");
		lblNewLabel_1.setBounds(208, 7, 167, 19);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		C_BDC_Top.add(lblNewLabel_1);
		
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
		
		JLabel lblNewLabel_2 = new JLabel("Datos personales:");
		lblNewLabel_2.setBounds(210, 7, 137, 19);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		C_DP_Top.add(lblNewLabel_2);
		
		JPanel C_DP_Center = new JPanel();
		C_DP_Center.setBounds(0, 33, 832, 66);
		C_DatosPersonales.add(C_DP_Center);
		C_DP_Center.setLayout(null);
		
		JPanel C_DP_C_Nombre = new JPanel();
		C_DP_C_Nombre.setBounds(0, 0, 832, 33);
		C_DP_Center.add(C_DP_C_Nombre);
		C_DP_C_Nombre.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre: ");
		lblNewLabel_4.setBounds(227, 7, 64, 19);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		C_DP_C_Nombre.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(295, 7, 303, 19);
		textField_2.setColumns(33);
		C_DP_C_Nombre.add(textField_2);
		
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
		
		JLabel lblNewLabel_7 = new JLabel("Direccion:");
		lblNewLabel_7.setBounds(210, 7, 77, 19);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		C_D_Top.setLayout(null);
		C_D_Top.add(lblNewLabel_7);
		
		JPanel C_D_Center = new JPanel();
		C_D_Center.setBounds(0, 33, 832, 115);
		C_Direccion.add(C_D_Center);
		C_D_Center.setLayout(null);
		
		JPanel C_D_C_Numero = new JPanel();
		C_D_C_Numero.setBounds(0, 0, 832, 33);
		C_D_Center.add(C_D_C_Numero);
		C_D_C_Numero.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("N\u00FAmero: ");
		lblNewLabel_8.setBounds(233, 7, 64, 19);
		C_D_C_Numero.add(lblNewLabel_8);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField_4 = new JTextField();
		textField_4.setBounds(301, 7, 299, 19);
		C_D_C_Numero.add(textField_4);
		textField_4.setColumns(33);
		
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
		
		JLabel lblNewLabel_6 = new JLabel("Apellidos:");
		lblNewLabel_6.setBounds(227, 7, 64, 19);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		C_DP_C_Apellidos.add(lblNewLabel_6);
		
		textField_3 = new JTextField();
		textField_3.setBounds(295, 7, 303, 19);
		textField_3.setColumns(33);
		C_DP_C_Apellidos.add(textField_3);
		C_D_C_CodigoPostal.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("C\u00F3digo postal:");
		lblNewLabel_10.setBounds(201, 7, 95, 19);
		C_D_C_CodigoPostal.add(lblNewLabel_10);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField_5 = new JTextField();
		textField_5.setBounds(300, 7, 303, 19);
		C_D_C_CodigoPostal.add(textField_5);
		textField_5.setColumns(33);
		
		JPanel C_D_C_Pais = new JPanel();
		C_D_C_Pais.setBounds(0, 33, 832, 49);
		C_D_C_More.add(C_D_C_Pais);
		C_D_C_Pais.setLayout(null);
		
		JLabel lblNewLabel_11 = new JLabel("Pa\u00EDs: ");
		lblNewLabel_11.setBounds(262, 7, 36, 19);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		C_D_C_Pais.add(lblNewLabel_11);
		
		textField_6 = new JTextField();
		textField_6.setBounds(302, 7, 299, 19);
		C_D_C_Pais.add(textField_6);
		textField_6.setColumns(33);
		
		JPanel Bottom = new JPanel();
		Bottom.setBounds(5, 434, 832, 41);
		contentPane.add(Bottom);
		
		JButton btnNewButton_1 = new JButton("Filtrar Clientes");
		btnNewButton_1.setBounds(338, 5, 155, 31);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		Bottom.setLayout(null);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Bottom.add(btnNewButton_1);
	}
}
