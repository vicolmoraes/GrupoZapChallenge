package com.vicolmoraes.grupozapchallenge

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vicolmoraes.grupozapchallenge.model.Building
import kotlinx.android.synthetic.main.building_item.view.*

class BuildingAdapter(val items: List<Building>, val context: Context) :
    RecyclerView.Adapter<BuildingAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.building_item, p0, false))
        //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0?.tvBuildingType?.text = items.get(p1).pricingInfos.businessType
        p0?.tvNumRoom?.text = items.get(p1).bedrooms.toString()
        p0?.tvNumBath?.text = items.get(p1).bathrooms.toString()
        p0?.tvNumCarSeat?.text = items.get(p1).parkingSpaces.toString()
        p0?.tvBuildingSize?.text = items.get(p1).usableAreas.toString()
        p0?.tvPrice?.text = items.get(p1).pricingInfos.price
        //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each animal to
        val tvBuildingType = view.tv_buildingType_building_fragment
        val tvNumRoom = view.tv_num_quartos_building_fragment
        val tvNumBath = view.tv_num_banheiros_building_fragment
        val tvNumCarSeat = view.tv_num_vagas_building_fragment
        val tvBuildingSize = view.tv_num_metros_building_fragment
        val tvPrice = view.tv_num_valor_building_fragment

    }
}