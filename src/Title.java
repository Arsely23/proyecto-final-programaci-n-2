public class Title {

    private String titleId;  // ID del título
    private String title;    // Nombre del libro
    private String type;     // Tipo de libro
    private String pubId;    // ID del publicador
    private double price;    // Precio del libro
    private double advance;  // Anticipo
    private int royalty;     // Regalías
    private int ytdSales;    // Ventas del libro hasta la fecha
    private String notes;    // Notas adicionales
    private String pubdate;  // Fecha de publicación

    // Constructor
    public Title(String titleId, String title, String type, String pubId, double price, double advance, 
                 int royalty, int ytdSales, String notes, String pubdate) {
        this.titleId = titleId;
        this.title = title;
        this.type = type;
        this.pubId = pubId;
        this.price = price;
        this.advance = advance;
        this.royalty = royalty;
        this.ytdSales = ytdSales;
        this.notes = notes;
        this.pubdate = pubdate;
    }

    // Getters y Setters
    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPubId() {
        return pubId;
    }

    public void setPubId(String pubId) {
        this.pubId = pubId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAdvance() {
        return advance;
    }

    public void setAdvance(double advance) {
        this.advance = advance;
    }

    public int getRoyalty() {
        return royalty;
    }

    public void setRoyalty(int royalty) {
        this.royalty = royalty;
    }

    public int getYtdSales() {
        return ytdSales;
    }

    public void setYtdSales(int ytdSales) {
        this.ytdSales = ytdSales;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    // Método toString para mostrar los datos del título
    @Override
    public String toString() {
        return "Title [titleId=" + titleId + ", title=" + title + ", type=" + type + ", pubId=" + pubId 
            + ", price=" + price + ", advance=" + advance + ", royalty=" + royalty + ", ytdSales=" + ytdSales 
            + ", notes=" + notes + ", pubdate=" + pubdate + "]";
    }
}
