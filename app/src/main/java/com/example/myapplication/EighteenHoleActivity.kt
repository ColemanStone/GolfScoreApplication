package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.RecyclerView


class EighteenHoleActivity : ComponentActivity() {
    private val holes = mutableListOf<Hole>()
    private var totalStrokes = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nine_hole)

        val yardageEditText: EditText = findViewById(R.id.yardageEditText)
        val parEditText: EditText = findViewById(R.id.parEditText)
        val strokesEditText: EditText = findViewById(R.id.strokesEditText)
        val submitButton: Button = findViewById(R.id.submitButton)
        val currentHoleTextView: TextView = findViewById(R.id.currentHoleTextView)
        val calculateScoreButton: Button = findViewById(R.id.calculateScoreButton)

        currentHoleTextView.text = "Current Hole: 1"

        submitButton.setOnClickListener {
            if (holes.size < 18) {
                val yardage = yardageEditText.text.toString().toIntOrNull() ?: 0
                val par = parEditText.text.toString().toIntOrNull() ?: 0
                val strokes = strokesEditText.text.toString().toIntOrNull() ?: 0
                totalStrokes += strokes
                holes.add(Hole(holes.size + 1, yardage, par, strokes))

                // Update the current hole text view
                currentHoleTextView.text = "Current Hole: ${holes.size + 1}"

                // Clear the EditText fields
                yardageEditText.text.clear()
                parEditText.text.clear()
                strokesEditText.text.clear()

                val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
                recyclerView.adapter = HoleAdapter(holes)
            }
            if (holes.size == 18) {
                // Calculate the score of the round
                val totalStrokes = holes.sumBy { it.strokes }
                val totalPar = holes.sumBy { it.par }
                val totalYardage = holes.sumBy { it.yardage }

                // Save the score summary
                val sharedPreferences = getSharedPreferences("ScoreSummary", MODE_PRIVATE)
                with(sharedPreferences.edit()) {
                    putInt("TotalStrokes", totalStrokes)
                    putInt("TotalPar", totalPar)
                    putInt("TotalYardage", totalYardage)
                    apply()
                }

                // Start ScoreSummaryActivity
                val intent = Intent(this, ScoreSummaryActivity::class.java)
                startActivity(intent)
            }
        }

        // Handle the calculate score button click
        calculateScoreButton.setOnClickListener {
            // Calculate the score of the round
            val score = holes.sumBy { it.strokes }
            Toast.makeText(this, "Score of the round: $score", Toast.LENGTH_SHORT).show()
        }
    }
}