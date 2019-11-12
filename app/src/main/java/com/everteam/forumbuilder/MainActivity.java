package com.everteam.forumbuilder;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ButtonFormObj.ButtonListener {

    List<FormElement> formElements = new ArrayList<>();
    RecyclerView rView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        formElements.add(new FormElement(
                TextElementViewHolder.class,
                new TextFiledFormObj(0, "First Text", "cool",true,null),
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
        
        formElements.add(new FormElement(
                MultiSelectionFormViewHolder.class,
                new MultiSelectionFormObj(
                        0,
                        "Second Text",
                        true,
                        false,
                        null,
                        null),
                R.layout.multiple_selection_layout));

        formElements.add(new FormElement(
                SubmitButtonViewHolder.class,
                new ButtonFormObj(
                        10,
                        this,
                        "Submit"),
                R.layout.button_layout));

        rView = findViewById(R.id.recyclerView);

        rView.setLayoutManager( new LinearLayoutManager(this));
        rView.setAdapter(new FormAdapter(formElements));
    }

    @Override
    public void clicked() {
        (formElements.get(0).getBaseFormObject()).setBaseThemeConfig(new TextFiledThemeConfig.Builder().
                setBackgroundColor(Color.YELLOW).setTextColor(Color.WHITE).build());

        ((FormAdapter)rView.getAdapter()).getButtonThemeConfig().setBackgroundColor(Color.GRAY);
        rView.getAdapter().notifyDataSetChanged();
    }
}
