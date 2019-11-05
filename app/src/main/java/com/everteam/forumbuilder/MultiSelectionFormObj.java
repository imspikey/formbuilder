package com.everteam.forumbuilder;


import java.util.ArrayList;

public class MultiSelectionFormObj extends BaseFormObj {

    private boolean mIsRequired = false;
    private boolean mIsMultiSelect = false;

    private ArrayList<String> mSelectionValues;

    MultiSelectionFormObj(int id, String label,boolean isRequired, ArrayList<String> selectionValues) {
        super(id, label);
        this.mIsRequired = isRequired;
        this.mSelectionValues = selectionValues;
    }

    MultiSelectionFormObj(int id, String label, String value,boolean isRequired, ArrayList<String> selectionValues) {
        super(id, label, value);

        this.mIsRequired = isRequired;
        this.mSelectionValues = selectionValues;
    }


    public boolean ismIsRequired() {
        return mIsRequired;
    }

    public boolean isMultiSelect() {
        return mIsMultiSelect;
    }

    public ArrayList<String> getSelectionValues() {
        return mSelectionValues;
    }
}
