package com.everteam.forumbuilder.formobjects;

import com.everteam.forumbuilder.themeconfigs.BaseThemeConfig;

import java.util.Calendar;

public class DateFormObj extends  BaseFormObj {

    private long date;

    private String format;

    public DateFormObj(String id, String label, BaseThemeConfig baseThemeConfig, long date, String format) {
        super(id, label, baseThemeConfig);

        this.date = date;
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public DateFormObj(String id, String label, String value, BaseThemeConfig mBaseThemeConfig) {
        super(id, label, value, mBaseThemeConfig);
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
