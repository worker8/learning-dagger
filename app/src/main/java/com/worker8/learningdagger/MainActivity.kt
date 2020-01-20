package com.worker8.learningdagger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.worker8.learningdagger.di.DaggerAppComponent
import com.worker8.learningdagger.model.Person
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    //    val jim: Person = Person(name = "Jim", pet = "Little Puppy", favoriteColor = "Blue")
    @Inject
    lateinit var jim: Person

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerAppComponent.builder().build().inject(this)
        nameTextView.text = """
            Name: ${jim.name}
            Pet: ${jim.pet}
            Favorite color: ${jim.favoriteColor}
            """.trimIndent()
    }
}
