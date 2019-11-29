package com.everteam.forumbuilder.form;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.everteam.forumbuilder.themeconfigs.ButtonThemeConfig;
import com.everteam.forumbuilder.themeconfigs.DateThemeConfig;
import com.everteam.forumbuilder.themeconfigs.MultiSelectThemConfig;
import com.everteam.forumbuilder.themeconfigs.TextFiledThemeConfig;
import com.everteam.forumbuilder.viewholders.AFormElementViewHolder;
import com.everteam.forumbuilder.viewholders.DateViewHolder;
import com.everteam.forumbuilder.viewholders.MultiSelectionFormViewHolder;
import com.everteam.forumbuilder.viewholders.SubmitButtonViewHolder;
import com.everteam.forumbuilder.viewholders.TextElementViewHolder;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class FormAdapter extends RecyclerView.Adapter<AFormElementViewHolder> {

   DateThemeConfig       dateThemeConfig;
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

    FormAdapter(List<FormElement> mFormEmFormElements, ButtonThemeConfig buttonThemeConfig, TextFiledThemeConfig textFiledThemeConfig, DateThemeConfig dateThemeConfig){

        this.mFormElements = mFormEmFormElements;

        multiSelectThemConfig = new MultiSelectThemConfig.Builder().
                setBackgoudnColor(Color.WHITE).build();

        this.textFiledThemeConfig = textFiledThemeConfig != null? textFiledThemeConfig : new TextFiledThemeConfig.Builder().setTextColor(Color.BLACK).
                setBackgroundColor(Color.BLACK).setLableSize(12).setLableColor(Color.BLACK).setTextSize(15).build();

        this.buttonThemeConfig = buttonThemeConfig != null ? buttonThemeConfig : new ButtonThemeConfig.Builder().setTextColor(Color.BLACK)
                .setBackgroundColor(Color.BLUE)
                .build();

        this.dateThemeConfig = dateThemeConfig != null ? dateThemeConfig : new DateThemeConfig.Builder().
                setDateColor(Color.BLACK).setLableColor(Color.BLACK).build();
    }

    @NonNull
    @Override
    public AFormElementViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        FormElement formElement = mFormElements.get(viewType);
        View view  = LayoutInflater.from(viewGroup.getContext()).inflate(
                 formElement.getLayout(),
                 viewGroup,
                 false);

        String className = formElement.getmFormElementViewHolderInstance().getName();
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
            AFormElementViewHolder fAVH = (AFormElementViewHolder) v;
            formElement.setFormElementViewHolder(fAVH);
            return  fAVH;

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
        aFormElementViewHolder.onBind(mFormElements.get(i).getBaseFormObject(), multiSelectThemConfig);

        if(aFormElementViewHolder instanceof TextElementViewHolder)
        aFormElementViewHolder.onBind(mFormElements.get(i).getBaseFormObject(), textFiledThemeConfig);

        if(aFormElementViewHolder instanceof SubmitButtonViewHolder)
            aFormElementViewHolder.onBind(mFormElements.get(i).getBaseFormObject(), buttonThemeConfig);

        if(aFormElementViewHolder instanceof DateViewHolder)
            aFormElementViewHolder.onBind(mFormElements.get(i).getBaseFormObject(), dateThemeConfig);

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
