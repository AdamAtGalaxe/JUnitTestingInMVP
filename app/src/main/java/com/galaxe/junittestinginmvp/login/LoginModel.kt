package com.galaxe.junittestinginmvp.login

class LoginModel : ContractInterface.Model{
    override fun verifyLogin(userName: String, password: String) : Boolean{
        return (userName == "admin" && password == "admin123")
    }
    override fun emptyString(userName: String, password: String) : Boolean{
        return (userName == "" && password == "")
    }

}