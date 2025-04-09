package com.example.tiendavirtual.activities

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tiendavirtual.R

class Activity_Perfil: AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var perfilNombre : EditText
    private lateinit var perfilApellidos : EditText
    private lateinit var perfilCorreo : EditText
    private lateinit var perfilTelefono : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)


        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)

        perfilNombre = findViewById(R.id.perfilNombre)
        perfilApellidos = findViewById(R.id.perfilApellidos)
        perfilCorreo = findViewById(R.id.perfilCorreo)
        perfilTelefono = findViewById(R.id.perfilTelefono)

        cargarDatos()

    }

    private fun cargarDatos() {
        try {
            // Recuperar datos de SharedPreferences
            val nombre = sharedPreferences.getString("nombre", "")
            val apellido = sharedPreferences.getString("apellido", "")
            val correo = sharedPreferences.getString("correo","")
            val telefono = sharedPreferences.getString("telefono","")

            // Mostrar datos en los EditText

                perfilNombre.setText(nombre)
                perfilApellidos.setText(apellido)
                perfilCorreo.setText(correo)
                perfilTelefono.setText(telefono)

        } catch (e: Exception) {
            Log.e("Activity_Perfil", "Error al cargar datos: ${e.message}")
            Toast.makeText(this, "Error al cargar los datos", Toast.LENGTH_SHORT).show()
        }
    }

}