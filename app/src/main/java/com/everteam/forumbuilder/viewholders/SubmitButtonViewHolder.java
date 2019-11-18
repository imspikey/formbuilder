package com.everteam.forumbuilder.viewholders;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;

import com.everteam.forumbuilder.formobjects.BaseFormObj;
import com.everteam.forumbuilder.themeconfigs.BaseThemeConfig;
import com.everteam.forumbuilder.formobjects.ButtonFormObj;
import com.everteam.forumbuilder.themeconfigs.ButtonThemeConfig;
import com.everteam.forumbuilder.R;

public class SubmitButtonViewHolder extends AFormElementViewHolder {

    Button submitButton;
    ButtonFormObj buttonFormObj;
    ButtonThemeConfig mainButtonThemeConfig, customButtonThemeConfig;

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
  public void onBind(BaseFormObj baseFormObj) {

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
    public void onBind(BaseFormObj baseFormObj, BaseThemeConfig baseThemeConfig) {

        this.customButtonThemeConfig = (ButtonThemeConfig) baseThemeConfig;

        onBind(baseFormObj);
    }
}
