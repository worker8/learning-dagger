package com.worker8.learningdagger.constructorInjection

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.worker8.learningdagger.R
import com.worker8.learningdagger.constructorInjection.di.DaggerConstructorInjectionComponent
import com.worker8.learningdagger.constructorInjection.model.ChickenFajita
import com.worker8.learningdagger.constructorInjection.model.Taco
import com.worker8.learningdagger.identityHashCode
import kotlinx.android.synthetic.main.activity_construction_injection.*
import javax.inject.Inject

class ConstructorInjectionActivity : AppCompatActivity() {
    @Inject
    lateinit var taco1: Taco

    @Inject
    lateinit var taco2: Taco

    @Inject
    lateinit var chickenFajita1: ChickenFajita

    @Inject
    lateinit var chickenFajita2: ChickenFajita

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_construction_injection)
        val component = DaggerConstructorInjectionComponent.builder().build()
        component.inject(this)
        tacoTV1.text = "${taco1.name} (${taco1.identityHashCode()})"
        tacoTV2.text = "${taco2.name} (${taco2.identityHashCode()})"
        chickenFajitaTV1.text = "${chickenFajita1.name} (${chickenFajita1.identityHashCode()})"
        chickenFajitaTV2.text = "${chickenFajita2.name} (${chickenFajita2.identityHashCode()})"
    }
}