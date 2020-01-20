package com.worker8.learningdagger

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.worker8.learningdagger.di.AppComponentA
import com.worker8.learningdagger.di.DaggerAppComponentA
import com.worker8.learningdagger.di.SubComponentA
import com.worker8.learningdagger.model.Coffee
import javax.inject.Inject

class SubComponentActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scope)
        val appComponentA = DaggerAppComponentA.builder().build()
        val fragmentA = FakeFragment(appComponentA, this)
        val fragmentB = FakeFragment(appComponentA, this)
        fragmentA.print()
        fragmentB.print()
    }
}

class FakeFragment(appComponentA: AppComponentA, context: Context) {
    private val subComponent: SubComponentA =
        appComponentA.getSubComponentBuilder().applicationBind(context).build()

    init {
        subComponent.inject(this)
    }

    fun print() {
        coffee.printContext()
        coffee2.printContext()
        Log.d("ddw", "-----------")
    }

    @Inject
    lateinit var coffee: Coffee

    @Inject
    lateinit var coffee2: Coffee
}