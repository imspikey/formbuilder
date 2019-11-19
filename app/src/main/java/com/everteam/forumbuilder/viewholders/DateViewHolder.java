package com.everteam.forumbuilder.viewholders;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import com.everteam.forumbuilder.R;
import com.everteam.forumbuilder.formobjects.BaseFormObj;
import com.everteam.forumbuilder.formobjects.DateFormObj;
import com.everteam.forumbuilder.themeconfigs.BaseThemeConfig;
import com.everteam.forumbuilder.themeconfigs.DateThemeConfig;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateViewHolder extends AFormElementViewHolder {

    DateFormObj dateFormObj;
    DateThemeConfig customThemConfig, mainThemeConfig;
    TextView textView;
    EditText editText;
    boolean isDateOnly, isTimeOnly, isDateAndTime;
    public DateViewHolder(@NonNull View itemView) {
        super(itemView);

        textView =  itemView.findViewById(R.id.textView);
        editText = itemView.findViewById(R.id.editText);

        editText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {


                    if(dateFormObj.getDateType() == DateFormObj.DateType.DATETIME || dateFormObj.getDateType() == DateFormObj.DateType.DATE)
                            showDatePicker();
                    else{
                        showTimePicker();
                    }
                }
                return true;
            }
        });

    }

    void showDatePicker(){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( dateFormObj.getIncomingFormat());

        Date date = null;
        try{
             date = simpleDateFormat.parse(dateFormObj.getDate());
        }
        catch (Exception ex){

        }
        final Calendar myCalendar = Calendar.getInstance();
        myCalendar.setTime(date);


        new DatePickerDialog(textView.getContext(), new OnDateSetListener(),
                myCalendar.get(Calendar.YEAR),
                myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    void showTimePicker(){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( dateFormObj.getIncomingFormat());

        Date date = null;
        try{
            date = simpleDateFormat.parse(dateFormObj.getDate());
        }
        catch (Exception ex){

        }
        final Calendar myCalendar = Calendar.getInstance();
        myCalendar.setTime(date);


        new TimePickerDialog(
                textView.getContext(),
                new OnTimeSetListener(),
                myCalendar.get(Calendar.HOUR_OF_DAY),
                myCalendar.get(Calendar.MINUTE),
                true).show();
    }

    class  OnTimeSetListener implements   TimePickerDialog.OnTimeSetListener{

        @Override
        public void onTimeSet(TimePicker timePicker, int i, int i1) {

            if(dateFormObj.getDateType() == DateFormObj.DateType.DATETIME){

            }
        }
    }

    class OnDateSetListener implements  DatePickerDialog.OnDateSetListener{

        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            showTimePicker();
        }
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
