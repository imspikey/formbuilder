package com.everteam.forumbuilder.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.everteam.forumbuilder.formobjects.BaseFormObj;
import com.everteam.forumbuilder.themeconfigs.BaseThemeConfig;

public abstract class AFormElementViewHolder extends RecyclerView.ViewHolder {

    public AFormElementViewHolder(@NonNull View itemView) {
        super(itemView); }
    public abstract boolean isElementValid();
    public abstract void onBind(BaseFormObj baseFormObj);
    public abstract void onBind(BaseFormObj baseFormObj, BaseThemeConfig baseThemeConfig);

}
