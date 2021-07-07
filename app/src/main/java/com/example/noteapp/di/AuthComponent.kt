package com.example.noteapp.di

import com.example.noteapp.activities.LoginActivity
import com.example.noteapp.viewmodel.LoginViewModel
import dagger.Subcomponent

@Auth
@Subcomponent
interface AuthComponent {

    fun getLoginViewModel(): LoginViewModel

    fun inject(activity: LoginActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): AuthComponent
    }
}