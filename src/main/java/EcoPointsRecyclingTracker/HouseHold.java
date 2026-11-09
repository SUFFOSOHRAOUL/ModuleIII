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

    public HouseHold(String id, String name, String address) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<RecyclingEvent> getEvents() {
        return events;
    }

    public void setEvents(List<RecyclingEvent> events) {
        this.events = events;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(double totalPoint) {
        this.totalPoint = totalPoint;
    }
}