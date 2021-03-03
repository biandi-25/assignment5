package com.company.entities;

public class Employee {
    private int id;
    private String name;
    private String surname;
    private String status;
    private String hobby;
    private String level;
    private String dream;
}
    Employee(int id, String name, String surname, String status, String level, String dream, String hobby){
        setId(id);
        setName(name);
        setSurname(surname);
        setStatus(status);
        setLevel(level);
        setDream(dream);
        setHobby(hobby);
    }
    public int getId() {        return id;
    }    public void setId(int id) {        this.id = id;
    }    public String getName() {        return name;
    }    public void setName(String name) {        this.name = name;
    }    public String getSurname() {        return surname;
    }    public void setSurname(String surname) {        this.surname = surname;
    }    public String getStatus() {        return status;
    }    public void setStatus(String status) {        this.status = status;
    }    public String getLevel() {        return level;
    }    public String getDream() {        return dream;
    }    public void setDream(String dream) {        this.dream = dream;
    }    public String getHobby() {        return hobby;
    }    public void setHobby(String hobby) {        this.hobby = hobby;
    }    public void setLevel(String level) {        this.level = level;


        System.out.println("Employee "+ getName()+ getSurname() + " with id "+getId());
        System.out.println("Level: " +getLevel());9
        System.out.println("Status: " +getStatus());
        System.out.println("Dream: " +getDream());
        System.out.println("Hobby: " +getHobby());
    }
    }
}
