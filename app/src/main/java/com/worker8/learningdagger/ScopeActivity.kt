package com.worker8.learningdagger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.worker8.learningdagger.di.DaggerAppComponent
import com.worker8.learningdagger.model.Dog
import com.worker8.learningdagger.model.Turtle
import kotlinx.android.synthetic.main.activity_scope.*
import javax.inject.Inject

class ScopeActivity : AppCompatActivity() {

    @Inject
    lateinit var snoopy1: Dog

    @Inject
    lateinit var snoopy2: Dog

    @Inject
    lateinit var turtle1: Turtle

    @Inject
    lateinit var turtle2: Turtle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scope)
        DaggerAppComponent.builder().build().inject(this)
        dogTextView1.text = "injected: ${snoopy1.name} (${snoopy1.identityHashCode()})"
        dogTextView2.text = "injected: ${snoopy2.name}  (${snoopy2.identityHashCode()})"
        turtleTextView1.text = "injected: ${turtle1.name} (${turtle1.identityHashCode()})"
        turtleTextView2.text = "injected: ${turtle2.name} (${turtle2.identityHashCode()})"
    }
}