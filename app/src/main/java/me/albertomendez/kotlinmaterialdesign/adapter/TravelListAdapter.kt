package me.albertomendez.kotlinmaterialdesign.adapter

import android.content.Context
import android.graphics.BitmapFactory
import android.support.v4.content.ContextCompat
import android.support.v7.graphics.Palette
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
    lateinit var itemClickListener: OnItemClickListener

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val place = PlaceData.placeList()[position]
        val photo = BitmapFactory.decodeResource(context.resources, place.getImageResourceId(context))
        Palette.from(photo).generate { palette ->
            val bgColor = palette.getMutedColor(ContextCompat.getColor(context, android.R.color.black))
            holder?.itemView?.placeNameHolder?.setBackgroundColor(bgColor)
        }
        holder?.itemView?.placeName?.text = place.name
        Picasso.with(context).load(place.getImageResourceId(context)).into(holder?.itemView?.placeImage)
    }

    override fun getItemCount() = PlaceData.placeList().size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.row_places, parent, false)
        return ViewHolder(itemView)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) = itemClickListener.onItemClick(itemView, adapterPosition)
    }

    fun setOnItemClickListener(itemClickListener: OnItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

}