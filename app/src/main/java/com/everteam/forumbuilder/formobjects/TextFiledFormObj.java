package com.everteam.forumbuilder.formobjects;

import com.everteam.forumbuilder.themeconfigs.TextFiledThemeConfig;

public class TextFiledFormObj extends BaseFormObj {

    public enum Position{TOP, Left}

    public Position getPosition() {
        return mPosition;
    }

    public void setPosition(Position position) {
        this.mPosition = position;
    }

    private Position mPosition;
    private int mInputType;
    private String text;

    public TextFiledFormObj(String id,
                     String label,
                     boolean isRequired,
                     TextFiledThemeConfig textFiledThemeConfig,
                     int inputType, String position) {
        super(id, label, textFiledThemeConfig, isRequired);

        this.mInputType = inputType;

        setPosition(position);
    }

   public TextFiledFormObj(String id,
                     String label,
                     String value,
                     boolean isRequired,
                     TextFiledThemeConfig textFiledThemeConfig,
                     int inputType,String position) {
        super(id, label, value, textFiledThemeConfig, isRequired);
        this.mInputType = inputType;
        setPosition(position);
    }

    private void setPosition(String position) {
        try {
            this.mPosition = Position.valueOf(position);
        }
        catch (IllegalArgumentException ex){
            this.mPosition = Position.Left;
        }
    }

    public int getInputType() {
        return mInputType;
    }

    public void setInputType(int inputType) {
        this.mInputType = inputType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
