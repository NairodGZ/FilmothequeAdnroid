package com.example.demoeni.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import com.example.demoeni.R
import com.example.demoeni.databinding.ActivityLoginBinding
import com.example.demoeni.model.Personne
import com.example.demoeni.viewmodel.ConnexionViewModel

class ConnextionActivity : ComponentActivity() {

    var personne = Personne()
    lateinit var vm : ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm = DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
        val connexionViewModel =  ConnexionViewModel(this, personne)
        vm.viewModel = connexionViewModel

        vm.btnSubmit.setOnClickListener()
        {
            connexionViewModel.connect()
        }

        vm.tvForgottenPassword.setOnClickListener()
        {
            connexionViewModel.goToActivityForgottenPassword();
        }

    }


}

