package com.example.kanban;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    Spinner sp1,sp2,sp3;
    ImageButton buttondata,buttonstat ;
    String[] number ={"1","2","3"} ;
    String[] composant ={"MQB P00165595","MQB 418946710","PORSHE P00155337"};
    String[] ligne = {} ;
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

    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        buttondata = findViewById(R.id.btn_data) ;
        buttonstat = findViewById(R.id.btn_stat) ;

        buttonstat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),data2.class) ;
                startActivity(intent);
                finish();
            }
        });
        sp1 = findViewById(R.id.sp_poste) ;
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,R.layout.item_file,number);
        adapter.setDropDownViewResource(R.layout.item_file);
        sp1.setAdapter(adapter);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value=parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, value , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp2 = findViewById(R.id.sp_composant) ;
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(MainActivity.this,R.layout.item_file,composant);
        adapter1.setDropDownViewResource(R.layout.item_file);
        sp2.setAdapter(adapter1);
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value=parent.getItemAtPosition(position).toString();
                data = value;
                Toast.makeText(MainActivity.this, value , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp3 = findViewById(R.id.sp_ligne) ;
        ArrayAdapter<String> adapter2 =new ArrayAdapter<String>(MainActivity.this,R.layout.item_file,ligne);
        adapter2.setDropDownViewResource(R.layout.item_file);
        sp3.setAdapter(adapter2);
        sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value=parent.getItemAtPosition(position).toString();

                Toast.makeText(MainActivity.this, value , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.home) {
                    Toast.makeText(MainActivity.this, "home", Toast.LENGTH_SHORT).show();
                } else if(item.getItemId() == R.id.notifcation) {
                    Toast.makeText(MainActivity.this, "notfi", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, stat.class));
                } else if(item.getItemId() == R.id.logout) {
                    Toast.makeText(MainActivity.this, "logout", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, LoginActivit.class));
                    finish();
                } else if(item.getItemId() == R.id.profil) {
                    Toast.makeText(MainActivity.this, "profil", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, pro.class));

                }
                return false;
            }

        });
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();}

        //buttondata.setOnClickListener((v ->{
          //  Intent intent = new Intent(this, data.class);
         //   intent.putExtra("composant", data);
         //   startActivity(intent);
       // }));

    }

}
