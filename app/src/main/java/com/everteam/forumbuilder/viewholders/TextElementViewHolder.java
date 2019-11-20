package com.everteam.forumbuilder.viewholders;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.everteam.forumbuilder.formobjects.BaseFormObj;
import com.everteam.forumbuilder.themeconfigs.BaseThemeConfig;
import com.everteam.forumbuilder.R;
import com.everteam.forumbuilder.formobjects.TextFiledFormObj;
import com.everteam.forumbuilder.themeconfigs.TextFiledThemeConfig;

public class TextElementViewHolder extends AFormElementViewHolder {

    enum position {Top,BOTTOM,Right}

    TextFiledThemeConfig mainTextFiledThemeConfig, customTextFiledThemeConfig;
    TextFiledFormObj textFiledFormObj;
    TextView tv;
    EditText et;

    public TextElementViewHolder(@NonNull View itemView) {
        super(itemView);

        tv = itemView.findViewById(R.id.textView);
        et = itemView.findViewById(R.id.editText);

    }

    @Override
    public void onBind(BaseFormObj baseFormObj) {

        textFiledFormObj  =  (TextFiledFormObj)baseFormObj;

        customTextFiledThemeConfig = (TextFiledThemeConfig) textFiledFormObj.getBaseThemeConfig();

        TextFiledThemeConfig config;

        if(customTextFiledThemeConfig!= null)
            config = customTextFiledThemeConfig;
        else
            config = mainTextFiledThemeConfig;

        tv.setText(textFiledFormObj.getLabel().replace("$",""));
        et.setHint(textFiledFormObj.getValue().replace("$",""));

        tv.setTextSize(config.getLabelSize());
        tv.setTextColor(config.getLabelColor());
        et.setTextSize(config.getTextSize());

        try {

        et.setTypeface(Typeface.createFromAsset(tv.getContext().getAssets(),
                config.getLabelFont()));
        tv.setTypeface(Typeface.createFromAsset(tv.getContext().getAssets(),
                config.getTextFont()));
        }catch (Exception ex){

        }
    }

    @Override
    public void onBind(BaseFormObj baseFormObj, BaseThemeConfig customTextFiledThemeConfig) {
        this.mainTextFiledThemeConfig = (TextFiledThemeConfig)customTextFiledThemeConfig;
        onBind(baseFormObj);
    }


    public boolean isElementValid(){

        return     et.getText().length() > 0;
    }
}
