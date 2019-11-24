package com.example.electroserv;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {
    EditText resetemail;
    Button resetpassword;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        resetemail=findViewById(R.id.resetemailid);
        resetpassword=findViewById(R.id.resetpassid);
        mAuth=FirebaseAuth.getInstance();
        resetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String useremail=resetemail.getText().toString().trim();
                if(useremail.equals("")){
                    Toast.makeText(ForgotPassword.this, "Enter the email id", Toast.LENGTH_SHORT).show();
                }else{
                    mAuth.sendPasswordResetEmail(useremail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(ForgotPassword.this, "Password reset email sent", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),LogIn.class);
                                startActivity(intent);
                            } else{
                                Toast.makeText(ForgotPassword.this, "Error occurred", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}
