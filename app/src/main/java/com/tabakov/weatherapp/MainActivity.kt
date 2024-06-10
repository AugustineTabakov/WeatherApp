package com.tabakov.weatherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

// Declaration of buttons and an exit process is provided

        val btnMainMenu: Button = findViewById(R.id.btnExit)
        btnMainMenu.setOnClickListener {

            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
        }

        val btnExit: Button = findViewById(R.id.btnExit)
        btnExit.setOnClickListener {

            exitProcess(0)
        }
    }
}

