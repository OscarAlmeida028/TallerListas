import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Interfaz extends JFrame {

    private JTabbedPane tabbedPane1;
    private JPanel Principal;
    private JButton btnCrear;
    private JTextField textTitulo;
    private JTextField textAnio;
    private JTextField textNumPag;
    private JTextField textEditorial;
    private JButton btnQuemarDatos;
    private JTextArea textAQuemarDatos;
    private JTabbedPane tabbedPane2;
    private JButton btnBuscarNombre;
    private JTextField textBuscarNombre;
    private JTextArea textABuscarNombre;
    private JButton btnBuscarID;
    private JTextField textBuscarID;
    private JTextArea textABuscarID;
    private JButton btnCalcularNumPag;
    private JTextArea textANumPag;
    private JButton btnMostar;
    private JTextArea textAMostrar;
    private JTabbedPane tabbedPane3;
    private JButton btnEliminarID;
    private JTextField textEliminarID;
    private JTextArea textAEliminarID;
    private JButton btnEliminarNombre;
    private JTextField textEliminarNombre;
    private JTextArea textAEliminarNombre;

    Busqueda busqueda = new Busqueda();

    public Interfaz() {
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    busqueda.addLibro(new Libro(textTitulo.getText(), Integer.parseInt(textAnio.getText()), Integer.parseInt(textNumPag.getText()), textEditorial.getText()));
                    limpiar();
                }catch (Exception x){
                    JOptionPane.showMessageDialog(null, "Por favor llene los campos con la información necesaria");
                }
            }
        });
        btnQuemarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ArrayList datosQuemados = busqueda.addPredefinido();
                    textAQuemarDatos.setText(String.valueOf(datosQuemados));
                    btnQuemarDatos.setEnabled(false);
                }catch (Exception x){
                    JOptionPane.showMessageDialog(null, "Por favor llene los campos con la información necesaria");
                }
            }
        });
        btnMostar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ArrayList mostrar = busqueda.mostrarLibros();
                    if(mostrar != null) {
                        textAMostrar.setText(String.valueOf(mostrar));
                    }else{
                        textAMostrar.setText("");
                    }
                }catch (Exception x){
                    JOptionPane.showMessageDialog(null, "Por favor llene los campos con la información necesaria");
                }

            }
        });
        btnBuscarID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String encontrado = busqueda.buscarIDBusquedaBinario(Integer.parseInt(textBuscarID.getText()));
                    textABuscarID.setText(encontrado);
                }catch (Exception x){
                    JOptionPane.showMessageDialog(null, "Por favor llene los campos con la información necesaria");
                }

            }
        });
        btnBuscarNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String encontrado = busqueda.buscarNombreBusquedaSecuencial(textBuscarNombre.getText());
                    textABuscarNombre.setText(encontrado);
                }catch (Exception x){
                    JOptionPane.showMessageDialog(null, "Por favor llene los campos con la información necesaria");
                }
            }
        });
        btnCalcularNumPag.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Long resultado = busqueda.calcularTotalPaginasRecursivo(busqueda.index);
                    textANumPag.setText(String.valueOf(resultado));
                }catch (Exception x){
                JOptionPane.showMessageDialog(null, "Por favor llene los campos con la información necesaria");
            }

            }
        });
        btnEliminarID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                String removido = busqueda.removerLibroID(Integer.parseInt(textEliminarID.getText()));
                textAEliminarID.setText(removido);
                }catch (Exception x){
                    JOptionPane.showMessageDialog(null, "Por favor llene los campos con la información necesaria");
                }
            }
        });
        btnEliminarNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textEliminarNombre.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Por favor llene los campos con la información necesaria");
                }else {
                    String removido = busqueda.removerLibroNombre(textEliminarNombre.getText());
                    textAEliminarNombre.setText(removido);
                }
            }
        });
    }

    public JPanel getPrincipal() {
        return Principal;
    }

    public void limpiar(){
        textTitulo.setText("");
        textAnio.setText("");
        textNumPag.setText("");
        textEditorial.setText("");
    }
}
