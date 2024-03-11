package com.example.demoeni

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.app.ComponentActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import com.example.demoeni.databinding.ActivityFilmDetailBinding
import com.example.demoeni.databinding.ActivityRecyclerViewDemoBinding
import com.example.demoeni.databinding.ActivitySignUpBinding
import kotlinx.coroutines.launch

class RecyclerViewFilms : androidx.activity.ComponentActivity() {

    lateinit var vm: ActivityRecyclerViewDemoBinding;
    lateinit var dataList: List<Film>;
    lateinit var adapter: FilmAdapter;
    lateinit var film: Film

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view_demo)

        // Connecter notre adapter custom (cellule personne etc) au recyclerview
        adapter = FilmAdapter();
        vm.RV.adapter = adapter;

        lifecycleScope.launch {

            //Afficher une loading modal avant d'appeler le service

            dataList = FiImService.FilmApi.retrofitService.getFilms();

            adapter.submitList(dataList);

        }
    }

    fun filmDetail(view: View) {

        lifecycleScope.launch {
            film = FiImService.FilmApi.retrofitService.getFilmById(view.tag as Int);
            //vm.film = film
            println("fillll : " + film.toString())

            var intent = Intent(vm.root.context, FilmDetailActivity::class.java)
            intent.putExtra("film", film)
            startActivity(intent)
        }


    }

    fun filmDelete(view: View) {

        lifecycleScope.launch {
            FiImService.FilmApi.retrofitService.deleteFilm(view.tag as Int);

            var intent = Intent(vm.root.context, RecyclerViewFilms::class.java)

            startActivity(intent)
        }


    }


}