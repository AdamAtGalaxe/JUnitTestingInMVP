package com.galaxe.junittestinginmvp.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.galaxe.junittestinginmvp.R

class LoginPage : AppCompatActivity(), ContractInterface.View {

    private var presenter = LoginPresenter(this)

    lateinit var userName: EditText
    lateinit var password: EditText
    lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)
        supportActionBar?.hide()
        userName = findViewById(R.id.user)
        password = findViewById(R.id.pass)
        loginButton = findViewById(R.id.loginbutton)

        initView()

    }
    //Why is everyone doing it this way? shouldn't I create the listener in onCreate?
    override fun initView() {
        loginButton.setOnClickListener { presenter?.login() }
    }
    //Is this a remnant of an old method or am I doing this wrong? Everything is updating on its own
    override fun updateViewData() {
        TODO("Not yet implemented")
    }


    fun back(v: View){
        finish()
        //intent = Intent(this, MainActivity::class.java )
        //startActivity(intent)
    }

}