package com.everteam.forumbuilder.formobjects;

import android.arch.core.util.Function;

import com.everteam.forumbuilder.themeconfigs.BaseThemeConfig;

public abstract  class BaseFormObj {

    private String mId = "0";
    private String mLabel;
    private String mValue;
    private BaseThemeConfig mBaseThemeConfig;
    private  boolean isRequierd;
    Function<Boolean, String> validationAddon =  null;

   public BaseFormObj(String id, String label,BaseThemeConfig baseThemeConfig , boolean isRequired){
        this.mId = id;
        this.mLabel = label;
        this.mBaseThemeConfig = baseThemeConfig;
        this.isRequierd = isRequired;
    }


    public BaseFormObj(String id, String label){
        this.mId = id;
        this.mLabel = label;
    }

    public BaseFormObj(String id, String label, String value,BaseThemeConfig mBaseThemeConfig, boolean isRequierd ){
        this.mId = id;
        this.mLabel = label;
        this.mValue = value;
        this.mBaseThemeConfig = mBaseThemeConfig;
        this.isRequierd = isRequierd;
    }

    public String getLabel() {
        return mLabel;
    }

    public String getValue() {
        return mValue;
    }

    public String getId() {
        return mId;
    }

    public  boolean getIsRequierd(){
       return isRequierd;
    }

    public BaseThemeConfig getBaseThemeConfig() {
        return mBaseThemeConfig;
    }

    public void setBaseThemeConfig(BaseThemeConfig baseThemeConfig) {
        this.mBaseThemeConfig = baseThemeConfig;
    }
}
