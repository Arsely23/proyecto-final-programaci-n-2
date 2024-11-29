public class Store {

    private String storId;      // ID de la tienda
    private String storName;    // Nombre de la tienda
    private String storAddress; // Dirección de la tienda
    private String city;        // Ciudad de la tienda
    private String state;       // Estado de la tienda
    private String zip;         // Código postal

    // Constructor
    public Store(String storId, String storName, String storAddress, String city, String state, String zip) {
        this.storId = storId;
        this.storName = storName;
        this.storAddress = storAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    // Getters y Setters
    public String getStorId() {
        return storId;
    }

    public void setStorId(String storId) {
        this.storId = storId;
    }

    public String getStorName() {
        return storName;
    }

    public void setStorName(String storName) {
        this.storName = storName;
    }

    public String getStorAddress() {
        return storAddress;
    }

    public void setStorAddress(String storAddress) {
        this.storAddress = storAddress;
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    // Método toString para mostrar los datos de la tienda
    @Override
    public String toString() {
        return "Store [storId=" + storId + ", storName=" + storName + ", storAddress=" + storAddress + ", city=" + city + ", state=" + state + ", zip=" + zip + "]";
    }
}
