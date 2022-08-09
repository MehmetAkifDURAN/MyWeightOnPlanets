package com.akif.myweightonplanets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val kilogramToPound = 2.20462262
    val poundToKilogram = 0.45359237
    var weightMultiplierValue: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rgPlanets.setOnCheckedChangeListener { group, checkedId ->
            weightMultiplierValue = when (checkedId) {
                R.id.rbMercury -> 0.38
                R.id.rbVenus -> 0.91
                R.id.rbEarth -> 1.00
                R.id.rbMars -> 0.38
                R.id.rbJupiter -> 2.34
                R.id.rbSaturn -> 1.06
                R.id.rbUranus -> 0.92
                R.id.rbNeptune -> 1.19
                R.id.rbPluto -> 0.06
                else -> null
            }
            if (!TextUtils.isEmpty(kiloInput.text.toString())) {
                var kilo = kiloInput.text.toString().toDouble()
                var pound = fromKilogramToPound(kilo)
                if (weightMultiplierValue != null) {
                    var result = fromPoundToKilogram(pound * weightMultiplierValue!!)
                    tvResult.text = "${String.format("%.2f", result)} kg"
                }
            }
        }
    }

    fun fromKilogramToPound(kilo: Double): Double {
        return kilo * kilogramToPound
    }

    fun fromPoundToKilogram(pound: Double): Double {
        return pound * poundToKilogram
    }
}