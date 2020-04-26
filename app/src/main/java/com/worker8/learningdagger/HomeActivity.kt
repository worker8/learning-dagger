package com.worker8.learningdagger

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.worker8.learningdagger.constructorInjection.ConstructorInjectionActivity
import com.worker8.learningdagger.multibinding.MultiBindingActivity
import com.worker8.learningdagger.multibinding.RabbitActivity
import com.worker8.learningdagger.subcomponent.SubComponentActivity
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.row_home.view.*

class HomeActivity : AppCompatActivity() {
    val homeAdapter = HomeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        homeList.adapter = homeAdapter
        homeAdapter.submitList(
            listOf(
                HomeRow("Basic Usage", getIntent(BasicActivity::class.java)),
                HomeRow("@Named usage", getIntent(CatActivity::class.java)),
                HomeRow("@Scope usage", getIntent(ScopeActivity::class.java)),
                HomeRow(
                    "@SubComponent usage", getIntent(SubComponentActivity::class.java)
                ),
                HomeRow(
                    "Constructor Injection Usage",
                    getIntent(ConstructorInjectionActivity::class.java)
                ),
                HomeRow(
                    "@IntoMap Usage",
                    getIntent(MultiBindingActivity::class.java)
                ),
                HomeRow(
                    "@IntoMap ViewModel Usage",
                    getIntent(RabbitActivity::class.java)
                )
            )
        )
    }

    private fun getIntent(clazz: Class<out Any>) =
        { -> startActivity(Intent(this@HomeActivity, clazz)) }
}

class HomeAdapter : ListAdapter<HomeRow, RecyclerView.ViewHolder>(comparator) {
    init {
        setHasStableIds(true)
    }

    companion object {
        val comparator = object : DiffUtil.ItemCallback<HomeRow>() {
            override fun areItemsTheSame(oldItem: HomeRow, newItem: HomeRow) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: HomeRow, newItem: HomeRow) =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return HomeViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val homeRowData = getItem(position)
        (holder as HomeViewHolder).bind(homeRowData)
    }
}

class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(homeRowData: HomeRow) {
        itemView.apply {
            rowTitle.text = homeRowData.title
            homeRowContainer.setOnClickListener {
                homeRowData.onClick()
            }
        }
    }

    companion object {
        fun create(parent: ViewGroup) =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_home, parent, false)
                .let { HomeViewHolder(it) }
    }
}

data class HomeRow(
    val title: String,
    val onClick: () -> Unit
)