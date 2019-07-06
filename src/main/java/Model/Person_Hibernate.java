package Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "persons")
public class Person_Hibernate {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "number")
    private long number;

    @Column(name = "address")
    private String address;

    @Column(name = "date")
    private Date date;

    public Person_Hibernate() {
    }

    public Person_Hibernate(int id, String name, long number, String address, String date) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.address = address;
        this.date = getParseDate(date);
    }

    public Person_Hibernate(String name, long number, String address, String date) {
        this.name = name;
        this.number = number;
        this.address = address;
        this.date = getParseDate(date);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDate(String date) {
        this.date = getParseDate(date);
    }

    private Date getParseDate(String date) {
        Date date1 = null;
        try {
            date1 = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return date1;
    }

    @Override
    public String toString() {
        return "Person [Id=" + id + ", Name=" + name + ", Number="
                + number + ", Address=" + address + ", Date=" + date + "]";
    }
}
