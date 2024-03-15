package com.example.demoeni.viewmodel

import android.opengl.Visibility
import android.view.View
import androidx.lifecycle.ViewModel
import com.tp.tpmovie.utils.AuthRegistry

class AuthContextViewModel : ViewModel() {

    suspend fun isLogged() : Boolean {
        return AuthRegistry.isTokenExist() && AuthRegistry._isTokenValid;
    }
//
//    fun isLoggedVisibility() : Int {
//        if (isLogged()){
//            return View.VISIBLE;
//        }
//        return View.INVISIBLE;
//    }
}