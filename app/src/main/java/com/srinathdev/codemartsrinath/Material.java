package com.srinathdev.codemartsrinath;

public class Material {

    private String clientname,des,modules,name,time;

    public Material() {
    }

    public Material(String clientname, String des, String modules, String name, String time) {
        this.clientname = clientname;
        this.des = des;
        this.modules = modules;
        this.name = name;
        this.time = time;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getModules() {
        return modules;
    }

    public void setModules(String modules) {
        this.modules = modules;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
