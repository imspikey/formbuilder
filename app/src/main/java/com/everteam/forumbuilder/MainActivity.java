package com.everteam.forumbuilder;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ButtonFormObj.ButtonListener {

    List<FormElement> formElements = new ArrayList<>();
    RecyclerView rView;
    private FormManager mFormManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

                formElements.add(new FormElement(
                TextElementViewHolder.class,
                new TextFiledFormObj(
                        "0",
                        "First Text",
                        "cool",
                        true,
                        null,
                        InputType.TYPE_CLASS_TEXT),
                        R.layout.text_element_layout));

        formElements.add(new FormElement(
                MultiSelectionFormViewHolder.class,
                new MultiSelectionFormObj(
                        "0",
                        "First Text",
                        true,
                        true,
                        null,
                        null),
                R.layout.multiple_selection_layout));
        
        formElements.add(new FormElement(
                MultiSelectionFormViewHolder.class,
                new MultiSelectionFormObj(
                        "0",
                        "Second Text",
                        true,
                        false,
                        null,
                        null),
                R.layout.multiple_selection_layout));

        formElements.add(new FormElement(
                SubmitButtonViewHolder.class,
                new ButtonFormObj(
                        "10",
                        this,
                        "Submit"),
                R.layout.button_layout));


        InputStream is = getResources().openRawResource(R.raw.jason_file);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String jsonString = writer.toString();

        rView = findViewById(R.id.recyclerView);

        mFormManager = new FormManager(new LinearLayoutManager(this),this, rView ,jsonString);
    }

    @Override
    public void clicked() {
        (formElements.get(0).getBaseFormObject()).setBaseThemeConfig(new TextFiledThemeConfig.Builder().
                setBackgroundColor(Color.YELLOW).setTextColor(Color.WHITE).build());

        ((FormAdapter)rView.getAdapter()).getButtonThemeConfig().setBackgroundColor(Color.GRAY);
        rView.getAdapter().notifyDataSetChanged();
    }
}
