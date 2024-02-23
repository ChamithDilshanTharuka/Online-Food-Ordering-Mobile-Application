
package com.example.foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CartPage extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView textViewTotalPrice;
    private Button buttonCheckout;
    private CartAdapter cartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartpage);

        recyclerView = findViewById(R.id.recyclerViewCartItems);
        textViewTotalPrice = findViewById(R.id.textViewTotalPrice);
        buttonCheckout = findViewById(R.id.checkoutButton);


        // Set up RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Get the list of items from the cart
        List<CartItem> cartItems = Cart.getInstance().getCartItems();
        cartAdapter = new CartAdapter(cartItems);
        recyclerView.setAdapter(cartAdapter);

        // Update the total price
        updateTotalPrice();

        // Checkout Button
        Button checkoutButton = findViewById(R.id.checkoutButton);
        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to the CheckoutActivity
                startActivity(new Intent(CartPage.this, Checkout.class));
            }
        });
    }

    // Method to update the total price based on the items in the cart
    private void updateTotalPrice() {
        double total = Cart.getInstance().calculateTotal();
        textViewTotalPrice.setText(String.format("Total: $%.2f", total));
    }


}