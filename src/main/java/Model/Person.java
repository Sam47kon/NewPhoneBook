package Model;

import java.util.Date;

public class Person {
    private int id;
    private String name;
    private long number;
    private String address;
    private Date date;

    public Person() {
    }

    public Person(int id, String name, long number, String address, String date) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.address = address;
        this.date = getParseDate(date);
    }

    public Person(String name, long number, String address, String date) {
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
