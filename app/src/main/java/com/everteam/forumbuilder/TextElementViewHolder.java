package com.everteam.forumbuilder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TextElementViewHolder extends AFormElementViewHolder {

    TextFiledThemeConfig mainTextFiledThemeConfig,customTextFiledThemeConfig;
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

        textFiledFormObj  =  (TextFiledFormObj)baseFormObj;

        TextFiledThemeConfig config = (TextFiledThemeConfig) textFiledFormObj.getBaseThemeConfig();

        TextFiledFormObj currTextFiledFormObj;
        if(customTextFiledThemeConfig != null)
            config = customTextFiledThemeConfig;
        else
            config = mainTextFiledThemeConfig;

        tv.setText(textFiledFormObj.getLabel());
        et.setText(textFiledFormObj.getValue());

        et.setTextColor(config.getTextColor());
        et.setBackgroundColor(config.getBackgroundColor());
    }

    @Override
    void onBind(BaseFormObj baseFormObj, BaseThemeConfig customTextFiledThemeConfig) {
        this.customTextFiledThemeConfig = (TextFiledThemeConfig)customTextFiledThemeConfig;
        onBind(baseFormObj);
    }
}
