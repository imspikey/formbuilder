package com.everteam.forumbuilder;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MultiSelectionFormViewHolder extends AFormElementViewHolder {

    private EditText mEditText;
    private TextView mTextView;
    private MultiSelectionFormObj mMultiSelectionFormObj;

    @SuppressLint("ClickableViewAccessibility")
    public MultiSelectionFormViewHolder(@NonNull View itemView) {
        super(itemView);

        mEditText = itemView.findViewById(R.id.editText);
        mTextView = itemView.findViewById(R.id.textView);
        mEditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    final Dialog dialog = new Dialog(mEditText.getContext(),
                            android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                    dialog.setContentView(R.layout.multiselect_dialog);
                    dialog.setCancelable(true);

                    final ListView listView = dialog.findViewById(R.id.listVIew);
                    final String[] names =
                            {"Denmark",
                            "Panama",
                            "Mexico",
                            "Yugoslavia"};
                    ListAdapter listAdapter = new ArrayAdapter<String>(listView.getContext(),
                            R.layout.list_layout,android.R.id.text1,names);

                    listView.setAdapter(listAdapter);
                    listView.setChoiceMode(mMultiSelectionFormObj.isMultiSelect() ?
                            AbsListView.CHOICE_MODE_MULTIPLE : AbsListView.CHOICE_MODE_SINGLE);

//                   int size =   mMultiSelectionFormObj.getSelectedIndexes().size();
//
//                    for (:
//                         ) {
//
//                    }
                    ArrayList<Integer> selectedIndexess = mMultiSelectionFormObj.getSelectedIndexes();

                    if(selectedIndexess != null) {
                        for (Integer index : selectedIndexess) {
                            listView.setItemChecked(index, true);
                        }
                    }


                    FloatingActionButton doneButton = dialog.findViewById(R.id.doneButton);

                    doneButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            SparseBooleanArray checkedItemPositions = listView.getCheckedItemPositions();
                            ;
                            ArrayList<Integer> selectedIndexes = new ArrayList<>();
                            mEditText.setTextSize(15);
                            StringBuilder result = new StringBuilder();
                            int itemCount = listView.getCount();
                            for(int i =0; i < itemCount; i++){

                                if(!checkedItemPositions.get(i))
                                    continue;

                                if(selectedIndexes.size() < 3)
                                result.append(names[i]).append(i+1  < itemCount && mMultiSelectionFormObj.isMultiSelect() ? ", " : "");

                                selectedIndexes.add(i);
                            }

                            if(checkedItemPositions.size() > 3){
                                result.append("...");
                                mEditText.setTextSize(12);
                            }

                            mMultiSelectionFormObj.setSelectedIndexes(selectedIndexes);

                            mEditText.setText(result.toString());

                            dialog.dismiss();
                        }
                    });
                    dialog.show();
                }
                return true;
            }
        });
    }

    @Override
    void onBind(BaseFormObj baseFormObj) {
        mMultiSelectionFormObj = (MultiSelectionFormObj) baseFormObj;
    }

    @Override
    void onBind(BaseFormObj baseFormObj, BaseThemeConfig baseThemeConfig) {

    }
}





