package com.example.tiendavirtual.activities

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tiendavirtual.R

class Activity_Registro: AppCompatActivity() {


    private lateinit var editTextNombreReg : EditText
    private lateinit var editTextCorreoReg: EditText
    private lateinit var editTextApellidoReg : EditText
    private lateinit var editTextTelefonoReg : EditText
    private lateinit var editTextContraseñaReg : EditText
    private lateinit var editTextContraseñaConfiReg : EditText
    private lateinit var ch_tycondiciones_registro : CheckBox
    private lateinit var buttomRegistroR: Button

    private lateinit var sharedPreferences: SharedPreferences

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_registro)

            Log.d("Activity_Registro", "onCreate: Activity Registro Iniciado")

            //Iniciar variables
            sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)

            //inicializar variables de vistas
            editTextNombreReg = findViewById(R.id.editTextNombreReg)
            editTextCorreoReg = findViewById(R.id.editTextCorreoReg)
            editTextApellidoReg = findViewById(R.id.editTextApellidoReg)
            editTextTelefonoReg = findViewById(R.id.editTextTelefonoReg)
            editTextContraseñaReg = findViewById(R.id.editTextContraseñaReg)
            editTextContraseñaConfiReg = findViewById(R.id.editTextContraseñaConfiReg)
            ch_tycondiciones_registro = findViewById(R.id.ch_tycondiciones_registro)
            buttomRegistroR = findViewById(R.id.buttonRegistroR)

            //Configuracion del Listener

            buttomRegistroR.setOnClickListener{
                if(validarCampos()){
                //metodo de guardado de datos de usuario
                    guardardatosUsuario()
                    //redirecionamiento
                    val intent = Intent(this,Activity_Login::class.java)
                    startActivity(intent)
                    finish()
                }
            }

        }
    private fun validarCampos(): Boolean{
        val nombre = editTextNombreReg.text.toString().trim()
        val apellido = editTextApellidoReg.text.toString().trim()
        val correo = editTextCorreoReg.text.toString().trim()
        val telefono = editTextTelefonoReg.text.toString().trim()
        val contraseña = editTextContraseñaReg.text.toString().trim()
        val confirmacontraseña = editTextContraseñaConfiReg.text.toString().trim()
        val aceptaTerminos: Boolean = ch_tycondiciones_registro.isChecked


        if (nombre.isEmpty()){
            Log.d("Activity_Registro","Campo de nombres vacio")
            Toast.makeText(this,"El campo nombres es requerido",Toast.LENGTH_SHORT).show()
            return false
        }

        if (apellido.isEmpty()){
            Log.d("Activity_Registro","Campo de apellido vacio")
            Toast.makeText(this,"El campo Apellidos es requerido",Toast.LENGTH_SHORT).show()
            return false
        }

        if (correo.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(correo).matches()){
            Log.d("Activity_Registro","Campo de correo vacio")
            Toast.makeText(this,"El campo Correo es requerido",Toast.LENGTH_SHORT).show()
            return false
        }

        if (telefono.isEmpty()){
            Log.d("Activity_Registro","Campo de telefono vacio")
            Toast.makeText(this,"El campo Telefono es requerido",Toast.LENGTH_SHORT).show()
            return false
        }

        if (contraseña.isEmpty()){
            Log.d("Activity_Registro","Campo de contraseña vacio")
            Toast.makeText(this,"El campo Contraseña es requerido",Toast.LENGTH_SHORT).show()
            return false
        }

        if (confirmacontraseña.isEmpty()){
            Log.d("Activity_Registro","Campo de confirmar contraseña vacio")
            Toast.makeText(this,"El campo Confirmar contraseñas es requerido",Toast.LENGTH_SHORT).show()
            return false
        }

        if (contraseña != confirmacontraseña) {
            Log.d("Activity_Registro","Las contraseñas no coinciden")
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            return false
        }

        if (!aceptaTerminos) {
            Log.d("Activity_Registro","terminos y condiciones no aceptados")
            Toast.makeText(this, "Debes aceptar los términos y condiciones", Toast.LENGTH_SHORT).show()
            return false
        }

        return true

    }


    private fun guardardatosUsuario(){
        val editor = sharedPreferences.edit()
        editor.putString("nombre", editTextNombreReg.text.toString().trim())
        editor.putString("apellido", editTextApellidoReg.text.toString().trim())
        editor.putString("correo", editTextCorreoReg.text.toString().trim())
        editor.putString("telefono", editTextTelefonoReg.text.toString().trim())
        editor.putString("contraseña", editTextContraseñaReg.text.toString().trim())
        editor.apply()

        Log.d("Acrivity_Registro", "guardardatosUsuarios: Datos del usuario guardados")
        Toast.makeText(this,"Registro exitoso", Toast.LENGTH_SHORT).show()
    }


}
