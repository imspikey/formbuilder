package com.everteam.forumbuilder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class AFormElementViewHolder extends RecyclerView.ViewHolder {

    public AFormElementViewHolder(@NonNull View itemView) {
        super(itemView); }

    abstract void onBind(BaseFormObj baseFormObj);

}
