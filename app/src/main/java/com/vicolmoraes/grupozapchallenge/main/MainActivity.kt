package com.vicolmoraes.grupozapchallenge.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageButton
import com.vicolmoraes.grupozapchallenge.R
import com.vicolmoraes.grupozapchallenge.model.Building
import com.vicolmoraes.grupozapchallenge.vivaReal.VivaRealActivity
import com.vicolmoraes.grupozapchallenge.zap.ZapActivity
import kotlinx.android.synthetic.main.main_activity.*
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    lateinit var ibVivaReal: ImageButton
    lateinit var ibZap: ImageButton
    lateinit var interactor: Interactor
    val zap = 1
    val vivaReal = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        Configurator.INSTANCE.setCleanArchitecture(this)

        findViews()
    }

    private fun findViews() {
        ibVivaReal = ib_vivareal_main_activity
        ibZap = ib_zap_main_activity

        ibVivaReal.setOnClickListener {
            interactor.fetch(vivaReal)
        }

        ibZap.setOnClickListener {
            interactor.fetch(zap)
        }
    }

    fun startVivaReal(buildings: List<Building>) {
        val intent: Intent = Intent(this, VivaRealActivity::class.java)
        intent.putExtra("buildings_vivareal", buildings as Serializable)
        startActivity(intent)
    }

    fun startZap(buildings: List<Building>) {
        val intent: Intent = Intent(this, ZapActivity::class.java)
        intent.putExtra("buildings_zap", buildings as Serializable)
        startActivity(intent)
    }
}