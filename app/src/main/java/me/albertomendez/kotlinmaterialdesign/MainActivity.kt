package me.albertomendez.kotlinmaterialdesign

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import me.albertomendez.kotlinmaterialdesign.adapter.TravelListAdapter

class MainActivity : AppCompatActivity() {
    lateinit private var staggeredLayoutManager: StaggeredGridLayoutManager
    lateinit private var adapter: TravelListAdapter

    private val onItemClickListener = object : TravelListAdapter.OnItemClickListener{
        override fun onItemClick(view: View, position: Int) {
            Toast.makeText(this@MainActivity, "Clicked: " + position, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        staggeredLayoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        list.layoutManager = staggeredLayoutManager
        adapter = TravelListAdapter(this)
        list.adapter = adapter
        adapter.setOnItemClickListener(onItemClickListener)
    }
}
