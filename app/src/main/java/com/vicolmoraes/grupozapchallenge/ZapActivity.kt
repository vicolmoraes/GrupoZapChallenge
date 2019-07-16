package com.vicolmoraes.grupozapchallenge

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import com.vicolmoraes.grupozapchallenge.model.Building
import kotlinx.android.synthetic.main.zap_activity.*

class ZapActivity : AppCompatActivity() {
    lateinit var rvBuildings: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.zap_activity)

        findViews()
    }

    private fun findViews() {
        val buildings = intent.extras.get("buildings_zap") as List<Building>

        rvBuildings = rv_zap_activity
        rvBuildings.adapter = BuildingAdapter(buildings, this)
    }

}