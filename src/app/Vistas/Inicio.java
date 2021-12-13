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

public class Inicio extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnAlemania;
	private JButton btnHolanda;
	

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
		
		JLabel lblTituloInicio = new JLabel("Tipo de ER");
		lblTituloInicio.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloInicio.setBounds(247, 48, 208, 46);
		contentPane.add(lblTituloInicio);
		
		btnAlemania = new JButton("Alemania");
		btnAlemania.setBounds(123, 307, 85, 21);
		btnAlemania.addActionListener(this);
		contentPane.add(btnAlemania);
		
		btnHolanda = new JButton("Holanda");
		btnHolanda.setBounds(457, 307, 85, 21);
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
