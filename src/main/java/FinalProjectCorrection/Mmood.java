package FinalProjectCorrection;

import FinalProject.Mood;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Mmood {
    private String name;
    private LocalDate date = LocalDate.now();
    private LocalTime  time =LocalTime.MIDNIGHT;
    private String note;

    public Mmood(String name, LocalDate date, LocalTime time, String note) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.note = note;
    }

    public Mmood(String name, LocalDate date, String note) {
        this.name = name;
        this.date = date;
        this.note = note;
    }

    public Mmood(String name, String note) {
        this.name = name;
        this.note = note;
    }

    public Mmood(String name, LocalDate date, LocalTime time) {
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public Mmood(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    public Mmood(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean equals(Mmood mood) {
        if(mood.name.equalsIgnoreCase(this.name) &&
                mood.getDate().equals(this.date) &&
                mood.getTime().equals(this.time)) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public String toString() {
        return "Mmood{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", note='" + note + '\'' +
                '}';
    }
}