package com.example.travel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private TextView exploreTextView;
    private ImageButton placesImageButton;
    private ImageButton yourPlacesImageButton;
    private ImageButton reviewsImageButton;
    private TextView placesTextView;
    private TextView yourPlacesTextView;
    private TextView reviewsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize views
        exploreTextView = findViewById(R.id.textView7);
        placesImageButton = findViewById(R.id.imageButton4);
        yourPlacesImageButton = findViewById(R.id.imageButton8);
        reviewsImageButton = findViewById(R.id.imageButton9);
        placesTextView = findViewById(R.id.textView8);
        yourPlacesTextView = findViewById(R.id.textView9);
        reviewsTextView = findViewById(R.id.textView10);

        // Set click listeners for ImageButtons
        placesImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle click for Places ImageButton
                Intent intent = new Intent(HomeActivity.this, places.class);
                startActivity(intent);
            }
        });

        yourPlacesImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle click for Your Places ImageButton
                Intent intent = new Intent(HomeActivity.this, yourplaces.class);
                startActivity(intent);
            }
        });

        reviewsImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle click for Reviews ImageButton
                Intent intent = new Intent(HomeActivity.this, reviews.class);
                startActivity(intent);
            }
        });

        // You can perform similar actions for other views as needed
    }
}
