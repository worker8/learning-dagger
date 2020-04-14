package com.worker8.learningdagger

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_home.view.*
import kotlinx.android.synthetic.main.row_home.view.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
//        homeList.adapter

    }
}

class HomeAdapter : ListAdapter<HomeRowType, RecyclerView.ViewHolder>(comparator) {
    init {
        setHasStableIds(true)
    }

    companion object {
        val comparator = object : DiffUtil.ItemCallback<HomeRowType>() {
            override fun areItemsTheSame(oldItem: HomeRowType, newItem: HomeRowType) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: HomeRowType, newItem: HomeRowType) =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return HomeViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val homeRowData = getItem(position)

    }
}

class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(homeRowData: HomeRowType) {
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

data class HomeRowType(
    val title: String,
    val onClick: () -> Unit
)