package com.everteam.forumbuilder.themeconfigs;

import android.graphics.Color;

public class TextFiledThemeConfig extends BaseThemeConfig {

    public static class Builder{

        private  int    mTextColor;
        private  int    mBackgroundColor;
        private  int    mTextSize;
        private  String mTextFont;
        private  String mLableText;
        private  int    mLableSize;
        private  int    mLableColor;
        private  String    mLableFont;

        public Builder setTextSize(int textSize) {
            this.mTextSize = textSize;
            return this;
        }

        public Builder setTextFont(String textFont) {
            this.mTextFont = textFont;
            return this;
        }

        public Builder setLableText(String labelText) {
            this.mLableText = labelText;
            return this;
        }

        public Builder setLableSize(int labelSize) {
            this.mLableSize = labelSize;
            return this;
        }

        public Builder setLableColor(int labelColor) {
            this.mLableColor = labelColor;
            return this;
        }

        public Builder setLableFont(String labelFont) {
            this.mLableFont = labelFont;
            return this;
        }

        public  Builder setBackgroundColor(int backGroundColor){
            this.mBackgroundColor = backGroundColor;
            return this;
        }

        public  Builder setTextColor(int mTextColor){
            this.mTextColor = mTextColor;
            return this;
        }

        public TextFiledThemeConfig build(){

            TextFiledThemeConfig textFiledThemeConfig  = new TextFiledThemeConfig();
            textFiledThemeConfig.mBackgroundColor      = this.mBackgroundColor;
            textFiledThemeConfig.mTextColor            = this.mTextColor;
            textFiledThemeConfig.mTextFont             = this.mTextFont;
            textFiledThemeConfig.mTextSize             = this.mTextSize;
            textFiledThemeConfig.mLabelColor           = this.mLableColor;
            textFiledThemeConfig.mLabelFont            = this.mLableFont;
            textFiledThemeConfig.mLabelSize            = this.mLableSize;

            return textFiledThemeConfig;
        }
    }

    private  TextFiledThemeConfig(){}
    private  int    mTextColor;
    private  int    mBackgroundColor;
    private  int    mTextSize;
    private  String mTextFont;
    private  String mLabelText;
    private  int    mLabelSize;
    private  int    mLabelColor;
    private  String mLabelFont;

    public int getTextSize() {
        return mTextSize > 0 ? mTextSize : 20;
    }

    public String getTextFont() {
        return mTextFont != null ? mTextFont : "Default";
    }

     String getLableText() {
        return mLabelText != null ? mLabelText : "";
    }

    public int getLabelSize() {
        return mLabelSize > 0 ? mLabelSize : 12 ;
    }

    public int getLabelColor() {
        return mLabelColor != 0 ? Color.BLACK : mLabelColor;
    }

    public String getLabelFont() {
        return mLabelFont != null ? mLabelFont : "Default";
    }

    int getTextColor() {
        return mTextColor > 0 ? mTextColor : Color.BLACK;
    }

     void setTextSize(int textSize) {
        this.mTextSize = textSize;
    }

     void setTextFont(String textFont) {
        this.mTextFont = textFont;
     }

     void setLableText(String lableText) {
        this.mLabelText = lableText;
    }

     void setLableSize(int lableSize) {
        this.mLabelSize = lableSize;
    }

     void setLableColor(int lableColor) {
        this.mLabelColor = lableColor;
    }

     void setLableFont(String labelFont) {
        this.mLabelFont = labelFont;
    }

     void setBackgroundColor(int backGroundColor){

        this.mBackgroundColor = backGroundColor;
    }

     void setTextColor(int mTextColor){
        this.mTextColor = mTextColor;
    }

}
