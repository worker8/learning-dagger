package com.worker8.learningdagger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.worker8.learningdagger.di.DaggerAppComponent
import com.worker8.learningdagger.model.Cat
import kotlinx.android.synthetic.main.activity_cat.*
import javax.inject.Inject
import javax.inject.Named

class CatActivity : AppCompatActivity() {

    @Inject
    @field:Named("Garfield")
    lateinit var garfield: Cat

    @Inject
    @field:Named("HelloKitty")
    lateinit var helloKitty: Cat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat)
        DaggerAppComponent.builder().build().inject(this)
        garfieldTextView.text = "injected: ${garfield.name} (${garfield.identityHashCode()})"
        helloKittyTextView.text = "injected: ${helloKitty.name} (${helloKitty.identityHashCode()})"
    }
}