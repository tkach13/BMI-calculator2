package com.benten.bmicalculator3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etHeight:EditText = findViewById(R.id.etHeight)
        val etMass:EditText = findViewById(R.id.etBodyMass)
        val button:Button   = findViewById(R.id.btnCalculate)
        val yourBmi:TextView = findViewById(R.id.tvYourBMI)
        val ivStatus:ImageView = findViewById(R.id.ivStatus)


        button.setOnClickListener {
            val bmi = calculateBmi(etHeight.text.toString().toDouble(),etMass.text.toString().toDouble())
            if (bmi < 25){
                ivStatus.setImageResource(R.drawable.ic_eat)
            } else {
                ivStatus.setImageResource(R.drawable.ic_excercise)
            }
            yourBmi.text = bmi.toString()

        }
    }
    fun calculateBmi(height: Double, mass: Double): Double {
        return  mass / (height / 100).pow(2)
    }
}