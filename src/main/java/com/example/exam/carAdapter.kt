package com.example.exam


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.exam.AppDataBase
import java.lang.Exception


class carAdapter (val championList: MutableList<Champion>) :  RecyclerView.Adapter<carAdapter.CarViewHolder>() {

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

        holder.btnLike.setOnClickListener {
            try {
                AppDataBase.getDatabase(holder.itemView.context).championDao().insert(
                    Champion(
                        position,
                        championList[position].champPic,
                        holder.nom.text.toString(),
                        holder.dispo.text.toString(),
                        holder.prix.text.toString().toInt()

                    )
                )
            }
            catch (ex: Exception){
                Toast.makeText(holder.itemView.context, "Could not add the car to favorite !", Toast.LENGTH_SHORT).show()
            }

        }


        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, Detail::class.java)
            intent.apply {
                putExtra(PICTURE, championList[position].champPic)
                putExtra(NAME, holder.nom.text.toString())
                putExtra(DISPO, holder.nom.text.toString())
                putExtra(PRIX, championList[position].prix.toString())
            }
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = championList.size

    class CarViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val carpic = itemView.findViewById<ImageView>(R.id.champPic)
        val nom = itemView.findViewById<TextView>(R.id.Nom)
        val dispo = itemView.findViewById<TextView>(R.id.dispo)
        val prix = itemView.findViewById<TextView>(R.id.prix)
        val btnLike = itemView.findViewById<ImageButton>(R.id.btnLike)
    }
}
