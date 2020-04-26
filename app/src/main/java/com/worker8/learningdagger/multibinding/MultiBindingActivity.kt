package com.worker8.learningdagger.multibinding

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.worker8.learningdagger.R
import com.worker8.learningdagger.multibinding.di.DaggerMultiMapComponent
import kotlinx.android.synthetic.main.activity_into_map.*
import javax.inject.Inject
import javax.inject.Provider

class MultiBindingActivity : AppCompatActivity() {

    @Inject
    lateinit var setProvider: Provider<Set<String>>

    @Inject
    lateinit var stringMap: Map<String, String>

    @Inject
    lateinit var intMap: Map<Int, String>

    @Inject
    lateinit var wolfMap: Map<Class<out AbstractWolf>, @JvmSuppressWildcards AbstractWolf>

    //    java.util.Map<kotlin.reflect.KClass<com.worker8.learningdagger.model.Cat>,? extends javax.inject.Provider<java.lang.String>> cannot be provided without an @Provides-annotated method.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerMultiMapComponent.builder().build().inject(this)
        setContentView(R.layout.activity_into_map)
        val set = setProvider.get()
        multiBindingTV.text = "Output:"

        multiBindingConsoleTV.text =
            "${multiBindingConsoleTV.text}\nset => ${set}\n"
        multiBindingConsoleTV.text =
            "${multiBindingConsoleTV.text}\nstringMap['first'] => ${stringMap.get("first")}\n"
        multiBindingConsoleTV.text =
            "${multiBindingConsoleTV.text}\nintMap[5] => ${intMap.get(5)}\n"

//        multiBindingConsoleTV.text += "classMap[CatKey()] => ${classMap.get(Cat::class)}\n"
    }
}
