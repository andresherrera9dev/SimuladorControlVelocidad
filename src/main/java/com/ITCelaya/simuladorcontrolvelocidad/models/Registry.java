package com.ITCelaya.simuladorcontrolvelocidad.models;

public class Registry {
    int id;
    int usernameId;
    double speed;
    int points;

    public Registry(int id, int usernameId, double speed, int points) {
        this.id = id;
        this.usernameId = usernameId;
        this.speed = speed;
        this.points = points;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsernameId() {
        return usernameId;
    }

    public void setUsernameId(int usernameId) {
        this.usernameId = usernameId;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
