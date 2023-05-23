public class Libro{
    private int ID, anioLibro;
    private  long numPag;
    private String nombreLibro, editorial;

    private int cont = 0;

    public Libro(String nombreLibro, int anioLibro, long numPag, String editorial) {
        this.ID = generarIdUnico();
        this.numPag = numPag;
        this.anioLibro = anioLibro;
        this.nombreLibro = nombreLibro;
        this.editorial = editorial;
    }

    private int generarIdUnico() {
        cont++;
        return cont;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public int getID() {
        return ID;
    }

    public long getNumPag() {
        return numPag;
    }

    @Override
    public String toString() {
        return "\n\nInformación del libro:"+
                "\nID: " + ID+
                "\nTítulo:" + nombreLibro+
                "\nAño de publicación: " + anioLibro +
                "\nNúmero de páginas: " + numPag +
                "\nEditorial: " + editorial;
    }
}
