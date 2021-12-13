package germany.Vistas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

import germany.Services.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class VentanaAlemania extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnReporteInicial;
	private JButton btnReporteSemanal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAlemania frame = new VentanaAlemania();
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
	public VentanaAlemania() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 851, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnReporteInicial = new JButton("Generar Reporte Inicial");
		btnReporteInicial.setBounds(470, 240, 300, 57);
		btnReporteInicial.addActionListener(this);
		contentPane.add(btnReporteInicial);
		
		
		btnReporteSemanal = new JButton("Generar Reporte Semanal");
		btnReporteSemanal.setBounds(50, 240, 300, 57);
		btnReporteSemanal.addActionListener(this);
		contentPane.add(btnReporteSemanal);
		
		JLabel lbTitulo = new JLabel("ALEMANIA");
		lbTitulo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lbTitulo.setBounds(315, 30, 235, 64);
		contentPane.add(lbTitulo);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Proceso p = new Proceso();
		if(e.getSource()==btnReporteInicial) {
			if(p.rInicial()) {
				JOptionPane.showMessageDialog(this,"Reporte inicial generado correctamente");
			}else {
				JOptionPane.showMessageDialog(this,"Error: Ya se ha generado un reporte inicial anteriormente");
			}
		}
		
		if(e.getSource()==btnReporteSemanal) {
			p.rSemanal();
			JOptionPane.showMessageDialog(this,"Reporte semanal generado correctamente");
		}
	}
	
	
}