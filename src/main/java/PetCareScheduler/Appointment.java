package PetCareScheduler;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment implements Serializable {
private String appointmentType;
private String date;
private String time;
private String notes;
    public Appointment(String appointmentType, String time, String date) {
        this.appointmentType = appointmentType;
        this.time = time;
        this.date = date;
    }

    public Appointment(String appointmentType,  String time, String date ,String notes) {
        this.appointmentType = appointmentType;

        this.time = time;
        this.date = date;
        this.notes = notes;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentType='" + appointmentType + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", notes='" + notes + '\'' +
                '}';
    }
}