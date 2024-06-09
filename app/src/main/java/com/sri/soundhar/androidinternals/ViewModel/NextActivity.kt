package com.sri.soundhar.androidinternals.ViewModel

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sri.soundhar.androidinternals.databinding.ActivityNextBinding

class NextActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNextBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonOpenMainActivity.setOnClickListener {
            startActivity(Intent(this@NextActivity, MainActivity::class.java))
            finish()
        }
    }

}