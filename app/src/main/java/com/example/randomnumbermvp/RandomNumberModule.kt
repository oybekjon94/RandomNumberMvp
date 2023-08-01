package com.example.randomnumbermvp

import android.os.Handler
import kotlin.random.Random

class RandomNumberModule:RandomNumberContract.Module {
    override fun getRandomNumber(onRandomNumberFinished: RandomNumberContract.Module.OnRandomNumberFinished) {
        Handler().postDelayed({
            val random = Random
            onRandomNumberFinished.numberReady(random.nextInt(2000))
        },2000)
    }
}