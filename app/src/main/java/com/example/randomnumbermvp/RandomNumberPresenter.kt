package com.example.randomnumbermvp

class RandomNumberPresenter(view:RandomNumberContract.MainView):RandomNumberContract.Presenter,
    RandomNumberContract.Module.OnRandomNumberFinished {

    var mainView:RandomNumberContract.MainView? = null
    private val module = RandomNumberModule()

    init{
        mainView = view
    }

    override fun onGenerateRandomNumberClicked() {
        mainView?.showDialog()
        module.getRandomNumber(this)
    }

    override fun onDestroy() {
        mainView = null
    }

    override fun numberReady(randomNumber: Int) {

        mainView?.hideDialog()
        mainView?.setRandomNumber(randomNumber)
    }
}