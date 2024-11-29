public class Noticia {

    private int idNoticia;     // ID de la noticia
    private String titulo;     // Título de la noticia
    private String fecha;      // Fecha de la noticia
    private String noticia;    // Cuerpo de la noticia

    // Constructor8
    public Noticia(int idNoticia, String titulo, String fecha, String noticia) {
        this.idNoticia = idNoticia;
        this.titulo = titulo;
        this.fecha = fecha;
        this.noticia = noticia;
    }

    // Getters y Setters
    public int getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(int idNoticia) {
        this.idNoticia = idNoticia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNoticia() {
        return noticia;
    }

    public void setNoticia(String noticia) {
        this.noticia = noticia;
    }

    // Método toString para mostrar los datos de la noticia
    @Override
    public String toString() {
        return "Noticia [idNoticia=" + idNoticia + ", titulo=" + titulo + ", fecha=" + fecha + ", noticia=" + noticia + "]";
    }
}
