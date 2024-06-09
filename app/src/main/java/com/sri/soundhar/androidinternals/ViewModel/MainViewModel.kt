package com.sri.soundhar.androidinternals.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _counter: MutableLiveData<Int> = MutableLiveData(0)

    val counter: LiveData<Int> = _counter

    fun increaseCounter() {
        _counter.value = _counter.value?.plus(1)
    }

}