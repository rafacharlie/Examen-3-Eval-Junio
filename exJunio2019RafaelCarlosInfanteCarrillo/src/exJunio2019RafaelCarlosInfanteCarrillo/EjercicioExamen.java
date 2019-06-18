/**Escribe un programa en Java usando su interfaz gráfica capaz de quitar los comentarios de un programa
de Java.
@author Rafael Infante
*/
package exJunio2019RafaelCarlosInfanteCarrillo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class EjercicioExamen {

  private JFrame frame;
  private JTextField textField;
  private JTextField textField_1;
  protected File ficheroOrigen; // variable
  protected File ficheroDestino; // variable
  protected JTextArea textArea;

  static String argumento1 = ""; // variable
  static String argumento2 = ""; // variable

  /**
   * Launch the application.
   */
  public static void main(String[] args) {

    // codigo
    if (args.length > 2) { // el lenght no cuenta el 0
      JOptionPane.showMessageDialog(null, "Numero de parametros incorrecto.");
      System.exit(0);
    }

    if (args.length == 1) {
      guardaArgumentos(args[0], true);
    }
    if (args.length == 2) {
      guardaArgumentos(args[0], true);
      guardaArgumentos(args[1], false);
    }

    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          EjercicioExamen window = new EjercicioExamen();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  // codigo
  /**
   * almacena los parametros introducidos por linea de comandos.
   * 
   * @param argumento
   * @param b
   */
  private static void guardaArgumentos(String argumento, boolean b) {
    if (b) {
      argumento1 = argumento;
    } else {
      argumento2 = argumento;
    }

  }

  /**
   * Create the application.
   */
  public EjercicioExamen() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setResizable(false);
    /* codigo para que salga mi nombre como titulo del programa */
    try {
      BufferedReader tituloEscribir = new BufferedReader(new FileReader("autor.txt"));
      String lineaTitulo;
      lineaTitulo = tituloEscribir.readLine();
      frame.setTitle(lineaTitulo);
      tituloEscribir.close();
    } catch (IOException ex) {
      JOptionPane.showMessageDialog(null, "No se encontro el fichero con el titulo");
      System.exit(0); // si no se encuentra el fichero termina el programa
    }
    /*-------------------------------------------------------------------------------------*/

    frame.setBounds(100, 100, 541, 437);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);

    JLabel lblNewLabel = new JLabel("Selecciona fichero origen");
    lblNewLabel.setBounds(10, 25, 156, 14);
    frame.getContentPane().add(lblNewLabel);

    JLabel lblFechaDestino = new JLabel("Selecciona fecha destino");
    lblFechaDestino.setBounds(10, 73, 123, 14);
    frame.getContentPane().add(lblFechaDestino);

    textField = new JTextField();
    textField.setEditable(false);
    textField.setBounds(10, 42, 385, 20);
    frame.getContentPane().add(textField);
    textField.setColumns(10);
    // codigo
    textField.setText(argumento1);
    if (argumento1 != "") {

      try {
        BufferedReader argument1 = new BufferedReader(new FileReader(argumento1));
        argument1.close();
      } catch (FileNotFoundException e) {
        JOptionPane.showMessageDialog(null, "Fichero no encontrado");
        System.exit(0);
      } catch (IOException e1) {
        JOptionPane.showMessageDialog(null, "Error de lectura");
        System.exit(0);
      }

    }

    textField_1 = new JTextField();
    textField_1.setEditable(false);
    textField_1.setBounds(10, 98, 385, 20);
    frame.getContentPane().add(textField_1);
    textField_1.setColumns(10);
    
    // codigo
    textField_1.setText(argumento2);
    
    if (argumento2 != "") {

      try {
        BufferedReader argument2 = new BufferedReader(new FileReader(argumento2));
        argument2.close();
      } catch (FileNotFoundException e) {
        JOptionPane.showMessageDialog(null, "Fichero no encontrado");
        System.exit(0);
      } catch (IOException e1) {
        JOptionPane.showMessageDialog(null, "Error de lectura");
        System.exit(0);
      }

    }
    /********************************************************
     * boton fichero origen
     *************************************************************/
    JButton btnNewButton = new JButton(" Fichero origen");
    // codigo
    if (argumento1 == "") {
      btnNewButton.setEnabled(true);
    } else {
      btnNewButton.setEnabled(false);
    }
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        /* codigo */
        /* filechooser fichero origen */
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(frame);

        if (seleccion == JFileChooser.APPROVE_OPTION) {

          ficheroOrigen = fileChooser.getSelectedFile();
          // ponemos la ruta en el textfield origen
          textField.setText(ficheroOrigen.getAbsolutePath());
        }

      }
    });
    btnNewButton.setBounds(405, 41, 108, 23);
    frame.getContentPane().add(btnNewButton);
    /********************************************************
     * fin boton fichero origen
     *************************************************************/

    /********************************************************
     * boton fichero destino
     *************************************************************/
    JButton btnNewButton_1 = new JButton("Fichero Destino");
    // codigo
    if (argumento2 == "") {
      btnNewButton_1.setEnabled(true);
    } else {
      btnNewButton_1.setEnabled(false);
    }

    btnNewButton_1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        /* codigo */
        /* filechooser fichero destino */
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(frame);

        if (seleccion == JFileChooser.APPROVE_OPTION) {

          ficheroDestino = fileChooser.getSelectedFile();
          // ponemos la ruta en el textfield destino
          textField_1.setText(ficheroDestino.getAbsolutePath());
        }
      }
    });
    btnNewButton_1.setBounds(405, 97, 108, 23);
    frame.getContentPane().add(btnNewButton_1);

    /********************************************************
     * fin boton fichero destino
     *************************************************************/

    JLabel lblProgramaPrincipal = new JLabel("Programa Original");
    lblProgramaPrincipal.setBounds(58, 139, 95, 14);
    frame.getContentPane().add(lblProgramaPrincipal);

    JLabel lblProgramaSinComentarios = new JLabel("Programa sin comentarios");
    lblProgramaSinComentarios.setBounds(332, 139, 128, 14);
    frame.getContentPane().add(lblProgramaSinComentarios);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(10, 164, 226, 184);
    frame.getContentPane().add(scrollPane);

    JTextArea textArea = new JTextArea();
    scrollPane.setViewportView(textArea);

    JScrollPane scrollPane_1 = new JScrollPane();
    scrollPane_1.setBounds(278, 164, 235, 184);
    frame.getContentPane().add(scrollPane_1);

    JTextArea textArea_1 = new JTextArea();
    scrollPane_1.setViewportView(textArea_1);

    /********************************************************
     * boton Quitar comentarios
     *************************************************************/
    JButton btnNewButton_2 = new JButton("Quitar comentarios");
    btnNewButton_2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // mi codigo de programa

        try {
          FileReader leer = new FileReader(textField.getText());
          FileWriter escribir = new FileWriter(textField_1.getText());

          BufferedReader br = new BufferedReader(leer);
          BufferedWriter bw = new BufferedWriter(escribir);

          String linea = "";
          String resultado = "";
          String resultado_1 = "";
          boolean comprueba = false;
          boolean cLinea = false;

          while (linea != null) {
            linea = br.readLine();

            if (linea != null) {
              cLinea = true;
              resultado += linea + "\n"; // escribe linea a linea en esta variable
              if (linea.contains("//")) {
                linea = "";
                cLinea = false;
              }
              if (linea.contains("/*")) {
                linea = "";
                comprueba = true;
              }

              if (linea.contains("/**")) {
                linea = "";
                comprueba = true;
              }

              if (linea.contains("*/")) {
                linea = "";
                comprueba = false;

              } else {
                if (cLinea != false && comprueba == false ) {
                  resultado_1 += linea + "\n"; // escribe linea a linea en esta variable
                  bw.write(linea); // escribe en el fichero
                  bw.newLine(); // hace un salto de linea a la hora de escribir en el fichero
                } else {
                  linea = "";
                }
              }

            }
          }

          textArea.append(resultado);
          textArea_1.append(resultado_1);

          br.close();
          bw.close();

          JOptionPane.showMessageDialog(null, "Programa finalizado con exito");

        } catch (IOException | NullPointerException ie) {
          JOptionPane.showMessageDialog(null, "No se encontro el archivo o no se ha especificado una ruta.");

        }
      }

    });
    btnNewButton_2.setBounds(113, 359, 123, 23);
    frame.getContentPane().add(btnNewButton_2);
    /********************************************************
     * fin boton Quitar comentarios
     *************************************************************/

    /********************************************************
     * boton terminar
     *************************************************************/
    JButton btnNewButton_3 = new JButton("Terminar");
    btnNewButton_3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        /* codigo */
        System.exit(0);
      }
    });
    btnNewButton_3.setBounds(278, 359, 89, 23);
    frame.getContentPane().add(btnNewButton_3);

    /********************************************************
     * fin boton terminar
     *************************************************************/
  }
}
