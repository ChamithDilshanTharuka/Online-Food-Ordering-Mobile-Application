package com.example.foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChooseRole extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_role);

        // Find buttons by their IDs
        TextView buttonUser = findViewById(R.id.buttonUser);
        TextView buttonAdmin = findViewById(R.id.buttonAdmin);

        // Set click listeners for the buttons
        buttonUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseRole.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        buttonAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle admin role selection
                // You can add your logic or navigate to the admin-specific activity
                // For now, let's assume you want to navigate to an AdminActivity
                Intent intent = new Intent(ChooseRole.this, AdminActivity.class);
                startActivity(intent);
            }
        });
    }
}
