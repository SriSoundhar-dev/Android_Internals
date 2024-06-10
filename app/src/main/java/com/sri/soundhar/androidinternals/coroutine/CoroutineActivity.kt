package com.sri.soundhar.androidinternals.coroutine

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sri.soundhar.androidinternals.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicInteger

class CoroutineActivity : AppCompatActivity() {
    companion object {
        const val TAG = "CoroutineActivity"
    }

    private var numTasksExpOne = AtomicInteger(0)
    private var numTasksExpTwo = AtomicInteger(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine)
    }

    fun startExperimentOne(view: View) {
        experimentOne()
    }

    fun startExperimentTwo(view: View) {
        experimentTwo()
    }

    fun launchCoroutines(view: View) {
        launchCoroutines()
    }

    fun launchThreads(view: View) {
        launchThreads()
    }

    private fun experimentOne() {
        numTasksExpOne = AtomicInteger(0)
        val threadPool = Executors.newFixedThreadPool(40)
        val startTime = System.currentTimeMillis()

        repeat(10_000) {
            threadPool.execute {
                longRunningTaskOne(startTime)
            }
        }
    }

    private fun experimentTwo() {
        numTasksExpTwo = AtomicInteger(0)
        val threadPool = Executors.newFixedThreadPool(4)
        val startTime = System.currentTimeMillis()

        repeat(4) {
            threadPool.execute {
                repeat(2500) {
                    longRunningTaskTwo(startTime)
                }
            }
        }
    }

    private fun longRunningTaskOne(startTime: Long) {
        if (numTasksExpOne.incrementAndGet() == 10_000) {
            Log.d(TAG, "Experiment One : = ${System.currentTimeMillis() - startTime}")
        }
    }

    private fun longRunningTaskTwo(startTime: Long) {
        if (numTasksExpTwo.incrementAndGet() == 10_000) {
            Log.d(TAG, "Experiment Two : = ${System.currentTimeMillis() - startTime}")
        }
    }

    private fun launchCoroutines() {
        repeat(100_000) {
            GlobalScope.launch {
                delay(5000L)
            }
        }
    }

    private fun launchThreads() {
        repeat(100_000) {
            Thread {
                Thread.sleep(5000L)
            }.start()
        }
    }

}