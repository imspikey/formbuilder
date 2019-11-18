package com.everteam.forumbuilder.viewholders;

import android.app.DatePickerDialog;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.everteam.forumbuilder.R;
import com.everteam.forumbuilder.formobjects.BaseFormObj;
import com.everteam.forumbuilder.formobjects.DateFormObj;
import com.everteam.forumbuilder.themeconfigs.BaseThemeConfig;
import com.everteam.forumbuilder.themeconfigs.DateThemeConfig;

import java.util.Calendar;

public class DateViewHolder extends AFormElementViewHolder {

    DateFormObj dateFormObj;
    DateThemeConfig customThemConfig, mainThemeConfig;
    TextView textView;
    EditText editText;
    public DateViewHolder(@NonNull View itemView) {
        super(itemView);

        textView =  itemView.findViewById(R.id.textView);
        editText = itemView.findViewById(R.id.editText);

        editText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final Calendar myCalendar = Calendar.getInstance();
                myCalendar.setTimeInMillis(0);
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    new DatePickerDialog(textView.getContext(), new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                        }
                    },
                            myCalendar.get(Calendar.YEAR),
                            myCalendar.get(Calendar.MONTH),
                            myCalendar.get(Calendar.MINUTE)).show();
                }
                return true;
            }
        });

    }

    @Override
    public void onBind(BaseFormObj baseFormObj) {

        dateFormObj = (DateFormObj) baseFormObj;
        mainThemeConfig = (DateThemeConfig) dateFormObj.getBaseThemeConfig();

        DateThemeConfig config;

        if(mainThemeConfig != null)
        {
            config = mainThemeConfig;
        }
        else
        {
            config = customThemConfig;
        }


        textView.setText(dateFormObj.getLabel());

    }

    @Override
    public void onBind(BaseFormObj baseFormObj, BaseThemeConfig baseThemeConfig) {
        customThemConfig = (DateThemeConfig) baseThemeConfig;
        onBind(baseFormObj);
    }
}
