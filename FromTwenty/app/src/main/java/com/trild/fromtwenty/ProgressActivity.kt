package com.trild.fromtwenty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.trild.fromtwenty.databinding.ActivityProgressBinding

class ProgressActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProgressBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProgressBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {

        }
    }
}