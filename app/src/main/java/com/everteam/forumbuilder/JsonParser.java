package com.everteam.forumbuilder;

import com.everteam.forumbuilder.utils.KeyTypes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Iterator;

class JsonParser {

 public static ArrayList<FormElement> convertToFormElementArrayList(String jsonString) throws JSONException {

     JSONArray jsonArray = new JSONArray(jsonString);

     ArrayList<FormElement>  formElements = new ArrayList<>();

     int length = jsonArray.length();

        for(int i = 0; i < jsonArray.length(); i++){

            JSONObject  jsonObject =   (JSONObject) jsonArray.get(i);

            Iterator<String> keys = jsonObject.keys();

            String type =  jsonObject.getString("type");

            switch (type){
                case "text":
                    String id        = getStringOrDefault(jsonObject, "id", "0");
                    String hint      = getStringOrDefault(jsonObject,"hint","");
                    String label     = getStringOrDefault(jsonObject,"label", "");
                    boolean required = getBooleanOrDefault(jsonObject,"required");
                    String inputType = getStringOrDefault(jsonObject,"keyboardType", "");

                    FormElement formElement = new FormElement(
                            TextElementViewHolder.class,
                            new TextFiledFormObj(
                                    Integer.parseInt(id),
                                    label,
                                    hint,
                                    required,
                                    null,
                                    KeyTypes.getKeyType(inputType)
                                    ),
                            R.layout.text_element_layout
                    );

                    formElements.add(formElement);

                    break;
            }
        }

        return  formElements;
    }

    private static String getStringOrDefault(JSONObject jsonObject, String key, String def) {

        try {
            return     jsonObject.getString(key);
        } catch (JSONException e) {
            return def;
        }
    }

    private static boolean getBooleanOrDefault(JSONObject jsonObject, String key) {

        try {
          return   jsonObject.getBoolean(key);
        } catch (JSONException e) {

            return false;
        }
    }
}
