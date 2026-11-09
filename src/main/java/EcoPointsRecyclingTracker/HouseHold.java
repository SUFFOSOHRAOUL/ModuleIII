package EcoPointsRecyclingTracker;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HouseHold implements Serializable {
    private String id;
    private String name;
    private String address;
    private LocalDate joinDate;
    private List<RecyclingEvent> events;
    private double totalPoint;

    public HouseHold(String id, String name, String address, LocalDate joinDate, List<RecyclingEvent> events, double totalPoint) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.joinDate = LocalDate.now();
        this.events = new ArrayList<>();
        this.totalPoint = 0.0;
    }

    public void addEvent(RecyclingEvent event){
       this.events.add(event);
       this.totalPoint =+ event.getEcoPoints();
    }
    public double getTotalWeigh(){
        double total = 0.0;
        for( RecyclingEvent event:events){
            total=+ event.getWeight();
        }

       return total;
    }
}