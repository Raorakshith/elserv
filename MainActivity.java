package com.example.electroserv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText regphoneemail;
    Button submitreg;
    TextView already;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        regphoneemail = findViewById(R.id.phoneemailreg);
        already=findViewById(R.id.already);
        submitreg = findViewById(R.id.submitreg);
        already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,LogIn.class);
                startActivity(intent);
            }
        });
        submitreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number="+91"+regphoneemail.getText().toString().trim();
                if(number.isEmpty()|| number.length()<11) {
                    regphoneemail.setError("Number is required");
                    regphoneemail.requestFocus();
                    return;
                }
                Intent intent=new Intent(getApplicationContext(),Verify.class);
                intent.putExtra("phonenumber",number);
                startActivity(intent);



            }
        });

    }
}
