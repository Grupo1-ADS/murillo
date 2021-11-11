package com.example.starwarsapp.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.starwarsapp.R;
import com.example.starwarsapp.databinding.ActivityPeopleDetailBinding;
import com.example.starwarsapp.models.people.People;

public class PeopleDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_detail);

        People people = getIntent().getParcelableExtra("people");

        ActivityPeopleDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_people_detail);
        binding.setPeople(people);

    }

}