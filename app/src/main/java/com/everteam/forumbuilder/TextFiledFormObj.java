package com.everteam.forumbuilder;

public class TextFiledFormObj extends BaseFormObj {

    private boolean mIsRequired = false;

    TextFiledFormObj(int id, String label,boolean isRequired, TextFiledThemeConfig textFiledThemeConfig) {
        super(id, label, textFiledThemeConfig);
        this.mIsRequired = isRequired;
    }

    TextFiledFormObj(int id, String label, String value, boolean isRequired, TextFiledThemeConfig textFiledThemeConfig) {
        super(id, label, value, textFiledThemeConfig);
        this.mIsRequired = isRequired;
    }

    public boolean ismIsRequired() {
        return mIsRequired;
    }
}
