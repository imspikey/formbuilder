package com.everteam.forumbuilder.form;

import android.support.annotation.LayoutRes;

public class BaseFormElement {

    @LayoutRes
    private int layoutId;

    public BaseFormElement(@LayoutRes int layoutId){
        this.layoutId = layoutId;
    }
     public int getLayout() {
        return layoutId;
    }
}
