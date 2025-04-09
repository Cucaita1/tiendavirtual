package com.example.tiendavirtual.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.example.tiendavirtual.R


class Activity_Home: AppCompatActivity() {

    private lateinit var button_home: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        Log.d("Activity_Home", "onCreate Activity Home Iniciado")

        button_home = findViewById(R.id.button_home)

        button_home.setOnClickListener{
            val intent = Intent(this, Activity_Login::class.java)
            startActivity(intent)
            finish()
        }


    }
}