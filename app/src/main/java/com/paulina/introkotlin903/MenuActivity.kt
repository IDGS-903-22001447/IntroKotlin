package com.paulina.introkotlin903

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.paulina.introkotlin903.R
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.paulina.introkotlin903.PracticaDiccionario.Diccionario
import com.paulina.introkotlin903.practica1.saludoActivity  // Nombre de clase corregido (mayúscula)
import com.paulina.introkotlin903.practica2.OperasActivity
import com.paulina.introkotlin903.ejemplo.Cinepolis
import com.paulina.introkotlin903.practica3.Ejemplo3Activity
import com.paulina.introkotlin903.practica4.ActivityArchivos


class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val btnSaludo = findViewById<Button>(R.id.btn1)
        val btnOperas = findViewById<Button>(R.id.btn2)
        val btnCinepolis= findViewById<Button>(R.id.btn3)
        val btnEjemplo3 = findViewById<Button>(R.id.btn4)
        val btnEjemplo4 = findViewById<Button>(R.id.btn5)

        val btnDiccionario = findViewById<Button>(R.id.btn6)

        btnSaludo.setOnClickListener {
            navigateToSaludo()  // Nombre de método corregido
        }

        btnOperas.setOnClickListener {
            navigateToOperas()  // Nombre de método corregido
        }
btnCinepolis.setOnClickListener {
    navigateToCinepolis()
}
        btnEjemplo3.setOnClickListener {
            navigateToEjemplo3()
        }
btnEjemplo4.setOnClickListener {
    navigateToEjemplo4()
}
        btnDiccionario.setOnClickListener {
            navigateToDiccionario()
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
    private fun navigateToCinepolis() {
        val intent = Intent(this, Cinepolis::class.java)
        startActivity(intent)
    }
    private fun navigateToEjemplo3() {
        val intent = Intent(this, Ejemplo3Activity::class.java)
        startActivity(intent)
    }
    private fun navigateToEjemplo4() {
        val intent = Intent(this, ActivityArchivos::class.java)
        startActivity(intent)

    }
    private fun navigateToDiccionario() {
        val intent = Intent(this, Diccionario::class.java)
        startActivity(intent)
    }
}