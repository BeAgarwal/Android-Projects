package com.example.carparking;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private TextView login;
    private EditText username, useremail, userPassword, userConfirmPassword, userAge;
    private Button regButton;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    String eml, name, age, pass, cnfpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setupUI();

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);


        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    String user_email = useremail.getText().toString().trim();
                    String user_password = userPassword.getText().toString().trim();
                    progressDialog.setMessage("Your details are uploading to our database.");
                    progressDialog.show();

                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {
                                sendUserData();
                                progressDialog.dismiss();
                                Toast.makeText(RegisterActivity.this, "Registration Successful.", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                            }
                            else{
                                progressDialog.dismiss();
                                Toast.makeText(RegisterActivity.this, "Something went wrong.",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
    }
    private void setupUI(){
        username = (EditText)findViewById(R.id.etUserName);
        useremail = (EditText)findViewById(R.id.etEmail);
        userPassword = (EditText)findViewById(R.id.etPassword);
        userConfirmPassword = (EditText)findViewById(R.id.etConfirmPassword);
        login = (TextView)findViewById(R.id.tvlogin);
        userAge = (EditText)findViewById(R.id.etAge);
        regButton = (Button)findViewById(R.id.btnregister);
    }

    private Boolean validate(){
        Boolean result = false;
        name = username.getText().toString();
        pass = userPassword.getText().toString();
        cnfpass = userConfirmPassword.getText().toString();
        eml = useremail.getText().toString();
        age = userAge.getText().toString();
        if(name.isEmpty() || pass.isEmpty() || eml.isEmpty() || cnfpass.isEmpty() || age.isEmpty()){
            Toast.makeText(this, "Please enter all the details.",Toast.LENGTH_SHORT).show();
            result = false;
        }
        else if(!pass.equals(cnfpass)){
            Toast.makeText(this, "Password doesn't match.",Toast.LENGTH_SHORT).show();
            result = false;
        }
        else if(pass.length()<6) {
            Toast.makeText(this, "Password should have minimum 6 characters.",Toast.LENGTH_SHORT).show();
            result = false;
        }
        else {
            result = true;
        }
        return result;
    }

    private void sendUserData(){
        name = username.getText().toString();
        eml = useremail.getText().toString();
        age = userAge.getText().toString();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myref = firebaseDatabase.getReference("Account");
        UserProfile userProfile = new UserProfile(name, eml, age);
        myref.setValue(userProfile);
    }

}
