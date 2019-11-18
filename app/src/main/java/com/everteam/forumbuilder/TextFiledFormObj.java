package com.everteam.forumbuilder;

public class TextFiledFormObj extends BaseFormObj {

    private boolean mIsRequired = false;
    private int mInputType;

    TextFiledFormObj(String id,
                     String label,
                     boolean isRequired,
                     TextFiledThemeConfig textFiledThemeConfig,
                     int inputType) {
        super(id, label, textFiledThemeConfig);
        this.mIsRequired = isRequired;
        this.mInputType = inputType;
    }

    TextFiledFormObj(String id,
                     String label,
                     String value,
                     boolean isRequired,
                     TextFiledThemeConfig textFiledThemeConfig,
                     int inputType) {
        super(id, label, value, textFiledThemeConfig);
        this.mIsRequired = isRequired;
        this.mInputType = inputType;
    }

    public boolean ismIsRequired() {
        return mIsRequired;
    }

    public int getInputType() {
        return mInputType;
    }

    public void setInputType(int inputType) {
        this.mInputType = inputType;
    }
}
