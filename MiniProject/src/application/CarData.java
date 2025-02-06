package application;


public class CarData {
    private String vin;
    private int year;
    private String make;
    private String model;
    private int mileage;
    private double price;
    private String damageReport;
    private String repairReport;
    private String serviceReport;

    // Constructor
    public CarData(String vin, int year, String make, String model, int mileage, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.price = price;
        this.damageReport = "";
        this.repairReport = "";
        this.serviceReport = "";
    }

    // Getters and setters 
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDamageReport() {
        return damageReport;
    }

    public void setDamageReport(String damageReport) {
        this.damageReport = damageReport;
    }

    public String getRepairReport() {
        return repairReport;
    }

    public void setRepairReport(String repairReport) {
        this.repairReport = repairReport;
    }

    public String getServiceReport() {
        return serviceReport;
    }

    public void setServiceReport(String serviceReport) {
        this.serviceReport = serviceReport;
    }

    // Override toString() for easy printing of car information
    @Override
    public String toString() {
        return  "\n VIN: "+getVin()+"\n"+
		        "Year: "+getYear()+"\n"+
		        "Make: "+getMake()+"\n"+
		        "Model: "+getModel()+"\n"+
		        "Mileage: "+getMileage()+"KM"+"\n"+
		        "Price: R"+getPrice()+"\n"+
		        "Damage Report: "+getDamageReport()+"\n"+
		        "Repair Report: "+getRepairReport()+"\n"+
		        "Service Report: "+getServiceReport()+"\n";
    }
}
