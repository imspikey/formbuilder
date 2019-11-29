package com.everteam.forumbuilder.formobjects;

import com.everteam.forumbuilder.form.FormElement;
import com.everteam.forumbuilder.themeconfigs.ButtonThemeConfig;
import com.everteam.forumbuilder.themeconfigs.DateThemeConfig;
import com.everteam.forumbuilder.themeconfigs.TextFiledThemeConfig;

import java.util.ArrayList;

public class FormJasonObjectsContainer {

    private TextFiledThemeConfig   textFiledThemeConfig;
    private DateThemeConfig        dateThemeConfig;
    private ButtonThemeConfig      buttonThemeConfig;
    private ArrayList<FormElement> formElements;

    public  FormJasonObjectsContainer(TextFiledThemeConfig textFiledThemeConfig, DateThemeConfig dateThemeConfig,
                                      ButtonThemeConfig buttonThemeConfig , ArrayList<FormElement> formElements ){
        this.textFiledThemeConfig   = textFiledThemeConfig;
        this.dateThemeConfig        = dateThemeConfig;
        this.buttonThemeConfig      = buttonThemeConfig;
        this.formElements           = formElements;
    }

    public TextFiledThemeConfig getTextFiledThemeConfig() {
        return textFiledThemeConfig;
    }

    public void setTextFiledThemeConfig(TextFiledThemeConfig textFiledThemeConfig) {
        this.textFiledThemeConfig = textFiledThemeConfig;
    }

    public DateThemeConfig getDateThemeConfig() {
        return dateThemeConfig;
    }

    public void setDateThemeConfig(DateThemeConfig dateThemeConfig) {
        this.dateThemeConfig = dateThemeConfig;
    }

    public ButtonThemeConfig getButtonThemeConfig() {
        return buttonThemeConfig;
    }

    public void setButtonThemeConfig(ButtonThemeConfig buttonThemeConfig) {
        this.buttonThemeConfig = buttonThemeConfig;
    }

    public ArrayList<FormElement> getFormElements() {
        return formElements;
    }

    public void setFormElements(ArrayList<FormElement> formElements) {
        this.formElements = formElements;
    }
}
