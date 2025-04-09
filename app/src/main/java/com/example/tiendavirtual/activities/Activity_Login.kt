package com.example.tiendavirtual.activities

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tiendavirtual.R

class Activity_Login: AppCompatActivity() {

    private lateinit var buttonLogin : Button
    private lateinit var etuser_login : EditText
    private lateinit var etpassword_login : EditText
    private lateinit var buttonRegister_login : Button
    private lateinit var recuperacontra_login : Button
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Log.d("Activity_Login", "onCreate Activity Login Iniciado")

        buttonLogin = findViewById(R.id.buttonLogin)
        etuser_login = findViewById(R.id.etuser_login)
        etpassword_login = findViewById(R.id.etpassword_login)
        buttonRegister_login = findViewById(R.id.buttonRegister_login)
        recuperacontra_login = findViewById(R.id.recuperacontra_login)

        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)

        buttonLogin.setOnClickListener{
            if (validarCorreo()){
                if (validarContrasena()){
                    verificarDatos()
                }
            }
        }

        buttonRegister_login.setOnClickListener{
            val intent = Intent(this, Activity_Registro::class.java)
            startActivity(intent)
            finish()
        }


        recuperacontra_login.setOnClickListener{
            val intent = Intent(this, Activity_Recuperacion::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun validarCorreo(): Boolean{
        val correo = etuser_login.text.toString().trim()
        if (correo.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(correo).matches()){
            Log.d("Activity_Login","chequeo de correo")
            Toast.makeText(this,"El campo Correo es requerido", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun validarContrasena(): Boolean{
        val contraseña = etpassword_login.text.toString().trim()
        if (contraseña.isEmpty()){
            Log.d("Activity_Login","chequeo de contraseña")
            Toast.makeText(this,"El campo Contraseña es requerido", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun verificarDatos(){
        val correo = etuser_login.text.toString().trim()
        val correoRegistrado = sharedPreferences.getString("correo","")
        val contra = etpassword_login.text.toString().trim()
        val contraRegistrada = sharedPreferences.getString("contraseña","")

        if (correo == correoRegistrado && contra == contraRegistrada) {
            Log.d("Activity_Login", "Credenciales correctas")
            Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()

            // Navegar a Activity_Perfil
            val intent = Intent(this, Activity_Perfil::class.java)
            startActivity(intent)
            finish()
        } else {
            Log.d("Activity_Login", "Credenciales incorrectas")
            Toast.makeText(this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show()
        }
    }
}