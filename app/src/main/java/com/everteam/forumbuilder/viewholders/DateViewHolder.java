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

import static com.everteam.forumbuilder.formobjects.DateFormObj.DateType.*;

public class DateViewHolder extends AFormElementViewHolder {

    DateFormObj dateFormObj;
    DateThemeConfig customThemConfig, mainThemeConfig;
    TextView textView;
    EditText editText;
    boolean isDateOnly,
            isTimeOnly,
            isDateAndTime;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minut;
    private String date ="";
    private String time ="";

    public DateViewHolder(@NonNull View itemView) {
        super(itemView);

        textView =  itemView.findViewById(R.id.textView);
        editText = itemView.findViewById(R.id.editText);

        editText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {

                    if(dateFormObj.getDateType() == DATETIME || dateFormObj.getDateType() == DATE)
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

        String dateStr = dateFormObj.getDate();

        Date date = null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( dateFormObj.getIncomingFormat());
            try {


        if(!this.date.equals(""))
        {
            simpleDateFormat = new SimpleDateFormat(dateFormObj.getDateFormat());
            date = simpleDateFormat.parse(this.date);
        }
        else if(dateStr.equals("")){
            date = Calendar.getInstance().getTime();
         }

    else {
                date = simpleDateFormat.parse(dateFormObj.getDate());
         }
    }
    catch (Exception ex) {

    }

        final Calendar myCalendar = Calendar.getInstance();
        myCalendar.setTime(date);

        new DatePickerDialog(textView.getContext(), new OnDateSetListener(),
                myCalendar.get(Calendar.YEAR),
                myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    void showTimePicker(){

        String dateStr = dateFormObj.getDate();

        Date date = null;

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormObj.getIncomingFormat());
        try {
            if(!this.time.equals(""))
            {
            simpleDateFormat = new SimpleDateFormat(dateFormObj.getTimeFormat());
            date = simpleDateFormat.parse(this.time);
            }

            else if(dateStr.equals("")) {
                date = Calendar.getInstance().getTime();
            } else {
                date = simpleDateFormat.parse(dateFormObj.getDate());
            }
        }
        catch (Exception ex) {

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
        public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {

            hour  = hourOfDay;
            minut = minute;

            if(dateFormObj.getDateType() == TIME){
                setTimeText(false);

            }
            else
            {
                setDateText();
                setTimeText(true);

            }
        }
    }


    class OnDateSetListener implements  DatePickerDialog.OnDateSetListener{

        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

            year  = datePicker.getYear();
            month = datePicker.getMonth();
            day   = datePicker.getDayOfMonth();

            if(dateFormObj.getDateType() == DATE)
            {
                setDateText();
                return;
            }

            showTimePicker();
        }
    }

    private void setDateText() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( dateFormObj.getDateFormat());

        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day);

        date = simpleDateFormat.format(cal.getTime());

        editText.setText(date);
    }


    private void setTimeText(boolean additive) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( dateFormObj.getTimeFormat());

        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day, hour, minut);

        time = simpleDateFormat.format(cal.getTime());

        editText.setText(additive ? editText.getText()+" "+ time : time);
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
