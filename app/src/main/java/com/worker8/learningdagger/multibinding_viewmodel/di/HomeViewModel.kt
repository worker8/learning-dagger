package com.worker8.learningdagger.multibinding.di

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor() : ViewModel() {
    override fun onCleared() {
        super.onCleared()
        // clear things up
    }
}
