package com.example.exam

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class favoriteAdapter (val championList: MutableList<Champion>) : RecyclerView.Adapter<favoriteAdapter.favoriteViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): favoriteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycle_favorite, parent, false)
        return favoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: favoriteViewHolder, position: Int) {
        val name = championList[position].Nom
        val dispo = championList[position].dispo
        val champPic = championList[position].champPic
        val prix = championList[position].prix
        holder.favoritepic.setImageResource(champPic)
        holder.nom.text = name
        holder.dispo.text = dispo
        holder.prix.text = prix.toString()
        holder.btn_delete.setOnClickListener {

            AlertDialog.Builder(holder.itemView.context)
                .setTitle("Delete from favorite")
                .setMessage(holder.itemView.context.getString(R.string.deleteMessageUniv, championList[position].Nom))
                .setPositiveButton("Yes"){ dialogInterface, which ->
                    AppDataBase.getDatabase(holder.itemView.context).championDao().delete(championList[position])
                    championList.removeAt(position)
                    notifyDataSetChanged()

                }.setNegativeButton("No"){dialogInterface, which ->
                    dialogInterface.dismiss()
                }.create().show()

        }
    }

    override fun getItemCount(): Int = championList.size

    class favoriteViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val favoritepic = itemView.findViewById<ImageView>(R.id.champPic)
        val nom = itemView.findViewById<TextView>(R.id.Nom)
        val dispo = itemView.findViewById<TextView>(R.id.dispo)
        val prix = itemView.findViewById<TextView>(R.id.prix)
        val btn_delete = itemView.findViewById<ImageButton>(R.id.btnDelete)

    }
}