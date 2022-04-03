package com.example.exam

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager


class profileFragment : Fragment(R.layout.fragment_profile) {

    lateinit var mSharedPref: SharedPreferences
    lateinit var usernameProfile: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_profile, container, false)
        mSharedPref = requireActivity().getSharedPreferences("LOGIN_PREF_CAR", AppCompatActivity.MODE_PRIVATE);
        usernameProfile = rootView.findViewById<TextView?>(R.id.usernameProfile)

        val nameStr: String = mSharedPref.getString("LOGIN", "zwayten").toString()
        usernameProfile.text = nameStr

        return rootView
    }
}