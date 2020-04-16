package com.worker8.learningdagger.subcomponent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.worker8.learningdagger.R
import com.worker8.learningdagger.subcomponent.di.DaggerParentComponent

class SubComponentActivity : AppCompatActivity() {

    val fragmentA = ChildFragment()
    val fragmentB = ChildFragment()
    val parentComponent = DaggerParentComponent.builder().build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subcomponent)
        fragmentA.setupSubComponentA(parentComponent, parentComponent.getSubComponent())
        fragmentB.setupSubComponentA(parentComponent, parentComponent.getSubComponent())

        supportFragmentManager.beginTransaction()
            .replace(R.id.scopeTop, fragmentA, "fragmentA").commit()
        supportFragmentManager.beginTransaction()
            .replace(R.id.scopeBottom, fragmentB, "fragmentB").commit()
    }
}