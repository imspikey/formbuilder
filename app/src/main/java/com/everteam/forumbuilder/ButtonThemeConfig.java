package com.everteam.forumbuilder;

class ButtonThemeConfig extends BaseThemeConfig{

    public static class Builder{

    private  int mTextColor;
    private  int mBackgroundColor;

    public Builder setBackgroundColor(int backGroundColor){

        this.mBackgroundColor = backGroundColor;
        return this;
    }

    public Builder setTextColor(int mTextColor){
        this.mTextColor = mTextColor;

        return this;
    }

    public ButtonThemeConfig build(){

        ButtonThemeConfig buttonThemeConfig =  new ButtonThemeConfig();
        buttonThemeConfig.mBackgroundColor      = this.mBackgroundColor;
        buttonThemeConfig.mTextColor            = this.mTextColor;

        return buttonThemeConfig;
    }
}

    private  ButtonThemeConfig(){

    }


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
