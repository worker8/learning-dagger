package com.worker8.learningdagger.multibinding

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.worker8.learningdagger.R
import com.worker8.learningdagger.multibinding.JackRabbitViewModel.ViewActions
import com.worker8.learningdagger.multibinding.di.DaggerViewModelComponent
import com.worker8.learningdagger.multibinding_viewmodel.commonMVVM.ViewModelFactory
import kotlinx.android.synthetic.main.activity_into_map.*
import javax.inject.Inject

class JackRabbitActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    val viewModel by viewModels<JackRabbitViewModel> { viewModelFactory }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerViewModelComponent.builder()
            .bindContext(this)
            .build()
            .inject(this)
        setContentView(R.layout.activity_into_map)
        setupViewModel()
        viewModel.listLiveData.observe(this, Observer {
            it.forEach {
                multiBindingConsoleTV.text =
                    "${multiBindingConsoleTV.text}\n ${it}\n"
            }
        })
        viewModel.onCreate()
    }

    private fun setupViewModel() {
        viewModel.viewActions = object : ViewActions {
            override fun setProgressBarVisibility(visibility: Boolean) {
                multiBindingProgressBar.visibility = if (visibility) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
            }
        }
    }
}
