package com.everteam.forumbuilder.utils;

import com.everteam.forumbuilder.R;
import com.everteam.forumbuilder.form.FormElement;
import com.everteam.forumbuilder.formobjects.ButtonFormObj;
import com.everteam.forumbuilder.formobjects.DateFormObj;
import com.everteam.forumbuilder.formobjects.MultiSelectionFormObj;
import com.everteam.forumbuilder.formobjects.TextFiledFormObj;
import com.everteam.forumbuilder.utils.KeyTypes;
import com.everteam.forumbuilder.viewholders.DateViewHolder;
import com.everteam.forumbuilder.viewholders.MultiSelectionFormViewHolder;
import com.everteam.forumbuilder.viewholders.SubmitButtonViewHolder;
import com.everteam.forumbuilder.viewholders.TextElementViewHolder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class JsonParser {

 public static ArrayList<FormElement> convertToFormElementArrayList(String jsonString, ButtonFormObj.ButtonListener buttonListener) throws JSONException {

     JSONArray jsonArray = new JSONArray(jsonString);

     ArrayList<FormElement>  formElements = new ArrayList<>();

     int length = jsonArray.length();

        for(int i = 0; i < jsonArray.length(); i++){

            JSONObject  jsonObject =   (JSONObject) jsonArray.get(i);

            Iterator<String> keys = jsonObject.keys();

            String type =  jsonObject.getString("type");
            String id, hint, label, inputType, btnCancel, btnSelection,
                    span,incomingFormat,dateFormat,timeFormat,date;

            boolean required, isMulti;
            JSONArray selectionsJOnArray;
            switch (type){
                case "text":
                     id        = getStringOrDefault(jsonObject, "id", "0");
                     hint      = getStringOrDefault(jsonObject,"hint","");
                     label     = getStringOrDefault(jsonObject,"label", "");
                     required = getBooleanOrDefault(jsonObject,"required");
                     inputType = getStringOrDefault(jsonObject,"keyboardType", "");
                     span = getStringOrDefault(jsonObject,"span","4");

                    FormElement formElement = new FormElement(
                            TextElementViewHolder.class,
                            new TextFiledFormObj(
                                    id,
                                    label,
                                    hint,
                                    required,
                                    null,
                                    KeyTypes.getKeyType(inputType)
                                    ),
                            R.layout.text_element_layout,
                            Integer.parseInt(span)
                    );

                    formElements.add(formElement);

                    break;

                    case "select":
                         id           = getStringOrDefault(jsonObject, "id", "0");
                         hint         = getStringOrDefault(jsonObject,"hint","");
                         label        = getStringOrDefault(jsonObject,"label", "");
                         required     = getBooleanOrDefault(jsonObject,"required");
                         isMulti      = getBooleanOrDefault(jsonObject,"isMulti");
                         btnCancel    = getStringOrDefault(jsonObject,"btnCancel", "cancel");
                         btnSelection = getStringOrDefault(jsonObject,"btnSelection", "select");
                         selectionsJOnArray   = jsonObject.getJSONArray("selections");
                         span = getStringOrDefault(jsonObject,"span","4");

                        ArrayList<String> selectionValues = new ArrayList<>();

                        for(int selectionIndex=0 ; selectionIndex < selectionsJOnArray.length(); selectionIndex++)
                        {
                            JSONObject selectionObject = (JSONObject) selectionsJOnArray.get(selectionIndex);

                            selectionValues.add(selectionObject.getString("value"));
                        }


                        FormElement multiSelectFormElement = new FormElement(
                                MultiSelectionFormViewHolder.class,
                                new MultiSelectionFormObj(
                                        id,
                                        label,
                                        required,
                                        isMulti,
                                        selectionValues,
                                        null

                                ),
                                R.layout.multiple_selection_layout,
                                Integer.parseInt(span)
                        );

                        formElements.add(multiSelectFormElement);

                        break;
                case "button":
                        id           = getStringOrDefault(jsonObject, "id", "0");
                        label        = getStringOrDefault(jsonObject,"label", "");
                        span = getStringOrDefault(jsonObject,"span","4");

                        FormElement buttonFormElemet = new FormElement(
                                SubmitButtonViewHolder.class,
                                new ButtonFormObj(id, buttonListener, label,"a", null),
                                R.layout.button_layout,
                                Integer.parseInt(span)
                        );

                        formElements.add(buttonFormElemet);
                        break;

                case "date":

                    id             = getStringOrDefault(jsonObject, "id", "0");
                    label          = getStringOrDefault(jsonObject,"label", "");
                    incomingFormat = getStringOrDefault(jsonObject,"incomingFormat", "dd-MM-yyyy");
                    dateFormat     = getStringOrDefault(jsonObject,"dateFormat", "");
                    timeFormat     = getStringOrDefault(jsonObject,"dateFormat", "");
                    span           = getStringOrDefault(jsonObject,"span","4");
                    date           = getStringOrDefault(jsonObject, "date", ""/*String.valueOf(System.currentTimeMillis())*/);


                    FormElement dateFormElement = new FormElement(
                            DateViewHolder.class,
                            new DateFormObj(id,label,null, date ,dateFormat, timeFormat, incomingFormat),
                            R.layout.multiple_selection_layout,
                            Integer.parseInt(span)
                    );

                    formElements.add(dateFormElement);
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
