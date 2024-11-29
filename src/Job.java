public class Job {

    private int jobId;        // ID del trabajo
    private String jobDesc;   // Descripción del trabajo
    private int minLvl;       // Nivel mínimo
    private int maxLvl;       // Nivel máximo

    // Constructor
    public Job(int jobId, String jobDesc, int minLvl, int maxLvl) {
        this.jobId = jobId;
        this.jobDesc = jobDesc;
        this.minLvl = minLvl;
        this.maxLvl = maxLvl;
    }

    // Getters y Setters
    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public int getMinLvl() {
        return minLvl;
    }

    public void setMinLvl(int minLvl) {
        this.minLvl = minLvl;
    }

    public int getMaxLvl() {
        return maxLvl;
    }

    public void setMaxLvl(int maxLvl) {
        this.maxLvl = maxLvl;
    }

    // Método toString para mostrar los datos del trabajo
    @Override
    public String toString() {
        return "Job [jobId=" + jobId + ", jobDesc=" + jobDesc + ", minLvl=" + minLvl + ", maxLvl=" + maxLvl + "]";
    }
}
