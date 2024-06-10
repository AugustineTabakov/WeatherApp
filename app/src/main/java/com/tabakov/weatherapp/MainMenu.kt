package com.tabakov.weatherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val dateTv = findViewById<TextView>(R.id.edtDate)
        val MinTempTv = findViewById<TextView>(R.id.txtTempMin)
        val MaxTempTv = findViewById<TextView>(R.id.txtTempMax)
        val WeatherConTv = findViewById<TextView>(R.id.txtWeatherCon)

        // Initializations
        var i: Int = 0 // Stores number of entries in array
        var display: String = "" // Display blank first
        val maxEntries = 7 // Only allow 7 array entries

        var averageMin: Int = 0
        var averageMax: Int = 0
        var averageTotal: Int = 0
        var displayAverage: String = ""

        // Create arrays for the weather 
        val day = Array(maxEntries) { "" }
        val minTemperature = Array(maxEntries) { 0 }
        val maxTemperature = Array(maxEntries) { 0 }
        val weatherCon = Array(maxEntries) { "" }

        val btnInsert: Button = findViewById<Button>(R.id.btnInsert)
        val btnDetails: Button = findViewById<Button>(R.id.btnDetails)
        val btnClear: Button = findViewById<Button>(R.id.btnClear)

        btnInsert.setOnClickListener {
            // Check if there's enough entries
            if (i < maxEntries) {
                // Convert to display types
                day[i] = dateTv.text.toString()
                minTemperature[i] =
                    MinTempTv.text.toString().toIntOrNull() ?: 0 // 0 is for error checking
                maxTemperature[i] =
                    MaxTempTv.text.toString().toIntOrNull() ?: 0 // 0 is for error checking
                weatherCon[i] = WeatherConTv.text.toString()
                i++ // Increment entry number

                Toast.makeText(this, "Entry added", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Maximum entries reached", Toast.LENGTH_SHORT).show()
            }
        }

        // Clear the text views
        btnClear.setOnClickListener {
            dateTv.text = ""
            MinTempTv.text = ""
            MaxTempTv.text = ""
            WeatherConTv.text = ""
        }

        // Button to navigate to Details View
        btnDetails.setOnClickListener {
            display = ""

            for (counter in 0 until i) {
                display += "Date: ${day[counter]}\nAM Time: ${minTemperature[counter]}\nPM Time: ${maxTemperature[counter]}\nNotes: ${weatherCon[counter]}\n\n"
                averageMin += minTemperature[counter]
                averageMax += maxTemperature[counter]
                averageTotal += minTemperature[counter] + maxTemperature[counter]
            }

            averageTotal /= i
            averageMin /= i
            averageMax /= i

            displayAverage =  "Average Time(AM): ${averageMin}\nAverage Time(PM): ${averageMax}\nAverage Time(Total): ${averageTotal}"
            display += displayAverage

            // Pass the data to DetailedViews and start the activity
            val intent = Intent(this, DetailedViews::class.java)
            intent.putExtra("DISPLAY_DATA", display)
            intent.putExtra("DISPLAY_DATA_AVG", displayAverage)
            startActivity(intent)
        }
    }


}

