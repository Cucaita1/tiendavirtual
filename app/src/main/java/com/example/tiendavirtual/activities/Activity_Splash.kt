package com.example.tiendavirtual.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.tiendavirtual.R
import kotlin.math.log

class Activity_Splash:AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Log.d("Activity_Splash","onCreate: Iniciando Activity Splash")
        //configurar temporizador de redireccion
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this,Activity_Home::class.java)
            startActivity(intent)
            finish()
        },SPLASH_TIME_OUT)
    }

    override fun onStart() {
        super.onStart()
        Log.d("Activity_Splash","onStart: Activity Splash esta en primer plano")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Activity_Splash","onPause: Activity Splash esta pausada")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Activity_Splash","onResume: Activity Splash esta en primer plano")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Activity_Splash","onDestroy: Activity Splash esta destruida")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Activity_Splash","onStop: Activity Splash esta detenida")
    }
}