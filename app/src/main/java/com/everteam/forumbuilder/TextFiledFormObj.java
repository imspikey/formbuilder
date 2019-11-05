package com.everteam.forumbuilder;

public class TextFiledFormObj extends BaseFormObj {

    boolean isRequierd = false;
    TextFiledFormObj(int id, String label,boolean isRequierd) {
        super(id, label);
        this.isRequierd = isRequierd;
    }

    TextFiledFormObj(int id, String label, String value, boolean isRequierd) {
        super(id, label, value);
        this.isRequierd = isRequierd;
    }
}
