package com.everteam.forumbuilder.formobjects;

import com.everteam.forumbuilder.themeconfigs.BaseThemeConfig;


public class DateFormObj extends  BaseFormObj {

    public enum DateType  {DATETIME,DATE,TIME}

    public DateType getDateType() {
        return dateType;
    }

    public void setDateType(DateType dateType) {
        this.dateType = dateType;
    }

    DateType dateType;

    public String getIncomingFormat() {
        return incomingFormat;
    }

    public void setIncomingFormat(String incomingFormat) {
        this.incomingFormat = incomingFormat;
    }

    public String getTimeFormat() {
        return timeFormat;
    }

    public void setTimeFormat(String timeFormat) {
        this.timeFormat = timeFormat;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    private String incomingFormat;
    private String timeFormat;
    private String date;
    private String dateFormat;

    public DateFormObj(String id, String label, BaseThemeConfig baseThemeConfig,
                       String date, String format, String timeFormat, String incomingFormat) {
        super(id, label, baseThemeConfig);

        this.date = date;
        this.dateFormat = format;
        this.timeFormat = timeFormat;
        this.incomingFormat = incomingFormat;

        if(!dateFormat.equals("") && !timeFormat.equals(""))
            dateType = DateType.DATETIME;
        if(!dateFormat.equals("") && timeFormat.equals(""))
            dateType = DateType.DATE;
        if(dateFormat.equals("") && !timeFormat.equals(""))
            dateType = DateType.TIME;
    }

    public String getFormat() {
        return dateFormat;
    }

    public void setFormat(String format) {
        this.dateFormat = format;
    }

    public DateFormObj(String id, String label, String value, BaseThemeConfig mBaseThemeConfig) {
        super(id, label, value, mBaseThemeConfig);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
