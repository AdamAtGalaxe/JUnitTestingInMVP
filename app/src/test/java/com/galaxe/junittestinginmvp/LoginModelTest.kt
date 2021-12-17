package com.galaxe.junittestinginmvp

import com.galaxe.junittestinginmvp.login.ContractInterface
import com.galaxe.junittestinginmvp.login.LoginModel
import junit.framework.Assert.assertEquals
import org.junit.Test

class LoginModelTest{

    @Test
    fun pass_verifyLogin(){
        val expected = true
        val username = "admin"
        val password = "admin123"
        val test = LoginModel()

        val actual = test.verifyLogin(username, password)


        assertEquals(expected, actual)
    }
    @Test
    fun fail_verifyLogin(){
        val expected = false
        val username = "ad"
        val password = "admin123"
        val test = LoginModel()

        val actual = test.verifyLogin(username, password)


        assertEquals(expected, actual)
    }
    @Test
    fun pass_emptyString(){
        val expected = false
        val username = " "
        val password = " "

        //Why are all the tutorials NOT having to do this step?
        val test = LoginModel()



        val actual = test.emptyString(username, password)
    }

}