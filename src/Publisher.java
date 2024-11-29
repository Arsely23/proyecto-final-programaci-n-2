public class Publisher {

    private String pubId;      // ID del publicador
    private String pubName;    // Nombre del publicador
    private String city;       // Ciudad
    private String state;      // Estado
    private String country;    // País

    // Constructor
    public Publisher(String pubId, String pubName, String city, String state, String country) {
        this.pubId = pubId;
        this.pubName = pubName;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    // Getters y Setters
    public String getPubId() {
        return pubId;
    }

    public void setPubId(String pubId) {
        this.pubId = pubId;
    }

    public String getPubName() {
        return pubName;
    }

    public void setPubName(String pubName) {
        this.pubName = pubName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    // Método toString para mostrar los datos del publicador
    @Override
    public String toString() {
        return "Publisher [pubId=" + pubId + ", pubName=" + pubName + ", city=" + city + ", state=" + state + ", country=" + country + "]";
    }
}
