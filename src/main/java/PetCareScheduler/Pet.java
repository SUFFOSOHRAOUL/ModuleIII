package PetCareScheduler;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Pet implements Serializable {
    private String id;
    private String name;
    private String owner;
    private  String breed;
    private int age;
    private String contactInfo;
    private LocalDate registrationDate;
    private List<Appointment> appointmentsList;

    public Pet(String id, String name, String breed, int age, String contactInfo, String owner) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.owner = owner;
        this.age = age;
        this.contactInfo = contactInfo;
        this.registrationDate = LocalDate.now();
        this.appointmentsList = new ArrayList<>() ;
    }


    public void addAppointment(Appointment appointment){
        this.appointmentsList.add(appointment);
    }
    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public List<Appointment> getAppointmentsList() {
        return appointmentsList;
    }

    public void setAppointmentsList(List<Appointment> appointmentsList) {
        this.appointmentsList = appointmentsList;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", Breed='" + breed + '\'' +
                ", age='" + age + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", registrationDate=" + registrationDate +
                ", appointmentsList=" + appointmentsList +
                '}';
    }
}