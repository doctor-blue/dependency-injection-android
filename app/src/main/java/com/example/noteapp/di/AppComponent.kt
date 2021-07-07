package com.example.noteapp.di

import android.app.Application
import com.example.noteapp.activities.AddNoteActivity
import com.example.noteapp.activities.MainActivity
import com.example.noteapp.activities.UpdateNoteActivity
import com.example.noteapp.viewmodel.NoteViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class]
)
interface AppComponent {

    fun getNoteViewModel(): NoteViewModel

    fun inject(activity: MainActivity)
    fun inject(activity: AddNoteActivity)
    fun inject(activity: UpdateNoteActivity)

    fun getAuthComponentFactory(): AuthComponent.Factory

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent

    }
}