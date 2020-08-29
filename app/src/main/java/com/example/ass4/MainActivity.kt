package com.example.ass4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun addListenerOnButton() {
        radio_group.setOnClickListener {
            var selectID :Int = radio_group.checkedRadioButtonId
            var radioButtonChecked : RadioButton = findViewById(selectID)
            var toast: Toast = Toast.makeText(this, radioButtonChecked.text, Toast.LENGTH_LONG)
            toast.show()
        }
    }

    fun showDatePickerDialog(v:View){
        val newDateFormant = DateAss4UI()
        newDateFormant.show(supportFragmentManager,"Date")
    }
    fun showRegister(v: View){
        var seletedId: Int = radio_group.checkedRadioButtonId
        var radioButton: RadioButton = findViewById(seletedId)
        text_show.text = "Name: ${edit_name.text}\nPassword: ${edit_pass.text}\nGender: ${radioButton.text}\nEmail: ${edit_Email.text}\nBirthday: ${show_date.text} "
    }
    fun reset(v: View){
        edit_name.text.clear()
        edit_pass.text.clear()
        edit_Email.text.clear()
        show_date.text="__/__/__"
        text_show.text="Show information"

    }
}