package com.example.carparking;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Gate1Activity extends AppCompatActivity {

    private TextView selection;
    private EditText etname;
    private Button A1, A2, A3, A4, B1, B2, B3, B4, C1, C2, C3, C4, D1, D2, D3, D4;
    private Button E1, E2, E3, E4, F1, F2, F3, F4, G1, G2, G3, G4, book;
    private String result="";
    private String place = "Gate 1";
    private ProgressDialog progressDialog;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    UserBooking userBooking;
    private ArrayList<String> slotlist;

    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gate1);

        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        etname = (EditText)findViewById(R.id.editname);
        selection = (TextView)findViewById(R.id.tvselected);
        selection.setVisibility(View.INVISIBLE);
        book = (Button)findViewById(R.id.btnbook);

        userBooking = new UserBooking();
        slotlist = new ArrayList<>();


        databaseReference = firebaseDatabase.getReference("Gate 1");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dss: dataSnapshot.getChildren())
                {
                    userBooking = dss.getValue(UserBooking.class);
                    slotlist.add(userBooking.getSlot());
                }
                int j= slotlist.size();
                for(int i=0; i<j;i++){
                    String str = "btn"+slotlist.get(i);
                    int passID = getResources().getIdentifier(str, "id", getPackageName());
                    Button btn = (Button)findViewById(passID);
                    btn.setBackgroundColor(getResources().getColor(R.color.colorred));
                    btn.setEnabled(false);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        A1 = (Button)findViewById(R.id.btnA1);
        A2 = (Button)findViewById(R.id.btnA2);
        A3 = (Button)findViewById(R.id.btnA3);
        A4 = (Button)findViewById(R.id.btnA4);
        B1 = (Button)findViewById(R.id.btnB1);
        B2 = (Button)findViewById(R.id.btnB2);
        B3 = (Button)findViewById(R.id.btnB3);
        B4 = (Button)findViewById(R.id.btnB4);
        C1 = (Button)findViewById(R.id.btnC1);
        C2 = (Button)findViewById(R.id.btnC2);
        C3 = (Button)findViewById(R.id.btnC3);
        C4 = (Button)findViewById(R.id.btnC4);
        D1 = (Button)findViewById(R.id.btnD1);
        D2 = (Button)findViewById(R.id.btnD2);
        D3 = (Button)findViewById(R.id.btnD3);
        D4 = (Button)findViewById(R.id.btnD4);
        E1 = (Button)findViewById(R.id.btnE1);
        E2 = (Button)findViewById(R.id.btnE2);
        E3 = (Button)findViewById(R.id.btnE3);
        E4 = (Button)findViewById(R.id.btnE4);
        F1 = (Button)findViewById(R.id.btnF1);
        F2 = (Button)findViewById(R.id.btnF2);
        F3 = (Button)findViewById(R.id.btnF3);
        F4 = (Button)findViewById(R.id.btnF4);
        G1 = (Button)findViewById(R.id.btnG1);
        G2 = (Button)findViewById(R.id.btnG2);
        G3 = (Button)findViewById(R.id.btnG3);
        G4 = (Button)findViewById(R.id.btnG4);

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmmessage(result);
            }
        });

        A1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = "A1";
                A1.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                selection.setText("Selected: A1");
                selection.setVisibility(View.VISIBLE);
                A2.setEnabled(false);
                A3.setEnabled(false);
                A4.setEnabled(false);
                B1.setEnabled(false);
                B2.setEnabled(false);
                B3.setEnabled(false);
                B4.setEnabled(false);
                C1.setEnabled(false);
                C2.setEnabled(false);
                C3.setEnabled(false);
                C4.setEnabled(false);
                D1.setEnabled(false);
                D2.setEnabled(false);
                D3.setEnabled(false);
                D4.setEnabled(false);
                E1.setEnabled(false);
                E2.setEnabled(false);
                E3.setEnabled(false);
                E4.setEnabled(false);
                F1.setEnabled(false);
                F2.setEnabled(false);
                F3.setEnabled(false);
                F4.setEnabled(false);
                G1.setEnabled(false);
                G2.setEnabled(false);
                G3.setEnabled(false);
                G4.setEnabled(false);
            }
        });
        A2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = "A2";
                A2.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                selection.setText("Selected: A2");
                selection.setVisibility(View.VISIBLE);
                A1.setEnabled(false);
                A3.setEnabled(false);
                A4.setEnabled(false);
                B1.setEnabled(false);
                B2.setEnabled(false);
                B3.setEnabled(false);
                B4.setEnabled(false);
                C1.setEnabled(false);
                C2.setEnabled(false);
                C3.setEnabled(false);
                C4.setEnabled(false);
                D1.setEnabled(false);
                D2.setEnabled(false);
                D3.setEnabled(false);
                D4.setEnabled(false);
                E1.setEnabled(false);
                E2.setEnabled(false);
                E3.setEnabled(false);
                E4.setEnabled(false);
                F1.setEnabled(false);
                F2.setEnabled(false);
                F3.setEnabled(false);
                F4.setEnabled(false);
                G1.setEnabled(false);
                G2.setEnabled(false);
                G3.setEnabled(false);
                G4.setEnabled(false);
            }
        });
        A3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = "A3";
                A3.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                selection.setText("Selected: A3");
                selection.setVisibility(View.VISIBLE);
                A2.setEnabled(false);
                A1.setEnabled(false);
                A4.setEnabled(false);
                B1.setEnabled(false);
                B2.setEnabled(false);
                B3.setEnabled(false);
                B4.setEnabled(false);
                C1.setEnabled(false);
                C2.setEnabled(false);
                C3.setEnabled(false);
                C4.setEnabled(false);
                D1.setEnabled(false);
                D2.setEnabled(false);
                D3.setEnabled(false);
                D4.setEnabled(false);
                E1.setEnabled(false);
                E2.setEnabled(false);
                E3.setEnabled(false);
                E4.setEnabled(false);
                F1.setEnabled(false);
                F2.setEnabled(false);
                F3.setEnabled(false);
                F4.setEnabled(false);
                G1.setEnabled(false);
                G2.setEnabled(false);
                G3.setEnabled(false);
                G4.setEnabled(false);
            }
        });
        A4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = "A4";
                A4.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                selection.setText("Selected: A4");
                selection.setVisibility(View.VISIBLE);
                A2.setEnabled(false);
                A3.setEnabled(false);
                A1.setEnabled(false);
                B1.setEnabled(false);
                B2.setEnabled(false);
                B3.setEnabled(false);
                B4.setEnabled(false);
                C1.setEnabled(false);
                C2.setEnabled(false);
                C3.setEnabled(false);
                C4.setEnabled(false);
                D1.setEnabled(false);
                D2.setEnabled(false);
                D3.setEnabled(false);
                D4.setEnabled(false);
                E1.setEnabled(false);
                E2.setEnabled(false);
                E3.setEnabled(false);
                E4.setEnabled(false);
                F1.setEnabled(false);
                F2.setEnabled(false);
                F3.setEnabled(false);
                F4.setEnabled(false);
                G1.setEnabled(false);
                G2.setEnabled(false);
                G3.setEnabled(false);
                G4.setEnabled(false);
            }
        });
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = "B1";
                B1.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                selection.setText("Selected: B1");
                selection.setVisibility(View.VISIBLE);
                A2.setEnabled(false);
                A3.setEnabled(false);
                A4.setEnabled(false);
                A1.setEnabled(false);
                B2.setEnabled(false);
                B3.setEnabled(false);
                B4.setEnabled(false);
                C1.setEnabled(false);
                C2.setEnabled(false);
                C3.setEnabled(false);
                C4.setEnabled(false);
                D1.setEnabled(false);
                D2.setEnabled(false);
                D3.setEnabled(false);
                D4.setEnabled(false);
                E1.setEnabled(false);
                E2.setEnabled(false);
                E3.setEnabled(false);
                E4.setEnabled(false);
                F1.setEnabled(false);
                F2.setEnabled(false);
                F3.setEnabled(false);
                F4.setEnabled(false);
                G1.setEnabled(false);
                G2.setEnabled(false);
                G3.setEnabled(false);
                G4.setEnabled(false);
            }
        });
        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = "B2";
                B2.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                selection.setText("Selected: B2");
                selection.setVisibility(View.VISIBLE);
                A2.setEnabled(false);
                A3.setEnabled(false);
                A4.setEnabled(false);
                B1.setEnabled(false);
                A1.setEnabled(false);
                B3.setEnabled(false);
                B4.setEnabled(false);
                C1.setEnabled(false);
                C2.setEnabled(false);
                C3.setEnabled(false);
                C4.setEnabled(false);
                D1.setEnabled(false);
                D2.setEnabled(false);
                D3.setEnabled(false);
                D4.setEnabled(false);
                E1.setEnabled(false);
                E2.setEnabled(false);
                E3.setEnabled(false);
                E4.setEnabled(false);
                F1.setEnabled(false);
                F2.setEnabled(false);
                F3.setEnabled(false);
                F4.setEnabled(false);
                G1.setEnabled(false);
                G2.setEnabled(false);
                G3.setEnabled(false);
                G4.setEnabled(false);
            }
        });
        B3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = "B3";
                B3.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                selection.setText("Selected: B3");
                selection.setVisibility(View.VISIBLE);
                A2.setEnabled(false);
                A3.setEnabled(false);
                A4.setEnabled(false);
                B1.setEnabled(false);
                B2.setEnabled(false);
                A1.setEnabled(false);
                B4.setEnabled(false);
                C1.setEnabled(false);
                C2.setEnabled(false);
                C3.setEnabled(false);
                C4.setEnabled(false);
                D1.setEnabled(false);
                D2.setEnabled(false);
                D3.setEnabled(false);
                D4.setEnabled(false);
                E1.setEnabled(false);
                E2.setEnabled(false);
                E3.setEnabled(false);
                E4.setEnabled(false);
                F1.setEnabled(false);
                F2.setEnabled(false);
                F3.setEnabled(false);
                F4.setEnabled(false);
                G1.setEnabled(false);
                G2.setEnabled(false);
                G3.setEnabled(false);
                G4.setEnabled(false);
            }
        });
        B4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = "B4";
                B4.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                selection.setText("Selected: B4");
                selection.setVisibility(View.VISIBLE);
                A2.setEnabled(false);
                A3.setEnabled(false);
                A4.setEnabled(false);
                B1.setEnabled(false);
                B2.setEnabled(false);
                B3.setEnabled(false);
                A1.setEnabled(false);
                C1.setEnabled(false);
                C2.setEnabled(false);
                C3.setEnabled(false);
                C4.setEnabled(false);
                D1.setEnabled(false);
                D2.setEnabled(false);
                D3.setEnabled(false);
                D4.setEnabled(false);
                E1.setEnabled(false);
                E2.setEnabled(false);
                E3.setEnabled(false);
                E4.setEnabled(false);
                F1.setEnabled(false);
                F2.setEnabled(false);
                F3.setEnabled(false);
                F4.setEnabled(false);
                G1.setEnabled(false);
                G2.setEnabled(false);
                G3.setEnabled(false);
                G4.setEnabled(false);
            }
        });
        C1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = "C1";
                C1.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                selection.setText("Selected: C1");
                selection.setVisibility(View.VISIBLE);
                A2.setEnabled(false);
                A3.setEnabled(false);
                A4.setEnabled(false);
                B1.setEnabled(false);
                B2.setEnabled(false);
                B3.setEnabled(false);
                B4.setEnabled(false);
                A1.setEnabled(false);
                C2.setEnabled(false);
                C3.setEnabled(false);
                C4.setEnabled(false);
                D1.setEnabled(false);
                D2.setEnabled(false);
                D3.setEnabled(false);
                D4.setEnabled(false);
                E1.setEnabled(false);
                E2.setEnabled(false);
                E3.setEnabled(false);
                E4.setEnabled(false);
                F1.setEnabled(false);
                F2.setEnabled(false);
                F3.setEnabled(false);
                F4.setEnabled(false);
                G1.setEnabled(false);
                G2.setEnabled(false);
                G3.setEnabled(false);
                G4.setEnabled(false);
            }
        });C2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = "C2";
                C2.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                selection.setText("Selected: C2");
                selection.setVisibility(View.VISIBLE);
                A2.setEnabled(false);
                A3.setEnabled(false);
                A4.setEnabled(false);
                B1.setEnabled(false);
                B2.setEnabled(false);
                B3.setEnabled(false);
                B4.setEnabled(false);
                C1.setEnabled(false);
                A1.setEnabled(false);
                C3.setEnabled(false);
                C4.setEnabled(false);
                D1.setEnabled(false);
                D2.setEnabled(false);
                D3.setEnabled(false);
                D4.setEnabled(false);
                E1.setEnabled(false);
                E2.setEnabled(false);
                E3.setEnabled(false);
                E4.setEnabled(false);
                F1.setEnabled(false);
                F2.setEnabled(false);
                F3.setEnabled(false);
                F4.setEnabled(false);
                G1.setEnabled(false);
                G2.setEnabled(false);
                G3.setEnabled(false);
                G4.setEnabled(false);
            }
        });C3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = "C3";
                C3.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                selection.setText("Selected: C3");
                selection.setVisibility(View.VISIBLE);
                A2.setEnabled(false);
                A3.setEnabled(false);
                A4.setEnabled(false);
                B1.setEnabled(false);
                B2.setEnabled(false);
                B3.setEnabled(false);
                B4.setEnabled(false);
                C1.setEnabled(false);
                C2.setEnabled(false);
                A1.setEnabled(false);
                C4.setEnabled(false);
                D1.setEnabled(false);
                D2.setEnabled(false);
                D3.setEnabled(false);
                D4.setEnabled(false);
                E1.setEnabled(false);
                E2.setEnabled(false);
                E3.setEnabled(false);
                E4.setEnabled(false);
                F1.setEnabled(false);
                F2.setEnabled(false);
                F3.setEnabled(false);
                F4.setEnabled(false);
                G1.setEnabled(false);
                G2.setEnabled(false);
                G3.setEnabled(false);
                G4.setEnabled(false);
            }
        });C4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = "C4";
                C4.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                selection.setText("Selected: C4");
                selection.setVisibility(View.VISIBLE);
                A2.setEnabled(false);
                A3.setEnabled(false);
                A4.setEnabled(false);
                B1.setEnabled(false);
                B2.setEnabled(false);
                B3.setEnabled(false);
                B4.setEnabled(false);
                C1.setEnabled(false);
                C2.setEnabled(false);
                C3.setEnabled(false);
                A1.setEnabled(false);
                D1.setEnabled(false);
                D2.setEnabled(false);
                D3.setEnabled(false);
                D4.setEnabled(false);
                E1.setEnabled(false);
                E2.setEnabled(false);
                E3.setEnabled(false);
                E4.setEnabled(false);
                F1.setEnabled(false);
                F2.setEnabled(false);
                F3.setEnabled(false);
                F4.setEnabled(false);
                G1.setEnabled(false);
                G2.setEnabled(false);
                G3.setEnabled(false);
                G4.setEnabled(false);
            }
        });
        D1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = "D1";
                D1.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                selection.setText("Selected: D1");
                selection.setVisibility(View.VISIBLE);
                A2.setEnabled(false);
                A3.setEnabled(false);
                A4.setEnabled(false);
                B1.setEnabled(false);
                B2.setEnabled(false);
                B3.setEnabled(false);
                B4.setEnabled(false);
                C1.setEnabled(false);
                C2.setEnabled(false);
                C3.setEnabled(false);
                C4.setEnabled(false);
                A1.setEnabled(false);
                D2.setEnabled(false);
                D3.setEnabled(false);
                D4.setEnabled(false);
                E1.setEnabled(false);
                E2.setEnabled(false);
                E3.setEnabled(false);
                E4.setEnabled(false);
                F1.setEnabled(false);
                F2.setEnabled(false);
                F3.setEnabled(false);
                F4.setEnabled(false);
                G1.setEnabled(false);
                G2.setEnabled(false);
                G3.setEnabled(false);
                G4.setEnabled(false);
            }
        });
        D2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = "D2";
                D2.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                selection.setText("Selected: D2");
                selection.setVisibility(View.VISIBLE);
                A2.setEnabled(false);
                A3.setEnabled(false);
                A4.setEnabled(false);
                B1.setEnabled(false);
                B2.setEnabled(false);
                B3.setEnabled(false);
                B4.setEnabled(false);
                C1.setEnabled(false);
                C2.setEnabled(false);
                C3.setEnabled(false);
                C4.setEnabled(false);
                D1.setEnabled(false);
                A1.setEnabled(false);
                D3.setEnabled(false);
                D4.setEnabled(false);
                E1.setEnabled(false);
                E2.setEnabled(false);
                E3.setEnabled(false);
                E4.setEnabled(false);
                F1.setEnabled(false);
                F2.setEnabled(false);
                F3.setEnabled(false);
                F4.setEnabled(false);
                G1.setEnabled(false);
                G2.setEnabled(false);
                G3.setEnabled(false);
                G4.setEnabled(false);
            }
        });
        D3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = "D3";
                D3.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                selection.setText("Selected: D3");
                selection.setVisibility(View.VISIBLE);
                A2.setEnabled(false);
                A3.setEnabled(false);
                A4.setEnabled(false);
                B1.setEnabled(false);
                B2.setEnabled(false);
                B3.setEnabled(false);
                B4.setEnabled(false);
                C1.setEnabled(false);
                C2.setEnabled(false);
                C3.setEnabled(false);
                C4.setEnabled(false);
                D1.setEnabled(false);
                D2.setEnabled(false);
                A1.setEnabled(false);
                D4.setEnabled(false);
                E1.setEnabled(false);
                E2.setEnabled(false);
                E3.setEnabled(false);
                E4.setEnabled(false);
                F1.setEnabled(false);
                F2.setEnabled(false);
                F3.setEnabled(false);
                F4.setEnabled(false);
                G1.setEnabled(false);
                G2.setEnabled(false);
                G3.setEnabled(false);
                G4.setEnabled(false);
            }
        });
        D4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = "D4";
                D4.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                selection.setText("Selected: D4");
                selection.setVisibility(View.VISIBLE);
                A2.setEnabled(false);
                A3.setEnabled(false);
                A4.setEnabled(false);
                B1.setEnabled(false);
                B2.setEnabled(false);
                B3.setEnabled(false);
                B4.setEnabled(false);
                C1.setEnabled(false);
                C2.setEnabled(false);
                C3.setEnabled(false);
                C4.setEnabled(false);
                D1.setEnabled(false);
                D2.setEnabled(false);
                D3.setEnabled(false);
                A1.setEnabled(false);
                E1.setEnabled(false);
                E2.setEnabled(false);
                E3.setEnabled(false);
                E4.setEnabled(false);
                F1.setEnabled(false);
                F2.setEnabled(false);
                F3.setEnabled(false);
                F4.setEnabled(false);
                G1.setEnabled(false);
                G2.setEnabled(false);
                G3.setEnabled(false);
                G4.setEnabled(false);
            }
        });
        E1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = "E1";
                E1.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                selection.setText("Selected: E1");
                selection.setVisibility(View.VISIBLE);
                A2.setEnabled(false);
                A3.setEnabled(false);
                A4.setEnabled(false);
                B1.setEnabled(false);
                B2.setEnabled(false);
                B3.setEnabled(false);
                B4.setEnabled(false);
                C1.setEnabled(false);
                C2.setEnabled(false);
                C3.setEnabled(false);
                C4.setEnabled(false);
                D1.setEnabled(false);
                D2.setEnabled(false);
                D3.setEnabled(false);
                D4.setEnabled(false);
                A1.setEnabled(false);
                E2.setEnabled(false);
                E3.setEnabled(false);
                E4.setEnabled(false);
                F1.setEnabled(false);
                F2.setEnabled(false);
                F3.setEnabled(false);
                F4.setEnabled(false);
                G1.setEnabled(false);
                G2.setEnabled(false);
                G3.setEnabled(false);
                G4.setEnabled(false);
            }
        });E2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = "E2";
                E2.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                selection.setText("Selected: E2");
                selection.setVisibility(View.VISIBLE);
                A2.setEnabled(false);
                A3.setEnabled(false);
                A4.setEnabled(false);
                B1.setEnabled(false);
                B2.setEnabled(false);
                B3.setEnabled(false);
                B4.setEnabled(false);
                C1.setEnabled(false);
                C2.setEnabled(false);
                C3.setEnabled(false);
                C4.setEnabled(false);
                D1.setEnabled(false);
                D2.setEnabled(false);
                D3.setEnabled(false);
                D4.setEnabled(false);
                E1.setEnabled(false);
                A1.setEnabled(false);
                E3.setEnabled(false);
                E4.setEnabled(false);
                F1.setEnabled(false);
                F2.setEnabled(false);
                F3.setEnabled(false);
                F4.setEnabled(false);
                G1.setEnabled(false);
                G2.setEnabled(false);
                G3.setEnabled(false);
                G4.setEnabled(false);
            }
        });E3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = "E3";
                E3.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                selection.setText("Selected: E3");
                selection.setVisibility(View.VISIBLE);
                A2.setEnabled(false);
                A3.setEnabled(false);
                A4.setEnabled(false);
                B1.setEnabled(false);
                B2.setEnabled(false);
                B3.setEnabled(false);
                B4.setEnabled(false);
                C1.setEnabled(false);
                C2.setEnabled(false);
                C3.setEnabled(false);
                C4.setEnabled(false);
                D1.setEnabled(false);
                D2.setEnabled(false);
                D3.setEnabled(false);
                D4.setEnabled(false);
                E1.setEnabled(false);
                E2.setEnabled(false);
                A1.setEnabled(false);
                E4.setEnabled(false);
                F1.setEnabled(false);
                F2.setEnabled(false);
                F3.setEnabled(false);
                F4.setEnabled(false);
                G1.setEnabled(false);
                G2.setEnabled(false);
                G3.setEnabled(false);
                G4.setEnabled(false);
            }
        });E4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = "E4";
                E4.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                selection.setText("Selected: E4");
                selection.setVisibility(View.VISIBLE);
                A2.setEnabled(false);
                A3.setEnabled(false);
                A4.setEnabled(false);
                B1.setEnabled(false);
                B2.setEnabled(false);
                B3.setEnabled(false);
                B4.setEnabled(false);
                C1.setEnabled(false);
                C2.setEnabled(false);
                C3.setEnabled(false);
                C4.setEnabled(false);
                D1.setEnabled(false);
                D2.setEnabled(false);
                D3.setEnabled(false);
                D4.setEnabled(false);
                E1.setEnabled(false);
                E2.setEnabled(false);
                E3.setEnabled(false);
                A1.setEnabled(false);
                F1.setEnabled(false);
                F2.setEnabled(false);
                F3.setEnabled(false);
                F4.setEnabled(false);
                G1.setEnabled(false);
                G2.setEnabled(false);
                G3.setEnabled(false);
                G4.setEnabled(false);
            }
        });
        F1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = "F1";
                F1.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                selection.setText("Selected: F1");
                selection.setVisibility(View.VISIBLE);
                A2.setEnabled(false);
                A3.setEnabled(false);
                A4.setEnabled(false);
                B1.setEnabled(false);
                B2.setEnabled(false);
                B3.setEnabled(false);
                B4.setEnabled(false);
                C1.setEnabled(false);
                C2.setEnabled(false);
                C3.setEnabled(false);
                C4.setEnabled(false);
                D1.setEnabled(false);
                D2.setEnabled(false);
                D3.setEnabled(false);
                D4.setEnabled(false);
                E1.setEnabled(false);
                E2.setEnabled(false);
                E3.setEnabled(false);
                E4.setEnabled(false);
                A1.setEnabled(false);
                F2.setEnabled(false);
                F3.setEnabled(false);
                F4.setEnabled(false);
                G1.setEnabled(false);
                G2.setEnabled(false);
                G3.setEnabled(false);
                G4.setEnabled(false);
            }
        });
        F2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = "F2";
                F2.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                selection.setText("Selected: F2");
                selection.setVisibility(View.VISIBLE);
                A2.setEnabled(false);
                A3.setEnabled(false);
                A4.setEnabled(false);
                B1.setEnabled(false);
                B2.setEnabled(false);
                B3.setEnabled(false);
                B4.setEnabled(false);
                C1.setEnabled(false);
                C2.setEnabled(false);
                C3.setEnabled(false);
                C4.setEnabled(false);
                D1.setEnabled(false);
                D2.setEnabled(false);
                D3.setEnabled(false);
                D4.setEnabled(false);
                E1.setEnabled(false);
                E2.setEnabled(false);
                E3.setEnabled(false);
                E4.setEnabled(false);
                F1.setEnabled(false);
                A1.setEnabled(false);
                F3.setEnabled(false);
                F4.setEnabled(false);
                G1.setEnabled(false);
                G2.setEnabled(false);
                G3.setEnabled(false);
                G4.setEnabled(false);
            }
        });
        F3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = "F3";
                F3.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                selection.setText("Selected: F3");
                selection.setVisibility(View.VISIBLE);
                A2.setEnabled(false);
                A3.setEnabled(false);
                A4.setEnabled(false);
                B1.setEnabled(false);
                B2.setEnabled(false);
                B3.setEnabled(false);
                B4.setEnabled(false);
                C1.setEnabled(false);
                C2.setEnabled(false);
                C3.setEnabled(false);
                C4.setEnabled(false);
                D1.setEnabled(false);
                D2.setEnabled(false);
                D3.setEnabled(false);
                D4.setEnabled(false);
                E1.setEnabled(false);
                E2.setEnabled(false);
                E3.setEnabled(false);
                E4.setEnabled(false);
                F1.setEnabled(false);
                F2.setEnabled(false);
                A1.setEnabled(false);
                F4.setEnabled(false);
                G1.setEnabled(false);
                G2.setEnabled(false);
                G3.setEnabled(false);
                G4.setEnabled(false);
            }
        });
        F4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = "F4";
                F4.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                selection.setText("Selected: F4");
                selection.setVisibility(View.VISIBLE);
                A2.setEnabled(false);
                A3.setEnabled(false);
                A4.setEnabled(false);
                B1.setEnabled(false);
                B2.setEnabled(false);
                B3.setEnabled(false);
                B4.setEnabled(false);
                C1.setEnabled(false);
                C2.setEnabled(false);
                C3.setEnabled(false);
                C4.setEnabled(false);
                D1.setEnabled(false);
                D2.setEnabled(false);
                D3.setEnabled(false);
                D4.setEnabled(false);
                E1.setEnabled(false);
                E2.setEnabled(false);
                E3.setEnabled(false);
                E4.setEnabled(false);
                F1.setEnabled(false);
                F2.setEnabled(false);
                F3.setEnabled(false);
                A1.setEnabled(false);
                G1.setEnabled(false);
                G2.setEnabled(false);
                G3.setEnabled(false);
                G4.setEnabled(false);
            }
        });
        G1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = "G1";
                G1.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                selection.setText("Selected: G1");
                selection.setVisibility(View.VISIBLE);
                A2.setEnabled(false);
                A3.setEnabled(false);
                A4.setEnabled(false);
                B1.setEnabled(false);
                B2.setEnabled(false);
                B3.setEnabled(false);
                B4.setEnabled(false);
                C1.setEnabled(false);
                C2.setEnabled(false);
                C3.setEnabled(false);
                C4.setEnabled(false);
                D1.setEnabled(false);
                D2.setEnabled(false);
                D3.setEnabled(false);
                D4.setEnabled(false);
                E1.setEnabled(false);
                E2.setEnabled(false);
                E3.setEnabled(false);
                E4.setEnabled(false);
                F1.setEnabled(false);
                F2.setEnabled(false);
                F3.setEnabled(false);
                F4.setEnabled(false);
                A1.setEnabled(false);
                G2.setEnabled(false);
                G3.setEnabled(false);
                G4.setEnabled(false);
            }
        });
        G2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = "G2";
                G2.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                selection.setText("Selected: G2");
                selection.setVisibility(View.VISIBLE);
                A2.setEnabled(false);
                A3.setEnabled(false);
                A4.setEnabled(false);
                B1.setEnabled(false);
                B2.setEnabled(false);
                B3.setEnabled(false);
                B4.setEnabled(false);
                C1.setEnabled(false);
                C2.setEnabled(false);
                C3.setEnabled(false);
                C4.setEnabled(false);
                D1.setEnabled(false);
                D2.setEnabled(false);
                D3.setEnabled(false);
                D4.setEnabled(false);
                E1.setEnabled(false);
                E2.setEnabled(false);
                E3.setEnabled(false);
                E4.setEnabled(false);
                F1.setEnabled(false);
                F2.setEnabled(false);
                F3.setEnabled(false);
                F4.setEnabled(false);
                G1.setEnabled(false);
                A1.setEnabled(false);
                G3.setEnabled(false);
                G4.setEnabled(false);
            }
        });
        G3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = "G3";
                G3.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                selection.setText("Selected: G3");
                selection.setVisibility(View.VISIBLE);
                A2.setEnabled(false);
                A3.setEnabled(false);
                A4.setEnabled(false);
                B1.setEnabled(false);
                B2.setEnabled(false);
                B3.setEnabled(false);
                B4.setEnabled(false);
                C1.setEnabled(false);
                C2.setEnabled(false);
                C3.setEnabled(false);
                C4.setEnabled(false);
                D1.setEnabled(false);
                D2.setEnabled(false);
                D3.setEnabled(false);
                D4.setEnabled(false);
                E1.setEnabled(false);
                E2.setEnabled(false);
                E3.setEnabled(false);
                E4.setEnabled(false);
                F1.setEnabled(false);
                F2.setEnabled(false);
                F3.setEnabled(false);
                F4.setEnabled(false);
                G1.setEnabled(false);
                G2.setEnabled(false);
                A1.setEnabled(false);
                G4.setEnabled(false);
            }
        });
        G4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = "G4";
                G4.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                selection.setText("Selected: G4");
                selection.setVisibility(View.VISIBLE);
                A2.setEnabled(false);
                A3.setEnabled(false);
                A4.setEnabled(false);
                B1.setEnabled(false);
                B2.setEnabled(false);
                B3.setEnabled(false);
                B4.setEnabled(false);
                C1.setEnabled(false);
                C2.setEnabled(false);
                C3.setEnabled(false);
                C4.setEnabled(false);
                D1.setEnabled(false);
                D2.setEnabled(false);
                D3.setEnabled(false);
                D4.setEnabled(false);
                E1.setEnabled(false);
                E2.setEnabled(false);
                E3.setEnabled(false);
                E4.setEnabled(false);
                F1.setEnabled(false);
                F2.setEnabled(false);
                F3.setEnabled(false);
                F4.setEnabled(false);
                G1.setEnabled(false);
                G2.setEnabled(false);
                G3.setEnabled(false);
                A1.setEnabled(false);
            }
        });

    }

    private void confirmmessage(String x){
        name = etname.getText().toString().trim();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Important");
        builder.setMessage("Do you want to confirm "+x+" slot?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                progressDialog.setMessage("Please wait. Your slot is blooking.");
                progressDialog.show();
                entrytodatabase(name, result, place);
                startActivity(new Intent(Gate1Activity.this, BookedActivity.class));
                progressDialog.dismiss();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(Gate1Activity.this, MainActivity.class));
            }
        });
        if(x.equals(""))
        {
            Toast.makeText(this,"Please select the slot.",Toast.LENGTH_SHORT).show();
        }
        else if(name.isEmpty())
        {
            Toast.makeText(this,"Please enter your name.",Toast.LENGTH_SHORT).show();
        }
        else
            {
                builder.show();
            }
    }
    private void entrytodatabase(String name, String slot, String place){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myref = firebaseDatabase.getReference("Booking");
        DatabaseReference myref2 = firebaseDatabase.getReference("Gate 1");
        DatabaseReference personalref = firebaseDatabase.getReference(firebaseAuth.getUid());
        UserBooking userBooking = new UserBooking(slot, place);
        myref.child(name).setValue(userBooking);
        myref2.child(name).setValue(userBooking);
        personalref.child(name).setValue(userBooking);
    }
}
