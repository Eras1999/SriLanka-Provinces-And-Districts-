package com.example.srilankaprovincesanddistricts

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val provinceDistrictsMap = mapOf(
        "Central Province" to listOf("Kandy", "Nuwara Eliya", "Matale"),
        "Eastern Province" to listOf("Ampara", "Batticaloa", "Trincomalee"),
        "North Central Province" to listOf("Anuradhapura", "Polonnaruwa"),
        "Northern Province" to listOf("Jaffna", "Kilinochchi", "Mannar", "Mullaitivu", "Vavuniya"),
        "North Western Province" to listOf("Kurunegala", "Puttalam"),
        "Sabaragamuwa Province" to listOf("Ratnapura", "Kegalle"),
        "Southern Province" to listOf("Galle", "Matara", "Hambantota"),
        "Uva Province" to listOf("Badulla", "Monaragala"),
        "Western Province" to listOf("Colombo", "Gampaha", "Kalutara")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val provinceSpinner: Spinner = findViewById(R.id.provinceSpinner)
        val submitButton: Button = findViewById(R.id.submitButton)
        val districtsTextView: TextView = findViewById(R.id.districtsTextView)

        // Populate Spinner with province names
        val provinces = provinceDistrictsMap.keys.toList()
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, provinces)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        provinceSpinner.adapter = adapter

        submitButton.setOnClickListener {
            val selectedProvince = provinceSpinner.selectedItem.toString()
            val districts = provinceDistrictsMap[selectedProvince]

            if (districts != null) {
                districtsTextView.text = districts.joinToString(", ")
            } else {
                districtsTextView.text = "Invalid province selected. Please try again."
            }
        }
    }
}
