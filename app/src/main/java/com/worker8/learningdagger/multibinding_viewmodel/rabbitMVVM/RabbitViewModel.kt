package com.worker8.learningdagger.multibinding

import android.util.Log
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
    var count = 0
    var threadName1 = ""
    var threadName2 = ""
    fun onCreate() {
        count++
        coroutineScope.launch {
            viewActions.setProgressBarVisibility(true)
            threadName1 = this.toString()
            withContext(ioDispatcher) {
                val names = repository.fetchNames()
                threadName2 = this.toString() //Thread.currentThread().name
                listLiveData.postValue(names)
                Log.d("ddw", "threadName1: ${threadName1}")
                Log.d("ddw", "threadName2: ${threadName2}")
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
