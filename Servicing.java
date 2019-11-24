package com.example.electroserv;

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

public class Servicing extends AppCompatActivity {
    Spinner Repairingcateg,repairingparts;
    TextView display;
    String[] categories={"Television","Refrigerator"};
    String[] partsmaint1={"Cathode Ray Tube","Light valve","Logic Board","Capacitors","Screen,Output", "Speaker"};
    String[] partsmaint2={"All parts","Insulation","Outer cabinet and door","Inner cabinet","Bulb","Evaporator","Thermostat","Condenser","Refrigerant/Cooling fluid","Expansive valve/capillary","Defrost system","Switch","Crisper"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicing);
        Repairingcateg=findViewById(R.id.repairdrop);
        repairingparts=findViewById(R.id.partsrepid);
        display=findViewById(R.id.storeid1);
        ArrayAdapter<String> myAdapter2=new ArrayAdapter<String>(Servicing.this, android.R.layout.simple_spinner_item,categories);
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Repairingcateg.setAdapter(myAdapter2);
        Repairingcateg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemselect=categories[position];
                Toast.makeText(Servicing.this, "Select Item:"+itemselect, Toast.LENGTH_SHORT).show();
                if (position==0){
                    ArrayAdapter<String> myAdapter3=new ArrayAdapter<String>(Servicing.this, android.R.layout.simple_spinner_item,partsmaint1);
                    myAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    repairingparts.setAdapter(myAdapter3);
                    repairingparts.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            String itemselects=partsmaint1[position];
                            display.setText(itemselects);

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            Toast.makeText(Servicing.this, "Select item", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else
                {
                    ArrayAdapter<String> myAdapter4=new ArrayAdapter<String>(Servicing.this, android.R.layout.simple_spinner_item,partsmaint2);
                    myAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    repairingparts.setAdapter(myAdapter4);
                    repairingparts.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            String itemselects=partsmaint2[position];
                            display.setText(itemselects);

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            Toast.makeText(Servicing.this, "Select item", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Servicing.this, "Select item", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
