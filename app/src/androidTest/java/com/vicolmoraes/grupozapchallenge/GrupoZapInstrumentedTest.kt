package com.vicolmoraes.grupozapchallenge

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import com.vicolmoraes.grupozapchallenge.main.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class GrupoZapInstrumentedTest {
    @Rule
    @JvmField
    val rule = IntentsTestRule(MainActivity::class.java)

    @Test
    fun abrir_tela_zap() {
        onView(withId(R.id.ib_zap_main_activity)).perform(click())
        Thread.sleep(2000)
        intended(hasComponent("com.vicolmoraes.grupozapchallenge.zap.ZapActivity"))
    }

    @Test
    fun abrir_tela_vivaReal() {
        onView(withId(R.id.ib_vivareal_main_activity)).perform(click())
        Thread.sleep(2000)
        intended(hasComponent("com.vicolmoraes.grupozapchallenge.vivaReal.VivaRealActivity"))
    }

    @Test
    fun abrir_tela_imovel() {
        onView(withId(R.id.ib_vivareal_main_activity)).perform(click())
        Thread.sleep(2000)
        onView(withId(R.id.rv_vivareal_activity)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())
        )
        Thread.sleep(2000)
        intended(hasComponent("com.vicolmoraes.grupozapchallenge.building.BuildingActivity"))
    }

    @Test
    fun verificar_recycler_imoveis() {
        onView(withId(R.id.ib_vivareal_main_activity)).perform(click())
        Thread.sleep(2000)

        Espresso.onView(ViewMatchers.withId(R.id.rv_vivareal_activity))
            .check(
                ViewAssertions.matches(
                    ViewMatchers.hasDescendant(
                        ViewMatchers.withId(R.id.tv_banheiros_building_fragment)
                    )
                )

            )

        Espresso.onView(ViewMatchers.withId(R.id.rv_vivareal_activity))
            .check(ViewAssertions.matches(ViewMatchers.hasChildCount(20)))

    }
}
