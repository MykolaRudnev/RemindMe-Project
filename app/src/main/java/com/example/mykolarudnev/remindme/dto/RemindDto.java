package com.example.mykolarudnev.remindme.dto;


import java.util.Date;

public class RemindDto {

    private long id;
    private String title;
    private Date remindDate;

    public RemindDto(String title) {
        this.title = title;
    }

    public RemindDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getRemindDate() {
        return remindDate;
    }

    public void setRemindDate(Date remindDate) {
        this.remindDate = remindDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
