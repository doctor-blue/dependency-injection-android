package com.example.noteapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.noteapp.NoteApplication
import com.example.noteapp.R
import com.example.noteapp.databinding.ActivityLoginBinding
import com.example.noteapp.di.AppComponent
import com.example.noteapp.viewmodel.LoginViewModel
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {
    private val TAG = "LoginActivityTAG"

    @Inject
    lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)

        val authComponent = (application as NoteApplication).appComponent.getAuthComponentFactory().create()

        authComponent.inject(this)

        Log.d(TAG, "LoginActivity $loginViewModel")

        binding.btnLogin.setOnClickListener {
            startActivity(
                Intent(this, MainActivity::class.java)
            )
            finish()
        }
    }
}