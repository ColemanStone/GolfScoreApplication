package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity

class ScoreSummaryActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score_summary)

        val totalStrokesTextView: TextView = findViewById(R.id.totalStrokesTextView)
        val totalParTextView: TextView = findViewById(R.id.totalParTextView)
        val totalYardageTextView: TextView = findViewById(R.id.totalYardageTextView)

        // Retrieve the score summary
        val sharedPreferences = getSharedPreferences("ScoreSummary", MODE_PRIVATE)
        val totalStrokes = sharedPreferences.getInt("TotalStrokes", 0)
        val totalPar = sharedPreferences.getInt("TotalPar", 0)
        val totalYardage = sharedPreferences.getInt("TotalYardage", 0)

        // Display the score summary
        totalStrokesTextView.text = "Total Strokes: $totalStrokes"
        totalParTextView.text = "Total Par: $totalPar"
        totalYardageTextView.text = "Total Yardage: $totalYardage"
    }
}