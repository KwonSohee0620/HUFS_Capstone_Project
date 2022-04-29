package com.example.trend

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.trend_test_3.*

class TrendTest3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.trend_test_3)

        increase.setOnClickListener(){
            increase.setBackgroundColor(Color.parseColor("#FFF1DD95"))
            startActivity(Intent(this, TrendTest4Activity::class.java))
        }

        decrease.setOnClickListener(){
            decrease.setBackgroundColor(Color.parseColor("#FFF1DD95"))
            startActivity(Intent(this, TrendTest4Activity::class.java))
        }

        nochange.setOnClickListener(){
            nochange.setBackgroundColor(Color.parseColor("#FFF1DD95"))
            startActivity(Intent(this, TrendTest4Activity::class.java))
        }
    }
}