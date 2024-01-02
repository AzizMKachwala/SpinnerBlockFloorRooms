package com.example.spinnerblockfloorrooms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    AppCompatSpinner blockSpinner;
    RecyclerView floorRecyclerView;
    FloorAdapter floorAdapter;
    List<Block> blockList;
    String[] blockValues = {"Select Block", "A", "B", "C", "D"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blockSpinner = findViewById(R.id.blockSpinner);
        floorRecyclerView = findViewById(R.id.floorRecyclerView);

        initializeBlockSpinner();

        floorRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        blockList = generateBlockData();
        floorAdapter = new FloorAdapter(this, blockList.get(0).getFloors());
        floorRecyclerView.setAdapter(floorAdapter);

    }

    private void initializeBlockSpinner() {
        ArrayAdapter<String> blockAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, blockValues);
        blockAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        blockSpinner.setAdapter(blockAdapter);

        blockSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View selectedItemView, int position, long id) {
                if (position !=  0) {
                    List<Floor> selectedFloors = blockList.get(position - 1).getFloors();
                    floorAdapter.updateData(selectedFloors);
                    Toast.makeText(MainActivity.this, "" + adapterView.getSelectedItem(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Please Select Block", Toast.LENGTH_SHORT).show();
                    floorAdapter.updateData(new ArrayList<>());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private List<Block> generateBlockData() {
        List<Block> blocks = new ArrayList<>();


        Block blockA = new Block("A");
        for (int i = 1; i <= 1; i++) {
            Floor floor = new Floor("Floor " + i);
            for (int j = 1; j <= 7; j++) {
                Room room = new Room("A-" + (i * 100 + j));
                floor.addRoom(room);
            }
            blockA.addFloor(floor);
        }
        blocks.add(blockA);


        Block blockB = new Block("B");
        for (int i = 1; i <= 7; i++) {
            Floor floor = new Floor("Floor " + i);
            for (int j = 1; j <= 6; j++) {
                Room room = new Room("B-" + (i * 100 + j));
                floor.addRoom(room);
            }
            blockB.addFloor(floor);
        }
        blocks.add(blockB);


        Block blockC = new Block("C");
        for (int i = 1; i <= 5; i++) {
            Floor floor = new Floor("Floor " + i);
            for (int j = 1; j <= 5; j++) {
                Room room = new Room("C-" + (i * 100 + j));
                floor.addRoom(room);
            }
            blockC.addFloor(floor);
        }
        blocks.add(blockC);


        Block blockD = new Block("D");
        for (int i = 1; i <= 3; i++) {
            Floor floor = new Floor("Floor " + i);
            for (int j = 1; j <= 8; j++) {
                Room room = new Room("D-" + (i * 100 + j));
                floor.addRoom(room);
            }
            blockD.addFloor(floor);
        }
        blocks.add(blockD);

        return blocks;
    }

    private List<String> getBlockNames() {
        List<String> blockNames = new ArrayList<>();
        for (Block block : blockList) {
            blockNames.add(block.getBlock());
        }
        return blockNames;
    }
}