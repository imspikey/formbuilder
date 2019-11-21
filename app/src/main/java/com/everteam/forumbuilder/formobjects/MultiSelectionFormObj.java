package com.everteam.forumbuilder.formobjects;


import com.everteam.forumbuilder.themeconfigs.MultiSelectThemConfig;

import java.util.ArrayList;

public class MultiSelectionFormObj extends BaseFormObj {

    private boolean mIsMultiSelect;

    private ArrayList<String> mSelectionValues;
    private ArrayList<Integer> mSelectedIndexes = new ArrayList<>();

    public MultiSelectionFormObj(String id, String label, boolean isRequired, boolean mIsMultiSelect,
                          ArrayList<String> selectionValues, ArrayList<Integer> mSelectedIndexes) {
        super(id, label);
        this.mIsMultiSelect = mIsMultiSelect;
        this.mSelectionValues = selectionValues;
        this.mSelectedIndexes = mSelectedIndexes;
    }

    public  MultiSelectionFormObj(String id, String label, boolean isRequired, boolean mIsMultiSelect,
                          ArrayList<String> selectionValues, ArrayList<Integer> mSelectedIndexes, MultiSelectThemConfig multiSelectThemConfig) {
        super(id, label,multiSelectThemConfig, isRequired);
        this.mIsMultiSelect = mIsMultiSelect;
        this.mSelectionValues = selectionValues;
        this.mSelectedIndexes = mSelectedIndexes;
    }

    public MultiSelectionFormObj(String id, String label, String value, boolean isRequired, boolean mIsMultiSelect,
                          ArrayList<String> selectionValues, ArrayList<Integer> mSelectedIndexes, MultiSelectThemConfig multiSelectThemConfig) {
        super(id, label, value, multiSelectThemConfig,isRequired);

        this.mIsMultiSelect = mIsMultiSelect;
        this.mSelectionValues = selectionValues;
        this.mSelectedIndexes = mSelectedIndexes;
    }

    public boolean isMultiSelect() {
        return mIsMultiSelect;
    }

    public ArrayList<String> getSelectionValues() {
        return mSelectionValues;
    }

    public ArrayList<Integer> getSelectedIndexes() {
        return mSelectedIndexes;
    }

    public void setSelectedIndexes(ArrayList<Integer> mSelectedIndexes) {
        this.mSelectedIndexes = mSelectedIndexes;
    }
}
