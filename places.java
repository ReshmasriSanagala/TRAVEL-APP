package com.example.travel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class places extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
    }

    public void hyd(View view) {
        // Handle the click event for the ImageButton
        Intent intent = new Intent(this, hyderabad.class);
        startActivity(intent);
    }
    public void del(View view) {
        // Handle the click event for the ImageButton
        Intent intent = new Intent(this, delhi.class);
        startActivity(intent);
    }
    public void tn(View view) {
        // Handle the click event for the ImageButton
        Intent intent = new Intent(this, tamil.class);
        startActivity(intent);
    }
    public void viz(View view) {
        // Handle the click event for the ImageButton
        Intent intent = new Intent(this, vizag.class);
        startActivity(intent);
    }
    public void taj(View view) {
        // Handle the click event for the ImageButton
        Intent intent = new Intent(this, agra.class);
        startActivity(intent);
    }
    public void mum(View view) {
        // Handle the click event for the ImageButton
        Intent intent = new Intent(this, mumbai.class);
        startActivity(intent);
    }
}
