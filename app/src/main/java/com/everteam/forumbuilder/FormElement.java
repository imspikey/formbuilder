package com.everteam.forumbuilder;

import android.support.annotation.LayoutRes;

public class FormElement<A extends AFormElementViewHolder >
        extends BaseFormElement
{
  private Class<?> mFormElementViewHolder;
  private BaseFormObj mBaseFormObject;

//  FormElement(@LayoutRes int layoutId){
//        super(layoutId);
//    }


//  FormElement( Class<A> mFormElementViewHolder, H BaseFormObj, @LayoutRes int layoutId){
//
//        super(layoutId);
//
//        this.mFormElementViewHolder = mFormElementViewHolder;
//        this.mBaseFormObject = BaseFormObj;
//    }
        //
    public FormElement( Class<AFormElementViewHolder> mFormElementViewHolder ,BaseFormObj mBaseFormObject, int layoutId) {
        super(layoutId);
        this.mBaseFormObject = mBaseFormObject;
        this.mFormElementViewHolder = mFormElementViewHolder;
    }

    public Class<?> getFormElementViewHolder()
   {
       return mFormElementViewHolder;
   }


  public BaseFormObj getBaseFormObject() {
        return mBaseFormObject;
    }
}
