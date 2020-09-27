package com.example.midterm3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import layout.Student

class MainActivity : AppCompatActivity() {
    var major :String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ////Set Spinner
        val majorSpinner: Spinner = major_spinner;
        val majorArray = resources.getStringArray(R.array.major_array)

        val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_item, majorArray)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        majorSpinner.adapter = arrayAdapter

        majorSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                major = majorArray[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }
    fun showregister(view: View) {
        val intent = Intent(this, SecondActivity::class.java)
        var radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        var selectedId : Int = radioGroup.checkedRadioButtonId;
        var radioButton : RadioButton = findViewById(selectedId);
        var str:String = ""
        if (apple.isChecked){
            str += " " + apple.text;
        }
        if (banana.isChecked){
            str += " " + banana.text;
        }
        var str_new = if (str.isNotEmpty()) str else "Please select your favorite fruit."
        intent.putExtra("StudentData", Student(edit_name.text.toString(),edit_password.text.toString(), radioButton.text.toString(),edit_email.text.toString(),text_date.text.toString(),text_time.text.toString(),major.toString(),str_new.toString()))
        startActivity(intent)
    }
    fun showTimePickerDialog(view: View) {
        val newTimeFragment = TimePickerFragment()
        newTimeFragment.show(supportFragmentManager, "Time Picker")
    }
    fun showDatePickerDialog(view: View) {
        val newDateFragment = DatePickerFragment()
        newDateFragment.show(supportFragmentManager, "Date Picker")
    }
    fun reset(view: View) {
        edit_name.text.clear()
        edit_password.text.clear()
        radioGroup.clearCheck()
        edit_email.text.clear()
        text_date.text="mm/dd/yy"
        text_time.text="_ _ : _ _"
        major_spinner.setSelection(0)
        apple.isChecked=false
        banana.isChecked=false
    }

    fun save(view: View) {
        val toast :Toast = Toast.makeText ( this, "Successful.",Toast.LENGTH_LONG )
        toast.show ( )
    }
}