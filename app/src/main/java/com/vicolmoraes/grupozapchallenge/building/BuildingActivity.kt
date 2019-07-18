package com.vicolmoraes.grupozapchallenge.building

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import com.vicolmoraes.grupozapchallenge.R
import com.vicolmoraes.grupozapchallenge.model.Building
import kotlinx.android.synthetic.main.building_activity.*

class BuildingActivity : AppCompatActivity() {
    lateinit var rvImages: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.building_activity)

        findViews()
    }

    private fun findViews() {
        val building = intent.extras?.get("building") as Building

        rvImages = rv_foto_building_activity
        rvImages.adapter = ImageAdapter(building.images, this)

        tv_num_valor_building_activity.text =
            getString(R.string.formatacao_reais, building.pricingInfos.price.toFloat())
        tv_num_banheiros_building_activity.text = building.bathrooms.toString()
        tv_num_quartos_building_activity.text = building.bedrooms.toString()
        tv_num_vagas_building_activity.text = building.parkingSpaces.toString()
        tv_num_metros_building_activity.text = building.usableAreas.toString()

        if (building.pricingInfos.businessType.equals("SALE"))
            tv_buildingType_building_activity.text = this.getString(R.string.imovel_tipo_venda)
        else
            tv_buildingType_building_activity.text = this.getString(R.string.imovel_tipo_aluguel)

    }

}