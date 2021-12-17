package com.galaxe.junittestinginmvp.login

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import com.galaxe.junittestinginmvp.login.ContractInterface.*
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.galaxe.junittestinginmvp.AboutUs
import com.galaxe.junittestinginmvp.R

class LoginPresenter(_view: LoginPage): Presenter {
    private var view: LoginPage = _view
    private var model: Model = LoginModel()
    override fun login() {

        if (model.verifyLogin(view.userName.text.toString(), view.password.text.toString())) {

            var sharedPref: SharedPreferences =
                view.getSharedPreferences("Myfile", Context.MODE_PRIVATE)
            var sfedit: SharedPreferences.Editor = sharedPref.edit()
            Toast.makeText(view, "Logged in!", Toast.LENGTH_LONG).show()
            sfedit.putString("name", view.userName.text.toString())
            sfedit.putString("pass", view.password.text.toString())

            sfedit.commit()



            var intent = Intent(view, AboutUs::class.java)
            view.startActivity(intent)
        } else if (model.emptyString(
                view.userName.text.toString(),
                view.password.text.toString()
            )
        ) {
            var msg = "Username and/or password are empty."
            showAlert(view.findViewById(R.id.loginPageLayout), msg)
            //Toast.makeText(view, "x!", Toast.LENGTH_LONG).show()
        } else {
            var msg = "Username and/or password are incorrect."
            showAlert(view.findViewById(R.id.loginPageLayout), msg)
            //Toast.makeText(view, "o!", Toast.LENGTH_LONG).show()
        }
    }

    fun showAlert(v: View, msg: String) {
        var alert = AlertDialog.Builder(view)
        alert.setTitle("Error")
        alert.setMessage(msg)
        alert.setIcon(android.R.drawable.ic_dialog_alert)
        alert.setPositiveButton("OK") { dialog, which ->


            var myalert: AlertDialog = alert.create()
            myalert.show()
        }
    }
}

