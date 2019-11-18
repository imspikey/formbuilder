package com.everteam.forumbuilder.themeconfigs;

public class ButtonThemeConfig extends BaseThemeConfig {

    public static class Builder{

        private  int    mTextColor;
        private  int    mBackgroundColor;
        private  String mFont;

        public Builder setFont(String font){
            this.mFont = font;
            return  this;
        }

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
            buttonThemeConfig.mFont                 = this.mFont;
            return buttonThemeConfig;
        }
}

    private  ButtonThemeConfig(){

    }

    private  int mTextColor;
    private  int mBackgroundColor;
    private  String mFont;

    public String getFont(){
        return  mFont != null ? mFont : "Default";
    }

    void setFont(String mFont){
        this.mFont = mFont;
    }

    public int getTextColor() {
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
