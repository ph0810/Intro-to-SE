package Model;

import java.util.Date;

public class VoluntaryEvent {
    private int id;
    private String name;
    private String note;
    private Date date1;
    private Date date2;

    public VoluntaryEvent(int id, String name, int money, String note, Date date1, Date date2) {
        this.id = id;
        this.name = name;
        this.note = note;
        this.date1 = date1;
        this.date2 = date2;
    }

    public VoluntaryEvent() {
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }
}
