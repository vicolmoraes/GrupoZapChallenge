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
    }

}