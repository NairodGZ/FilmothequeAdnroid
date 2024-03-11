package com.example.demoeni

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity

class ConnextionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_demo_form)
        //setContentView(R.layout.activity_sign_up)
        setContentView(R.layout.activity_login)
        //setContentView(R.layout._activity_forgotten_password)
        //setContentView(R.layout.activity_main)

    }

    fun goToActivityForgottenPassword(view: View)
    {
       var intent = Intent(this, ForgottenPasswordActivity::class.java)

        startActivity(intent)

    }

    fun connect(view : View)
    {

        //println("ici   " + view.tag);

        var builder = AlertDialog.Builder(this);
        builder.setTitle("Connxexion")
        builder.setMessage("Vous etes connectés avec succès")
        builder.setPositiveButton("Se rendre a la page d'oubli de mot de passe"){
                dialog, wich -> var intent = Intent(this, ForgottenPasswordActivity::class.java)

            startActivity(intent)
        }
        builder.setNeutralButton("OK"){
                dialog, wich -> var intent = Intent(this, RecyclerViewFilms::class.java)

            startActivity(intent)
        }
        //Afficher le dialogue
        builder.show();

    }
}

