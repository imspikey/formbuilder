package com.everteam.forumbuilder.form;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import com.everteam.forumbuilder.utils.JsonParser;
import com.everteam.forumbuilder.MainActivity;
import com.everteam.forumbuilder.formobjects.ButtonFormObj;
import org.json.JSONException;
import java.util.ArrayList;

public class FormManager implements ButtonFormObj.ButtonListener{

    private  RecyclerView recyclerView;

    private RecyclerView.LayoutManager layoutManager;
    ArrayList<FormElement> formElements;
    Context context;

    public FormManager(RecyclerView.LayoutManager layoutManager,Context mainActivity,ArrayList<FormElement> formElements){
        this.formElements = formElements;
        this.context = mainActivity;
        this.layoutManager = layoutManager;
    }

    public FormManager(RecyclerView.LayoutManager layoutManager, MainActivity mainActivity, RecyclerView recyclerView, String jsonElements){
        this.formElements  = createFormElements(jsonElements);
        this.context       = mainActivity;
        this.layoutManager = layoutManager;
        this.recyclerView  = recyclerView;
        createForm();
    }

    private void createForm() {

        ((GridLayoutManager)layoutManager).setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int i) {
                return  formElements.get(i).getSpan();
            }
        });
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new FormAdapter(formElements));
    }

    Pair<Boolean, String> isFormValid(){
        Pair<Boolean, String> message = new Pair<>(true,"Under Construction");
        return message;
    }


    ArrayList<FormElement> createFormElements(String jsonArrayString){
        try {
            return JsonParser.convertToFormElementArrayList(jsonArrayString,this);
        } catch (JSONException e) {
            e.printStackTrace();
            return  null;
        }
    }

    //todo ...
    @Override
    public void clicked() {
        ((ButtonFormObj.ButtonListener) context).clicked();
    }
}
