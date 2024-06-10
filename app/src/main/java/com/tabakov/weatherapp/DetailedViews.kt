package com.tabakov.weatherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DetailedViews : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_views)



        val btnMainMenu: Button = findViewById<Button>(R.id.btnMainMenu)
        val tvDetails = findViewById<TextView>(R.id.tvDetails)
        val displayData = intent.getStringExtra("DISPLAY_DATA")
        tvDetails.text = displayData




        btnMainMenu.setOnClickListener {
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
        }
    }
}


