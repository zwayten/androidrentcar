package com.example.exam

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout


const val PREF_NAME = "LOGIN_PREF_CAR"
const val LOGIN = "LOGIN"
const val PASSWORD = "PASSWORD"
const val IS_REMEMBRED = "IS_REMEMBRED"

class login : AppCompatActivity() {

    private lateinit var buttonLogin: Button
    private lateinit var username: EditText
    private lateinit var password: EditText
    lateinit var editTextuser1: TextInputLayout
    lateinit var editTextuser2: TextInputLayout
    private lateinit var remember_me: CheckBox
    lateinit var mSharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.title="Login";

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        buttonLogin = findViewById(R.id.login);
        remember_me = findViewById(R.id.remember);
        editTextuser2 = findViewById(R.id.txtLayoutpassword)
        editTextuser1 = findViewById(R.id.txtLayoutLogin)

        mSharedPref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        if (mSharedPref.getBoolean(IS_REMEMBRED, false)){
            navigate()
        }

        buttonLogin.setOnClickListener {
            val user = username.text.toString();
            val pass = password.text.toString()


            if (validate()!! && remember_me.isChecked()){
                mSharedPref.edit().apply{
                    putBoolean(IS_REMEMBRED, true)
                    putString(LOGIN, user)
                    putString(PASSWORD, pass)
                }.apply()
                navigate()
            }
            if (validate()!! && !remember_me.isChecked()){
                mSharedPref.edit().apply{
                    putBoolean(IS_REMEMBRED, false)
                    putString(LOGIN, user)
                    putString(PASSWORD, pass)
                }.apply()
                navigate()
            }

        }

    }

    private fun validate(): Boolean {
        editTextuser1.error = null
        editTextuser2.error = null

        if (username.text!!.isEmpty()) {
            editTextuser1.error = getString(R.string.mustNotBeEmpty)
            return false
        }

        if (password.text!!.isEmpty()) {
            editTextuser2.error = getString(R.string.mustNotBeEmpty)
            return false
        }

        return true
    }

    private fun navigate(){
        val mainIntent = Intent(this, home::class.java)
        startActivity(mainIntent)
    }
}