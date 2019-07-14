package com.vicolmoraes.grupozapchallenge

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageButton
import com.vicolmoraes.grupozapchallenge.model.Building
import kotlinx.android.synthetic.main.main_activity.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var ibVivaReal: ImageButton
    lateinit var ibZap: ImageButton
    lateinit var notes: List<Building>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        findViews()
    }

    private fun findViews() {
        ibVivaReal = ib_vivareal_main_activity
        ibZap = ib_zap_main_activity

        ibVivaReal.setOnClickListener {
            val call = RetrofitInitializer().buildingService().list()
            call.enqueue(object : Callback<List<Building>?> {
                override fun onResponse(
                    call: Call<List<Building>?>?,
                    response: Response<List<Building>?>?
                ) {
                    response?.body()?.let {
                        val notes: List<Building> = it
                    }
                }

                override fun onFailure(
                    call: Call<List<Building>?>?,
                    t: Throwable?
                ) {
                }
            })
        }
    }

}