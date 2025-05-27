package com.paulina.introkotlin903.PracticaDiccionario

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import com.paulina.introkotlin903.R
class BuscarActivity : AppCompatActivity() {

    private lateinit var rgIdioma: RadioGroup
    private lateinit var rbEspanol: RadioButton
    private lateinit var rbIngles: RadioButton
    private lateinit var tvPalabraBuscar: TextView
    private lateinit var etPalabraBuscar: EditText
    private lateinit var btnBuscar: Button
    private lateinit var tvResultado: TextView
    private lateinit var btnRegresar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar)


        rgIdioma = findViewById(R.id.rgIdioma)
        rbEspanol = findViewById(R.id.rbEspanol)
        rbIngles = findViewById(R.id.rbIngles)
        tvPalabraBuscar = findViewById(R.id.tvPalabraBuscar)
        etPalabraBuscar = findViewById(R.id.etPalabraBuscar)
        btnBuscar = findViewById(R.id.btnBuscar)
        tvResultado = findViewById(R.id.tvResultado)
        btnRegresar = findViewById(R.id.btnRegresar)


        rgIdioma.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rbEspanol -> tvPalabraBuscar.text = "Palabra a Buscar (Inglés)"
                R.id.rbIngles -> tvPalabraBuscar.text = "Palabra a Buscar (Español)"
            }
        }
 btnBuscar.setOnClickListener {
            buscarPalabra()
        }


        btnRegresar.setOnClickListener {
            finish()
        }
    }

    private fun buscarPalabra() {
        val palabraABuscar = etPalabraBuscar.text.toString().trim()

        if (palabraABuscar.isEmpty()) {
            Toast.makeText(this, "Por favor ingresa una palabra", Toast.LENGTH_SHORT).show()
            return
        }

        val buscarEnEspanol = rbEspanol.isChecked
        val resultado = buscarEnArchivo(palabraABuscar, buscarEnEspanol)

        if (resultado.isNotEmpty()) {
            tvResultado.text = resultado
        } else {
            mostrarAlertaNoEncontrado()
            tvResultado.text = ""
        }
    }

    private fun buscarEnArchivo(palabra: String, buscarEnEspanol: Boolean): String {
        val file = File(filesDir, "diccionario.txt")
        if (!file.exists()) {
            return ""
        }

        val reader = BufferedReader(FileReader(file))
        var line: String?

        while (reader.readLine().also { line = it } != null) {
            val partes = line?.split(",")
            if (partes?.size == 2) {
                val espanol = partes[0].trim()
                val ingles = partes[1].trim()

                if (buscarEnEspanol) {

                    if (ingles.equals(palabra, ignoreCase = true)) {
                        reader.close()
                        return espanol
                    }
                } else {

                    if (espanol.equals(palabra, ignoreCase = true)) {
                        reader.close()
                        return ingles
                    }
                }
            }
        }
        reader.close()
        return ""
    }

    private fun mostrarAlertaNoEncontrado() {
        AlertDialog.Builder(this)
            .setTitle("No encontrado")
            .setMessage("La palabra no existe en el diccionario")
            .setPositiveButton("Aceptar") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }
}