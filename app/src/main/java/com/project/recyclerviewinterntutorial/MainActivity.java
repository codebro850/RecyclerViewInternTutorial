package com.project.recyclerviewinterntutorial;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements Adapter.OnItemClickListener {

    RecyclerView rvUser;
    ExtendedFloatingActionButton fabNewUser;
    Adapter adapter;
    ArrayList<ModelClass> usersList;
    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvUser = findViewById(R.id.rv_users);
        fabNewUser = findViewById(R.id.fab_new_user);
        usersList = new ArrayList<>();

        setUpRv();
        addData();

        fabNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addData();
            }
        });


    }

    public void addData() {
        int number = rand.nextInt(10 - 1 + 1) + 1;
        usersList.add(new ModelClass("Brijesh", 21, number));
        adapter.setData(usersList);

    }

    public void setUpRv() {
        rvUser.setHasFixedSize(true);
        rvUser.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(MainActivity.this);
        rvUser.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int number) {
        Toast.makeText(MainActivity.this, "" + number, Toast.LENGTH_SHORT).show();
    }
}