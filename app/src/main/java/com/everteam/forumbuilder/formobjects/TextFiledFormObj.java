package com.everteam.forumbuilder.formobjects;

import com.everteam.forumbuilder.themeconfigs.TextFiledThemeConfig;

public class TextFiledFormObj extends BaseFormObj {

    private int mInputType;

    public TextFiledFormObj(String id,
                     String label,
                     boolean isRequired,
                     TextFiledThemeConfig textFiledThemeConfig,
                     int inputType) {
        super(id, label, textFiledThemeConfig, isRequired);

        this.mInputType = inputType;
    }

   public TextFiledFormObj(String id,
                     String label,
                     String value,
                     boolean isRequired,
                     TextFiledThemeConfig textFiledThemeConfig,
                     int inputType) {
        super(id, label, value, textFiledThemeConfig, isRequired);
        this.mInputType = inputType;
    }

    public int getInputType() {
        return mInputType;
    }

    public void setInputType(int inputType) {
        this.mInputType = inputType;
    }

}
