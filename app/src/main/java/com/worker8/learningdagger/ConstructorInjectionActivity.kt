package com.worker8.learningdagger

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.worker8.learningdagger.di.DaggerConstructorInjectionComponent
import com.worker8.learningdagger.model.Taco
import javax.inject.Inject

class ConstructorInjectionActivity : AppCompatActivity() {
    @Inject
    lateinit var taco: Taco

    @Inject
    lateinit var taco2: Taco

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val component = DaggerConstructorInjectionComponent.builder().build()
        component.inject(this)
        Log.d("ddw", "onCreate: ${taco.name} (${taco.identityHashCode()})")
        Log.d("ddw", "onCreate: ${taco2.name} (${taco2.identityHashCode()})")
    }
}