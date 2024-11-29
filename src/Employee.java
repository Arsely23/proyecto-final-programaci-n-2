public class Employee {

    private String empId;     // ID del empleado
    private String fname;     // Primer nombre
    private String minit;     // Inicial
    private String lname;     // Apellido
    private int jobId;        // ID del trabajo
    private int jobLvl;       // Nivel del trabajo
    private String pubId;     // ID del publicador
    private String hireDate;  // Fecha de contratación

    // Constructor
    public Employee(String empId, String fname, String minit, String lname, int jobId, int jobLvl, String pubId, String hireDate) {
        this.empId = empId;
        this.fname = fname;
        this.minit = minit;
        this.lname = lname;
        this.jobId = jobId;
        this.jobLvl = jobLvl;
        this.pubId = pubId;
        this.hireDate = hireDate;
    }

    // Getters y Setters
    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMinit() {
        return minit;
    }

    public void setMinit(String minit) {
        this.minit = minit;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getJobLvl() {
        return jobLvl;
    }

    public void setJobLvl(int jobLvl) {
        this.jobLvl = jobLvl;
    }

    public String getPubId() {
        return pubId;
    }

    public void setPubId(String pubId) {
        this.pubId = pubId;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    // Método toString para mostrar los datos del empleado
    @Override
    public String toString() {
        return "Employee [empId=" + empId + ", fname=" + fname + ", minit=" + minit + ", lname=" + lname + ", jobId=" + jobId 
                + ", jobLvl=" + jobLvl + ", pubId=" + pubId + ", hireDate=" + hireDate + "]";
    }
}
