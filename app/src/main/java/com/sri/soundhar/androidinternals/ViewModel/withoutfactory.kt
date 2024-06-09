package com.sri.soundhar.androidinternals.ViewModel

class MyViewModel {

    fun doSomething() {
        println("doSomething")
    }

}

fun <T> getViewModel(modelClass: Class<T>): T {
    return modelClass.getDeclaredConstructor().newInstance()
}

fun main() {
    val myViewModel = getViewModel(MyViewModel::class.java)
    myViewModel.doSomething()
}