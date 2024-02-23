package com.example.foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PizzaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pizzaactivity);

        FloatingActionButton cartButton = findViewById(R.id.cartButton);
        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Redirect to the cart page
                startActivity(new Intent(PizzaActivity.this, CartPage.class));
            }
        });

        // Add your pizza items to the layout, and set click listeners to navigate to the detailed item page
        // Example:
        CardView cardViewPizza1 = findViewById(R.id.cardView1);
        cardViewPizza1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToDetailedItemPage(new PizzaItem("Deluxe Pizza", "A delicious combination of toppings", 10.99, R.drawable.pizzaimg));
            }
        });

        CardView cardViewPizza2 = findViewById(R.id.cardView2);
        cardViewPizza2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToDetailedItemPage(new PizzaItem("Vegetarian Pizza", "A delightful assortment of fresh vegetables", 12.99, R.drawable.vegpizzaimg));
            }
        });

        CardView cardViewPizza3 = findViewById(R.id.cardView3);
        cardViewPizza3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToDetailedItemPage(new PizzaItem("Margherita Pizza", "Classic pizza with fresh tomatoes and mozzarella", 9.99, R.drawable.margpizza));
            }
        });

        CardView cardViewPizza4 = findViewById(R.id.cardView4);
        cardViewPizza4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToDetailedItemPage(new PizzaItem("Pepperoni Pizza", "Classic pizza with spicy pepperoni slices", 11.99, R.drawable.pepperpizzaimg));
            }
        });
    }
    private void navigateToDetailedItemPage(PizzaItem pizzaItem) {
        Intent intent = new Intent(this, DetailedItemActivity.class);
        intent.putExtra("pizzaItem", pizzaItem);
        startActivity(intent);
    }

}
