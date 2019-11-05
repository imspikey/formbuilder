package com.everteam.forumbuilder;

import android.support.annotation.LayoutRes;

public class BaseFormElement {

    @LayoutRes
    private int layoutId;

    BaseFormElement(@LayoutRes int layoutId){
        this.layoutId = layoutId;
    }
     int getLayout() {
        return layoutId;
    }
}
