package com.example.carparking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

public class AboutActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.back: {
                startActivity(new Intent(AboutActivity.this, MainActivity.class));
                return true;
            }
            case R.id.logoutmenu2:{
                logoutfunct();
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void logoutfunct(){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(AboutActivity.this, LoginActivity.class));
    }
}
