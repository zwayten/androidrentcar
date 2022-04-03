package com.example.exam

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
/*
class carAdapter(val championList: MutableList<Champion>) :
    RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycle_model, parent, false)
        return ViewHolder(rootView)
    }


    override fun getItemCount(): Int {
        return championList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val name = championList[position].Nom
        val dispo = championList[position].dispo
        val champPic = championList[position].champPic
        val prix = championList[position].prix
         holder.carpic.setImageResource(champPic)
        holder.nom.text = name
        holder.dispo.text = dispo
        holder.prix.text = prix.toString()
    }


}
*/
class carAdapter (val championList: MutableList<Champion>) : RecyclerView.Adapter<carAdapter.CarViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CarViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycle_model, parent, false)
        return CarViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val name = championList[position].Nom
        val dispo = championList[position].dispo
        val champPic = championList[position].champPic
        val prix = championList[position].prix
        holder.carpic.setImageResource(champPic)
        holder.nom.text = name
        holder.dispo.text = dispo
        holder.prix.text = prix.toString()
    }

    override fun getItemCount(): Int = championList.size

    class CarViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val carpic = itemView.findViewById<ImageView>(R.id.champPic)
        val nom = itemView.findViewById<TextView>(R.id.Nom)
        val dispo = itemView.findViewById<TextView>(R.id.dispo)
        val prix = itemView.findViewById<TextView>(R.id.prix)
    }
}
