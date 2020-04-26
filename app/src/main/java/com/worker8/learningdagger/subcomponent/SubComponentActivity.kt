package com.worker8.learningdagger.subcomponent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.worker8.learningdagger.R
import com.worker8.learningdagger.subcomponent.di.DaggerParentComponent

class SubComponentActivity : AppCompatActivity() {

    val childFragmentA = ChildFragment()
    val childFragmentB = ChildFragment()
    val parentComponent = DaggerParentComponent.builder().build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subcomponent)
        childFragmentA.setupSubComponentA(parentComponent, parentComponent.getSubComponent())
        childFragmentB.setupSubComponentA(parentComponent, parentComponent.getSubComponent())

        supportFragmentManager.beginTransaction()
                .replace(R.id.scopeTop, childFragmentA, "fragmentA").commit()
        supportFragmentManager.beginTransaction()
                .replace(R.id.scopeBottom, childFragmentB, "fragmentB").commit()
    }
}