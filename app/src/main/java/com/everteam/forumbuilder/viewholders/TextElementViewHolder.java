package com.everteam.forumbuilder.viewholders;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
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
    TextView tv,tvTop;
    EditText et;

    public TextElementViewHolder(@NonNull View itemView) {
        super(itemView);

        tv = itemView.findViewById(R.id.textView);
        tvTop = itemView.findViewById(R.id.textViewTop);
        et = itemView.findViewById(R.id.editText);


        tvTop.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                textFiledFormObj.setText(s.toString());
            }
        });

        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                textFiledFormObj.setText(s.toString());
            }
        });

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

        if(textFiledFormObj.getPosition() == TextFiledFormObj.Position.TOP) {
            tv.setText(textFiledFormObj.getLabel().replace("$", ""));
            tv.setTextSize(config.getLabelSize());
            tv.setTextColor(config.getLabelColor());
            tvTop.setVisibility(View.GONE);
        }
        else{
            tvTop.setText(textFiledFormObj.getLabel().replace("$", ""));
            tvTop.setTextSize(config.getLabelSize());
            tvTop.setTextColor(config.getLabelColor());
            tv.setVisibility(View.GONE);
        }


        et.setHint(textFiledFormObj.getValue().replace("$",""));

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

        if(textFiledFormObj.getIsRequierd())
        return  et.getText().length() > 0;

        return  true;
    }
}
