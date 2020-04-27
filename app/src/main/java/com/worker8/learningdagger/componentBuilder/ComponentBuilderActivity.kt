package com.worker8.learningdagger.componentBuilder

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.worker8.learningdagger.R
import com.worker8.learningdagger.componentBuilder.di.CBRepositoryModule
import com.worker8.learningdagger.componentBuilder.di.DaggerCBComponent
import kotlinx.android.synthetic.main.activity_into_map.*
import javax.inject.Inject

class ComponentBuilderActivity : AppCompatActivity() {

    @Inject
    lateinit var repo: CBRepository

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_into_map)

        DaggerCBComponent.builder()
            .cBRepositoryModule(CBRepositoryModule("Injected String"))
            .bindContext(this)
            .build().inject(this)
        multiBindingConsoleTV.text =
            "${multiBindingConsoleTV.text}\n ${repo.injectedString}\n"
    }
}
