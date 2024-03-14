package com.tp.tpmovie.utils

import androidx.lifecycle.lifecycleScope
import com.example.demoeni.services.PersonneService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class AuthRegistry() {

    companion object
    {
        var connexionToken = ""
        var isTokenValid = false

        fun isTokenExist() : Boolean
        {
            return (connexionToken != "")
        }

        fun isTokenValid() : Boolean
        {
            return isTokenValid
        }

        fun verifyToken()
        {
            CoroutineScope(Dispatchers.Main).launch{

                val response = PersonneService.PersonApi.retrofitService.verifyToken(connexionToken);

                if(response.code == "200")
                {
                    isTokenValid = true
                }
                else
                {
                    isTokenValid = false
                }

            }
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