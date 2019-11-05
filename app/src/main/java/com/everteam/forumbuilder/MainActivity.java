package com.everteam.forumbuilder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<FormElement> formElements = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i  = 0; i < 300  ; i++)
        formElements.add(new FormElement(
                TextElementViewHolder.class,
                new TextFiledFormObj(0,"First Text" + i,"cool" + i,true),
                R.layout.text_element_layout));

        RecyclerView rView = findViewById(R.id.recyclerView);

        rView.setLayoutManager( new LinearLayoutManager(this));
        rView.setAdapter(new FormAdapter(formElements));
    }
}
