package com.everteam.forumbuilder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MultiSelectionFormViewHolder extends AFormElementViewHolder {

    private EditText mEditText;
    private TextView mTextView;
    private MultiSelectionFormObj mMultiSelectionFormObj;

    public MultiSelectionFormViewHolder(@NonNull View itemView) {
        super(itemView);

        mEditText = itemView.findViewById(R.id.editText);
        mTextView = itemView.findViewById(R.id.textView);
    }

    @Override
    void onBind(BaseFormObj baseFormObj) {
         mMultiSelectionFormObj = (MultiSelectionFormObj) baseFormObj;

    }
}
