package com.sri.soundhar.androidinternals.ViewModel

fun interface Factory<T> {
    fun create(): T
}

class MyViewModelWithParameter(mainRepository: MainRepository) {

    fun doSomething() {
        println("doSomething")
    }

}

fun <T> getViewModelWithFactory(factory: Factory<T>): T {
    return factory.create()
}

fun main() {
    val myViewModel = getViewModelWithFactory(Factory {
        return@Factory MyViewModelWithParameter(MainRepository())
    })
    myViewModel.doSomething()
}