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


        formElements.add(new FormElement(
                TextElementViewHolder.class,
                new TextFiledFormObj(0, "First Text", "cool",true),
                R.layout.text_element_layout));
        formElements.add(new FormElement(
                MultiSelectionFormViewHolder.class,
                new MultiSelectionFormObj(
                        0,
                        "First Text",
                        true,
                        true,
                        null,
                        null),
                R.layout.multiple_selection_layout));

        RecyclerView rView = findViewById(R.id.recyclerView);

        rView.setLayoutManager( new LinearLayoutManager(this));
        rView.setAdapter(new FormAdapter(formElements));
    }
}
