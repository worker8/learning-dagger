package com.worker8.learningdagger.multibinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.worker8.learningdagger.multibinding_viewmodel.rabbitMVVM.RabbitRepositoryInterface
import kotlinx.coroutines.*
import javax.inject.Inject

class RabbitViewModel @Inject constructor(
    private val repository: RabbitRepositoryInterface,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {
    val listLiveData = MutableLiveData<List<String>>()
    lateinit var viewActions: ViewActions
    lateinit var coroutineScope: CoroutineScope

    fun onCreate() {
        coroutineScope.launch {
            viewActions.setProgressBarVisibility(true)
            withContext(ioDispatcher) {
                val names = repository.fetchNames()
                listLiveData.postValue(names)
            }
            viewActions.setProgressBarVisibility(false)
        }
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }

    interface ViewActions {
        fun setProgressBarVisibility(visibility: Boolean)
    }
}
