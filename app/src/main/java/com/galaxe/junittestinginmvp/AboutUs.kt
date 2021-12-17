package com.galaxe.junittestinginmvp


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class AboutUs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)
        supportActionBar?.hide()
    }
    fun logout(v: View){

        var sharedPref : SharedPreferences = this.getSharedPreferences("Myfile", Context.MODE_PRIVATE)
        var sfedit : SharedPreferences.Editor = sharedPref.edit()

        sfedit.putString("name", "N/A")
        sfedit.putString("pass", "N/A")

        sfedit.commit()

        var intent = Intent(this, MainActivity()::class.java);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        startActivity(intent);

    }
}