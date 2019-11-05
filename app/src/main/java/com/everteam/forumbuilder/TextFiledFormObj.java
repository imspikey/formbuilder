package com.everteam.forumbuilder;

public class TextFiledFormObj extends BaseFormObj {

    private boolean mIsRequired = false;

    TextFiledFormObj(int id, String label,boolean isRequierd) {
        super(id, label);
        this.mIsRequired = isRequierd;
    }

    TextFiledFormObj(int id, String label, String value, boolean isRequierd) {
        super(id, label, value);
        this.mIsRequired = isRequierd;
    }

    public boolean ismIsRequired() {
        return mIsRequired;
    }
}
