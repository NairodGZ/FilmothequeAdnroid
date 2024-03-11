package com.example.demoeni

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import com.example.demoeni.databinding.ActivitySignUpBinding

class MainActivity : ComponentActivity() {

    lateinit var SignUpView : ActivitySignUpBinding
    lateinit var personne : Personne

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SignUpView = DataBindingUtil.setContentView<ActivitySignUpBinding>(this, R.layout.activity_sign_up)

    }

    fun goToActivityLogin(view: View)
    {

        var builder = AlertDialog.Builder(this);
        builder.setTitle("Insciption")
        builder.setMessage("Votre compte fut créé avec succces")
        builder.setPositiveButton("Se rendre a la page de connexion"){
                dialog, wich -> var intent = Intent(this, ConnextionActivity::class.java)

            startActivity(intent)
            ;
        }

        //Afficher le dialogue
        builder.show();



    }


}

