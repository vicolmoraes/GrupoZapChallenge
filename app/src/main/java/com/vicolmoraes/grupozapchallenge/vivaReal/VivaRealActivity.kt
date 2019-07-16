package com.vicolmoraes.grupozapchallenge.vivaReal

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import com.vicolmoraes.grupozapchallenge.BuildingAdapter
import com.vicolmoraes.grupozapchallenge.R
import com.vicolmoraes.grupozapchallenge.model.Building
import kotlinx.android.synthetic.main.vivareal_activity.*

class VivaRealActivity : AppCompatActivity() {
    lateinit var rvBuildings: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vivareal_activity)

        findViews()
    }

    private fun findViews() {
        val buildings = intent.getSerializableExtra("buildings_vivareal") as List<Building>

        rvBuildings = rv_vivareal_activity
        rvBuildings.adapter = BuildingAdapter(buildings, this)
    }

}