package Vista;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaHolandaFiltrarClientes frame = new VentanaHolandaFiltrarClientes();
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
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel Top = new JPanel();
		contentPane.add(Top, BorderLayout.NORTH);
		Top.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("< Retroceder");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Top.add(btnNewButton, BorderLayout.WEST);
		
		JPanel TOP_Titulo = new JPanel();
		Top.add(TOP_Titulo, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("Holanda");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 47));
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		TOP_Titulo.add(lblNewLabel);
		
		JPanel Center = new JPanel();
		contentPane.add(Center, BorderLayout.CENTER);
		Center.setLayout(new BorderLayout(0, 0));
		
		JPanel C_BusquedaDeClientes = new JPanel();
		Center.add(C_BusquedaDeClientes, BorderLayout.NORTH);
		C_BusquedaDeClientes.setLayout(new BorderLayout(0, 0));
		
		JPanel C_BDC_Center = new JPanel();
		C_BusquedaDeClientes.add(C_BDC_Center, BorderLayout.CENTER);
		C_BDC_Center.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel C_BDC_C_Desde = new JPanel();
		C_BDC_Center.add(C_BDC_C_Desde);
		C_BDC_C_Desde.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_3 = new JLabel("Desde:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		C_BDC_C_Desde.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		C_BDC_C_Desde.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(VentanaHolandaFiltrarClientes.class.getResource("/Holanda/res/calendarioPeque.png")));
		C_BDC_C_Desde.add(lblNewLabel_5);
		
		JPanel C_BDC_C_Hasta = new JPanel();
		C_BDC_Center.add(C_BDC_C_Hasta);
		C_BDC_C_Hasta.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_3_1 = new JLabel("Hasta:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		C_BDC_C_Hasta.add(lblNewLabel_3_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		C_BDC_C_Hasta.add(textField);
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setIcon(new ImageIcon(VentanaHolandaFiltrarClientes.class.getResource("/Holanda/res/calendarioPeque.png")));
		C_BDC_C_Hasta.add(lblNewLabel_5_1);
		
		JPanel C_BDC_Top = new JPanel();
		C_BusquedaDeClientes.add(C_BDC_Top, BorderLayout.NORTH);
		C_BDC_Top.setLayout(new MigLayout("", "[110px][][][][][][][][][][][][]", "[13px]"));
		
		JLabel lblNewLabel_1 = new JLabel("Busqueda de clientes:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		C_BDC_Top.add(lblNewLabel_1, "cell 4 0,alignx center,aligny center");
		
		JPanel C_Datos = new JPanel();
		Center.add(C_Datos, BorderLayout.CENTER);
		C_Datos.setLayout(new BorderLayout(0, 0));
		
		JPanel C_DatosPersonales = new JPanel();
		C_Datos.add(C_DatosPersonales, BorderLayout.NORTH);
		C_DatosPersonales.setLayout(new BorderLayout(0, 0));
		
		JPanel C_DP_Top = new JPanel();
		C_DatosPersonales.add(C_DP_Top, BorderLayout.NORTH);
		C_DP_Top.setLayout(new MigLayout("", "[][][][][][][][][]", "[]"));
		
		JLabel lblNewLabel_2 = new JLabel("Datos personales:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		C_DP_Top.add(lblNewLabel_2, "cell 7 0");
		
		JPanel C_DP_Center = new JPanel();
		C_DatosPersonales.add(C_DP_Center, BorderLayout.CENTER);
		C_DP_Center.setLayout(new BorderLayout(0, 0));
		
		JPanel C_DP_C_Nombre = new JPanel();
		C_DP_Center.add(C_DP_C_Nombre, BorderLayout.NORTH);
		C_DP_C_Nombre.setLayout(new MigLayout("", "[59px][95px][][][][][][]", "[19px]"));
		
		JLabel lblNewLabel_4 = new JLabel("Nombre: ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		C_DP_C_Nombre.add(lblNewLabel_4, "cell 4 0,alignx left,aligny top");
		
		textField_2 = new JTextField();
		textField_2.setColumns(33);
		C_DP_C_Nombre.add(textField_2, "cell 5 0,alignx left,aligny top");
		
		JPanel C_DP_C_Apellidos = new JPanel();
		C_DP_Center.add(C_DP_C_Apellidos, BorderLayout.CENTER);
		
		JPanel C_Direccion = new JPanel();
		C_Datos.add(C_Direccion, BorderLayout.CENTER);
		C_Direccion.setLayout(new BorderLayout(0, 0));
		
		JPanel C_D_Top = new JPanel();
		C_Direccion.add(C_D_Top, BorderLayout.NORTH);
		C_D_Top.setLayout(new MigLayout("", "[][][][][][][][][]", "[]"));
		
		JLabel lblNewLabel_7 = new JLabel("Direccion:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		C_D_Top.add(lblNewLabel_7, "cell 7 0");
		
		JPanel C_D_Center = new JPanel();
		C_Direccion.add(C_D_Center, BorderLayout.CENTER);
		C_D_Center.setLayout(new BorderLayout(0, 0));
		
		JPanel C_D_C_Numero = new JPanel();
		C_D_Center.add(C_D_C_Numero, BorderLayout.NORTH);
		C_D_C_Numero.setLayout(new MigLayout("", "[31px][120px][][][][][][][][][][][][][][]", "[19px]"));
		
		JLabel lblNewLabel_8 = new JLabel("N\u00FAmero: ");
		C_D_C_Numero.add(lblNewLabel_8, "cell 5 0,alignx left,aligny top");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField_4 = new JTextField();
		C_D_C_Numero.add(textField_4, "cell 6 0,alignx left,aligny top");
		textField_4.setColumns(33);
		
		JPanel C_D_C_More = new JPanel();
		C_D_Center.add(C_D_C_More, BorderLayout.CENTER);
		C_D_C_More.setLayout(new BorderLayout(0, 0));
		
		JPanel C_D_C_CodigoPostal = new JPanel();
		C_D_C_More.add(C_D_C_CodigoPostal, BorderLayout.NORTH);
		
		JLabel lblNewLabel_9 = new JLabel("Apellidos:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		C_DP_C_Apellidos.setLayout(new MigLayout("", "[64px][90px][][][][]", "[19px]"));
		
		JLabel lblNewLabel_6 = new JLabel("Apellidos:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		C_DP_C_Apellidos.add(lblNewLabel_6, "cell 4 0,alignx left,aligny top");
		
		textField_3 = new JTextField();
		textField_3.setColumns(33);
		C_DP_C_Apellidos.add(textField_3, "cell 5 0,alignx left,aligny top");
		C_D_C_CodigoPostal.setLayout(new MigLayout("", "[97px][31px][][][][][][][][][][]", "[19px]"));
		
		JLabel lblNewLabel_10 = new JLabel("C\u00F3digo postal:");
		C_D_C_CodigoPostal.add(lblNewLabel_10, "cell 4 0,alignx left,aligny top");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField_5 = new JTextField();
		C_D_C_CodigoPostal.add(textField_5, "cell 5 0 2 1,alignx left,aligny top");
		textField_5.setColumns(33);
		
		JPanel C_D_C_Pais = new JPanel();
		C_D_C_More.add(C_D_C_Pais, BorderLayout.CENTER);
		C_D_C_Pais.setLayout(new MigLayout("", "[31px][100px][][][][][][][][][][][][][][][][]", "[19px]"));
		
		JLabel lblNewLabel_11 = new JLabel("Pa\u00EDs: ");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		C_D_C_Pais.add(lblNewLabel_11, "cell 7 0,alignx left,aligny top");
		
		textField_6 = new JTextField();
		C_D_C_Pais.add(textField_6, "flowx,cell 8 0,alignx left,aligny top");
		textField_6.setColumns(33);
		
		JPanel Bottom = new JPanel();
		contentPane.add(Bottom, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("Filtrar Clientes");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		Bottom.add(btnNewButton_1);
	}
}
