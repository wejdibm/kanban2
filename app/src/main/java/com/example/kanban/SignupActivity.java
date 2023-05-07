package com.example.kanban;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {

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

                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");

                String name = signupName.getText().toString();
                String email = signupEmail.getText().toString();
                String username = signupUsername.getText().toString();
                String password = signupPassword.getText().toString();
                String matricule = signupMatricule.getText().toString() ;
                String as = "user" ;

                HelperClass helperClass = new HelperClass(name, email, username, password, matricule, as);

                reference.child(username).setValue(helperClass);

                Toast.makeText(SignupActivity.this, "You have signup successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignupActivity.this, LoginActivit.class);
                startActivity(intent);
            }
        });

        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, LoginActivit.class);
                startActivity(intent);
            }
        });
    }
}