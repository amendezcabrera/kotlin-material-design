package me.albertomendez.kotlinmaterialdesign.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_places.view.*
import me.albertomendez.kotlinmaterialdesign.R
import me.albertomendez.kotlinmaterialdesign.model.PlaceData

/**
 * Created by alberto on 10/1/18.
 */
class TravelListAdapter(private var context: Context) : RecyclerView.Adapter<TravelListAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val place = PlaceData.placeList()[position]
        holder?.itemView?.placeName?.text = place.name
        Picasso.with(context).load(place.getImageResourceId(context)).into(holder?.itemView?.placeImage)
    }

    override fun getItemCount() = PlaceData.placeList().size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.row_places, parent, false)
        return ViewHolder(itemView)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}