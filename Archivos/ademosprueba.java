// JFileChooserTest.java
// Accionar la clase JFileChooserDemo.java

import java.io.IOException;
import javax.swing.JFrame;

public class JFileChooserPrueba{
public static void main(String[] args) throws IOException {
   JFileChooserDemo application = new JFileChooserDemo();
   application.setSize(400, 400); 
   application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   application.setVisible(true); 
} 
}
