package com.vicolmoraes.grupozapchallenge

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.bumptech.glide.Glide
import com.vicolmoraes.grupozapchallenge.model.Building
import kotlinx.android.synthetic.main.building_item.view.*

class BuildingAdapter(val items: List<Building>, val context: Context, val clickListener: (Building) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        (p0 as BuildingViewHolder).bind(items[p1], clickListener)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): BuildingViewHolder {
        return BuildingViewHolder(LayoutInflater.from(context).inflate(R.layout.building_item, p0, false))
        //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class BuildingViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemVieww = view
        fun bind(part: Building, clickListener: (Building) -> Unit) {
            if (part.pricingInfos.businessType.equals("SALE")) {
                itemVieww.tv_buildingType_building_fragment.text =
                    itemVieww.context.getString(R.string.imovel_tipo_venda)
            } else
                itemVieww.tv_buildingType_building_fragment.text =
                    itemVieww.context.getString(R.string.imovel_tipo_aluguel)

            itemVieww.tv_num_quartos_building_fragment.text = part.bedrooms.toString()
            itemVieww.tv_num_banheiros_building_fragment.text = part.bathrooms.toString()
            itemVieww.tv_num_vagas_building_fragment.text = part.parkingSpaces.toString()
            itemVieww.tv_num_metros_building_fragment.text = part.usableAreas.toString()
            itemVieww.tv_num_valor_building_fragment.text =
                itemVieww.context.getString(R.string.formatacao_reais, part.pricingInfos.price.toFloat())

            Glide.with(itemVieww.context).load(part.images.get(0)).into(itemVieww.iv_foto_building_fragment);

            val layout: CardView = itemVieww.cv_card_building_fragment

            val animZoomin = AnimationUtils.loadAnimation(
                itemVieww.context,
                R.anim.zoom_from_center
            )
            val x = 200 * adapterPosition
            animZoomin.startOffset = x.toLong()
            layout.setAnimation(animZoomin)

            itemVieww.setOnClickListener { clickListener(part) }
        }
        // Holds the TextView that will add each animal to

    }

}