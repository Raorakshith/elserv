package com.example.electroserv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

public class Maintenance extends AppCompatActivity {
    Spinner category,maintenanaceparts;
    Button see;
    TextView display;
    String[] categories={"Television","Refrigerator"};
    String[] partsmaint={"All parts","Cathode Ray Tube","Light valve","Logic Board","Capacitors","Screen,Output", "Speaker"};
    String[] partsmaint1={"All parts","Insulation","Outer cabinet and door","Inner cabinet","Bulb","Evaporator","Thermostat","Condenser","Refrigerant/Cooling fluid","Expansive valve/capillary","Defrost system","Switch","Crisper"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenance);
display=findViewById(R.id.storeid1);
        category = findViewById(R.id.category);
        maintenanaceparts = findViewById(R.id.maintpart);

        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(Maintenance.this, android.R.layout.simple_spinner_item, categories);
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(myAdapter2);
        category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemselect = categories[position];
                Toast.makeText(Maintenance.this, "Select Item:" + itemselect, Toast.LENGTH_SHORT).show();
                if (position == 0) {
                    ArrayAdapter<String> myAdapter3 = new ArrayAdapter<String>(Maintenance.this, android.R.layout.simple_spinner_item, partsmaint);
                    myAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    maintenanaceparts.setAdapter(myAdapter3);
                    maintenanaceparts.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            String itemselects=partsmaint[position];
                            display.setText(itemselects);

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            Toast.makeText(Maintenance.this, "Select item", Toast.LENGTH_SHORT).show();
                        }
                    });

                } else {
                    ArrayAdapter<String> myAdapter4 = new ArrayAdapter<String>(Maintenance.this, android.R.layout.simple_spinner_item, partsmaint1);
                    myAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    maintenanaceparts.setAdapter(myAdapter4);
                    maintenanaceparts.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            String itemselects=partsmaint1[position];
                            display.setText(itemselects);

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            Toast.makeText(Maintenance.this, "Select item", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Maintenance.this, "Select item", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
