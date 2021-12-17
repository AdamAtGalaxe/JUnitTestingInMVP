package com.galaxe.junittestinginmvp.login

interface ContractInterface {

    interface View {
        fun initView()
        fun updateViewData()
    }

    interface Presenter {

        fun login()
    }

    interface Model {
        fun verifyLogin(userName: String, password: String): Boolean
        fun emptyString(userName: String, password: String): Boolean
    }

}