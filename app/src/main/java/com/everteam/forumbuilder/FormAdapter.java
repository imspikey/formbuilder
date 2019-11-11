package com.everteam.forumbuilder;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class FormAdapter extends RecyclerView.Adapter<AFormElementViewHolder> {

    List<FormElement>     mFormElements;
    TextFiledThemeConfig  textFiledThemeConfig;
    MultiSelectThemConfig multiSelectThemConfig;
    ButtonThemeConfig     buttonThemeConfig;
   ButtonThemeConfig getButtonThemeConfig(){
        return  buttonThemeConfig;
    }
    MultiSelectThemConfig  getMultiSelectThemeConfig(){
       return  multiSelectThemConfig;
    }
  TextFiledThemeConfig  getTextFiledConfig(){
       return textFiledThemeConfig;
  }

    FormAdapter(List<FormElement> mFormEmFormElements){

        this.mFormElements = mFormEmFormElements;

        multiSelectThemConfig = new MultiSelectThemConfig.Builder().
                setBackgoudnColor(Color.WHITE).build();

        textFiledThemeConfig  = new TextFiledThemeConfig.Builder().setTextColor(Color.BLACK).
                setBackgoudnColor(Color.BLACK).build();
        buttonThemeConfig   = new ButtonThemeConfig.Builder().setTextColor(Color.BLACK)
                .setBackgroundColor(Color.BLUE)
                .build();
    }

    @NonNull
    @Override
    public AFormElementViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        FormElement formElement = mFormElements.get(viewType);
        View view  = LayoutInflater.from(viewGroup.getContext()).inflate(
                 formElement.getLayout(),
                 viewGroup,
                 false);

        String className = formElement.getFormElementViewHolder().getName();
        Class<?>  c = null;
        try {
            c = Class.forName(className);

            Constructor<?> cons = c.getConstructor(View.class);

            Object v;
            v = cons.newInstance(view);
//            Object v;
//            if(c.getName().equals(TextFiledFormObj.class.getName()))
//            v = cons.newInstance(view);
//
//            if(c.getName().equals(MultiSelectionFormObj.class.getName()))
//                v = cons.newInstance(view);
//            else{
//                v = cons.newInstance(view);
//            }
            return  (AFormElementViewHolder) v;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AFormElementViewHolder aFormElementViewHolder, int i) {

        if(aFormElementViewHolder instanceof MultiSelectionFormViewHolder)
        aFormElementViewHolder.onBind(mFormElements.get(i).getBaseFormObject());

        if(aFormElementViewHolder instanceof TextElementViewHolder)
        aFormElementViewHolder.onBind(mFormElements.get(i).getBaseFormObject(), textFiledThemeConfig);

        if(aFormElementViewHolder instanceof SubmitButtonViewHolder)
            aFormElementViewHolder.onBind(mFormElements.get(i).getBaseFormObject(), buttonThemeConfig);

        else{
            aFormElementViewHolder.onBind(mFormElements.get(i).getBaseFormObject());
        }
    }

    @Override
    public int getItemViewType(int position) {
        super.getItemViewType(position);
        return  position;
    }

    @Override
    public int getItemCount() {
        return mFormElements.size();
    }
}
