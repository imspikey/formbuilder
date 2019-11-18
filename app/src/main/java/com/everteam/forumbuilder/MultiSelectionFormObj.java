package com.everteam.forumbuilder;


import java.util.ArrayList;

public class MultiSelectionFormObj extends BaseFormObj {

    private boolean mIsRequired = false;
    private boolean mIsMultiSelect;

    private ArrayList<String> mSelectionValues;
    private ArrayList<Integer> mSelectedIndexes = new ArrayList<>();

    MultiSelectionFormObj(String id, String label, boolean isRequired, boolean mIsMultiSelect,
                          ArrayList<String> selectionValues, ArrayList<Integer> mSelectedIndexes) {
        super(id, label);
        this.mIsRequired = isRequired;
        this.mIsMultiSelect = mIsMultiSelect;
        this.mSelectionValues = selectionValues;
        this.mSelectedIndexes = mSelectedIndexes;
    }

    MultiSelectionFormObj(String id, String label, boolean isRequired, boolean mIsMultiSelect,
                          ArrayList<String> selectionValues, ArrayList<Integer> mSelectedIndexes, MultiSelectThemConfig multiSelectThemConfig) {
        super(id, label,multiSelectThemConfig);
        this.mIsRequired = isRequired;
        this.mIsMultiSelect = mIsMultiSelect;
        this.mSelectionValues = selectionValues;
        this.mSelectedIndexes = mSelectedIndexes;
    }

    MultiSelectionFormObj(String id, String label, String value, boolean isRequired, boolean mIsMultiSelect,
                          ArrayList<String> selectionValues, ArrayList<Integer> mSelectedIndexes, MultiSelectThemConfig multiSelectThemConfig) {
        super(id, label, value, multiSelectThemConfig);

        this.mIsRequired = isRequired;
        this.mIsMultiSelect = mIsMultiSelect;
        this.mSelectionValues = selectionValues;
        this.mSelectedIndexes = mSelectedIndexes;
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

    public ArrayList<Integer> getSelectedIndexes() {
        return mSelectedIndexes;
    }

    public void setSelectedIndexes(ArrayList<Integer> mSelectedIndexes) {
        this.mSelectedIndexes = mSelectedIndexes;
    }
}
