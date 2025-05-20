package com.paulina.introkotlin903.practica2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.paulina.introkotlin903.R

class OperasActivity : AppCompatActivity() {
    // Declara todas las variables necesarias
    private lateinit var edt1: EditText
    private lateinit var edt2: EditText
    private lateinit var tv1: TextView
    private lateinit var button2: Button
    private lateinit var radioGroupOperaciones: RadioGroup


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operas)

        // Inicializa las vistas
        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        tv1 = findViewById(R.id.tv1)
        button2 = findViewById(R.id.button2)
        radioGroupOperaciones = findViewById(R.id.radioGroupOperaciones) // Solo necesitas el RadioGroup

        button2.setOnClickListener { calcular(it) }
    }

    fun calcular(view: android.view.View) {
        val num1 = edt1.text.toString().toDoubleOrNull() ?: 0.0
        val num2 = edt2.text.toString().toDoubleOrNull() ?: 0.0

        val resultado = when (radioGroupOperaciones.checkedRadioButtonId) {
            R.id.radioSuma -> num1 + num2
            R.id.radioResta -> num1 - num2
            R.id.radioMultiplicacion -> num1 * num2
            R.id.radioDivision -> if (num2 != 0.0) num1 / num2 else Double.NaN
            else -> 0.0 // Caso por defecto
        }

        tv1.text = "Resultado: $resultado"

    }
}