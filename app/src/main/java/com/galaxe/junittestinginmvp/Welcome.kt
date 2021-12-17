package com.galaxe.junittestinginmvp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class Welcome : AppCompatActivity() {
    lateinit var info: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        supportActionBar?.hide()

        info = findViewById(R.id.info)

        var sharedPref : SharedPreferences = this.getSharedPreferences("Myfile", Context.MODE_PRIVATE)

        var name = sharedPref.getString("name", "N/A")
        var pass = sharedPref.getString("pass", "N/A")
        var year = sharedPref.getString("year", "N/A")
        var day = sharedPref.getString("day", "N/A")
        var month = sharedPref.getString("month", "N/A")


        info.text = "NAME: $name\nPassword: $pass\nBirthday: $month/$day/$year"


    }
    fun showAlert2(v: View){
        var alert = AlertDialog.Builder(this)


        alert.setTitle("ALERT!!!")
        alert.setMessage("You have been welcomed!!")
        alert.setIcon(android.R.drawable.ic_dialog_alert)
        alert.setPositiveButton("Ok"){dialog, which ->
            intent = Intent(this, AboutUs::class.java )
            startActivity(intent)
        }

        alert.setNegativeButton("Cancel"){dialog, which ->
            this.finish()
        }


        var myalert : AlertDialog = alert.create()
        myalert.show()

    }
}