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
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.TitledBorder;

import netherlands.Services.*;
import netherlands.Vistas.*;

import javax.swing.border.LineBorder;
import java.awt.Color;

public class VentanaHolanda extends JFrame {

	private JPanel contentPane;
	static VentanaHolanda frame;
	private HolandaService services;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new VentanaHolanda(new HolandaService());
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
	public VentanaHolanda(HolandaService services) {
		this.services=services;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Filtrar Clientes");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new VentanaHolandaFiltrarClientes(services).setVisible(true);
			}
		});
		btnNewButton.setBounds(82, 307, 146, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Filtrar Cuentas");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new VentanaHolandaFiltrarCuentas(services).setVisible(true);
			}
		});
		btnNewButton_1.setBounds(409, 307, 146, 21);
		contentPane.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(214, 41, 211, 79);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Holanda");
		lblNewLabel.setBounds(10, 0, 191, 79);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 38));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnNewButton_2 = new JButton("Health Check");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AvisoConexion ac = new AvisoConexion();
				ac.setLblNewLabel(services.getEstado());
				ac.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(251, 195, 129, 41);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Establecer conexi\u00F3n:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(240, 172, 160, 13);
		contentPane.add(lblNewLabel_1);
		
	}
}
