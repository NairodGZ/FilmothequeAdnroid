package com.example.demoeni

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.demoeni.databinding.ActivityFilmDetailBinding
import kotlinx.coroutines.launch

class FilmDetailActivity : ComponentActivity() {

    lateinit var vm : ActivityFilmDetailBinding
    lateinit var film: Film

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm = DataBindingUtil.setContentView<ActivityFilmDetailBinding>(this, R.layout.activity_film_detail)

        val film = intent.getParcelableExtra<Film>("film") as Film


        vm.film = film

    }

    fun modifierFilm(view: View) {

        film = vm.film!!

        lifecycleScope.launch {
            FiImService.FilmApi.retrofitService.updateFilm(film);

            var intent = Intent(vm.root.context, RecyclerViewFilms::class.java)
            startActivity(intent)
        }
    }








}

