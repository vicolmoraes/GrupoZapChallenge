package com.vicolmoraes.grupozapchallenge.zap

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import com.vicolmoraes.grupozapchallenge.BuildingAdapter
import com.vicolmoraes.grupozapchallenge.R
import com.vicolmoraes.grupozapchallenge.building.BuildingActivity
import com.vicolmoraes.grupozapchallenge.model.Building
import kotlinx.android.synthetic.main.zap_activity.*
import java.io.Serializable

class ZapActivity : AppCompatActivity() {
    lateinit var rvBuildings: RecyclerView
    lateinit var listaImoveis: List<Building>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.zap_activity)

        findViews()
        setRecycler()
    }

    private fun setRecycler() {
        rvBuildings.adapter = BuildingAdapter(listaImoveis, this, { partItem: Building -> partItemClicked(partItem) })
    }

    private fun findViews() {
        val buildings = intent.extras.get("buildings_zap") as List<Building>
        listaImoveis = buildings.take(20)
        rvBuildings = rv_zap_activity
    }

    private fun partItemClicked(imovel: Building) {
        val intent: Intent = Intent(this, BuildingActivity::class.java)
        intent.putExtra("building", imovel as Serializable)
        startActivity(intent)
    }
}