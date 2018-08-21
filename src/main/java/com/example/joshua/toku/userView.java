package com.example.joshua.toku;

import android.content.Intent;
import android.provider.CalendarContract;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

import io.opencensus.tags.Tag;

import static android.widget.Toast.makeText;

public class userView extends AppCompatActivity {

    private FirebaseUser firebaseUser;
    private FirebaseUserMetadata userMetadata;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth firebaseAuth;

    private ArrayList<String> listLike;
    private ArrayAdapter<String> adapter;

    private ListView listView;

    String userName;
    String oneThingLikes;
    String email;
    String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        listView = findViewById(R.id.listLikes);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        assert firebaseUser != null;
        uid = firebaseUser.getUid();
        listLike = new ArrayList<>();




        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }
        if (firebaseAuth.getCurrentUser() == null){
            Intent intent = new Intent(userView.this, signUp.class);
            startActivity(intent);
        }
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

            //TODO get list of the things the child likes
            //Item from list era set
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    String user_food=dataSnapshot.child(uid).child("food").getValue(String.class);
                    String user_drink=dataSnapshot.child(uid).child("drink").getValue(String.class);
                    String user_activity=dataSnapshot.child(uid).child("activity").getValue(String.class);


                    listLike.add(user_food);
                    listLike.add(user_drink);
                    listLike.add(user_activity);

                    adapter = new ArrayAdapter<>(userView.this, android.R.layout.simple_list_item_1, listLike);
                    listView.setAdapter(adapter);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            loasUserInformation();

    }

    private void loasUserInformation() {
        FirebaseUser user = firebaseAuth.getCurrentUser();

        String dName = user.getDisplayName();
        String dEmail = user.getEmail();
    }


}
