package com.example.randomnumbermvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.view.isVisible
import com.example.randomnumbermvp.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity(),RandomNumberContract.MainView {
    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: RandomNumberPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = RandomNumberPresenter(this)

        binding.generateRandomNumberBtn.setOnClickListener {
               presenter.onGenerateRandomNumberClicked()

        }
    }

    override fun showDialog() {
        binding.progressBar.isVisible  = true
    }

    override fun hideDialog() {
        binding.progressBar.isVisible  = false
    }

    override fun setRandomNumber(randomNumber: Int) {
        binding.numberTv.text = randomNumber.toString()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

}