package com.worker8.learningdagger.subcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.worker8.learningdagger.R
import com.worker8.learningdagger.model.Coffee
import com.worker8.learningdagger.model.Dog
import com.worker8.learningdagger.subcomponent.di.ChildComponent
import com.worker8.learningdagger.subcomponent.di.ParentComponent
import kotlinx.android.synthetic.main.fragment_subcomponent.view.*
import javax.inject.Inject

class ChildFragment() : Fragment() {
    @Inject
    lateinit var coffee: Coffee

    @Inject
    lateinit var coffee2: Coffee

    @Inject
    lateinit var dog: Dog

    lateinit var mainComponent: ParentComponent
    lateinit var childComponentBuilder: ChildComponent.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        childComponentBuilder.bindContext(context!!).build().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_subcomponent, container, false).apply {
            latte1.text = coffee.identityString
            latte2.text = coffee2.identityString
            fragmentDog.text = dog.toString()
        }
    }

    fun setupSubComponentA(
        mainComponent: ParentComponent,
        childComponentBuilder: ChildComponent.Builder
    ) {
        this.mainComponent = mainComponent
        this.childComponentBuilder = childComponentBuilder
    }

    companion object {
        val FragmentName = "FragmentName"
        fun newInstance(name: String) =
            ChildFragment().apply {
                arguments = Bundle().apply {
                    putString(FragmentName, name)
                }
            }

    }
}