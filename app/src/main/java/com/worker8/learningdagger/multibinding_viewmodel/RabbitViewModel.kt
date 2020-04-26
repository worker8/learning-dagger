package com.worker8.learningdagger.multibinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.worker8.learningdagger.multibinding_viewmodel.di.RabbitRepository
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject

class RabbitViewModel @Inject constructor(private val repository: RabbitRepository) : ViewModel() {
    val listLiveData = MutableLiveData<List<String>>()

    init {
        viewModelScope.launch {
            listLiveData.postValue(repository.fetchNames())
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}
