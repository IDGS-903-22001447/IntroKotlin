package com.paulina.introkotlin903.practica1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.paulina.introkotlin903.R

class saludoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_saludo)
        val btnStart= findViewById<Button>(R.id.button)
        val edtName=findViewById<EditText>(R.id.edit_name)
        btnStart.setOnClickListener {
            val name=edtName.text.toString()
            if(name.isNotEmpty()){
                val intent=Intent(this,Resultado::class.java)
                intent.putExtra("name",name)
                startActivity(intent)
            }
        }
        setContentView(R.layout.activity_saludo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}