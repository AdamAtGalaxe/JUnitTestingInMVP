package com.galaxe.junittestinginmvp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import java.util.*

class Registration : AppCompatActivity() {
    lateinit var name: EditText
    lateinit var password: EditText
    lateinit var birth: DatePicker
    lateinit var city: EditText
    lateinit var register: Button
    lateinit var next: Button
    lateinit var myMonth: String
    lateinit var myDay: String
    lateinit var myYear: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        supportActionBar?.hide()

        name = findViewById(R.id.name1)
        password = findViewById(R.id.password1)
        city = findViewById(R.id.city1)

        birth = findViewById(R.id.birthday)
        var today = Calendar.getInstance()

        birth.init(
            today.get(Calendar.YEAR),
            today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)
        )
        { view, year, month, day ->
            myMonth = (month + 1).toString()
            myDay = day.toString()
            myYear = year.toString()
            // var msg = "You have selected $day/$month/$year"

            //Toast.makeText(this, msg, Toast.LENGTH_LONG).show()

        }
    }

    fun showAlert(v: View) {
        var alert = AlertDialog.Builder(this)
        if (name.text.toString() != "" && password.text.toString() != "" && city.text.toString() != "") {

            alert.setTitle("ALERT!!!")
            alert.setMessage("You've been saved by the blood of GalaxE!")
            alert.setIcon(android.R.drawable.ic_dialog_alert)
            alert.setPositiveButton("Praise him") { dialog, which ->
            }

            var sharedPref: SharedPreferences =
                this.getSharedPreferences("Myfile", Context.MODE_PRIVATE)
            var sfedit: SharedPreferences.Editor = sharedPref.edit()

            sfedit.putString("name", name.text.toString())
            sfedit.putString("pass", password.text.toString())
            sfedit.putString("day", myDay)
            sfedit.putString("month", myMonth)
            sfedit.putString("year", myYear)




            sfedit.commit()
        } else {
            alert.setTitle("ALERT!!!")
            alert.setMessage("You have done wrong.. Go straight to hell!")
            alert.setIcon(android.R.drawable.ic_dialog_alert)
            alert.setPositiveButton("Womp womp") { dialog, which ->
            }
        }

        var myalert: AlertDialog = alert.create()
        myalert.show()

    }

    fun home(v: View) {

        intent = Intent(this, Welcome::class.java)
        startActivity(intent)

    }
}