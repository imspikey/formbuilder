package com.everteam.forumbuilder.form;

import com.everteam.forumbuilder.formobjects.BaseFormObj;
import com.everteam.forumbuilder.viewholders.AFormElementViewHolder;

public class FormElement<A extends AFormElementViewHolder>
        extends BaseFormElement
{
  private Class<?> mFormElementViewHolder;
  private BaseFormObj mBaseFormObject;
  private int span;
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
public FormElement( Class<AFormElementViewHolder> mFormElementViewHolder ,BaseFormObj mBaseFormObject, int layoutId, int span) {
        super(layoutId);
        this.mBaseFormObject = mBaseFormObject;
        this.mFormElementViewHolder = mFormElementViewHolder;
        this.span = span;
    }


    public Class<?> getFormElementViewHolder()
   {
       return mFormElementViewHolder;
   }
    public int getSpan()
    {
        return  span;
    }

     void setSpan(int span) {
        this.span = span;
    }

    public BaseFormObj getBaseFormObject() {
        return mBaseFormObject;
    }
}
