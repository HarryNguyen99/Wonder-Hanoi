package com.example.baihoc1.ontap1appkorea.Controller;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;

import com.example.baihoc1.ontap1appkorea.R;

public class HomeActivity extends AppCompatActivity {
    NavigationView nav;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
    }

    private void init() {
        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle actionBarDrawerToggle
                = new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_open);
        drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container,homeFragment);
        fragmentTransaction.commit();

        nav = findViewById(R.id.nav);
        nav.setCheckedItem(R.id.nav_home);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case  R.id.nav_home: {
                        HomeFragment homeFragment = new HomeFragment();
                        FragmentTransaction fragmentTransaction =
                                getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.container,homeFragment);
                        fragmentTransaction.commit();


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
                        PlaceFragment placeFragment = new PlaceFragment();
                        FragmentTransaction fragmentTransaction =
                                getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.container,placeFragment);
                        fragmentTransaction.commit();

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
                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }
}
