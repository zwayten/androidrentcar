package com.example.exam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class carFragment : Fragment() {
    lateinit var recylcerChampionAdapter: carAdapter
    lateinit var carRecyclerView: RecyclerView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_car, container, false)

        var champList : MutableList<Champion> = ArrayList()


        carRecyclerView = rootView.findViewById(R.id.recycler_champ)



        champList.add(Champion(champPic = R.drawable.kia_picanto, Nom = "kia picanto", dispo = "DISPONIBLE",prix = 120))
        champList.add(Champion(champPic = R.drawable.kia_rio, Nom = "kia_rio", dispo = "DISPONIBLE",prix = 1250 ))
        champList.add(Champion(champPic = R.drawable.polo8, Nom = "polo8", dispo = "DISPONIBLE",prix = 412440 ))
        champList.add(Champion(champPic = R.drawable.polo8, Nom = "renault_symbol", dispo = "DISPONIBLE",prix = 519620 ))
        champList.add(Champion(champPic = R.drawable.seat_ibiza, Nom = "seat_ibiza", dispo = "DISPONIBLE",prix = 91066 ))
        champList.add(Champion(champPic = R.drawable.polo8, Nom = "renault_symbol", dispo = "DISPONIBLE",prix = 61033 ))
        recylcerChampionAdapter = carAdapter(champList)
        carRecyclerView.adapter = recylcerChampionAdapter

        carRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL ,
            false)


        return rootView
    }

}