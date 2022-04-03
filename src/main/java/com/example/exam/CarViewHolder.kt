package com.example.exam

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
    val carpic = itemView.findViewById<ImageView>(R.id.champPic)
    val nom = itemView.findViewById<TextView>(R.id.Nom)

    val dispo = itemView.findViewById<TextView>(R.id.dispo)
    val prix = itemView.findViewById<TextView>(R.id.prix)
}