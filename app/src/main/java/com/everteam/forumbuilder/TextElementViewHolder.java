package com.everteam.forumbuilder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.everteam.forumbuilder.R;

public class TextElementViewHolder extends AFormElementViewHolder {

    TextFiledFormObj textFiledFormObj;
    TextView tv;
    EditText et;

    public TextElementViewHolder(@NonNull View itemView) {
        super(itemView);

        tv = itemView.findViewById(R.id.textView);
        et = itemView.findViewById(R.id.editText);
    }

    @Override
    void onBind(BaseFormObj baseFormObj) {
        textFiledFormObj = (TextFiledFormObj) baseFormObj;
        tv.setText(textFiledFormObj.getLable());
        et.setText(textFiledFormObj.getValue());
    }
}
