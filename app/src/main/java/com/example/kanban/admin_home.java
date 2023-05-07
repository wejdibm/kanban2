package com.example.kanban;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class admin_home extends AppCompatActivity {
    DrawerLayout drawerLayout ;
    NavigationView navigationView ;
    ActionBarDrawerToggle drawerToggle ;
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)){
            return true ;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        drawerLayout = findViewById(R.id.drawer_layoutadmin);
        navigationView = findViewById(R.id.nav_);
        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.home) {
                    Toast.makeText(admin_home.this, "home", Toast.LENGTH_SHORT).show();
                } else if(item.getItemId() == R.id.listprofil) {
                    Toast.makeText(admin_home.this, "liste des utilisateur ", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(admin_home.this, MainActivity3.class));
                } else if(item.getItemId() == R.id.logout) {
                    Toast.makeText(admin_home.this, "logout", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(admin_home.this, LoginActivit.class));
                    finish();
                } else if(item.getItemId() == R.id.controle) {
                    Toast.makeText(admin_home.this, "controle", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(admin_home.this, controle.class));

                }
                return false;
            }

        });
    }
}