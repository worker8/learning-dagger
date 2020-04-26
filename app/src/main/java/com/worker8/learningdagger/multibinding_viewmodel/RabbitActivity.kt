package com.worker8.learningdagger.multibinding

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.worker8.learningdagger.R
import com.worker8.learningdagger.multibinding.di.DaggerRabbitViewModelComponent
import com.worker8.learningdagger.multibinding_viewmodel.di.RabbitViewModelFactory
import kotlinx.android.synthetic.main.activity_into_map.*
import javax.inject.Inject

class RabbitActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: RabbitViewModelFactory

    val viewModel by viewModels<RabbitViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerRabbitViewModelComponent.builder().bindContext(this).build().inject(this)
        setContentView(R.layout.activity_into_map)
        viewModel.listLiveData.observe(this, Observer {
            it.forEach {
                multiBindingConsoleTV.text =
                    "${multiBindingConsoleTV.text}\n ${it}\n"
            }
        })
    }
}
