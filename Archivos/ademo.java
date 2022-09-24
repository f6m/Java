// JFileChooserDemo.java
// Control JFileChooser de Swing para archivos - demo

//librerias io / nio (io=ImputOutput nio=NewImputOutput
import java.io.IOException; //Manejo de excepciones de E/S
import java.nio.file.DirectoryStream;
import java.nio.file.Files; //Informacion del archivo
import java.nio.file.Path;
import java.nio.file.Paths;

//libreria swing
import javax.swing.JFileChooser; //Control JFileChooser
import javax.swing.JFrame; //Componente grafico JFrame marco principal
import javax.swing.JOptionPane; //Componente grafico JOptionPane para mostrar en el JFrame
import javax.swing.JScrollPane; //Componente Scroll
import javax.swing.JTextArea; //Componente Area de texto

public class JFileChooserDemo extends JFrame
{

private final JTextArea outputArea; // Area para desplegar el contenido de los archivos

// Creamos la GUI en el constructor
public JFileChooserDemo() throws IOException
{
 super("Control de archivos JFileChooser Demo"); //Nombre del JFrame
 outputArea = new JTextArea(); //Memoria para el area de texto
 add(new JScrollPane(outputArea)); //Agrega el control deslizante y lo agrega a frame

 analyzePath(); // get Path from user and display info
} 

// display information about file or directory user specifies 

public void analyzePath() throws IOException{
     // Obtiene el archvo o directorio seleccionado por el usuario
     Path path = getFileOrDirectoryPath(); //Declara objeto path

     // Revisamos si existe y desplegamos la informacion
     if (path != null && Files.exists(path)) 
     { 
       // Objeto constructor de cadenas (StringBuilder)
        StringBuilder builder = new StringBuilder();
 
        builder.append(String.format("%s:%n", path.getFileName()));
        builder.append(String.format("%s a directory%n", Files.isDirectory(path) ? "Is" : "Is not"));
        builder.append(String.format("%s an absolute path%n", path.isAbsolute() ? "Is" : "Is not"));
        builder.append(String.format("Last modified: %s%n", Files.getLastModifiedTime(path)));
        builder.append(String.format("Size: %s%n", Files.size(path)));
        builder.append(String.format("Path: %s%n", path));
        builder.append(String.format("Absolute path: %s%n", path.toAbsolutePath()));
     
     // Si es un directorio, "decider" isDirectory
     if (Files.isDirectory(path)) 
         {
            
         builder.append(String.format("%nContenido del directorio:%n"));
         // Objeto para iterar dentro del directorio
         DirectoryStream<Path> directoryStream =  Files.newDirectoryStream(path);
             for (Path p : directoryStream)
               builder.append(String.format("%s%n", p));
         }
         outputArea.setText(builder.toString()); // display String content
     } //Fin if path!=null
     else {
         JOptionPane.showMessageDialog(this, path.getFileName() + " no existe.", "ERROR", JOptionPane.ERROR_MESSAGE);
      }   
   } // end method analyzePath

// Metodo para permitir al usuario especificar el nombre de archivo o directorio

private Path getFileOrDirectoryPath()
   {
  // configure dialog allowing selection of a file or directory
JFileChooser fileChooser = new JFileChooser();
fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
int result = fileChooser.showOpenDialog(this);    

// if user clicked Cancel button on dialog, return
if (result == JFileChooser.CANCEL_OPTION)
         System.exit(1);

// return Path representing the selected file
return fileChooser.getSelectedFile().toPath();
}
} //Fin clase JFileChooser
