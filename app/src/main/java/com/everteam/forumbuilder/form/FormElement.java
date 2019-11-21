package com.everteam.forumbuilder.form;

import com.everteam.forumbuilder.formobjects.BaseFormObj;
import com.everteam.forumbuilder.viewholders.AFormElementViewHolder;

public class FormElement<A extends AFormElementViewHolder>
        extends BaseFormElement
{
  private Class<?> mFormElementViewHolderInstance;
  private BaseFormObj mBaseFormObject;
  private int span;
  AFormElementViewHolder aFormElementViewHolder;

//  FormElement(@LayoutRes int layoutId){
//        super(layoutId);
//    }


//  FormElement( Class<A> mFormElementViewHolderInstance, H BaseFormObj, @LayoutRes int layoutId){
//
//        super(layoutId);
//
//        this.mFormElementViewHolderInstance = mFormElementViewHolderInstance;
//        this.mBaseFormObject = BaseFormObj;
//    }
        //

public FormElement( Class<AFormElementViewHolder> mFormElementViewHolder ,BaseFormObj mBaseFormObject, int layoutId, int span) {
        super(layoutId);
        this.mBaseFormObject = mBaseFormObject;
        this.mFormElementViewHolderInstance = mFormElementViewHolder;
        this.span = span;
    }

    public Class<?> getmFormElementViewHolderInstance(){
    return mFormElementViewHolderInstance;
    }
    public AFormElementViewHolder getFormElementViewHolder()
   {
       return aFormElementViewHolder;
   }

   public void setFormElementViewHolder(AFormElementViewHolder aFormElementViewHolder){
    this.aFormElementViewHolder = aFormElementViewHolder;
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
