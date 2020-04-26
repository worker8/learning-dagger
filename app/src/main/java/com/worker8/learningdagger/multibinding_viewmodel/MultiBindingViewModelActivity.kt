package com.worker8.learningdagger.multibinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.worker8.learningdagger.R

class MultiBindingViewModelActivity : AppCompatActivity() {

//    @Inject
//    lateinit var viewModelFactory: DaggerViewModelFactory
//
//    val model by viewModels<HomeViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        DaggerViewModelComponent.builder().build().inject(this)
        setContentView(R.layout.activity_into_map)

//        Log.d("ddw", "model: ${model}")
//        multiBindingConsoleTV.text += "classMap[CatKey()] => ${classMap.get(Cat::class)}\n"
    }
}
