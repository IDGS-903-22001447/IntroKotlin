package com.paulina.introkotlin903.practica4

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.paulina.introkotlin903.R
import java.io.FileNotFoundException

class ActivityArchivos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_archivos)
        val btnGuardar = findViewById<Button>(R.id.saveButton)
        val btnLeer = findViewById<Button>(R.id.readButton)
        val btnBorrar = findViewById<Button>(R.id.btnBorrar)
        val inputText = findViewById<EditText>(R.id.inputText)
        val outputText = findViewById<TextView>(R.id.outputText)

        btnGuardar.setOnClickListener {
            val texto = inputText.text.toString()+"\n"
            // val archivo = openFileOutput("datos.txt", MODE_PRIVATE)
            try{
                openFileOutput("datos.txt", MODE_APPEND).use {
                    it.write(texto.toByteArray())
                }

            } catch (e: Exception){
                e.printStackTrace()

            }

        }

        btnLeer.setOnClickListener {
            try {
                val contenido = openFileInput("datos.txt").bufferedReader()
                    .useLines { lines -> lines.joinToString("\n") }

                outputText.text = contenido
            }catch (e: FileNotFoundException){
                outputText.text = "El archivo no existe"
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
        btnBorrar.setOnClickListener {
            
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}