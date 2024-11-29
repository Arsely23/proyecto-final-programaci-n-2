public class Authors {

    private String auId;       // ID del autor
    private String auLname;    // Apellido del autor
    private String auFname;    // Nombre del autor
    private String phone;      // Teléfono
    private String address;    // Dirección
    private String city;       // Ciudad
    private String state;      // Estado
    private String zip;        // Código postal
    private boolean contract;  // Contrato (bit)

    // Constructor
    public Authors(String auId, String auLname, String auFname, String phone, String address, String city, String state, String zip, boolean contract) {
        this.auId = auId;
        this.auLname = auLname;
        this.auFname = auFname;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.contract = contract;
    }

    // Getters y Setters
    public String getAuId() {
        return auId;
    }

    public void setAuId(String auId) {
        this.auId = auId;
    }

    public String getAuLname() {
        return auLname;
    }

    public void setAuLname(String auLname) {
        this.auLname = auLname;
    }

    public String getAuFname() {
        return auFname;
    }

    public void setAuFname(String auFname) {
        this.auFname = auFname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public boolean isContract() {
        return contract;
    }

    public void setContract(boolean contract) {
        this.contract = contract;
    }

    // Método toString para mostrar los datos del autor
    @Override
    public String toString() {
        return "Authors [auId=" + auId + ", auLname=" + auLname + ", auFname=" + auFname + ", phone=" + phone + 
                ", address=" + address + ", city=" + city + ", state=" + state + ", zip=" + zip + ", contract=" + contract + "]";
    }
}
