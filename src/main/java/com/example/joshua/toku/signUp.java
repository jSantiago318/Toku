package com.example.joshua.toku;

import android.app.ProgressDialog;
import android.content.Intent;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class signUp extends AppCompatActivity {

    Button logInBtn;
    Button  signUpBtn;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    private DatabaseReference databaseReference;
    EditText email;
    EditText password;
    EditText personName;
    EditText personAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email = findViewById(R.id.uEmail);
        password = findViewById(R.id.passwordText);
        personName = findViewById(R.id.personName);
        personAge = findViewById(R.id.userAge);
        firebaseAuth = FirebaseAuth.getInstance();
        logInBtn = findViewById(R.id.btnSign);
        signUpBtn= findViewById(R.id.btnLog);

        progressDialog = new ProgressDialog(this);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailGet = email.getText().toString();
                String passwordGet = password.getText().toString();
                String nameGet = personName.getText().toString();
                String ageGet = personAge.getText().toString();
                if (TextUtils.isEmpty(emailGet) || TextUtils.isEmpty(passwordGet) || TextUtils.isEmpty(nameGet) || TextUtils.isEmpty(ageGet)) {
                    Toast.makeText(getApplicationContext(), "Sorry...you forgot something", Toast.LENGTH_SHORT).show();
                    return;
                } else {

                    if (!TextUtils.isEmpty(nameGet) && !TextUtils.isEmpty(ageGet) && !TextUtils.isEmpty(emailGet) && !TextUtils.isEmpty(passwordGet)) {
                    progressDialog.setTitle("Loading...");
                    progressDialog.setMessage("Finishing up for you...");
                    progressDialog.setCanceledOnTouchOutside(true);
                    progressDialog.show();
                    register(nameGet, ageGet, emailGet, passwordGet);
                    //4.51
                    }

                    //TODO On click store email'n password and move to the next  and add the name'n age to the DB
                    //    Intent intent = new Intent(signUp.this, .class);
                    //    startActivity(intent);
                }
            }

            private void register(final String nameGet, final String ageGet, final String emailGet, final String passwordGet)
                {
                    firebaseAuth.createUserWithEmailAndPassword(emailGet, passwordGet).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                String uid = user.getUid();
                                databaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child(uid);

                                HashMap<String, String> userMap = new HashMap<>();
                                //ORGANIZER ON DB
                                userMap.put("name", nameGet);
                                userMap.put("age", ageGet);
                                userMap.put("email", emailGet);
                                userMap.put("password", passwordGet);

                                databaseReference.setValue(userMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        progressDialog.dismiss();
                                        Intent intent = new Intent(signUp.this, chatMain.class);
                                        startActivity(intent);
                                    }
                                });
                            }
                        }
                    });
                }

        });

        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signUp.this, logIn.class);
                startActivity(intent);
            }
        });

    }
}
