package com.example.arifinfrds.recyclerview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    ArrayList<City> cities;
    private MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        prepareData();
        mainAdapter = new MainAdapter(cities);
        setupRecyclerView();
    }

    private void prepareData() {
        cities = new ArrayList<>();
        cities.add(new City("Surabaya"));
        cities.add(new City("Malang"));
        cities.add(new City("Sidoarjo"));
        cities.add(new City("Jakarta"));
        cities.add(new City("Bandung"));
        cities.add(new City("Surabaya"));
        cities.add(new City("Malang"));
        cities.add(new City("Sidoarjo"));
        cities.add(new City("Jakarta"));
        cities.add(new City("Bandung"));
    }

    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(mainAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL, false
        );
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
