package com.example.carparking;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class BookedActivity extends AppCompatActivity {

    private ListView listView;

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    UserBooking userBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booked);

        userBooking = new UserBooking();
        listView = (ListView)findViewById(R.id.listview);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());

        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, R.layout.user_info, R.id.userInfoName, list);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dss: dataSnapshot.getChildren())
                {
                    userBooking = dss.getValue(UserBooking.class);
                    list.add("Place: "+ userBooking.getPlace() +" \nSlot: "+ userBooking.getSlot());
                }
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(BookedActivity.this, "You have no bookings.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
