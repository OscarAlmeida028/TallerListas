import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Busqueda {
    int index = 0;
    ArrayList<Libro> libros = new ArrayList<>();

    public  ArrayList<Libro> addPredefinido(){
        ArrayList<Libro> datosQuemados = new ArrayList<>();
        Libro libro1 = new Libro("Los hechiCeros", 2018,200, "Maravilla");
        datosQuemados.add(libro1);

        Libro libro2 = new Libro("La casa",2004,282,  "Estrella");
        datosQuemados.add(libro2);

        Libro libro3 = new Libro("Los amigos",2006,312,  "Estelar");
        datosQuemados.add(libro3);

        Libro libro4 = new Libro("Vinland",2013 ,457, "ChavezWalter");
        datosQuemados.add(libro4);

        libros.addAll(datosQuemados);
        return datosQuemados;
    }
    public void addLibro(Libro libro){
        for (Libro l : libros) {
            if (libro.getNombreLibro().equals(l.getNombreLibro())){
                JOptionPane.showMessageDialog(null, "Ya existe un libro con ese nombre");
                return;
            }
        }
        libros.add(libro);
        JOptionPane.showMessageDialog(null, "El libro se ha agregado con éxito");
    }

    public String removerLibroID(int ID){
        String libroRemovido ="";
        Libro l;
        for (int i=0;i<libros.size();i++) {
            l=libros.get(i);
            if(l.getID()== ID){
                libros.remove(i);
                libroRemovido = l.toString();
                JOptionPane.showMessageDialog(null, "El libro se ha eliminado con éxito");
                return libroRemovido;
            }
        }
        JOptionPane.showMessageDialog(null, "No se puedo eliminar el libro, ya que no existe");
        return null;
    }

    public String removerLibroNombre(String nombreLibro){
        String libroRemovido ="";
        Libro libro1;
        for (int i=0;i<libros.size();i++) {
            libro1=libros.get(i);
            if(libro1.getNombreLibro().equals(nombreLibro)){
                libroRemovido = libro1.toString();
                libros.remove(i);
                JOptionPane.showMessageDialog(null, "El libro se ha eliminado con éxito");
                return libroRemovido;
            }
        }
        JOptionPane.showMessageDialog(null, "No se puedo eliminar el libro, ya que no existe");
        return null;
    }

    public String buscarNombreBusquedaSecuencial(String nombreLibro) {
        String libroEncontrado = "";
        for (Libro libro : libros) {
            if (libro.getNombreLibro().equals(nombreLibro)) {
                JOptionPane.showMessageDialog(null, "Se ha encontrado el libro");
                libroEncontrado = libro.toString();
                return libroEncontrado;
            }
        }
        JOptionPane.showMessageDialog(null, "El libro no se ha encontrado");
        return null;  // Si no se encuentra el libro, se devuelve null
    }

    private int buscarIndicePorNombre(String nombreLibro) {
        for (int i = 0; i < libros.size(); i++) {
            Libro libro = libros.get(i);
            if (libro.getNombreLibro().equals(nombreLibro)) {
                return i;
            }
        }
        return -1;  // Si no se encuentra el libro, se devuelve -1
    }

    public String buscarIDBusquedaBinario( int ID){
        ordenarLibros();
        String libroEncontrado = "";
        int inicio = 0;
        int fin = libros.size() - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            Libro libroMedio = libros.get(medio);

            if (libroMedio.getID() == ID) {
                libroEncontrado = libroMedio.toString();
                JOptionPane.showMessageDialog(null, "Se ha encontrado el libro");
                return libroEncontrado;  // Se encontró el libro
            } else if (libroMedio.getID() < ID) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        JOptionPane.showMessageDialog(null, "El libro no se ha encontrado");
        return null;
    }

    public void ordenarLibros(){
        Collections.sort(libros, new Comparator<Libro>() {
            @Override
            public int compare(Libro libro1, Libro libro2) {
                return Integer.compare(libro1.getID(), libro2.getID());
            }
        });
    }


    public long calcularTotalPaginasRecursivo(int index) {
        if (index >= libros.size()) {
            return 0;
        }
        Libro libro = libros.get(index);
        long paginasActuales = libro.getNumPag();
        long paginasRestantes = calcularTotalPaginasRecursivo(index + 1);

        return paginasActuales + paginasRestantes;
    }

    public ArrayList<Libro> mostrarLibros() {
        if (!libros.isEmpty()) {
            return libros;
        } else {
            JOptionPane.showMessageDialog(null, "No hay libros para mostrar");
            return null;
        }
    }
}
