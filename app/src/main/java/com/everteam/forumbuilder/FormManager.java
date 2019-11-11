package com.everteam.forumbuilder;

import android.content.Context;
import android.util.Pair;

import java.util.ArrayList;

public class FormManager implements ButtonFormObj.ButtonListener{

    ArrayList<FormElement> formElements;
    Context context;
    FormManager(ArrayList<FormElement> formElements){
        this.formElements = formElements;
    }


    Pair<Boolean, String> isFormValid(){
        Pair<Boolean, String> message = new Pair<>(true,"Under Construction");
        return message;
    }


    void createFormElements(String jsonArrayString){

    }

    //todo ...
    @Override
    public void clicked() {
        ((ButtonFormObj.ButtonListener) context).clicked();
    }
}
