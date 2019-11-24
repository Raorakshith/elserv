package com.example.electroserv;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogIn extends AppCompatActivity {
    TextView resetp;
    EditText phoneemail,password;
    Button login;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        mAuth=FirebaseAuth.getInstance();
        phoneemail=findViewById(R.id.enterphoneemailid);
        password=findViewById(R.id.enterpass);
        login=findViewById(R.id.loginid);
        resetp=findViewById(R.id.reset);
        resetp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ForgotPassword.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SignInAccount();

            }
        });
    }
    private void SignInAccount() {
        String email=phoneemail.getText().toString();
        String pass=password.getText().toString();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please write your email...", Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(pass)){
            Toast.makeText(this, "Please write your password...", Toast.LENGTH_SHORT).show();
        }else{
            mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        SendUserTodetails();
                        Toast.makeText(LogIn.this, "Successful LogIn", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        String message=task.getException().getMessage();
                        Toast.makeText(LogIn.this, "Error occured"+message, Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    private void SendUserTodetails() {
        Intent intent=new Intent(LogIn.this,SellerForm.class);
        startActivity(intent);
    }
}
