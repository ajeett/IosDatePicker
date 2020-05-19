package com.wheelview

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.iosdatepicker.wheelview.view.DatePickerPopUpWindow
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity(), DatePickerPopUpWindow.OnDateSelectedListener {
    private val DEFAULT_TEMPLATE = "dd/MM/yyyy"

    private val formatter: SimpleDateFormat =
        SimpleDateFormat(DEFAULT_TEMPLATE, Locale.getDefault())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.date).setOnClickListener { v: View? ->
            val datePicker: DatePickerPopUpWindow =
                DatePickerPopUpWindow.Builder(
                        applicationContext
                    )
                    .setMinYear(1990)
                    .setMaxYear(2550)
                    .setSelectedDate("2013-11-11")
                    .setLocale(Locale.getDefault())
                    .setOnDateSelectedListener(this)
                    .setConfirmButtonText("CONFIRM")
                    .setCancelButtonText("CANCEL")
                    .setConfirmButtonTextColor(Color.parseColor("#999999"))
                    .setCancelButtonTextColor(Color.parseColor("#009900"))
                    .setButtonTextSize(16)
                    .setViewTextSize(15)
                    .setShowShortMonths(true)
                    .setShowDayMonthYear(true)
                    .build()
            datePicker.show(this)
        }
    }

    override fun onDateSelected(year: Int, month: Int, dayOfMonth: Int) {
         var calendar = Calendar.getInstance(Locale.getDefault());

        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.YEAR, year);

        Toast.makeText(this, formatter.format(calendar.getTime()), Toast.LENGTH_SHORT).show();
    }
}
