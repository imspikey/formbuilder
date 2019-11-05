package com.everteam.forumbuilder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class FormAdapter extends RecyclerView.Adapter<AFormElementViewHolder> {

    List<FormElement> mFormElements;

    FormAdapter(List<FormElement> mFormElemets){
        this.mFormElements = mFormElemets;
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
            Object v = cons.newInstance(view);


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

        aFormElementViewHolder.onBind(mFormElements.get(i).getBaseFormObject());
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
