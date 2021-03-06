package com.example.exam

import android.app.AlertDialog
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class home : AppCompatActivity() {
    lateinit var rent: Button
    lateinit var profile: Button
    lateinit var favorite: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        //supportActionBar?.hide();

        supportFragmentManager.beginTransaction().replace(R.id.flfragment, carFragment()).commit()
        rent = findViewById(R.id.rent)
        profile = findViewById(R.id.profile)
        favorite = findViewById(R.id.favorites)
        rent.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.flfragment, carFragment()).commit()
        }
        profile.setOnClickListener { supportFragmentManager.beginTransaction().replace(R.id.flfragment, profileFragment()).commit() }

        favorite.setOnClickListener {  supportFragmentManager.beginTransaction().replace(R.id.flfragment, favoriteFragment()).commit() }


    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        lateinit var mSharedPref: SharedPreferences
        when(item.itemId){

            R.id.logoutMenu ->{
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Logout")
                builder.setMessage("logout")
                builder.setPositiveButton("Yes"){ dialogInterface, which ->
                    getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit().clear().apply()
                    finish()
                }
                builder.setNegativeButton("No"){dialogInterface, which ->
                    dialogInterface.dismiss()
                }
                builder.create().show()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}