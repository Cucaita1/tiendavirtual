package com.example.tiendavirtual.activities

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tiendavirtual.R

class Activity_Recuperacion : AppCompatActivity() {


    private lateinit var recuperacontra_correo : EditText
    private lateinit var buttonRegister_login : Button
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var exit_registro: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperacion)

        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)

        recuperacontra_correo = findViewById(R.id.recuperacontra_correo)
        buttonRegister_login = findViewById(R.id.buttonRecuperacion)
        //exit_registro = findViewById(R.id.exit_registro)

        buttonRegister_login.setOnClickListener {
            if (validarCorreo()){
                verificarCorreo()
            }
        }
    }

    private fun validarCorreo(): Boolean{
        val correo = recuperacontra_correo.text.toString().trim()
        if (correo.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(correo).matches()){
            Log.d("Activity_Recuperacion","chequeo de correo")
            Toast.makeText(this,"El campo Correo es requerido", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun verificarCorreo(){
        val correo = recuperacontra_correo.text.toString().trim()
        val correoRegistrado = sharedPreferences.getString("correo","")

        if (correo == correoRegistrado){
            Log.d("Activity_Recuperacion","futuro correo de recuperacion")
            Toast.makeText(this,"Se ha enviado un correo de verificacion", Toast.LENGTH_SHORT).show()

            buttonRegister_login.postDelayed({
                val intent = Intent(this, Activity_Login::class.java)
                startActivity(intent)
                finish()
            },1000)
        }else{
            Log.d("Activty_Recuperacion", "correo verificado correctamente")
            //mesaje de error del correo electronico
            Toast.makeText(this,"El correo electronico no se encuentra registrado", Toast.LENGTH_SHORT).show()
        }
    }

}