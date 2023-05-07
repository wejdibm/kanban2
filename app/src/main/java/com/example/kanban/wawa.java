package com.example.kanban;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class wawa extends AppCompatActivity {

    EditText signupName, signupUsername, signupEmail, signupPassword,signupMatricule;
    TextView loginRedirectText;
    Button signupButton;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre2);

        signupName = findViewById(R.id.name);
        signupEmail = findViewById(R.id.email1);
        signupUsername = findViewById(R.id.username2);
        signupPassword = findViewById(R.id.password1);
        loginRedirectText = findViewById(R.id.seconnecter);
        signupMatricule = findViewById(R.id.matricule);
        signupButton = findViewById(R.id.registre1);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateUsername() | !validatePassword() | !validateEMAIL() | !validateMatricule() | !validateNom()) {

                } else {
                    checkUser();
                }
            }
        });

        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(wawa.this, LoginActivit.class);
                startActivity(intent);
            }
        });

    }

    public Boolean validateUsername() {
        String val = signupUsername.getText().toString();
        if (val.isEmpty()) {
            signupUsername.setError("Username cannot be empty");
            return false;
        } else {
            signupUsername.setError(null);
            return true;
        }
    }

    public Boolean validatePassword(){
        String val = signupPassword.getText().toString();
        if (val.isEmpty()) {
            signupPassword.setError("Password cannot be empty");
            return false;
        } else {
            signupPassword.setError(null);
            return true;
        }
    }
    public Boolean validateEMAIL() {
        String val = signupEmail.getText().toString();
        if (val.isEmpty()) {
            signupEmail.setError("Email cannot be empty");
            return false;
        } else {
            signupEmail.setError(null);
            return true;
        }
    }
    public Boolean validateMatricule() {
        String val = signupMatricule.getText().toString();
        if (val.isEmpty()) {
            signupMatricule.setError("Matricule cannot be empty");
            return false;
        } else {
            signupMatricule.setError(null);
            return true;
        }
    }
    public Boolean validateNom() {
        String val = signupName.getText().toString();
        if (val.isEmpty()) {
            signupName.setError("Nom cannot be empty");
            return false;
        } else {
            signupName.setError(null);
            return true;
        }
    }

    public void checkUser(){
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("users");

        String name = signupName.getText().toString();
        String email = signupEmail.getText().toString();
        String username = signupUsername.getText().toString();
        String password = signupPassword.getText().toString();
        String matricule = signupMatricule.getText().toString() ;
        String as ="user" ;


            HelperClass helperClass = new HelperClass(name, email, username, password, matricule,as);
            reference.child(username).setValue(helperClass);

            Toast.makeText(wawa.this, "You have signup successfully!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(wawa.this, LoginActivit.class);
            startActivity(intent);

    }
}