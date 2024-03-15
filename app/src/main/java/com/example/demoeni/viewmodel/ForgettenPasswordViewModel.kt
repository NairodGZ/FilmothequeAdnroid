package com.example.demoeni.viewmodel

import android.app.AlertDialog
import android.content.Context
import android.view.View
import androidx.lifecycle.ViewModel

class ForgettenPasswordViewModel(var context : Context, var email : String = "") : ViewModel(){


    fun forgottenPasswordSend()
    {

        val emailSaisi = email;

        var builder = AlertDialog.Builder(context);
        builder.setTitle("Mot de passe oublié")
        builder.setMessage("Le lien de récupération de mot de passe vous a été envoyé a : $emailSaisi")
        builder.setPositiveButton("OK"){
                dialog, wich -> dialog.dismiss();
        }

        //Afficher le dialogue
        builder.show();

    }

}