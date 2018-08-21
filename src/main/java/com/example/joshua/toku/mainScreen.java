package com.example.joshua.toku;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.common.oob.SignUp;
import com.google.firebase.auth.FirebaseAuth;

public class mainScreen extends AppCompatActivity {

    Button sign;
    Button log;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

         sign = (Button)findViewById(R.id.btnSign);
         log = (Button)findViewById(R.id.btnLog);
        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null){
            Intent intent = new Intent(mainScreen.this, chatMain.class);
            startActivity(intent);
        }

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainScreen.this, signUp.class);
                startActivity(intent);
            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainScreen.this, logIn.class);
                startActivity(intent);
            }
        });
    }
}
