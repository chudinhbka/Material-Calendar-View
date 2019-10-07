package com.applandeo.materialcalendarview.utils;

import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.widget.TextView;

import com.applandeo.materialcalendarview.R;

import java.util.Calendar;

/**
 * This class is used to set a style of calendar cells.
 * <p>
 * Created by Mateusz Kornakiewicz on 24.05.2017.
 */

public class DayColorsUtils {

    /**
     * This is general method which sets a color of the text, font type and a background of a TextView object.
     * It is used to set day cell (numbers) style.
     *
     * @param textView   TextView containing a day number
     * @param textColor  A resource of a color of the day number
     * @param typeface   A type of text style, can be set as NORMAL or BOLD
     * @param background A resource of a background drawable
     */
    public static void setDayColors(TextView textView, int textColor, int typeface, int background) {
        if (textView == null) {
            return;
        }

        textView.setTypeface(null, typeface);
        textView.setTextColor(textColor);
        textView.setBackgroundResource(background);
    }

    public static void setOtherDayColors(TextView textView, int textColor, int typeface, int background) {
        if (textView == null) {
            return;
        }

        textView.setTypeface(null, typeface);
        textView.setTextColor(textColor);
        textView.setTextSize(16);
        textView.setBackgroundResource(background);
    }

    /**
     * This method sets a color of the text, font type and a background of a TextView object.
     * It is used to set day cell (numbers) style in the case of selected day (when calendar is in
     * the picker mode). It also colors a background of the selection.
     *
     * @param dayLabel           TextView containing a day number
     * @param calendarProperties A resource of a selection background color
     */
    public static void setSelectedDayColors(TextView dayLabel, CalendarProperties calendarProperties) {
        setDayColors(dayLabel, calendarProperties.getSelectionLabelColor(), Typeface.NORMAL,
                R.drawable.background_color_circle_selector);

        setDayBackgroundColor(dayLabel, calendarProperties.getSelectionColor());
    }

    /**
     * This method is used to set a color of texts, font types and backgrounds of TextView objects
     * in a current visible month. Visible day labels from previous and forward months are set using
     * setDayColors() method. It also checks if a day number is a day number of today and set it
     * a different color and bold face type.
     *
     * @param day                A calendar instance representing day date
     * @param today              A calendar instance representing today date
     * @param dayLabel           TextView containing a day numberx
     * @param calendarProperties A resource of a color used to mark today day
     */
    public static void setCurrentMonthDayColors(Calendar day, Calendar today, TextView dayLabel,
                                                CalendarProperties calendarProperties) {
        if (today.equals(day)) {
            setTodayColors(dayLabel, calendarProperties);
        } else {
            setDayColor(day, dayLabel, calendarProperties);
        }

    }

    private static void setTodayColors(TextView dayLabel, CalendarProperties calendarProperties) {
        setDayColors(dayLabel, calendarProperties.getTodayLabelColor(), Typeface.BOLD,
                R.drawable.background_transparent);

        // Sets custom background color for present
        if (calendarProperties.getTodayColor() != 0) {
            setDayColors(dayLabel, calendarProperties.getSelectionLabelColor(), Typeface.NORMAL,
                    R.drawable.background_color_circle_selector);
            setDayBackgroundColor(dayLabel, calendarProperties.getTodayColor());
        }
    }

    private static void setDayColor(Calendar day, TextView dayLabel, CalendarProperties calendarProperties){
        int dayOfWeek = day.get(Calendar.DAY_OF_WEEK);

        if (Calendar.MONDAY == dayOfWeek) {
            setEventDayColors(day, dayLabel);
        } else if (Calendar.TUESDAY == dayOfWeek) {
            setEventDayColors(day, dayLabel);
        } else if (Calendar.WEDNESDAY == dayOfWeek) {
            setEventDayColors(day, dayLabel);
        } else if (Calendar.THURSDAY == dayOfWeek) {
            setEventDayColors(day, dayLabel);
        } else if (Calendar.FRIDAY == dayOfWeek) {
            setEventDayColors(day, dayLabel);
        } else if (Calendar.SATURDAY == dayOfWeek) {
            setSatDayColors(day, dayLabel);
        } else if (Calendar.SUNDAY == dayOfWeek) {
            setSunDayColors(day, dayLabel);
        }
    }

    private static void setEventDayColors(Calendar day, TextView dayLabel) {
        DayColorsUtils.setDayColors(dayLabel, Color.parseColor("#000000"),
                Typeface.NORMAL, R.drawable.background_transparent);
    }

    private static void setSunDayColors(Calendar day, TextView dayLabel) {
        DayColorsUtils.setDayColors(dayLabel, Color.parseColor("#C63942"),
                        Typeface.NORMAL, R.drawable.background_transparent);
    }

    private static void setSatDayColors(Calendar day, TextView dayLabel) {
        DayColorsUtils.setDayColors(dayLabel, Color.parseColor("#2165A5"),
                        Typeface.NORMAL, R.drawable.background_transparent);
    }

    private static void setSunDayNotMonthColors(Calendar day, TextView dayLabel) {
        setOtherDayColors(dayLabel, Color.parseColor("#4DC63942"),
                Typeface.NORMAL, R.drawable.background_transparent);
    }

    private static void setSatDayNotMonthColors(Calendar day, TextView dayLabel) {
        setOtherDayColors(dayLabel, Color.parseColor("#4D2165A5"),
                Typeface.NORMAL, R.drawable.background_transparent);
    }

    private static void setDayNotMonthColors(Calendar day, TextView dayLabel) {
        setOtherDayColors(dayLabel, Color.parseColor("#4D000000"),
                Typeface.NORMAL, R.drawable.background_transparent);
    }

    private static void setDayBackgroundColor(TextView dayLabel, int color) {
        dayLabel.getBackground().setColorFilter(color, android.graphics.PorterDuff.Mode.MULTIPLY);
    }

    public static void setDayNotMonthColor(Calendar day, TextView dayLabel){
        int dayOfWeek = day.get(Calendar.DAY_OF_WEEK);

        if (Calendar.MONDAY == dayOfWeek) {
            setDayNotMonthColors(day, dayLabel);
        } else if (Calendar.TUESDAY == dayOfWeek) {
            setDayNotMonthColors(day, dayLabel);
        } else if (Calendar.WEDNESDAY == dayOfWeek) {
            setDayNotMonthColors(day, dayLabel);
        } else if (Calendar.THURSDAY == dayOfWeek) {
            setDayNotMonthColors(day, dayLabel);
        } else if (Calendar.FRIDAY == dayOfWeek) {
            setDayNotMonthColors(day, dayLabel);
        } else if (Calendar.SATURDAY == dayOfWeek) {
            setSatDayNotMonthColors(day, dayLabel);
        } else if (Calendar.SUNDAY == dayOfWeek) {
            setSunDayNotMonthColors(day, dayLabel);
        }
    }
}
