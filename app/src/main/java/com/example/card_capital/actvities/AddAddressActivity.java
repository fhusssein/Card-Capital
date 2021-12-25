/*
        Final Project: Mobile Application 2
        AddAddressActivity
        Created by: Faisal Hussein
        Date: 12/12/2021*/
package com.example.card_capital.actvities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.card_capital.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddAddressActivity extends AppCompatActivity {

    EditText name, address, city, postalCode, phoneNumber;
    Toolbar toolbar;
    Button addAddressBtn;

    FirebaseAuth auth;
    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);

        toolbar = findViewById(R.id.add_address_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        name = findViewById(R.id.ad_name);
        address = findViewById(R.id.ad_address);
        city = findViewById(R.id.ad_city);
        postalCode = findViewById(R.id.ad_code);
        phoneNumber = findViewById(R.id.ad_phone);
        addAddressBtn = findViewById(R.id.ad_add_address);

        addAddressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = name.getText().toString();
                String userAddress = address.getText().toString();
                String userCity = city.getText().toString();
                String userCode = postalCode.getText().toString();
                String userPhone = phoneNumber.getText().toString();

                String finalAddress = "";

                if (!userName.isEmpty()){
                    finalAddress +=userName+" ";
                }
                if(!userAddress.isEmpty()){
                    finalAddress +=userAddress+" ";
                }
                if(!userCity.isEmpty()){
                    finalAddress+=userCity+" ";
                }
                if(!userCode.isEmpty()){
                    finalAddress+=userCode+" ";
                }
                if(!userPhone.isEmpty()){
                    finalAddress+=userPhone;
                }
                if(!userName.isEmpty()&&!userAddress.isEmpty()&&!userCode.isEmpty()&&!userCity.isEmpty()&&!userPhone.isEmpty()) {
                    Map<String, String> map = new HashMap<>();
                    map.put("userAddress", finalAddress);

                    firestore.collection("CurrentUser").document(auth.getCurrentUser().getUid())
                            .collection("Address").add(map).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentReference> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(AddAddressActivity.this, "Address Added", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else{
                    Toast.makeText(AddAddressActivity.this, "Please Fill All Fields", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}