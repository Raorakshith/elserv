package com.example.electroserv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Category extends AppCompatActivity {
    Button Maintenance,Servicing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Maintenance=findViewById(R.id.maintenance);
        Servicing=findViewById(R.id.servicing);

        Maintenance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Maintenance.class);
                startActivity(intent);
            }
        });
        Servicing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Servicing.class);
                startActivity(intent);
            }
        });
    }
}
