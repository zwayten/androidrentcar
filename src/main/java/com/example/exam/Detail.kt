package com.example.exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Detail : AppCompatActivity() {


    lateinit var prixCar:TextView
    lateinit var dispoCar:TextView
    lateinit var image44: ImageView
    lateinit var namecar:TextView


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        prixCar = findViewById(R.id.prixCar)
        dispoCar = findViewById(R.id.dispoCar)
        image44 = findViewById(R.id.image44)
        namecar = findViewById(R.id.namecar)

        image44.setImageResource(intent.getIntExtra(PICTURE, 0))

        val name = intent.getStringExtra(NAME)
        val dispo = intent.getStringExtra(DISPO)
        val prix = intent.getStringExtra(PRIX)

        title= "$name Detail"

        namecar.text = "Name : $name"
        dispoCar.text = dispo
        prixCar.text = prix
    }
}