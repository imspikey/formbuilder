package com.everteam.forumbuilder;

import android.graphics.Typeface;
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

        customTextFiledThemeConfig = (TextFiledThemeConfig) textFiledFormObj.getBaseThemeConfig();

        TextFiledThemeConfig config;

        if(customTextFiledThemeConfig!= null)
            config = customTextFiledThemeConfig;
        else
            config = mainTextFiledThemeConfig;

        tv.setText(textFiledFormObj.getLabel());
        et.setText(textFiledFormObj.getValue());

        tv.setTextSize(config.getLabelSize());
        tv.setTextColor(config.getLabelColor());
        et.setTextSize(config.getLabelSize());

        try {

        et.setTypeface(Typeface.createFromAsset(tv.getContext().getAssets(),
                config.getLabelFont()));
        tv.setTypeface(Typeface.createFromAsset(tv.getContext().getAssets(),
                config.getTextFont()));
        }catch (Exception ex){

        }


    }

    @Override
    void onBind(BaseFormObj baseFormObj, BaseThemeConfig customTextFiledThemeConfig) {
        this.mainTextFiledThemeConfig = (TextFiledThemeConfig)customTextFiledThemeConfig;
        onBind(baseFormObj);
    }
}
