package com.example.randomnumbermvp

interface RandomNumberContract {
    interface MainView{
        fun showDialog()
        fun hideDialog()
        fun setRandomNumber(randomNumber:Int)
    }
    interface Presenter{
        fun onGenerateRandomNumberClicked()
        fun onDestroy()
    }
    interface Module{
        interface OnRandomNumberFinished{
            fun numberReady(randomNumber: Int)
        }
        fun getRandomNumber(onRandomNumberFinished: OnRandomNumberFinished)
    }
}