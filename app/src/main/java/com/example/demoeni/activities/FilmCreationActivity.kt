package com.example.demoeni.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.demoeni.R
import com.example.demoeni.databinding.ActivityFilmCreateBinding
import com.example.demoeni.model.Film
import com.example.demoeni.viewmodel.FilmCreationViewModel
import com.tp.tpmovie.utils.AuthRegistry
import kotlinx.coroutines.launch

class FilmCreationActivity : ComponentActivity() {

    lateinit var vm: ActivityFilmCreateBinding
    var film = Film()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm = DataBindingUtil.setContentView<ActivityFilmCreateBinding>(
            this,
            R.layout.activity_film_create
        )

        val filmCreationViewModel = FilmCreationViewModel(this, film)
        vm.viewModel = filmCreationViewModel

        vm.btnSubmit.setOnClickListener()
        {
            filmCreationViewModel.creerFilm()
        }

        vm.btnCancel.setOnClickListener()
        {
            filmCreationViewModel.goToMainActivity()
        }


    }


}

