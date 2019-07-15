package com.vicolmoraes.grupozapchallenge.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageButton
import com.vicolmoraes.grupozapchallenge.R
import com.vicolmoraes.grupozapchallenge.model.Building
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {
    lateinit var ibVivaReal: ImageButton
    lateinit var ibZap: ImageButton
    lateinit var imoveis: List<Building>
    lateinit var interactor: Interactor

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
            interactor.fetch()
        }
    }

}