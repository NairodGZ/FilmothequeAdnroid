package com.example.demoeni.activities

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import com.example.demoeni.R
import com.example.demoeni.databinding.ActivityForgottenPasswordBinding
import com.example.demoeni.viewmodel.ForgettenPasswordViewModel

class ForgottenPasswordActivity : ComponentActivity() {

    lateinit var vm : ActivityForgottenPasswordBinding

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm = DataBindingUtil.setContentView(this, R.layout._activity_forgotten_password)
        val forgottenPasswordViewModel = ForgettenPasswordViewModel(this, "")
        vm.viewModel = forgottenPasswordViewModel

        vm.btnSubmit.setOnClickListener()
        {
            forgottenPasswordViewModel.forgottenPasswordSend()
        }


    }


}

