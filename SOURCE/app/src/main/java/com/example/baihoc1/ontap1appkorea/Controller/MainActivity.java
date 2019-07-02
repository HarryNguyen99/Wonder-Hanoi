package com.example.baihoc1.ontap1appkorea.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.baihoc1.ontap1appkorea.R;

public class MainActivity extends AppCompatActivity {

    TextView tvContact, tvPlace, tvPromotion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    void init(){
//        tvContact = findViewById(R.id.tv_contact);
//        tvPlace = findViewById(R.id.tv_place);
//        tvPromotion = findViewById(R.id.tv_promotion);

        tvContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent contact = new Intent(MainActivity.this, Contact.class);
                startActivity(contact);

            }
        });

        tvPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent place = new Intent(MainActivity.this, Place.class);
                startActivity(place);

            }
        });

        tvPromotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent promotion = new Intent(MainActivity.this, Promotion.class);
                startActivity(promotion);

            }
        });


    }

}

