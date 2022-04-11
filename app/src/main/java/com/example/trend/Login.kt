package com.example.trend

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val register : Button = findViewById<Button>(R.id.btn_register)
        val id : EditText = findViewById<EditText>(R.id.edit_id)
        val pw : EditText = findViewById<EditText>(R.id.edit_pw)

        register.setOnClickListener(){
            val intent = Intent(this,Login2::class.java)
            startActivity(intent)
        }
    }
}