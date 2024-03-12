package com.example.demoeni

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.demoeni.databinding.ActivityFilmDetailBinding
import com.example.demoeni.databinding.ActivityLoginBinding
import kotlinx.coroutines.launch

class ConnextionActivity : ComponentActivity() {

    lateinit var personne : Personne
    lateinit var vm : ActivityLoginBinding

    companion object
    {
       var connexionToken = ""
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     vm = DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)

        vm.personne = Personne()

    }

    fun goToActivityForgottenPassword(view: View)
    {
       var intent = Intent(this, ForgottenPasswordActivity::class.java)

        startActivity(intent)

    }

    fun goToActivityInscription(view : View)
    {
        var intent = Intent(this, InscriptionActivity::class.java)

        startActivity(intent)

    }

    fun connect(view : View)
    {
        personne = vm.personne!!;

        var builder = AlertDialog.Builder(this);
        builder.setTitle("Connxexion")

        lifecycleScope.launch {

            var response = PersonneService.PersonApi.retrofitService.login(personne);

            //println("reponse coddee : " + response.code)

            if(response.code == "200")
            {
                connexionToken = response.data!!

                //println("Tokeennn de coooo : " + connexionToken)

                builder.setMessage("Vous etes connectés avec succès")

                builder.setPositiveButton("OK"){
                        dialog, wich -> var intent = Intent(vm.root.context, MainActivity::class.java)

                    startActivity(intent)
                }

                builder.show();
            }
            else
            {

                builder.setMessage("Connexion echouée")

                builder.setNeutralButton("Se rendre a la page d'oubli de mot de passe"){
                        dialog, wich -> var intent = Intent(vm.root.context, ForgottenPasswordActivity::class.java)

                    startActivity(intent)
                }
                builder.setPositiveButton("Reessayer"){
                        dialog, wich -> dialog.dismiss()
                }

                //Afficher le dialogue
                builder.show();

            }

        }



    }
}

