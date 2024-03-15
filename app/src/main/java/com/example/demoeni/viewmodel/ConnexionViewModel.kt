package com.example.demoeni.viewmodel

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoeni.activities.ForgottenPasswordActivity
import com.example.demoeni.activities.InscriptionActivity
import com.example.demoeni.activities.MainActivity
import com.example.demoeni.model.Personne
import com.example.demoeni.services.PersonneService
import com.tp.tpmovie.utils.AuthRegistry
import kotlinx.coroutines.launch

class ConnexionViewModel(var context : Context, var personne : Personne) : ViewModel() {



    fun goToActivityForgottenPassword()
    {
        var intent = Intent(context, ForgottenPasswordActivity::class.java)

        context.startActivity(intent)

    }

    fun goToActivityInscription(view : View)
    {
        var intent = Intent(context, InscriptionActivity::class.java)

        context.startActivity(intent)

    }

    fun connect()
    {
        var builder = AlertDialog.Builder(context);
        builder.setTitle("Connxexion")

        viewModelScope.launch {

            var response = PersonneService.PersonApi.retrofitService.login(personne);

            //println("reponse coddee : " + response.code)

            if(response.code == "200")
            {
                AuthRegistry.connexionToken = response.data!!

                //println("Tokeennn de coooo : " + connexionToken)

                builder.setMessage("Vous etes connectés avec succès")

                builder.setPositiveButton("OK"){
                        dialog, wich -> var intent = Intent(context, MainActivity::class.java)

                    context.startActivity(intent)
                }

                builder.show();
            }
            else
            {

                builder.setMessage("Connexion echouée")

                builder.setNeutralButton("Se rendre a la page d'oubli de mot de passe"){
                        dialog, wich -> var intent = Intent(context, ForgottenPasswordActivity::class.java)

                    context.startActivity(intent)
                }
                builder.setPositiveButton("Reessayer"){
                        dialog, wich -> dialog.dismiss()
                }

                //Afficher le dialogue
                builder.show();

            }

        }



    }

}