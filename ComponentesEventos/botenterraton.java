// Compilacion y ejecución:
// C:\Users\lunas\Documents>javac -cp . botenterraton.java
// C:\Users\lunas\Documents>java -cp . botenterraton

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

// extends JFrame INDICA que Frame es una superclase para la clase botonerraton
// para la cual se implementa los metodos de las interfaces (planillas)
// WindowListener, ActionListener

// CLASE botonenterraton
class botenterraton extends JFrame implements WindowListener, ActionListener, FocusListener, KeyListener {
        JTextField text = new JTextField(20);
        JButton b;
        private int numClicks = 0;
	private int numEnters = 0;

        //FUNCION PRINCIPAL MAIN
        public static void main(String[] args) {
                botenterraton miFrame = new botenterraton("Ejemplo de eventos - Frame JFrame");
                miFrame.setSize(350,100);
                miFrame.setVisible(true);
        }

	//CONSTRUCTOR DE LA CLASE
        public botenterraton(String title) {
                super(title); //INVOCA AL CONSTRUCTOR DE LA SUPERCLASE EN ESTE CASO JFrame y le pasa el string
                setLayout(new FlowLayout()); //setLayout pertenece a Frame y configura la apariencia/despliegue del JFrame
                addWindowListener(this); //agrea un WindowListener al JFrame 
                b = new JButton("Click aqui o TAB o ENTER o ESC"); //Creamos un boton con una leyenda
                add(b);//Lo agregamos el boton al JFrame
                add(text); //Agregamos el campo de texto al JFrame
                b.addFocusListener(this); //Agregamos el FocusListener al boton
                b.addKeyListener(this); //Agregamos el KeyListener al mismo boton, this es la referencia a la instancia
		b.addActionListener(this); //un tercer escucha a este boton para contar el numero de clicks
        }
	
      //Metodos a sobre escribir para la interfaz ActionListener del boton
       public void actionPerformed(ActionEvent e) {
                numClicks++;
                text.setText("Num. Clicks " + numClicks);
        }
       
      //Metodos a sobre escribir para la interfaz FocusListener del boton
	public void focusGained(FocusEvent e) {
         text.setText(e.getComponent().getClass().getSimpleName() + " 1 Gano atencion. ");
      }

        public void focusLost(FocusEvent e) {  //Se activa cuando el boton pierde el foco / atencion del teclado, tab
         text.setText(e.getComponent().getClass().getSimpleName() + " 0 Perdio atentencion. ");
      }
       
      //Metodos a sobre escribir para la interfaz KeyListener del boton
	public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                numEnters++; //incrementamos numero de enters
		text.setText("ENTER presionado " + numEnters + " veces");
                }
                if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
                    System.exit(0);
                }
            }

         public void keyReleased(KeyEvent e){
                //Necesario la inclusion el compilador lo indico
            }
 
        public void keyTyped(KeyEvent e){
                 //Necesario la inclusion el compilador lo indico
            }

       //Metodos a sobre escribir para la interfaz WindowListener

        public void windowClosing(WindowEvent e) {
		System.exit(0);
                dispose();
                   }
        public void windowOpened(WindowEvent e) {
	System.out.println("Ventana abierta");
	}
        public void windowActivated(WindowEvent e) {
        System.out.println("Ventana activada");
        }
        public void windowIconified(WindowEvent e) {
        System.out.println("Ventana con icono");
        }
        public void windowDeiconified(WindowEvent e) {
        System.out.println("Ventana sin iconos"); 
        }
        public void windowDeactivated(WindowEvent e) {
        System.out.println("Ventana desactivada");
        }
        public void windowClosed(WindowEvent e) {
        System.out.println("Ventana cerrada");
        }

}
