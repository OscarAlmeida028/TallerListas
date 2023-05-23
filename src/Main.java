import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
        interfaz.setContentPane(interfaz.getPrincipal());
        interfaz.setVisible(true);
        interfaz.setTitle("Bibliteca Oscar Almeida, Diego Toscano");
        interfaz.setBounds(100,100,600,600);
        interfaz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}