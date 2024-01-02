package com.example.spinnerblockfloorrooms;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    String floor;
    List<Room> rooms;

    public Floor(String floor) {
        this.floor = floor;
        this.rooms = new ArrayList<>();
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }
}
