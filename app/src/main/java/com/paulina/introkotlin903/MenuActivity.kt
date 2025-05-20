package com.paulina.introkotlin903

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.paulina.introkotlin903.practica1.saludoActivity  // Nombre de clase corregido (mayúscula)
import com.paulina.introkotlin903.practica2.OperasActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val btnSaludo = findViewById<Button>(R.id.btn1)
        val btnOperas = findViewById<Button>(R.id.btn2)

        btnSaludo.setOnClickListener {
            navigateToSaludo()  // Nombre de método corregido
        }

        btnOperas.setOnClickListener {
            navigateToOperas()  // Nombre de método corregido
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun navigateToSaludo() {  // Corregido "navegate" a "navigate"
        val intent = Intent(this, saludoActivity::class.java)  // Clase con mayúscula
        startActivity(intent)
    }

    private fun navigateToOperas() {  // Corregido "navegate" a "navigate"
        val intent = Intent(this, OperasActivity::class.java)
        startActivity(intent)
    }
}