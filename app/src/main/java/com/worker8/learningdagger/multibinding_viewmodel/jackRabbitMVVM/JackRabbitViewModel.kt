package com.worker8.learningdagger.multibinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.worker8.learningdagger.multibinding_viewmodel.jackRabbitMVVM.JackRabbitRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class JackRabbitViewModel @Inject constructor(
    private val repository: JackRabbitRepository,
    private val ioDispatcher: CoroutineDispatcher
) :
    ViewModel() {
    val listLiveData = MutableLiveData<List<String>>()
    lateinit var viewActions: ViewActions

    fun onCreate() {
        viewModelScope.launch {
            viewActions.setProgressBarVisibility(true)
            withContext(ioDispatcher) {
                listLiveData.postValue(repository.fetchNames())
            }
            viewActions.setProgressBarVisibility(false)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

    interface ViewActions {
        fun setProgressBarVisibility(visibility: Boolean)
    }
}
