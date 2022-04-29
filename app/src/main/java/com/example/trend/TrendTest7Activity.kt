package com.example.trend

import android.content.ContentValues
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.trend_test_7.*

class TrendTest7Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.trend_test_7)

        val num = 80
        result.setText(num.toString())

        back_to_home.setOnClickListener(){
            dialog()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun dialog(){
        var dialog = AlertDialog.Builder(this)

        dialog.setTitle("Notice")
        dialog.setMessage("알림 탭에서 더 많은 정보를 확인할 수 있어요!")

        var dialog_listener = object: DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                when(which){
                    DialogInterface.BUTTON_POSITIVE ->
                        Log.d(ContentValues.TAG, "")
                }
            }
        }

        dialog.setPositiveButton("확인",dialog_listener)
        dialog.show()
    }
}