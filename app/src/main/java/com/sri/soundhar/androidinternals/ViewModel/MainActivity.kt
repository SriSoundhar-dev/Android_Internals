package com.sri.soundhar.androidinternals.ViewModel

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.sri.soundhar.androidinternals.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

//        viewModel = MainViewModel()

//        viewModel = (application as MainApplication).getViewModel("MainActivity") as MainViewModel

        viewModel.counter.observe(this) {
            binding.textView.text = it.toString()
        }

        binding.buttonClickMe.setOnClickListener {
            viewModel.increaseCounter()
        }

        binding.buttonOpenNextActivity.setOnClickListener {
            startActivity(Intent(this@MainActivity, NextActivity::class.java))
            finish()
        }
    }

//    override fun onDestroy() {
//        super.onDestroy()
//        (application as MainApplication).clearViewModel("MainActivity")
//    }

//    override fun onDestroy() {
//        super.onDestroy()
//        if (!isChangingConfigurations) {
//            (application as MainApplication).clearViewModel("MainActivity")
//        }
//    }

}