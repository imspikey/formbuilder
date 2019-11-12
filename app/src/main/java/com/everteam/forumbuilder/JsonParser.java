package com.everteam.forumbuilder;

import android.util.JsonReader;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class JsonParser {

    ArrayList<FormElement> convertToFormElementArrayList(String jsonString) throws JSONException {

        JSONObject jsonReader = new JSONObject(jsonString);

        for(int i = 0; i < jsonReader.length(); i++){

        }

        return  null;
    }
}
