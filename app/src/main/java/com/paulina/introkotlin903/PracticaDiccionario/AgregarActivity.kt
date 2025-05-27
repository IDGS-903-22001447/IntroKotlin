package com.paulina.introkotlin903.PracticaDiccionario

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.paulina.introkotlin903.R
import java.io.File
import java.io.FileOutputStream

class AgregarActivity : AppCompatActivity() {

    private lateinit var etEspanol: EditText
    private lateinit var etIngles: EditText
    private lateinit var btnGuardar: Button
    private lateinit var btnRegresar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar)


        etEspanol = findViewById(R.id.etEspanol)
        etIngles = findViewById(R.id.etIngles)
        btnGuardar = findViewById(R.id.btnGuardar)
        btnRegresar = findViewById(R.id.btnRegresar)


        btnGuardar.setOnClickListener {
            guardarPalabras()
        }

        btnRegresar.setOnClickListener {
            finish()
        }
    }

    private fun guardarPalabras() {
        val palabraEspanol = etEspanol.text.toString().trim()
        val palabraIngles = etIngles.text.toString().trim()

        if (palabraEspanol.isEmpty() || palabraIngles.isEmpty()) {
            Toast.makeText(this, "Por favor ingresa ambas palabras", Toast.LENGTH_SHORT).show()
            return
        }


        try {
            val file = File(filesDir, "diccionario.txt")
            val fos = FileOutputStream(file, true)

            val linea = "$palabraEspanol,$palabraIngles\n"
            fos.write(linea.toByteArray())
            fos.close()


            mostrarAlertaExito()


            etEspanol.text.clear()
            etIngles.text.clear()

        } catch (e: Exception) {
            Toast.makeText(this, "Error al guardar: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun mostrarAlertaExito() {
        AlertDialog.Builder(this)
            .setTitle("Éxito")
            .setMessage("Palabras guardadas con éxito")
            .setPositiveButton("Aceptar") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }
}
