package Conversor_Temperatura;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ConversorTemperatura {
	
	public static void main (String[] args) {
		
		MarcoConversor miMarco=new MarcoConversor();
		
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		miMarco.setVisible(true);
				
	}

}

class MarcoConversor extends JFrame{
	
	public MarcoConversor() {
		
		this.setTitle("Conversor de Temperatura");
		
		setVisible(true);
		
		setBounds(550, 300, 500, 300);
		
		LaminaConversor miLamina=new LaminaConversor();
		
		add(miLamina);
		
	}
	
}

class LaminaConversor extends JPanel{
	
	public LaminaConversor() {
		
		setLayout(new BorderLayout());
		
		mensaje=new JLabel("Bienvenido al conversor de temperatura. Por favor ingrese la temperatura"
				+ " seguido del º. A su vez, indique luego una C o F tratando de grados Celcius o Fahrenheit", SwingConstants.CENTER);
		
		mensaje.setFont(new Font("Serif", Font.PLAIN, 20));
				
		add(mensaje, BorderLayout.NORTH);
		
		JPanel miLamina2=new JPanel(); 
		
		miLamina2.setLayout(new FlowLayout());
		
		JLabel texto1=new JLabel("Temperatura: ");
		
		miLamina2.add(texto1);
		
		campo1=new JTextField(20);
		
		miLamina2.add(campo1);
		
		JButton miBoton=new JButton("Convertir");
		
		DameTexto miEvento=new DameTexto();
		
		miBoton.addActionListener(miEvento);
		
		miLamina2.add(miBoton);
		
		add(miLamina2, BorderLayout.CENTER);
		
		resultado=new JLabel("");
		
		resultado.setFont(new Font("Serif", Font.PLAIN, 20));
				
		add(resultado,BorderLayout.SOUTH);
		
		
		
	}
	
	public class DameTexto implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			int correcto=0;
			
			boolean celcius=false;
			
			int fintemp=0;
			
			String temperatura=campo1.getText().trim();
			
			for(int i=0; i<temperatura.length(); i++) {
				
				if(temperatura.charAt(i)=='º') {
					
					correcto++; 
					fintemp=i;
				}
				else if(temperatura.charAt(i)=='C') {
					
					celcius=true; 
				}
			
				
			}
					
			
			if(correcto==0) {
				
				resultado.setText("Error en el dato ingresado, por favor revisar la estructura");
			}
			else {
				
				double valorTemperatura= Double.parseDouble(temperatura.substring(0, fintemp));
				
				resultadoConversion=conversor(valorTemperatura,celcius);
				
				double roundrdo=Math.round(resultadoConversion*100.0)/100.0;
				
				if(celcius==true) {
					
					resultado.setText("El resultado de la conversion es: " + roundrdo + " ºF");
				}
				else {
					resultado.setText("El resultado de la conversion es: " + roundrdo + " ºC");
				}
			}
			
			
		}
		
		public double conversor(double temperatura, boolean medicion) {
		
		 double conversion;
			
			if(medicion==true) {
				
				conversion=(temperatura * 9/5) + 32; 
			}
			else {
				conversion=(temperatura -32) * 5/9;
			}
			
			return conversion;
		}
		
		
	}
	
	private double resultadoConversion;
	
	private JLabel mensaje;
	
	private JTextField campo1;
	
	private JLabel resultado;
	
}
