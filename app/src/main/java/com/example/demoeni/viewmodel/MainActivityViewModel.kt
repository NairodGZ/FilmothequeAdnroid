package com.example.demoeni.viewmodel

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.example.demoeni.activities.ConnextionActivity
import com.example.demoeni.activities.FilmCreationActivity
import com.example.demoeni.activities.FilmDetailActivity
import com.example.demoeni.activities.MainActivity
import com.example.demoeni.model.Film
import com.example.demoeni.services.FiImService
import com.tp.tpmovie.utils.AuthRegistry
import kotlinx.coroutines.launch

class MainActivityViewModel(val context : Context, var film : Film) : ViewModel(){

    fun goToActivityLogin()
    {
        var intent = Intent(context, ConnextionActivity::class.java)

        context.startActivity(intent)

    }

    fun goToActivityCreateFilm()
    {


        var intent = Intent(context, FilmCreationActivity::class.java)

        context.startActivity(intent)

    }

    fun filmDetail(tag : String) {

        viewModelScope.launch {
            val response = FiImService.FilmApi.retrofitService.getFilmById(tag as Int);

            if(response.code == "200")
            {
                var intent = Intent(context, FilmDetailActivity::class.java)
                intent.putExtra("film", response.data)
                context.startActivity(intent)
            }


        }


    }

    fun filmDelete(tag : String) {

        var builder = AlertDialog.Builder(context);
        builder.setTitle("Confirmation")
        builder.setMessage("Etes vous sur de vouloir supprimer ce film")
        builder.setPositiveButton("Oui"){
                dialog, wich ->
            viewModelScope.launch {
                FiImService.FilmApi.retrofitService.deleteFilm(tag as Int, AuthRegistry.connexionToken);

                var intent = Intent(context, MainActivity::class.java)

                context.startActivity(intent)
            }
        }
        builder.setNegativeButton("Non"){
                dialog, wich -> dialog.dismiss()
        }
        //Afficher le dialogue
        builder.show();




    }

//    fun verifyToken()
//    {
//        var response = PersonneService.PersonApi.retrofitService.verifyToken();
//    }
    
}