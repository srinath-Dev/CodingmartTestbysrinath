package com.srinathdev.codemartsrinath;

public class TimeSheet {

    private String task,des,hours,date;

    public TimeSheet() {
    }

    public TimeSheet(String task, String des, String hours, String date) {
        this.task = task;
        this.des = des;
        this.hours = hours;
        this.date = date;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
