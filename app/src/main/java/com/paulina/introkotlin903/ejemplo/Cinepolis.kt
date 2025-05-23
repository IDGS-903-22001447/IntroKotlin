package com.paulina.introkotlin903.ejemplo

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
import java.text.NumberFormat
import java.util.Locale

class Cinepolis : AppCompatActivity() {
    private lateinit var nombre: EditText
    private lateinit var cantidadCompradores: EditText
    private lateinit var cantidadBoletos: EditText
    private lateinit var button2: Button
    private lateinit var tv1: TextView
    private lateinit var radioGroup: RadioGroup
    private lateinit var siTarjeta: RadioButton
    private lateinit var noTarjeta: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cinepolis)

        // Inicializar vistas
        nombre = findViewById(R.id.nombre)
        cantidadCompradores = findViewById(R.id.cantidad)
        cantidadBoletos = findViewById(R.id.cantidadBoletos)
        button2 = findViewById(R.id.button2)
        tv1 = findViewById(R.id.tv1)
        radioGroup = findViewById(R.id.radioGroup)
        siTarjeta = findViewById(R.id.siTarjeta)
        noTarjeta = findViewById(R.id.noTarjeta)

        button2.setOnClickListener { calcular(it) }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun calcular(view: android.view.View) {
        val nombreCliente = nombre.text.toString()
        val boletos = cantidadBoletos.text.toString().toIntOrNull() ?: 0
        val precioUnitario = 12000.0
        var total: Double
        var mensaje = ""

        // Validar cantidad máxima de boletos por persona
        if (boletos > 7) {
            tv1.text = "Error: No se pueden comprar más de 7 boletos por persona"
            return
        }

        if (nombreCliente.isEmpty()) {
            tv1.text = "Por favor ingrese su nombre"
            return
        }

        // Calcular total sin descuentos
        total = boletos * precioUnitario

        // Aplicar descuentos por cantidad de boletos
        when {
            boletos > 5 -> total *= 0.85 // 15% de descuento
            boletos in 3..5 -> total *= 0.90 // 10% de descuento
            boletos <= 2 -> total *= 1.0 // Sin descuento
        }

        // Aplicar descuento adicional por tarjeta CINECO (si seleccionó "Sí")
        if (siTarjeta.isChecked) {
            total *= 0.90 // 10% adicional
        }

        // Formatear el precio como moneda
        val format = NumberFormat.getCurrencyInstance(Locale("es", "CO"))
        format.maximumFractionDigits = 0
        val precioFormateado = format.format(total)

        // Construir mensaje de resultado
        mensaje = """
            Cliente: $nombreCliente
            Boletos comprados: $boletos
            Total a pagar: $precioFormateado
           
        """.trimIndent()

        tv1.text = mensaje
    }
}