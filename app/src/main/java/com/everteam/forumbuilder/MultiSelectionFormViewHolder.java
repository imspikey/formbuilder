package com.everteam.forumbuilder;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

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

                    ListView listView = dialog.findViewById(R.id.listVIew);
                    String[] names =
                            {"Not Playing",
                            "playing",
                            "Still Playing",
                            "Not Playing"};
                    ListAdapter listAdapter = new ArrayAdapter<String>(listView.getContext(),
                            R.layout.list_layout,android.R.id.text1,names);

                    listView.setAdapter(listAdapter);
                    listView.setChoiceMode(mMultiSelectionFormObj.isMultiSelect() ?
                            AbsListView.CHOICE_MODE_MULTIPLE : AbsListView.CHOICE_MODE_SINGLE);

                    listView.setItemChecked(2, true);

                    FloatingActionButton doneButton = dialog.findViewById(R.id.doneButton);

                    doneButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
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
}





