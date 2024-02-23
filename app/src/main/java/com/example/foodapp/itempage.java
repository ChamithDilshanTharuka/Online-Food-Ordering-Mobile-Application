package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class itempage extends AppCompatActivity {

    private TextView textViewQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itempage);

        textViewQuantity = findViewById(R.id.textViewQuantity);
        ImageView buttonPlus = findViewById(R.id.buttonPlus);
        ImageView buttonMinus = findViewById(R.id.buttonMinus);
        Button addToCartButton = findViewById(R.id.buttonAddToCart);

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateQuantity(true);
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateQuantity(false);
            }
        });

        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(itempage.this, CartPage.class));
                addToCart();
            }
        });
    }

    private void updateQuantity(boolean increase) {
        int currentQuantity = Integer.parseInt(textViewQuantity.getText().toString());
        int newQuantity = increase ? currentQuantity + 1 : Math.max(1, currentQuantity - 1);
        textViewQuantity.setText(String.valueOf(newQuantity));
    }

    private void addToCart() {
        String itemName = "Pizza"; // Adjust as needed
        double price = 10.99; // Adjust as needed
        int quantity = Integer.parseInt(textViewQuantity.getText().toString());

        CartItem cartItem = new CartItem(itemName, price, quantity);

        // Debug logs
        Log.d("DEBUG", "Before addToCart");
        Cart.getInstance().addToCart(cartItem);
        Log.d("DEBUG", "After addToCart");

        // Log to check if the item is added
        List<CartItem> cartItems = Cart.getInstance().getCartItems();
        for (CartItem item : cartItems) {
            Log.d("DEBUG", "Item: " + item.getItemName() + ", Quantity: " + item.getQuantity());
        }

        // Show a toast message indicating that the item has been added to the cart
        Toast.makeText(itempage.this, "Item added to cart", Toast.LENGTH_SHORT).show();
    }
}
