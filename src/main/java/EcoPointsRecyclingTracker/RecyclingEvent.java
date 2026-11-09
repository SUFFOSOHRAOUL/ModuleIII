package EcoPointsRecyclingTracker;

import java.io.Serializable;
import java.time.LocalDate;


public class RecyclingEvent implements Serializable {
    private String Materialtype;
    private double weight;
    private LocalDate date;
    private double ecoPoints;

    public RecyclingEvent(String materialtype, double weight) {
        Materialtype = materialtype;
        this.weight = weight;
        this.date = date.now();
        this.ecoPoints = weight*10;
    }

    public String getMaterialtype() {
        return Materialtype;
    }

    public void setMaterialtype(String materialtype) {
        Materialtype = materialtype;
    }

    public double getEcoPoints() {
        return ecoPoints;
    }

    public void setEcoPoints(double ecoPoints) {
        this.ecoPoints = ecoPoints;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        date = date;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "RecyclingEvent{" +
                "Materialtype='" + Materialtype + '\'' +
                ", weight=" + weight +
                ", Date=" + date +
                ", ecoPoints=" + ecoPoints +
                '}';
    }
}