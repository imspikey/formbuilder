package com.everteam.forumbuilder.utils;

import android.graphics.Color;

import com.android.volley.toolbox.JsonObjectRequest;
import com.everteam.forumbuilder.R;
import com.everteam.forumbuilder.form.FormElement;
import com.everteam.forumbuilder.formobjects.ButtonFormObj;
import com.everteam.forumbuilder.formobjects.DateFormObj;
import com.everteam.forumbuilder.formobjects.FormJasonObjectsContainer;
import com.everteam.forumbuilder.formobjects.MultiSelectionFormObj;
import com.everteam.forumbuilder.formobjects.TextFiledFormObj;
import com.everteam.forumbuilder.themeconfigs.ButtonThemeConfig;
import com.everteam.forumbuilder.themeconfigs.DateThemeConfig;
import com.everteam.forumbuilder.themeconfigs.TextFiledThemeConfig;
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
import java.util.Iterator;

public class JsonParser {

 public static FormJasonObjectsContainer convertToFormElementArrayList(String jsonString,
                                                                       ButtonFormObj.ButtonListener buttonListener,
                                                                       int layoutSpanCount) throws JSONException {

     JSONObject formJsonObject = new JSONObject(jsonString);
     JSONObject styles = formJsonObject .getJSONObject("styles");

     ///
     JSONObject textFieldsStyle = styles.getJSONObject("textFieldsStyle");
     String textFiledLableColor = getStringOrDefault(textFieldsStyle,"labelColor","#ffff");
     String textFiledTextColor = getStringOrDefault(textFieldsStyle,"textFieldTextColor","#ffff");

     TextFiledThemeConfig textFiledThemeConfig = new TextFiledThemeConfig.Builder().
             setLableColor(Color.parseColor(textFiledLableColor)).
             setTextColor(Color.parseColor(textFiledTextColor)).build();

     ///
     JSONObject dateFieldsStyle = styles.getJSONObject("dateFieldsStyle");

     String dateColor = getStringOrDefault(dateFieldsStyle, "dateColor", "#ffff");
     String dateLabelColor = getStringOrDefault(dateFieldsStyle, "labelColor", "#ffff");

     DateThemeConfig dateThemeConfig = new DateThemeConfig.Builder().
             setDateColor(Color.parseColor(dateColor)).setLableColor(Color.parseColor(dateLabelColor))
            .build();

////
     JSONObject buttonFiledStyle = styles.getJSONObject("buttonsStyle");

     String buttonTextColor = getStringOrDefault(buttonFiledStyle, "textColor", "#FFFFF");
     String backgroundColor = getStringOrDefault(buttonFiledStyle, "backgroundColor", "#00000");

     ButtonThemeConfig buttonThemeConfig = new ButtonThemeConfig.Builder().
                                               setTextColor(Color.parseColor(buttonTextColor)).
     setBackgroundColor(Color.parseColor(backgroundColor)).build();






     JSONObject buttonsStyle    = styles.getJSONObject("buttonsStyle");

     JSONArray jsonArray = formJsonObject.getJSONArray("elements");

     ArrayList<FormElement>  formElements = new ArrayList<>();

     int length = jsonArray.length();

        for(int i = 0; i < jsonArray.length(); i++){

            JSONObject  jsonObject =   (JSONObject) jsonArray.get(i);

            Iterator<String> keys = jsonObject.keys();

            String type =  jsonObject.getString("type");
            String id, hint, label, inputType,
                    btnCancel, btnSelection,span,incomingFormat,
                    dateFormat,timeFormat,date, position;

            boolean required, isMulti;
            JSONArray selectionsJOnArray;
            switch (type){
                case "text":
                     id        = getStringOrDefault(jsonObject, "id", "0");
                     hint      = getStringOrDefault(jsonObject,"hint","");
                     label     = getStringOrDefault(jsonObject,"label", "");
                     position  = getStringOrDefault(jsonObject,"position", "Left");
                     required  = getBooleanOrDefault(jsonObject,"required", false);
                     inputType = getStringOrDefault(jsonObject,"keyboardType", "");
                     span           = getStringOrDefault(jsonObject,"widthMultiplier","1");
                     span = (int)( layoutSpanCount * Float.parseFloat(span)) + "";

                    FormElement formElement = new FormElement(
                            TextElementViewHolder.class,
                            new TextFiledFormObj(
                                    id,
                                    label,
                                    hint,
                                    required,
                                    null,
                                    KeyTypes.getKeyType(inputType),
                                    position
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
                         required     = getBooleanOrDefault(jsonObject,"required", false);
                         isMulti      = getBooleanOrDefault(jsonObject,"isMulti", false);
                         btnCancel    = getStringOrDefault(jsonObject,"btnCancel", "cancel");
                         btnSelection = getStringOrDefault(jsonObject,"btnSelection", "select");
                         selectionsJOnArray   = jsonObject.getJSONArray("selections");
                         span           = getStringOrDefault(jsonObject,"widthMultiplier","1");
                         span = (int)( layoutSpanCount * Float.parseFloat(span)) + "";

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
                        span           = getStringOrDefault(jsonObject,"widthMultiplier","1");
                        span = (int)( layoutSpanCount * Float.parseFloat(span)) + "";

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
                    timeFormat     = getStringOrDefault(jsonObject,"timeFormat", "");
                    date           = getStringOrDefault(jsonObject, "date", ""/*String.valueOf(System.currentTimeMillis())*/);
                    required       = getBooleanOrDefault(jsonObject, "required", false);
                    span           = getStringOrDefault(jsonObject,"widthMultiplier","1");
                    span           = (int)( layoutSpanCount * Float.parseFloat(span)) + "";

                    FormElement dateFormElement = new FormElement(
                            DateViewHolder.class,
                            new DateFormObj(id,label,null, date ,dateFormat, timeFormat, incomingFormat, required),
                            R.layout.multiple_selection_layout,
                            Integer.parseInt(span)
                    );

                    formElements.add(dateFormElement);
            }
        }

        return  new FormJasonObjectsContainer(textFiledThemeConfig,dateThemeConfig,buttonThemeConfig,formElements);
    }

    private static String getStringOrDefault(JSONObject jsonObject, String key, String def) {

        try {
            return     jsonObject.getString(key);
        } catch (JSONException e) {
            return def;
        }
    }

    private static boolean getBooleanOrDefault(JSONObject jsonObject, String key, boolean def) {

        try {
          return   jsonObject.getBoolean(key);
        } catch (JSONException e) {

            return def;
        }
    }
}
