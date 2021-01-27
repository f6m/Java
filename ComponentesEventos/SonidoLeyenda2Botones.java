
/*
 * SonidoLeyenda2Botones.java crea Frame marco JFrame y agrega dos botones y una leyenda JLabel, cada uno de los dos botones se 
 le agrega un escucha (listener en ingles) el cual cambia la leyenda JLabel y activa un sonido, en windows deben estar activados
 los sonidos y tener bocinas. 

Compilacion y ejecucion: 
$javac SonidoLeyenda2Botones.java
$java SonidoLeyenda2Botones

Convertir el archivo .class derivado de la compilacion al rar
$jar cvf SonidoLeyenda2Botones.jar SonidoLeyenda2Botones.class
added manifest
adding: SonidoLeyenda2Botones.class(in = 2319) (out= 1337)(deflated 42%)

Ejecutar el jar
$java -jar SonidoLeyenda2Botones.jar

 */

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SonidoLeyenda2Botones extends JPanel 
                    implements ActionListener { //ActionListener es una clase abstracta no define el metodo actionPerformed
    JButton boton1,boton2;
    JLabel bienvenida = new JLabel("******************");

    public SonidoLeyenda2Botones() { //constructor de la clase Sonido
        super(new BorderLayout());
        boton1 = new JButton("Click aqui");
        boton1.setPreferredSize(new Dimension(200, 80)); //dimensiones del boton
        add(boton1, BorderLayout.CENTER); //localizacion en el frame en el centro, BorderLayout considera 5 zonas
        boton1.addActionListener(this); //agregamos el escucha al boton
        
        boton2 = new JButton("Otro click aqui");
        boton2.setPreferredSize(new Dimension(200, 80)); //mismas dimensiones del boton
        add(boton2, BorderLayout.EAST); //localizacion en el frame en el centro, BorderLayout considera 5 zonas
        boton2.addActionListener(this); //agregamos el escucha al boton

        bienvenida.setFont(new Font("SansSerif",Font.PLAIN,34)); //cambiamos el tipo de letra 
        bienvenida.setHorizontalAlignment(JLabel.CENTER); //indicamos el alineado de la fuente
        add(bienvenida, BorderLayout.NORTH); //agregamos en la parte norte la bienvenida, es una clase de layouts

    }

    public void actionPerformed(ActionEvent e) { // actionPerformed() es un metodo de ActionListener, del escucha que agregamos al boton
        Toolkit.getDefaultToolkit().beep(); //Toolkit es una clase abstracta que no se puede instanciar, pero getDefaultToolkit obtiee un objeto
        bienvenida.setText("*****BIENVENIDOS A POO2****");
	if (e.getSource()==boton2) {
        bienvenida.setText("***** BUENOS DIAS ****");
		}
    }

    /**
     * Creaa la intefaz grafica gui
     */

    private static void creamuestraGUI() {
        //Create el JFrame
        JFrame frame = new JFrame("Escuchas / listeners y eventos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Crea el componente con los dos botones
        JComponent newContentPane = new SonidoLeyenda2Botones();
        newContentPane.setOpaque(true); //agrega los botones
        frame.setContentPane(newContentPane);

        //Despliega la ventana
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
   creamuestraGUI();
        
    }
}
