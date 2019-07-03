package com.example.baihoc1.ontap1appkorea.Controller;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.baihoc1.ontap1appkorea.Controller.Adapter.PlaceFragment;
import com.example.baihoc1.ontap1appkorea.R;

public class HomeActivity extends AppCompatActivity {
    NavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
    }

    private void init() {
        nav = findViewById(R.id.nav);
        nav.setCheckedItem(R.id.nav_home);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
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
