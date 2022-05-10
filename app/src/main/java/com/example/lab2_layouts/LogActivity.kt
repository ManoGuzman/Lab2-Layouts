package com.example.lab2_layouts

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log)

        // Ingresar datos
        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val login = findViewById<Button>(R.id.btnLogin)

        //evento onClick
        login.setOnClickListener{
            val intent = Intent(this, RatingActivity::class.java)
            intent.putExtra("username", username.text.toString())
            intent.putExtra("password", password.text.toString())
            startActivity(intent)
        }

    }
}