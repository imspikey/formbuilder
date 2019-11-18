package com.everteam.forumbuilder;

public class ButtonFormObj extends BaseFormObj {

    public interface ButtonListener {
        void clicked();
    }

    ButtonListener buttonListener;
    ButtonFormObj(String id, ButtonListener buttonListener, String label, BaseThemeConfig baseThemeConfig) {
        super(id, label, baseThemeConfig);

        this.buttonListener = buttonListener;
    }

    ButtonFormObj(String id,ButtonListener buttonListener, String label) {
        super(id, label);

        this.buttonListener = buttonListener;
    }

    ButtonFormObj(String id, ButtonListener buttonListener, String label, String value,
                  BaseThemeConfig mBaseThemeConfig) {
        super(id, label, value, mBaseThemeConfig);
        this.buttonListener =buttonListener;
    }

    ButtonListener getOnCLickListener(){
        return  buttonListener;
    }

}
