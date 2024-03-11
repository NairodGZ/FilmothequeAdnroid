package com.example.demoeni

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import com.example.demoeni.databinding.ActivityForgottenPasswordBinding
import com.example.demoeni.viewmodel.ForgettenPasswordViewModel

class ForgottenPasswordActivity : ComponentActivity() {

    lateinit var vm : ActivityForgottenPasswordBinding

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm = DataBindingUtil.setContentView(this, R.layout._activity_forgotten_password)
        vm.forgottenPasswordModel = ForgettenPasswordViewModel()


    }

    fun forgottenPasswordSend(view : View)
    {

        val emailSaisi = vm.forgottenPasswordModel?.email;

        var builder = AlertDialog.Builder(this);
        builder.setTitle("Mot de passe oublié")
        builder.setMessage("Le lien de récupération de mot de passe vous a été envoyé a : $emailSaisi")
        builder.setPositiveButton("OK"){
                dialog, wich -> dialog.dismiss();
        }

        //Afficher le dialogue
        builder.show();

    }
}

