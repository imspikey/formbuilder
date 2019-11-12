package com.everteam.forumbuilder;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;

public class SubmitButtonViewHolder extends AFormElementViewHolder {

    Button submitButton;
    ButtonFormObj buttonFormObj;
    ButtonThemeConfig  mainButtonThemeConfig, customButtonThemeConfig;

    public SubmitButtonViewHolder(@NonNull View itemView) {
        super(itemView);
      submitButton = itemView.findViewById(R.id.button);
      submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            buttonFormObj.getOnCLickListener().clicked();
            }
        });
    }

    @Override
    void onBind(BaseFormObj baseFormObj) {

        ButtonThemeConfig config;
        buttonFormObj = (ButtonFormObj) baseFormObj;
        mainButtonThemeConfig =  (ButtonThemeConfig)buttonFormObj.getBaseThemeConfig();

        if(mainButtonThemeConfig != null)
        {
            config = mainButtonThemeConfig;
        }
        else
        {
            config = customButtonThemeConfig;
        }

        submitButton.setText(baseFormObj.getLabel());
        submitButton.setTextColor(config.getTextColor());
        submitButton.setBackgroundColor(config.getBackgroundColor());
        String font = config.getFont();

        try {

        if(font != "Default")
        submitButton.setTypeface(Typeface.createFromAsset(submitButton.getContext().getAssets(),font));
        }
        catch (Exception ex){

        }

    }

    @Override
    void onBind(BaseFormObj baseFormObj, BaseThemeConfig baseThemeConfig) {

        this.customButtonThemeConfig = (ButtonThemeConfig) baseThemeConfig;

        onBind(baseFormObj);
    }
}
