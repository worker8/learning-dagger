package com.worker8.learningdagger

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.worker8.learningdagger.di.AppComponentA
import com.worker8.learningdagger.di.DaggerAppComponentA
import com.worker8.learningdagger.di.SubComponentA
import com.worker8.learningdagger.model.Coffee
import com.worker8.learningdagger.model.Dog
import javax.inject.Inject


class SubComponentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subcomponent)
        val appComponentA = DaggerAppComponentA.builder().build()
        val fragmentA = FakeFragment()
        fragmentA.setupSubComponentA(appComponentA, appComponentA.getSubComponent())
        val fragmentB = FakeFragment()
        fragmentB.setupSubComponentA(appComponentA, appComponentA.getSubComponent())

        getSupportFragmentManager().beginTransaction()
            .replace(R.id.scopeTop, fragmentA, "fragmentA").commit()
        getSupportFragmentManager().beginTransaction()
            .replace(R.id.scopeBottom, fragmentB, "fragmentB").commit()
    }
}

class FakeFragment() : Fragment() {
    @Inject
    lateinit var coffee: Coffee

    @Inject
    lateinit var coffee2: Coffee

    @Inject
    lateinit var dog: Dog

    lateinit var mainComponent: AppComponentA
    lateinit var subComponentABuilder: SubComponentA.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subComponentABuilder.bindContext(context!!).build().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_subcomponent, container, false)
        val latte1 = view.findViewById<TextView>(R.id.latte1)
        val latte2 = view.findViewById<TextView>(R.id.latte2)
        val dogTextView = view.findViewById<TextView>(R.id.fragmentDog)

        latte1.text = coffee.identityString
        latte2.text = coffee2.identityString
        dogTextView.text = "asdf"//fragmentDog.toString()
        return view
    }

    fun setupSubComponentA(
        mainComponent: AppComponentA,
        subComponentABuilder: SubComponentA.Builder
    ) {
        this.mainComponent = mainComponent
        this.subComponentABuilder = subComponentABuilder
    }
}