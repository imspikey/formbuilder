package com.everteam.forumbuilder.themeconfigs;

public class DateThemeConfig extends BaseThemeConfig {

    public static class Builder{

       private  int mDateColor;
       private  int lableColor;

        public Builder setDateColor(int mDateColor) {
            this.mDateColor = mDateColor;
            return this;
        }

        public Builder setLableColor(int lableColor) {
            this.lableColor = lableColor;
            return this;
        }



        public DateThemeConfig build(){

            DateThemeConfig textFiledThemeConfig  = new DateThemeConfig();
            textFiledThemeConfig.mDateColor       = this.mDateColor;

            return textFiledThemeConfig;
        }
    }

    private  DateThemeConfig(){}
    private  int mDateColor;
    private  int mLabelColor;


    public int getLabelColor() {
        return mLabelColor;
    }

    public void setLabelColor(int labelColor) {
        this.mLabelColor = labelColor;
    }

    public int getDateColor() {
        return mDateColor;
    }

    public void setDateColor(int mDateColor) {
        this.mDateColor = mDateColor;
    }
}
