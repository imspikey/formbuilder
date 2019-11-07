package com.everteam.forumbuilder;

class MultiSelectThemConfig  extends BaseThemeConfig{

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

    public MultiSelectThemConfig build(){

        MultiSelectThemConfig multiSelectThemConfig = new MultiSelectThemConfig();
        multiSelectThemConfig.mBackgroundColor      = this.mBackgroundColor;
        multiSelectThemConfig.mTextColor            = this.mTextColor;

        return multiSelectThemConfig;
    }
}

    private  MultiSelectThemConfig(){}
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
