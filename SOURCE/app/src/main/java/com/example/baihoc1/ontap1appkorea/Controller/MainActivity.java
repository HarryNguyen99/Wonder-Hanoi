package com.example.baihoc1.ontap1appkorea.Controller;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.baihoc1.ontap1appkorea.R;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    void init(){
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case  R.id.nav_home: {

                                break;
                            }
                            case  R.id.nav_contact : {
                                ContactFragment categoryFragment = new ContactFragment();
                                FragmentTransaction fragmentTransaction =
                                        getSupportFragmentManager().beginTransaction();
                                fragmentTransaction.replace(R.id.container,categoryFragment);
                                fragmentTransaction.commit();
                                break;
                            }
                            case  R.id.nav_place : {

                                break;
                            }
                            case  R.id.nav_promation : {
                                PromotionFragment promotionFragment = new PromotionFragment();
                                FragmentTransaction fragmentTransaction =
                                        getSupportFragmentManager().beginTransaction();
                                fragmentTransaction.replace(R.id.container,promotionFragment);
                                fragmentTransaction.commit();

                                break;
                            }
                        }
                        return true;
                    }
                });

    }

}

