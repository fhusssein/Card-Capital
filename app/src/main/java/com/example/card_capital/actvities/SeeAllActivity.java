/*
        Final Project: Mobile Application 2
        SeeAllActivity
        Created by: Faisal Hussein
        Date: 12/12/2021*/
package com.example.card_capital.actvities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.card_capital.R;
import com.example.card_capital.adapter.SeeAllAdapter;
import com.example.card_capital.models.SeeAllModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class SeeAllActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SeeAllAdapter seeAllAdapter;
    List<SeeAllModel> seeAllModelList;

    Toolbar toolbar;

    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);

        //Toolbar
        toolbar = findViewById(R.id.see_all_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        String type = getIntent().getStringExtra("type");

        firestore = FirebaseFirestore.getInstance();

        recyclerView = findViewById(R.id.show_all_rec);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        seeAllModelList = new ArrayList<>();
        seeAllAdapter = new SeeAllAdapter(this,seeAllModelList);
        recyclerView.setAdapter(seeAllAdapter);



        if(type == null || type.isEmpty()){
            firestore.collection("SeeAll")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {

                            if(task.isSuccessful()){
                                for (DocumentSnapshot document : task.getResult().getDocuments()){

                                    SeeAllModel seeAllModel = document.toObject(SeeAllModel.class);
                                    seeAllModelList.add(seeAllModel);
                                    seeAllAdapter.notifyDataSetChanged();

                                }
                            }
                        }
                    });
        }
        if (type !=null && type.equalsIgnoreCase("mBooster")){
            firestore.collection("SeeAll").whereEqualTo("type","mBooster")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {

                            if(task.isSuccessful()){
                                for (DocumentSnapshot document : task.getResult().getDocuments()){

                                    SeeAllModel seeAllModel = document.toObject(SeeAllModel.class);
                                    seeAllModelList.add(seeAllModel);
                                    seeAllAdapter.notifyDataSetChanged();

                                }
                            }
                        }
                    });
        } if (type !=null && type.equalsIgnoreCase("eBooster")){
            firestore.collection("SeeAll").whereEqualTo("type","eBooster")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {

                            if(task.isSuccessful()){
                                for (DocumentSnapshot document : task.getResult().getDocuments()){

                                    SeeAllModel seeAllModel = document.toObject(SeeAllModel.class);
                                    seeAllModelList.add(seeAllModel);
                                    seeAllAdapter.notifyDataSetChanged();

                                }
                            }
                        }
                    });
        } if (type !=null && type.equalsIgnoreCase("rBooster")){
            firestore.collection("SeeAll").whereEqualTo("type","rBooster")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {

                            if(task.isSuccessful()){
                                for (DocumentSnapshot document : task.getResult().getDocuments()){

                                    SeeAllModel seeAllModel = document.toObject(SeeAllModel.class);
                                    seeAllModelList.add(seeAllModel);
                                    seeAllAdapter.notifyDataSetChanged();

                                }
                            }
                        }
                    });
        } if (type !=null && type.equalsIgnoreCase("sBooster")){
            firestore.collection("SeeAll").whereEqualTo("type","sBooster")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {

                            if(task.isSuccessful()){
                                for (DocumentSnapshot document : task.getResult().getDocuments()){

                                    SeeAllModel seeAllModel = document.toObject(SeeAllModel.class);
                                    seeAllModelList.add(seeAllModel);
                                    seeAllAdapter.notifyDataSetChanged();

                                }
                            }
                        }
                    });
        } if (type !=null && type.equalsIgnoreCase("tDeck")){
            firestore.collection("SeeAll").whereEqualTo("type","tDeck")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {

                            if(task.isSuccessful()){
                                for (DocumentSnapshot document : task.getResult().getDocuments()){

                                    SeeAllModel seeAllModel = document.toObject(SeeAllModel.class);
                                    seeAllModelList.add(seeAllModel);
                                    seeAllAdapter.notifyDataSetChanged();

                                }
                            }
                        }
                    });
        }

    }
}