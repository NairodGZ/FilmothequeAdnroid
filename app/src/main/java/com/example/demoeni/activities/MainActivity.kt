package com.example.demoeni.activities

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.demoeni.R
import com.example.demoeni.services.FiImService
import com.example.demoeni.adapters.FilmAdapter
import com.example.demoeni.databinding.ActivityRecyclerViewDemoBinding
import com.example.demoeni.model.Film
import com.example.demoeni.viewmodel.MainActivityViewModel
import com.tp.tpmovie.utils.AuthRegistry
import com.tp.tpmovie.utils.Helpers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    lateinit var vm: ActivityRecyclerViewDemoBinding;
    lateinit var adapter: FilmAdapter;
    lateinit var film: Film


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Helpers.showProgressDialog(this, "Chargement des films")

        vm = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view_demo)

        vm.viewModel = MainActivityViewModel(this, film)
        vm.viewModelCell = MainActivityViewModel(this, film)

        vm.connexionToken = AuthRegistry.connexionToken

        // Connecter notre adapter custom (cellule personne etc) au recyclerview
        adapter = FilmAdapter();
        vm.RV.adapter = adapter;

        lifecycleScope.launch {

            //Afficher une loading modal avant d'appeler le service

            val response = FiImService.FilmApi.retrofitService.getFilms();

            adapter.submitList(response.data);

        }

        Helpers.closeProgressDialog()

        vm

    }







}

