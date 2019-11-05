package com.everteam.forumbuilder;

import android.arch.core.util.Function;

public class BaseFormObj {

    private int mId = 0;
    private String mLabel;
    private String mValue;

    Function<Boolean, String> validationAddon =  null;

    BaseFormObj(int id, String label){
        this.mId = id;
        this.mLabel = label;
    }


    BaseFormObj(int id, String label, String value ){
        this.mId = id;
        this.mLabel = label;
        this.mValue = value;
    }

    public String getLable() {
        return mLabel;
    }

    public String getValue() {
        return mValue;
    }

    public int getId() {
        return mId;
    }
}
