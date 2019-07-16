package com.vicolmoraes.grupozapchallenge.building

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.vicolmoraes.grupozapchallenge.R
import kotlinx.android.synthetic.main.image_item.view.*

class ImageAdapter(val items: List<String>, val context: Context) :
    RecyclerView.Adapter<ImageAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.image_item,
                p0,
                false
            )
        )
        //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        Glide.with(context).load(items.get(p1)).into(p0?.ivBuildingImage);
        //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each animal to
        val ivBuildingImage = view.iv_foto_image_item
    }
}