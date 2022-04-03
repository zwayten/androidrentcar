package com.example.exam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

lateinit var recylcerChampionAdapter: favoriteAdapter
lateinit var carRecyclerView: RecyclerView
lateinit var dataBase: AppDataBase
class favoriteFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_favorite, container, false)

        var champList : MutableList<Champion> = ArrayList()
        dataBase = AppDataBase.getDatabase(requireActivity())

        carRecyclerView = rootView.findViewById(R.id.recycler_champ)

        champList =  dataBase.championDao().getAllchamps()



        recylcerChampionAdapter = favoriteAdapter(champList)
        carRecyclerView.adapter = recylcerChampionAdapter

        carRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL ,
            false)


        return rootView
    }

}