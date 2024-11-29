public class Sales {
    private String storId;    // ID de la tienda
    private String ordNum;    // Número de orden
    private String ordDate;   // Fecha de la orden
    private int qty;          // Cantidad
    private String payterms;  // Términos de pago
    private String titleId;   // ID del título

    // Constructor
    public Sales(String storId, String ordNum, String ordDate, int qty, String payterms, String titleId) {
        this.storId = storId;
        this.ordNum = ordNum;
        this.ordDate = ordDate;
        this.qty = qty;
        this.payterms = payterms;
        this.titleId = titleId;
    }

    // Getters y Setters
    public String getStorId() {
        return storId;
    }

    public void setStorId(String storId) {
        this.storId = storId;
    }

    public String getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }

    public String getOrdDate() {
        return ordDate;
    }

    public void setOrdDate(String ordDate) {
        this.ordDate = ordDate;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getPayterms() {
        return payterms;
    }

    public void setPayterms(String payterms) {
        this.payterms = payterms;
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    // Método toString para mostrar la información de la venta
    @Override
    public String toString() {
        return "Sales [storId=" + storId + ", ordNum=" + ordNum + ", ordDate=" + ordDate + ", qty=" + qty 
                + ", payterms=" + payterms + ", titleId=" + titleId + "]";
    }
}
