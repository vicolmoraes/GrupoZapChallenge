package com.vicolmoraes.grupozapchallenge.vivaReal

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.widget.Button
import com.vicolmoraes.grupozapchallenge.BuildingAdapter
import com.vicolmoraes.grupozapchallenge.R
import com.vicolmoraes.grupozapchallenge.building.BuildingActivity
import com.vicolmoraes.grupozapchallenge.model.Building
import kotlinx.android.synthetic.main.vivareal_activity.*
import java.io.Serializable

class VivaRealActivity : AppCompatActivity() {
    lateinit var rvBuildings: RecyclerView
    lateinit var listaImoveis: List<Building>
    lateinit var btVerMais: Button
    var contador = 20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vivareal_activity)

        findViews()
        setRecycler()
    }

    private fun setRecycler() {
        rvBuildings.adapter = BuildingAdapter(listaImoveis, this, { partItem: Building -> partItemClicked(partItem) })
    }

    private fun findViews() {
        val buildings = intent.extras.get("buildings_vivareal") as List<Building>

        listaImoveis = buildings.take(contador)

        rvBuildings = rv_vivareal_activity

        btVerMais = bt_ver_mais_vivareal_activity
        btVerMais.setOnClickListener {
            contador = contador + 20
            listaImoveis = buildings.take(contador)
            setRecycler()
        }
    }

    private fun partItemClicked(imovel: Building) {
        val intent: Intent = Intent(this, BuildingActivity::class.java)
        intent.putExtra("building", imovel as Serializable)
        startActivity(intent)
    }

}