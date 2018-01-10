package me.albertomendez.kotlinmaterialdesign.model

import android.content.Context

/**
 * Created by alberto on 10/1/18.
 */
class Place(val name: String, private val imageName: String, val isFav: Boolean = false) {
    fun getImageResourceId(context: Context): Int {
        return context.resources.getIdentifier(this.imageName, "drawable", context.packageName)
    }
}