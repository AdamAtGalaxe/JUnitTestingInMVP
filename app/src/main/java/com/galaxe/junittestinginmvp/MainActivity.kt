package com.galaxe.junittestinginmvp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.galaxe.junittestinginmvp.login.LoginPage

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var logedin = false

        var sharedPref : SharedPreferences = this.getSharedPreferences("Myfile", Context.MODE_PRIVATE)

        var n = sharedPref.getString("name", "N/A")
        var p = sharedPref.getString("pass", "N/A")

        Toast.makeText(this, "$n : $p", Toast.LENGTH_LONG)
        if(n != "N/A" && p!= "N/A") logedin = true

        if(logedin == false){

            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            supportActionBar?.hide()
        }
        else{
            intent = Intent(this, AboutUs::class.java )
            startActivity(intent)
        }
    }
    fun login(v: View){

        intent = Intent(this, LoginPage::class.java )
        startActivity(intent)
    }
    fun register(v: View){

        intent = Intent(this, Registration::class.java )
        startActivity(intent)

    }

}