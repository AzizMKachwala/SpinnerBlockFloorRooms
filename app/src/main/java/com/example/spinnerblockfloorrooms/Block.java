package com.example.spinnerblockfloorrooms;

import java.util.ArrayList;
import java.util.List;

public class Block {
    String block;
    List<Floor> floors;

    public Block(String block) {
        this.block = block;
        this.floors = new ArrayList<>();
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public void addFloor(Floor floor) {
        floors.add(floor);
    }
}
