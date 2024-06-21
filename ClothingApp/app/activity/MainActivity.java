package com.example.clothingapp.clothingapp.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.clothingapp.R;
import com.example.clothingapp.databinding.ActivityMainBinding;
import com.example.clothingapp.clothingapp.adapter.PopularAdapter;
import com.example.clothingapp.clothingapp.domain.PopularDomain;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);

        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<PopularDomain> items = new ArrayList<>();

        items.add(new PopularDomain("T-Shirt black", "item_1", 15, 4, 500, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Diam quam nulla porttitor massa id neque aliquam. Lobortis scelerisque fermentum dui faucibus in ornare quam viverra orci. Eget felis eget nunc lobortis mattis aliquam faucibus purus in."));
        items.add(new PopularDomain("Smart Watch", "item_2", 10, 4.5, 450, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Diam quam nulla porttitor massa id neque aliquam. Lobortis scelerisque fermentum dui faucibus in ornare quam viverra orci. Eget felis eget nunc lobortis mattis aliquam faucibus purus in."));
        items.add(new PopularDomain("Phone", "item_3", 3, 4.9, 800, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Diam quam nulla porttitor massa id neque aliquam. Lobortis scelerisque fermentum dui faucibus in ornare quam viverra orci. Eget felis eget nunc lobortis mattis aliquam faucibus purus in."));

        binding.PopularView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.PopularView.setAdapter(new PopularAdapter(items));
    }

}