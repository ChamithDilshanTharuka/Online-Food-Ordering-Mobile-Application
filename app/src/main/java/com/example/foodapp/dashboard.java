package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ImageView pizzaImageView = findViewById(R.id.imageView2);
        // Set a click listener for the Pizza image
        pizzaImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click, for example, start a new activity
                Intent pizzaIntent = new Intent(dashboard.this, PizzaActivity.class);
                startActivity(pizzaIntent);
            }
        });


        // Find the ImageView for Burger
        ImageView burgerImageView = findViewById(R.id.imageView4);
        burgerImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent burgerIntent = new Intent(dashboard.this, BurgerActivity.class);
                startActivity(burgerIntent);
            }
        });

        // Find the ImageView for Hot Dog
        ImageView hotDogImageView = findViewById(R.id.imageView5);
        hotDogImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hotDogIntent = new Intent(dashboard.this, HotDogActivity.class);
                startActivity(hotDogIntent);
            }
        });

        // Find the ImageView for Donut
        ImageView donutImageView = findViewById(R.id.imageView6);
        donutImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent donutIntent = new Intent(dashboard.this, DonutActivity.class);
                startActivity(donutIntent);
            }
        });

        FloatingActionButton cartButton = findViewById(R.id.cartButton);
        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Redirect to the cart page
                startActivity(new Intent(dashboard.this, CartPage.class));
            }
        });
    }
}