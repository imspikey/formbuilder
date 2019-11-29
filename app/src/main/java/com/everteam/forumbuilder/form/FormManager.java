package com.everteam.forumbuilder.form;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import com.everteam.forumbuilder.formobjects.BaseFormObj;
import com.everteam.forumbuilder.formobjects.DateFormObj;
import com.everteam.forumbuilder.formobjects.FormJasonObjectsContainer;
import com.everteam.forumbuilder.formobjects.MultiSelectionFormObj;
import com.everteam.forumbuilder.formobjects.TextFiledFormObj;
import com.everteam.forumbuilder.utils.JsonParser;
import com.everteam.forumbuilder.MainActivity;
import com.everteam.forumbuilder.formobjects.ButtonFormObj;
import org.json.JSONException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FormManager implements ButtonFormObj.ButtonListener{

    private  FormJasonObjectsContainer formJasonObjectsContainer;
    private  RecyclerView recyclerView;
    private  RecyclerView.LayoutManager layoutManager;
    ArrayList<FormElement> formElements;
    Context context;

    public FormManager(RecyclerView.LayoutManager layoutManager,Context mainActivity,ArrayList<FormElement> formElements){
        this.formElements = formElements;
        this.context = mainActivity;
        this.layoutManager = layoutManager;
    }

    public FormManager(RecyclerView.LayoutManager layoutManager, MainActivity mainActivity,
                       RecyclerView recyclerView, String jsonElements){

       int spanCount = layoutManager instanceof GridLayoutManager ? ((GridLayoutManager)layoutManager).getSpanCount() : 1;
        this.formJasonObjectsContainer  = createFormElements(jsonElements,spanCount);
        this.formElements = formJasonObjectsContainer.getFormElements();
        this.context       = mainActivity;
        this.layoutManager = layoutManager;
        this.recyclerView  = recyclerView;
        createForm();
    }

    private void createForm() {

        ((GridLayoutManager)layoutManager).setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int i) {
                return   formElements.get(i).getSpan();
            }
        });
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new FormAdapter(formElements,formJasonObjectsContainer.getButtonThemeConfig(),
                formJasonObjectsContainer.getTextFiledThemeConfig(),formJasonObjectsContainer.getDateThemeConfig()));
    }

    Pair<Boolean, String> isFormValid(){
        Pair<Boolean, String> message = new Pair<>(true,"Under Construction");
        return message;
    }

    FormJasonObjectsContainer createFormElements(String jsonArrayString, int layoutSpanCount){
        try {
            return JsonParser.convertToFormElementArrayList(jsonArrayString,this, layoutSpanCount);
        } catch (JSONException e) {
            e.printStackTrace();
            return  null;
        }
    }

    //todo ...
    @Override
    public void clicked() {

        boolean isFormValid = true;

        Map<String, Map<String, Object>> formData = new HashMap<>();
        for(int i = 0; i < formElements.size(); i++){
            FormElement element = formElements.get(i);

                if(!element.getFormElementViewHolder().isElementValid())
                {
                        isFormValid = false;
                        break;
                }
            BaseFormObj formObject = element.getBaseFormObject();

                Map<String, Object> elementsMap = new HashMap<>();

                elementsMap.put("id", formObject.getId());

                if(formObject instanceof TextFiledFormObj)
                {
                    TextFiledFormObj texFiled = (TextFiledFormObj) formObject;
                    elementsMap.put("text",texFiled.getText());

                } else if(formObject instanceof MultiSelectionFormObj) {

                    MultiSelectionFormObj multiSelectionFiled = (MultiSelectionFormObj) formObject;

                    if(multiSelectionFiled.isMultiSelect())
                    elementsMap.put("multi",multiSelectionFiled.getSelectedIndexes());
                    else
                    elementsMap.put("selection",multiSelectionFiled.getSelectedIndexes().get(0));

                } else if(formObject instanceof DateFormObj){

                }

                formData.put(formObject.getId(), elementsMap);
        }

        ((ButtonFormObj.ButtonListener) context).clicked();
    }
}
