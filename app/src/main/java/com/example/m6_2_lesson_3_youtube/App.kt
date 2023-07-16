package com.example.m6_2_lesson_3_youtube

import android.app.Application
import com.example.m6_2_lesson_3_youtube.repository.Repository

class App: Application() {

    val repository = Repository()
}