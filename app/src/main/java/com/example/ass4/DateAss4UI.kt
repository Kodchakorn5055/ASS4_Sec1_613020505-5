package com.example.ass4

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import java.text.DateFormat
import java.util.*


class DateAss4UI :DialogFragment(),DatePickerDialog.OnDateSetListener{
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var calendar = Calendar.getInstance()
        val month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(
            activity!!,
            2,
            this,
            month,
            day,
            year
        )
    }

    override fun onDateSet(view: DatePicker, month: Int, day: Int, year: Int) {
        var textView: TextView? = activity?.findViewById(R.id.show_date)
        textView!!.text=formatDate(month, day, year)

    }
    override fun onCancel(dialog: DialogInterface) {
        Toast.makeText(activity, "Please select a date.", Toast.LENGTH_SHORT).show()
        super.onCancel(dialog)
    }
    private fun formatDate(month: Int, day: Int, year: Int):String{
        var calendar: Calendar = Calendar.getInstance();
        calendar.set(month, day, year)
        val chosenDate = calendar.time
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM)
        return df.format(chosenDate)
    }

    }




