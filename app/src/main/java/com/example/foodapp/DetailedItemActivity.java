package com.example.foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class DetailedItemActivity extends AppCompatActivity {

    private PizzaItem pizzaItem;
    private int quantity = 1;  // Initial quantity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itempage);

        // Retrieve pizza item data from intent
        Intent intent = getIntent();
        if (intent.hasExtra("pizzaItem")) {
            pizzaItem = (PizzaItem) intent.getParcelableExtra("pizzaItem");
        }

        Intent intent2 = getIntent();
        PizzaItem pizzaItem = intent2.getParcelableExtra("pizzaItem");

        // Set the pizza image
        ImageView imageViewPizza = findViewById(R.id.imageViewPizza);
        imageViewPizza.setImageResource(pizzaItem.getImageResource());

        // Update UI with pizza item data
        updateUI();

        // Handle quantity buttons
        ImageView buttonMinus = findViewById(R.id.buttonMinus);
        ImageView buttonPlus = findViewById(R.id.buttonPlus);

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementQuantity();
            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementQuantity();
            }
        });

        // Handle "Add to Cart" button
        Button buttonAddToCart = findViewById(R.id.buttonAddToCart);
        buttonAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                addToCart();
            }
        });
    }

    private void updateUI() {
        TextView textViewItemName = findViewById(R.id.textViewItemName);
        TextView textViewPrice = findViewById(R.id.textViewPrice);
        TextView textViewDescription = findViewById(R.id.textViewDescription);
        ImageView imageViewPizza = findViewById(R.id.imageViewPizza);

        textViewItemName.setText(pizzaItem.getName());
        textViewPrice.setText(String.format(Locale.getDefault(), "$%.2f", pizzaItem.getPrice()));
        textViewDescription.setText(pizzaItem.getDescription());
        imageViewPizza.setImageResource(pizzaItem.getImageResource());
    }

    private void incrementQuantity() {
        TextView textViewQuantity = findViewById(R.id.textViewQuantity);
        quantity++;
        textViewQuantity.setText(String.valueOf(quantity));
    }

    private void decrementQuantity() {
        if (quantity > 1) {
            TextView textViewQuantity = findViewById(R.id.textViewQuantity);
            quantity--;
            textViewQuantity.setText(String.valueOf(quantity));
        }
    }

    private void addToCart() {
        Toast.makeText(this, "Added to Cart", Toast.LENGTH_SHORT).show();
    }
}
