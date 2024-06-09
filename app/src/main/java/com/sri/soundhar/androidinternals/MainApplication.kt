package com.sri.soundhar.androidinternals

import android.app.Application
import androidx.lifecycle.ViewModel
import com.sri.soundhar.androidinternals.ViewModel.MainViewModel

class MainApplication : Application() {

    private val map = HashMap<String, ViewModel>()

    fun getViewModel(key: String): ViewModel {
        if (map[key] != null) {
            return map[key]!!
        }

        val viewModel = MainViewModel()
        map[key] = viewModel
        return viewModel
    }

    fun clearViewModel(key: String) {
        map.remove(key)
    }

}