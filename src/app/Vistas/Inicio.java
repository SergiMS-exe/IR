package app.Vistas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import germany.Vistas.*;
import netherlands.Services.HolandaService;
import netherlands.Vistas.*;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Inicio extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnAlemania;
	private JButton btnHolanda;
	private JPanel panel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(241, 33, 220, 67);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTituloInicio = new JLabel("Tipo de ER");
		lblTituloInicio.setBounds(0, 10, 218, 46);
		panel.add(lblTituloInicio);
		lblTituloInicio.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTituloInicio.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnAlemania = new JButton("Alemania");
		btnAlemania.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAlemania.setBounds(129, 217, 129, 52);
		btnAlemania.addActionListener(this);
		contentPane.add(btnAlemania);
		
		btnHolanda = new JButton("Holanda");
		btnHolanda.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnHolanda.setBounds(449, 217, 122, 52);
		btnHolanda.addActionListener(this);
		contentPane.add(btnHolanda);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnAlemania) {
			this.setVisible(false);
			new VentanaAlemania().setVisible(true);
		}
		
		if(e.getSource()==btnHolanda) {
			this.setVisible(false);
			new VentanaHolanda(new HolandaService()).setVisible(true);
		}
	}
}
