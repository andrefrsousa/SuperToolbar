package com.andrefrsousa.supertoolbar.demo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_demo.*
import kotlinx.android.synthetic.main.list_item.view.*

class DemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)

        toolbar.title = getString(R.string.app_name)

        val layoutManager = LinearLayoutManager(this)
        items_list.layoutManager = layoutManager
        items_list.adapter = ItemsAdapter()

        items_list.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                toolbar.setElevationVisibility(recyclerView.canScrollVertically(-1))
            }
        })
    }
}

// Inner classes

class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.list_item))
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
    }

    override fun getItemCount() = 15

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val text: TextView = view.text_view
    }
}

fun ViewGroup.inflate(layoutId: Int): View {
    return LayoutInflater.from(context).inflate(layoutId, this, false)
}