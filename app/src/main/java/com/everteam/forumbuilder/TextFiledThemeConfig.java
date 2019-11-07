package com.everteam.forumbuilder;

class TextFiledThemeConfig extends BaseThemeConfig {

    public static class Builder{

        private  int mTextColor;
        private  int mBackgroundColor;

        public Builder setBackgoudnColor(int backGroundColor){

            this.mBackgroundColor = backGroundColor;
            return this;
        }

        public Builder setTextColor(int mTextColor){
            this.mTextColor = mTextColor;

            return this;
        }

        public TextFiledThemeConfig build(){

            TextFiledThemeConfig textFiledThemeConfig =  new TextFiledThemeConfig();
            textFiledThemeConfig.mBackgroundColor      = this.mBackgroundColor;
            textFiledThemeConfig.mTextColor            = this.mTextColor;

            return textFiledThemeConfig;
        }
    }

    private  TextFiledThemeConfig(){}
    private  int mTextColor;
    private  int mBackgroundColor;

    int getTextColor() {
        return mTextColor;
    }

    public int getBackgroundColor() {
        return mBackgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.mBackgroundColor = backgroundColor;
    }

    public void setTextColor(int textBackgroundColor) {
        this.mTextColor = textBackgroundColor;
    }

}
