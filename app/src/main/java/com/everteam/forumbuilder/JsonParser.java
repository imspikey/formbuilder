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
            String id, hint, label, inputType, btnCancel, btnSelection;
            boolean required, isMulti;
            JSONArray selectionsJOnArray;
            switch (type){
                case "text":
                     id        = getStringOrDefault(jsonObject, "id", "0");
                     hint      = getStringOrDefault(jsonObject,"hint","");
                     label     = getStringOrDefault(jsonObject,"label", "");
                     required = getBooleanOrDefault(jsonObject,"required");
                     inputType = getStringOrDefault(jsonObject,"keyboardType", "");

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
                            R.layout.text_element_layout
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
                                R.layout.multiple_selection_layout
                        );

                        formElements.add(multiSelectFormElement);

                        break;
                    case "button"
                        id           = getStringOrDefault(jsonObject, "id", "0");
                        label        = getStringOrDefault(jsonObject,"label", "");

                        FormElement buttonFormElemet = new FormElement(
                                SubmitButtonViewHolder.class,
                                new ButtonFormObj()
                        )
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
