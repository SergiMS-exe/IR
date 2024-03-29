package netherlands.Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.border.TitledBorder;

import org.json.JSONException;

import netherlands.Services.HolandaService;

import javax.swing.border.LineBorder;
import java.awt.Color;

public class VentanaHolandaFiltrarCuentas extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private static  VentanaHolandaFiltrarCuentas frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private HolandaService holandaService;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new VentanaHolandaFiltrarCuentas(new HolandaService());
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
	public VentanaHolandaFiltrarCuentas(HolandaService services) {
		this.holandaService=services;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(226, 18, 202, 90);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Holanda\r\n");
		lblNewLabel.setBounds(10, 10, 182, 70);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 38));
		
		JButton btnNewButton_1 = new JButton("< Retroceder");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new VentanaHolanda(services).setVisible(true);
			}
		});
		btnNewButton_1.setBounds(38, 29, 111, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Busqueda de cuentas bancarias:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(78, 127, 298, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Estado:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(78, 210, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JRadioButton rbActiva = new JRadioButton("Activa\r\n");
		rbActiva.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonGroup.add(rbActiva);
		rbActiva.setBounds(157, 182, 103, 21);
		contentPane.add(rbActiva);
		
		JRadioButton rbInactiva = new JRadioButton("Cerrada");
		rbInactiva.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonGroup.add(rbInactiva);
		rbInactiva.setBounds(157, 230, 103, 21);
		contentPane.add(rbInactiva);
		
		JLabel lblNewLabel_3 = new JLabel("IBAN:\r\n");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(78, 284, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(133, 283, 250, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Filtrar Cuentas");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String estado="";
				if (rbActiva.isSelected())
					estado="activa";
				else if (rbInactiva.isSelected())
					estado="cerrada";
				if ((rbActiva.isSelected() || rbInactiva.isSelected()) && !textField.getText().equals(""))
					JOptionPane.showMessageDialog(frame,"Se debe de filtrar por estado de la cuenta o IBAN, pero no ambas");
				String cuentas = holandaService.filtrarCuentas(estado, textField.getText());
				setVisible(false);
				System.out.println(cuentas);
				new VentanaHolandaResultado(services,cuentas).setVisible(true);
			}
		});
		btnNewButton.setBounds(244, 338, 172, 29);
		contentPane.add(btnNewButton);
		
	}
}
