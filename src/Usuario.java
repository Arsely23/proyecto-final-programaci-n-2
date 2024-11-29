public class Usuario {

    private int id;           // ID del usuario
    private String usuario;   // Nombre de usuario
    private String password;  // Contraseña
    private int nivel;        // Nivel de acceso

    // Constructor
    public Usuario(int id, String usuario, String password, int nivel) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.nivel = nivel;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    // Método toString para mostrar los datos del usuario
    @Override
    public String toString() {
        return "Usuario [id=" + id + ", usuario=" + usuario + ", password=" + password + ", nivel=" + nivel + "]";
    }
}
