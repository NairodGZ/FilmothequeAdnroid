package com.example.demoeni

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.demoeni.databinding.ActivityRecyclerViewDemoBinding
import com.example.demoeni.databinding.ActivitySignUpBinding
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    lateinit var vm: ActivityRecyclerViewDemoBinding;
    lateinit var adapter: FilmAdapter;
    lateinit var film: Film
    lateinit var connexionToken : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view_demo)

        vm.connexionToken = ConnextionActivity.connexionToken

        // Connecter notre adapter custom (cellule personne etc) au recyclerview
        adapter = FilmAdapter();
        vm.RV.adapter = adapter;

        lifecycleScope.launch {

            //Afficher une loading modal avant d'appeler le service

            val response = FiImService.FilmApi.retrofitService.getFilms();

            adapter.submitList(response.data);

        }
    }


    fun goToActivityLogin(view: View)
    {
        var intent = Intent(this, ConnextionActivity::class.java)

        startActivity(intent)

    }

    fun filmDetail(view: View) {

        lifecycleScope.launch {
            val response = FiImService.FilmApi.retrofitService.getFilmById(view.tag as Int);

            if(response.code == "200")
            {
                var intent = Intent(vm.root.context, FilmDetailActivity::class.java)
                intent.putExtra("film", response.data)
                startActivity(intent)
            }


        }


    }

    fun filmDelete(view: View) {

        var builder = AlertDialog.Builder(this);
        builder.setTitle("Confirmation")
        builder.setMessage("Etes vous sur de vouloir supprimer ce film")
        builder.setPositiveButton("Oui"){
                dialog, wich ->
            lifecycleScope.launch {
                FiImService.FilmApi.retrofitService.deleteFilm(view.tag as Int, ConnextionActivity.connexionToken);

                var intent = Intent(vm.root.context, MainActivity::class.java)

                startActivity(intent)
            }
        }
        builder.setNegativeButton("Non"){
                dialog, wich -> dialog.dismiss()
        }
        //Afficher le dialogue
        builder.show();




    }


}

