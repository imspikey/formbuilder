package com.everteam.forumbuilder;

import android.text.InputType;

import java.util.HashMap;

public class KeyTypes {

    public static HashMap<String, Integer> keyTypes = new HashMap<String, Integer>(){{
        put("", InputType.TYPE_CLASS_TEXT);
        put("default", InputType.TYPE_CLASS_TEXT);
        put("ascii", InputType.TYPE_CLASS_TEXT);
        put("numbersPunctuation", InputType.TYPE_CLASS_NUMBER);
        put("url", InputType.TYPE_TEXT_VARIATION_URI);
        put("number", InputType.TYPE_NUMBER_VARIATION_PASSWORD);
        put("email", InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        put("decimal", InputType.TYPE_NUMBER_FLAG_DECIMAL);
        put("twitter", InputType.TYPE_CLASS_TEXT);
        put("web", InputType.TYPE_TEXT_VARIATION_WEB_EDIT_TEXT);
        put("asciiNumber", InputType.TYPE_CLASS_TEXT);
    }};
}
