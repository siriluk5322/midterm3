package com.example.midterm3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*
import layout.Student

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var data = intent.extras
        var newStudent = data?.getParcelable<Student>("StudentData")
        nameText.text = "Student Name : ${newStudent?.name}"
        passText.text = "Password : ${newStudent?.pass}"
        genderText.text = "Gender : ${newStudent?.gender}"
        emailText.text = "Email : ${newStudent?.email}"
        birthdayText.text = "Birthday : ${newStudent?.birthday}"
        timeText.text = "Time : ${newStudent?.time}"
        majorText.text = "Major : ${newStudent?.major}"
        fruiteText.text = "Fruite : ${newStudent?.fruit}"

    }

    fun onClickClose(view: View) {
        finish()
    }
}