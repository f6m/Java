/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad1.pkg1;

/**
 *
 * @author nesly
 */

import javax.swing.*;
import java.awt.event.*;



public class Formulario extends JFrame implements ActionListener {
    
    	JButton boton1;
	//JPanel panel; //Panel

	public Formulario() {
		//setLayout(null);
		setBounds(0,0,350,150);
		boton1=new JButton("Finalizar");
		boton1.setBounds(300,250,100,30);
		//panel = new JPanel();
		//panel.add(boton1);
	//		this.getContentPane().add(panel);
		add(boton1);
		boton1.addActionListener(this); //el this se puede cambiar por new action()
		//Donde action() es una clase que implementa ActionListener
		setVisible(true);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
    
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==boton1) {
			System.exit(0);
		}
	}
    
	public static void main(String[] args) {
		Formulario formulario1=new Formulario();
		//formulario1.setVisible(true);
		//formulario1.show();
	}
}
