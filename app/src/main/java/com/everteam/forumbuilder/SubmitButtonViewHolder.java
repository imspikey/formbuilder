package com.everteam.forumbuilder;

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

    }

    @Override
    void onBind(BaseFormObj baseFormObj, BaseThemeConfig baseThemeConfig) {

        this.customButtonThemeConfig = (ButtonThemeConfig) baseThemeConfig;

        onBind(baseFormObj);
    }
}
