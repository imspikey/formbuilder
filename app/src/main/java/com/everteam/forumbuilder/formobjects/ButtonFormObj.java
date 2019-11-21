package com.everteam.forumbuilder.formobjects;

import com.everteam.forumbuilder.themeconfigs.BaseThemeConfig;

public class ButtonFormObj extends BaseFormObj {

    public interface ButtonListener {
        void clicked();
    }

    ButtonListener buttonListener;

    public ButtonFormObj(String id, ButtonListener buttonListener, String label, BaseThemeConfig baseThemeConfig) {
        super(id, label, baseThemeConfig, false);

        this.buttonListener = buttonListener;
    }

    public  ButtonFormObj(String id,ButtonListener buttonListener, String label) {
        super(id, label);

        this.buttonListener = buttonListener;
    }

    public ButtonFormObj(String id, ButtonListener buttonListener, String label, String value,
                  BaseThemeConfig mBaseThemeConfig) {
        super(id, label, value, mBaseThemeConfig, false);

        this.buttonListener = buttonListener;
    }

    public ButtonListener getOnCLickListener(){
        return  buttonListener;
    }

}
