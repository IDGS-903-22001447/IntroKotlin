package com.paulina.introkotlin903.PracticaDiccionario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.paulina.introkotlin903.R
import com.paulina.introkotlin903.practica1.saludoActivity

class Diccionario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_diccionario)

        val capturar = findViewById<Button>(R.id.btnCapturar)
        val buscar = findViewById<Button>(R.id.btnBuscar)

        capturar.setOnClickListener {
            navigateToCapturar()
        }

        buscar.setOnClickListener {
            navigateToBuscar()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun navigateToCapturar() {
        val intent = Intent(this, AgregarActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToBuscar() {
        val intent = Intent(this, BuscarActivity::class.java)
        startActivity(intent)
    }
}