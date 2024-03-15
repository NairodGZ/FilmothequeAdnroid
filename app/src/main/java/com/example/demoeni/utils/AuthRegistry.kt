package com.tp.tpmovie.utils

import androidx.lifecycle.lifecycleScope
import com.example.demoeni.services.PersonneService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.suspendCoroutine


class AuthRegistry() {

    companion object
    {
        var connexionToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJtYWlsIjoiYmVsbGFpcmUuZG9yaWFuQGdtYWlsLmNvbSIsImlhdCI6MTcxMDQ5MzMwMywiZXhwIjoxNzEwNDk2OTAzfQ.8CQN1lt1FHeBpTsj4XcUZUFGBmiymkaaK79a6Kk3Qpc"
        var _isTokenValid = false

        fun isTokenExist() : Boolean
        {
            return (connexionToken != "")
        }


       fun verifyToken() : Boolean {

            GlobalScope.launch(Dispatchers.Main) {

                val response = PersonneService.PersonApi.retrofitService.verifyToken(connexionToken)


                if (response.code == "200") {

                    _isTokenValid = true

                } else {

                    _isTokenValid = false
                }
                println("vraie val de _ : " + _isTokenValid)

            }

           println("valll de _ : " + _isTokenValid)
            return false

        }
    }





//    fun setValidToken(_token : String){
//        token = _token;
//    }
//

//
//    companion object {
//
//        var instance : AuthRegistry? = null;
//
//        fun getAuthInstance() : AuthRegistry? {
//            if (instance != null) {
//                return instance;
//            }
//            instance = AuthRegistry("");
//            return instance;
//        }
//    }
}