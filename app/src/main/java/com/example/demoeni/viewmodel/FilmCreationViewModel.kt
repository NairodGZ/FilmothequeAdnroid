package com.example.demoeni.viewmodel

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoeni.activities.MainActivity
import com.example.demoeni.model.Film
import com.example.demoeni.services.FiImService
import com.tp.tpmovie.utils.AuthRegistry
import kotlinx.coroutines.launch

class FilmCreationViewModel(val context : Context, var film : Film) : ViewModel(){


    fun creerFilm() {
        

        var builder = AlertDialog.Builder(context);
        builder.setTitle("Création de film")



        viewModelScope.launch {

            var response =  FiImService.FilmApi.retrofitService.createFilm(film, AuthRegistry.connexionToken);

            if(response.code == "200")
            {
                builder.setMessage("Film créé avec succès")
                builder.setPositiveButton("Retourner a l'acceuil"){
                        dialog, wich ->
                    var intent = Intent(context, MainActivity::class.java)

                    context.startActivity(intent)

                }

                builder.show();

            }
            else
            {
                builder.setMessage("Création du film échoué")
                builder.setNeutralButton("Retourner a l'acceuil"){
                        dialog, wich ->
                    var intent = Intent(context, MainActivity::class.java)

                    context.startActivity(intent)

                }
                builder.setNeutralButton("Reessayer"){
                        dialog, wich ->
                   // var intent = Intent(context, FilmCreationActivity::class.java)
                  //  context.startActivity(intent)

                }

                builder.show();
            }


        }
    }

    fun goToMainActivity()
    {
        var intent = Intent(context, MainActivity::class.java)

        context.startActivity(intent)
    }
}