package FinalProject;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Mood {
    private String name;
    private LocalDate date;
    private LocalTime time;
    private String notes;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Mood mood = (Mood) o;
        return Objects.equals(name, mood.name) && Objects.equals(date, mood.date) && Objects.equals(time, mood.time) && Objects.equals(notes, mood.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, date, time, notes);
    }

    public Mood(String name, LocalDate date, LocalTime time, String notes) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return "Mood{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", notes='" + notes + '\'' +
                '}';
    }
}