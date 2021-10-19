package com.example.starwarsapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.starwarsapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPeople = findViewById(R.id.btnPeople);
        Button btnPlanets = findViewById(R.id.btnPlanets);
        Button btnFilms = findViewById(R.id.btnFilms);
        Button btnSpecies = findViewById(R.id.btnSpecies);

        btnPeople.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PeopleActivity.class);
                startActivity(intent);
            }
        });

        btnPlanets.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PlanetActivity.class);
                startActivity(intent);
            }
        });

        btnFilms.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FilmActivity.class);
                startActivity(intent);
            }
        });

        btnSpecies.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SpecieActivity.class);
                startActivity(intent);
            }
        });

    }
}