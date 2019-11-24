package com.example.electroserv;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SellerForm extends AppCompatActivity {
    EditText sellername,workname,address,pannumber,gstnumber,adharnumber;

    TextView areaservicing;
    CheckBox homeservyes,homeservno,wareyes,wareno;
    Button finish,place;
    Spinner waredropdown;
    String[] add={"Warehouse building,Mankoli Naka ,Dapoda,Bhiwandi,Thane-421302"};
    DatabaseReference mRef;
    int PLACE_PICKER_REQUEST=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_form);
        mRef=FirebaseDatabase.getInstance().getReference();
        sellername=findViewById(R.id.nameid);
        place=findViewById(R.id.placepickerid);
        workname=findViewById(R.id.workid);
        address=findViewById(R.id.addressid);
        pannumber=findViewById(R.id.pannumberid);
        gstnumber=findViewById(R.id.gstnumberid);
        adharnumber=findViewById(R.id.adharnumberid);
        areaservicing=findViewById(R.id.areaservicingid);
        homeservyes=findViewById(R.id.homeyesid);
        homeservno=findViewById(R.id.homenoid);
        waredropdown=findViewById(R.id.category);
        wareyes=findViewById(R.id.wareyesid);
        wareno=findViewById(R.id.wareyesno);
        finish=findViewById(R.id.submitid);
        areaservicing.setEnabled(false);
        waredropdown.setEnabled(false);
        place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlacePicker.IntentBuilder builder=new PlacePicker.IntentBuilder();
                try {
                    startActivityForResult(builder.build(SellerForm.this),PLACE_PICKER_REQUEST);
                }catch (GooglePlayServicesRepairableException e){
                    e.printStackTrace();
                }catch (GooglePlayServicesNotAvailableException e){
                    e.printStackTrace();
                }

            }
        });
        wareyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (wareyes.isChecked()){
                    waredropdown.setEnabled(true);
                    return;
                }

            }
        });
        wareno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wareno.isChecked()){
                    waredropdown.setEnabled(false);
                    return;
                }
            }
        });
        homeservyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(homeservyes.isChecked()){
                    areaservicing.setEnabled(true);
                }
            }
        });
        homeservno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(homeservno.isChecked()){
                    areaservicing.setEnabled(false);
                }
            }
        });
        ArrayAdapter<String> myAdapter2=new ArrayAdapter<String>(SellerForm.this, android.R.layout.simple_spinner_item,add);
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        waredropdown.setAdapter(myAdapter2);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                adddata();

            }
        });
    }
    private void adddata() {
        String sellernames=sellername.getText().toString().trim();
        String workarea=workname.getText().toString().trim();
        String addressess=address.getText().toString().trim();
        String pannumbers=pannumber.getText().toString().trim();
        String gstnumbers=gstnumber.getText().toString().trim();
        String adharnumbers=adharnumber.getText().toString().trim();

        String drop=waredropdown.getSelectedItem().toString();
        if(!TextUtils.isEmpty(sellernames)&&!TextUtils.isEmpty(workarea)&&!TextUtils.isEmpty(addressess)&&!TextUtils.isEmpty(pannumbers)&&!TextUtils.isEmpty(gstnumbers)&&!TextUtils.isEmpty(adharnumbers)) {
            String id = mRef.push().getKey();
            Sell sell = new Sell(id, sellernames, workarea, addressess, pannumbers, gstnumbers, adharnumbers,drop);
            mRef.child(id).setValue(sell);
            Toast.makeText(this, "Details added successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), Category.class);
            startActivity(intent);

        }
        else{
            Toast.makeText(this, "All the fields are mandatory", Toast.LENGTH_SHORT).show();

        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==PLACE_PICKER_REQUEST){
            if (resultCode==RESULT_OK){
                Place place=PlacePicker.getPlace(data,this);
                StringBuilder stringBuilder=new StringBuilder();
                String Latitude=String.valueOf(place.getLatLng().latitude);
                String Longitude= String.valueOf(place.getLatLng().longitude);
                stringBuilder.append("LATITUDE:");
                stringBuilder.append(Latitude);
                stringBuilder.append("/n");
                stringBuilder.append("LONGITUDE:");
                stringBuilder.append(Longitude);
                areaservicing.setText(stringBuilder.toString());


            }
        }
    }
}
