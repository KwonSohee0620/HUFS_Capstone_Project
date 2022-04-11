package com.example.trend

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Login2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        val register_check : Button = findViewById<Button>(R.id.btn_register_check)
        val id : EditText = findViewById<EditText>(R.id.edit_id)
        val pw : EditText = findViewById<EditText>(R.id.edit_pw)
        val pw_check : EditText = findViewById<EditText>(R.id.edit_pw_check)
        val business_num : EditText = findViewById<EditText>(R.id.edit_business_num)


    }
}