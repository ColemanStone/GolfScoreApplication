package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.RecyclerView

class HoleAdapter(private val holes: List<Hole>) : RecyclerView.Adapter<HoleAdapter.HoleViewHolder>() {

    class HoleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val holeNumberTextView: TextView = view.findViewById(R.id.holeNumber)
        val yardageTextView: TextView = view.findViewById(R.id.yardage)
        val parTextView: TextView = view.findViewById(R.id.par)
        val strokesTextView: TextView = view.findViewById(R.id.strokes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hole_item, parent, false)
        return HoleViewHolder(view)
    }

    override fun onBindViewHolder(holder: HoleViewHolder, position: Int) {
        val hole = holes[position]
        holder.holeNumberTextView.text = "Hole ${hole.holeNumber}"
        holder.yardageTextView.text = hole.yardage.toString()
        holder.parTextView.text = hole.par.toString()
        holder.strokesTextView.text = hole.strokes.toString()
    }

    override fun getItemCount() = holes.size
}