package com.example.demoeni.activities

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.demoeni.services.PersonneService
import com.example.demoeni.R
import com.example.demoeni.databinding.ActivitySignUpBinding
import com.example.demoeni.model.Personne
import kotlinx.coroutines.launch

class InscriptionActivity : ComponentActivity() {
    lateinit var personne : Personne
    lateinit var vm : ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm = DataBindingUtil.setContentView<ActivitySignUpBinding>(this, R.layout.activity_sign_up)

        vm.personne = Personne()

    }

    fun inscription(view : View)
    {
        personne = vm.personne!!

        lifecycleScope.launch {
            PersonneService.PersonApi.retrofitService.createPersonne(personne);


            var builder = AlertDialog.Builder(vm.root.context);
            builder.setTitle("Inscription")
            builder.setMessage("Vous etes inscrits avec succès")
            builder.setPositiveButton("OK"){
                    dialog, wich -> var intent = Intent(vm.root.context, ConnextionActivity::class.java)
                startActivity(intent)
            }
            //Afficher le dialogue
            builder.show();
        }




    }

}

